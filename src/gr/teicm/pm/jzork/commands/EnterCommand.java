/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.items.Item;
import gr.teicm.pm.jzork.items.Vault;

/**
 *
 * @author Babis
 */
public class EnterCommand extends Command {

    private String item;
    private final Player player;
    public Item obj;

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
                        if (player.currentRoom.isItemValid(item)) {
                            obj = player.currentRoom.searchItem(item);
                            Vault vault = (Vault) obj;
                            return vault.enterPassword(player);
                        } else {
                            return "I can't see a " + item + " here";
                        }
                    }
                } else {
                    return "Enter vault what?";
                }
        }
        return "gdsgdsg";

    }
    /*
    public boolean enterPass() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the vault's password: ");
        String pass = input.next();

        String vaultPass = player.currentRoom.searchItem("vault").getPassword();

        while (!pass.equals(vaultPass) || pass.equals("exit")) {
            System.out.println("Wrong Password! Try again or type exit to quit");
            pass = input.next();
        }
        return pass.equals(vaultPass);

    }
    */
}
