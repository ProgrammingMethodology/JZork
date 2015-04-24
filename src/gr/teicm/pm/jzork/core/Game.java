/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.core;

import gr.teicm.pm.jzork.commands.*;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.navigation.Map;
import gr.teicm.pm.jzork.navigation.Room;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Babis
 */
public class Game {

    private final Parser parser;
    private final Player player;
    private Map map;
    private boolean initialized = false;
    String output;
    String name;
    private final View view = new View();

    public void play() throws IOException {
        createPlayer();
        ensureInitialization();
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            if (command == null) {
                System.out.println("I don't understand what you mean!");
            } else {
                output = command.execute(player);
                if (output.equals("quit")) {
                    finished = true;
                } else {
                    view.printThis(output);
                }
            }
        }
        System.out.println("Thank you for playing.Good bye.");

    }

    public Game() {
        player = new Player();
        parser = new Parser();
    }

    public Game(Player player, Parser parser) {
        this.player = player;
        this.parser = parser;
    }

    public final Parser parser() {
        ensureInitialization();
        return parser;
    }

    public final Player player() {
        ensureInitialization();
        return player;
    }

    private void ensureInitialization() {
        if (!initialized) {
            initialized = true;
            createCommands();
            createRooms();
        }
    }

    public void createPlayer() {
        Scanner input = new Scanner(System.in);
        System.out.print("To start, please enter your name: ");
        name = input.next();
        Player player = new Player();
        player.setName(name);
    }

    public void createCommands() {
        ensureInitialization();
        parser.commandWords().addCommand("go", new GoCommand(player));
        parser.commandWords().addCommand("quit", new QuitCommand());
        parser.commandWords().addCommand("open", new OpenCommand(player));
        parser.commandWords().addCommand("pickup", new PickupCommand(player));
        parser.commandWords().addCommand("take", new PickupCommand(player));
        parser.commandWords().addCommand("get", new PickupCommand(player));
        parser.commandWords().addCommand("inventory", new InventoryCommand(player));
        parser.commandWords().addCommand("turnon", new TurnOnCommand(player));
        parser.commandWords().addCommand("enter", new EnterCommand(player));
        parser.commandWords().addCommand("examine", new ExamineCommand(player));
        parser.commandWords().addCommand("look", new ExamineCommand(player));

        //parser.commandWords().addCommand("unlock", new UnlockCommand());
        //parser.commandWords().addCommand("attack", new AttackCommand());
        //parser.commandWords().addCommand("equip", new EquipCommand());
    }

    public void createRooms() {
        Map map = new Map();
        Room startRoom = map.generateMap();
        player.setCurrentRoom(startRoom);
    }

    public void printWelcome() {
        System.out.println();
        System.out.println("Welcome " + name + "!");
        System.out.println();
        System.out.println(player.getCurrentRoom().getDescription());

    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        System.out.println("Welcome to the Zork Game\n");
        Game theGame = new Game();
        theGame.play();
    }

}
