/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.items.Item;

/**
 *
 * @author Maria
 */

public class DropCommand extends Command {

    public DropCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(Player player) {
        if (hasSecondWord()) {
            String itemName = getSecondWord();
            return dropItem(itemName);
        } else {
            return "Drop what?";
        }
    }

    public String dropItem(String itemName) {
        String results = "";
        Item dropInventoryItem = player.inventory.searchItem(itemName);

        if (dropInventoryItem != null) {
            player.inventory.removeItem(itemName);
            player.currentRoom.addItem(dropInventoryItem);
            return "You droped the " + itemName;
        } else {
            return "This item there isn't in your inventory.";
        }

    }

}
