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

    private Parser parser;
    private Player player;
    private static Player loadedPlayer;
    private Map map;
    private boolean initialized = false;
    private String output;
    private String name;
    private boolean loaded;
    

    public void play() throws IOException {
        GUI gui = new GUI();
        createPlayer();
        LoadCommand loadIfExists = new LoadCommand(true);
        loadIfExists.execute(player);
        loaded = LoadCommand.getLoaded();
        
        if(loaded) {
            player = loadedPlayer;     
            LoadCommand.setLoaded();
        }
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
                    loaded = LoadCommand.getLoaded();
                    if(loaded) {
                        player = loadedPlayer;
                        createCommands();
                        System.out.println(player.getCurrentRoom().getDescription());
                        LoadCommand.setLoaded();
                    }
                    System.out.println(output);
                }
            }
        }
        System.out.println("Thank you for playing.Good bye.");

    }

    public Game() {
        loaded = false;
        player = new Player();
        parser = new Parser();
    }

    public Game(Player player, Parser parser) {
        loaded = false;
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
        
        if(!loaded) {
            player = new Player();
            player.setName(name);
        } else {
            System.out.println("Loading game . . .");
        }
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
        parser.commandWords().addCommand("save", new SaveCommand());
        parser.commandWords().addCommand("load", new LoadCommand());
        parser.commandWords().addCommand("unlock", new UnlockCommand(player));
        //parser.commandWords().addCommand("attack", new AttackCommand());
        //parser.commandWords().addCommand("equip", new EquipCommand());
    }

    public void createRooms() {
        Map map = new Map();
        if(!loaded) {
            Room startRoom = map.generateMap();
            player.setCurrentRoom(startRoom);
        }
    }

    public void printWelcome() {
        System.out.println();
        if(!loaded)
            System.out.println("Welcome " + name + "!");
        else
            System.out.println("Welcome back " + name + "!");
        System.out.println();
        System.out.println(player.getCurrentRoom().getDescription());
    }
    
    public static void SetLoadedPlayer(Player player) {
        loadedPlayer = player;
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