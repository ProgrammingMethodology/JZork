/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;

/**
 *
 * @author Babis
 */
public class EnterCommand extends Command {

    private String item;

    public EnterCommand() {

    }

    @Override
    public boolean execute(Player player) {
        if (hasSecondWord()) {
            item = getSecondWord();
        } else {
            System.out.println("Open what?");
        }
        switch (item) {
            case "vault":
                if (hasThirdWord()) {
                    String noun = getThirdWord();
                    if (noun.equals("password")) {
                        boolean success = player.tryVaultPass();
                        if (success) {
                            player.currentRoom.searchItem(item).setIsOpen(true);
                            System.out.println("Great! You've opened the vault!");
                        } else {
                            System.out.println("The vault stills closed...");
                        }

                    }
                } else {
                    System.out.println("Enter vault what?");
                }
                return false;

        }
        return false;
        
    }
}
