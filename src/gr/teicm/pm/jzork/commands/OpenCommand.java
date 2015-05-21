/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.items.*;

/**
 *
 * @author Babis
 */
public class OpenCommand extends Command {

    /**
     * Constructor for objects of class GoCommand
     */
    private String item;

    public OpenCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(Player player) {
        if (hasSecondWord()) {
            item = getSecondWord();
            switch (item) {
                case "door":
                    if (hasThirdWord()) {
                        String direction = getThirdWord();
                        return openDoor(direction);
                    } else {
                        return "In which direction?";
                    }
                case "chest":
                    if (!hasThirdWord()) {
                        if (!player.currentRoom.isItemValid(item)) {
                            return "You can't find this item";
                        } else {
                            Item obj = player.currentRoom.searchItem(item);
                            Chest chest = (Chest) obj;
                            chest.setIsOpen(true);
                            return "The chest is open now";
                        }
                    } else {
                        return "Just open this item.";
                    }

            }

        } else {
            return "open what?";
        }
        return null;

    }

    public String openDoor(String direction) {

        Door nextDoor = player.currentRoom.getExit(direction);

        if (nextDoor == null) {
            return "There is no door in this direction!";
        } else if (nextDoor.isIsLocked()) {
            return "The door is locked so you can't enter";
        } else {
            nextDoor.setIsOpen(true);
            return "The door has been opened!";
        }

    }
}
