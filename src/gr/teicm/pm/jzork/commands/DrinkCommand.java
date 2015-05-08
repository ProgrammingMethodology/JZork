/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.items.Item;
import gr.teicm.pm.jzork.items.Potion;

/**
 *
 * @author Babis
 */
public class DrinkCommand extends Command {

    public DrinkCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(Player player) {
        if (hasSecondWord()) {
            String liquid = getSecondWord();
            return drink(liquid);
        } else {
            return "Drink what?";
        }
    }

    public String drink(String liquid) {

        switch (liquid) {

            case "potion":
                if (player.inventory.isItemValid(liquid)) {
                    Item obj = player.inventory.searchItem(liquid);
                    Potion potion = (Potion) obj;
                    return potion.drink(player);
                } else {
                    return "You can't find this item";
                }
            default:
                return "Drink what?";
        }

    }
}
