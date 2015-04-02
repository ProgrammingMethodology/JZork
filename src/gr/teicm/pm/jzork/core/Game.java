/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.core;

import gr.teicm.pm.jzork.commands.GoCommand;
import gr.teicm.pm.jzork.commands.InventoryCommand;
import gr.teicm.pm.jzork.commands.OpenCommand;
import gr.teicm.pm.jzork.commands.PickupCommand;
import gr.teicm.pm.jzork.commands.QuitCommand;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.items.Item;
import gr.teicm.pm.jzork.navigation.Map;
import gr.teicm.pm.jzork.navigation.Room;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Babis
 */
public class Game {

    private Parser parser;
    private Player player;
    private Map map;
    protected ArrayList<Item> inventory = new ArrayList<Item>();
    private boolean initialized = false;
    String name;

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
                finished = command.execute(player);
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
        parser.commandWords().addCommand("go", new GoCommand());
        parser.commandWords().addCommand("quit", new QuitCommand());
        parser.commandWords().addCommand("open", new OpenCommand());
        parser.commandWords().addCommand("pickup", new PickupCommand());
        parser.commandWords().addCommand("take", new PickupCommand());
        parser.commandWords().addCommand("get", new PickupCommand());
        parser.commandWords().addCommand("inventory", new InventoryCommand());
    }

    public void createRooms() {
        Map map = new Map();
        Room startRoom = map.generateMap();
        player.setCurrentRoom(startRoom);
    }
    
    public void printInventory() {
        String allitems = "";
        for (Item item : inventory) {
            allitems += "\n" + item.getName();
        }
        if (allitems.length() > 0) {
            System.out.println("Your inventory:" + allitems);
        } else {
            System.out.println("Your inventory is empty");
        }
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
        System.out.println("Welcome to the Zork Game,");
        Game theGame = new Game();
        theGame.play();
    }

}
