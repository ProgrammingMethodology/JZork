/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.items.Door;
import gr.teicm.pm.jzork.items.Item;
import java.util.Iterator;

/**
 *
 * @author Walkin
 */
public class UnlockCommand extends Command {

    boolean keyFound;

    public UnlockCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(Player player) {
        if (hasSecondWord()) {
            String itemName = getSecondWord();
            switch (itemName) {
                case "door":
                    if (hasThirdWord()) {
                        String direction = getThirdWord();
                        return unlockDoor(direction, player);
                    } else {
                        return "In which direction?";
                    }
                default:
                    return "Unlock what?";
            }

        } else {
            return "Unlock what?";
        }
    }

    public String unlockDoor(String direction, Player player) {

        Door nextDoor = player.currentRoom.getExit(direction);

        if (nextDoor == null) {
            return "There is no door in this direction!";
        } else if (!nextDoor.isIsLocked()) {
            return "The door is already unlocked!";
        } else {
            Iterator<Item> item = player.inventory.inventory.iterator();
            {
                while (item.hasNext()) {
                    Item tmp = item.next();
                    if (tmp.getName().equals("key") && tmp.getId().equals(nextDoor.getId())) {
                        nextDoor.setIsLocked(false);
                        item.remove();
                        keyFound =true;
                        return "The door has been unlocked!";
                    } 
                }
            }
            return "You don't have the right key!";

        }
        

    }
}