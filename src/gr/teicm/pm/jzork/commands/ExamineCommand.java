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
 * @author Babis
 */
public class ExamineCommand extends Command {


    public ExamineCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(Player player) {
        if (hasSecondWord()) {
            String itemName = getSecondWord();
            return lookItem(itemName);
        } else {
            return "Examine what?";
        }

    }

    public String lookItem(String itemName) {
        Item examinedRoomItem = player.currentRoom.searchItem(itemName);
        Item examinedInventoryItem = player.inventory.searchItem(itemName);

        if(examinedRoomItem != null && examinedRoomItem.isAvailable){
            return examinedRoomItem.getDescription();
        }
        else if(examinedInventoryItem != null && examinedInventoryItem.isAvailable){
           return examinedInventoryItem.getDescription();
        }
        else
            return "I can't find this item";
            
    }

}
