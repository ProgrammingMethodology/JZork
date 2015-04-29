package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Game;
import gr.teicm.pm.jzork.entities.Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LoadCommand extends SaveLoadCommand {
    
    private final boolean init;
    private static boolean loaded;

    public LoadCommand() {
        init = false;
        loaded = false;
    }
    
    public LoadCommand(boolean init) {
        this.init = init;
        loaded = false;
    }
    
    @Override
    public String execute(Player player) {

        File folder = new File(DEFAULT_PATH + FILE_SEP + player.getName());
        
        if(!checkIfExists(folder)) {
            if(!init) 
                System.out.println("I'm sorry.No saves for player " + player.getName());               
            return "";
        }
        
        Map<Integer, String> savedFiles = new TreeMap<>();
        int i = 1;
        
        for(File file : folder.listFiles()) {
            savedFiles.put(i++, file.getName());
        }
        
        if(savedFiles.isEmpty()) {
            System.out.println("I'm sorry.No saves for player " + player.getName());
            return "";
        }
        
        File saveFile;
                
        System.out.print("Select saved instance [number]. Press [0] to ");
        System.out.println(init ? "start new game" : "continue current game");
        for(Map.Entry<Integer, String> entry : savedFiles.entrySet()) {
            System.out.println("[" + entry.getKey() +
                    "] " + entry.getValue().split("\\.")[0]);
        }
        
        int choise;
        
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                choise = scanner.nextInt();
                
                if(choise > savedFiles.size()) {
                    System.out.print("Please enter a valid number. Try again: ");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.print("Please enter an integer. Try again: ");
            }
        }
        
        if(choise == 0)
            return "";

        saveFile = new File(folder.getAbsolutePath() + FILE_SEP +
                savedFiles.get(choise));
        
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(
                    new FileInputStream(saveFile));
            Game.SetLoadedPlayer((Player) ois.readObject());

            loaded = true;
        } catch (Exception e) {
            System.out.println("I'm sorry couldn't load the file.Try again..");
            return "";
        }
        
        return "loaded";
    }
    
    public static boolean getLoaded() {
        return loaded;
    }
    
    public static void setLoaded() {
        loaded = false;
    }
}
