/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import java.util.Scanner;

/**
 *
 * @author Babis
 */
public class EnterCommand extends Command {

    private String item;
    private final Player player;
    
    public EnterCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(Player player) {
        if (hasSecondWord()) {
            item = getSecondWord();
        } else {
            return "Enter what?";
        }
        switch (item) {
            case "vault":
                if (hasThirdWord()) {
                    String noun = getThirdWord();
                    if (noun.equals("password")) {
                        boolean success = enterPass();
                        if (success) {
                            player.currentRoom.searchItem(item).setIsOpen(true);
                            return "Great! You've opened the " +item;
                        } else {
                            return "The vault stills closed...";
                        }

                    }
                } else {
                    return "Enter vault what?";
                }
                

        }
        return null;
        
        
    }
    
    public boolean enterPass(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the vault's password: ");
        String pass = input.next();
        
        String vaultPass = player.currentRoom.searchItem("vault").getPassword();
        
        
        while (!pass.equals(vaultPass) || pass.equals("exit")){
            System.out.println("Wrong Password! Try again or type exit to quit");
            pass = input.next();
        }
        return pass.equals(vaultPass);
       
    }
}
