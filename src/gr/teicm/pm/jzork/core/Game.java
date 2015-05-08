/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.core;

import gr.teicm.pm.jzork.commands.*;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.navigation.Map;
import java.io.IOException;

/**
 *
 * @author Babis
 */
public class Game {

    private final Parser parser;
    private Player player;
    private final Map map;
    private static Player loadedPlayer;
    private static CommandWords commands;
    private boolean initialized = false;
    private String output;
    private boolean loaded;
    

    public Game() {
        loaded = false;
        player = new Player();
        parser = new Parser();
        map = new Map();
        commands = new CommandWords();
    }
    
    
    public void play() throws IOException {
        //GUI gui = new GUI();
        player.createPlayer(loaded, player);
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
                        commands.createCommands(parser,player);
                        System.out.println(player.getCurrentRoom().getDescription());
                        LoadCommand.setLoaded();
                    }
                    System.out.println(output);
                }
            }
        }
        System.out.println("Thank you for playing.Good bye.");

    }

    private void ensureInitialization() {
        if (!initialized) {
            initialized = true;
            commands.createCommands(parser,player);
            map.createMap(loaded, player);
        }
    }

    public void printWelcome() {
        System.out.println();
        if(!loaded)
            System.out.println("Welcome " + player.getName() + "!");
        else
            System.out.println("Welcome back " + player.getName() + "!");
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