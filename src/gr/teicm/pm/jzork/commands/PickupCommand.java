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
public class PickupCommand extends Command {

    
    public PickupCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(Player player) {
        if (hasSecondWord()) {
            String itemName = getSecondWord();
            return pickItem(itemName);
        } else {
            return "Pick up what?";
        }

         
    }

    public String pickItem(String itemName) {
        Item pickedUp = player.currentRoom.searchItem(itemName);
        if (pickedUp != null && pickedUp.isAvailable) {
            player.inventory.addItem(pickedUp);
            player.currentRoom.removeItem(itemName);
            return "You picked up " +itemName;
        } else {
            return "Can't find that item";
        }
    }

}