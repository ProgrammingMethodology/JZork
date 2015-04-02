/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.navigation.Room;

/**
 *
 * @author Babis
 */
public class OpenCommand extends Command {

    /**
     * Constructor for objects of class GoCommand
     */
    private Room currentRoom;
    private String item;

    public OpenCommand() {
    }

    public boolean execute(Player player) {
        if (hasSecondWord()) {
            item = getSecondWord();
        }

        switch (item) {
            case "door":
                if (hasThirdWord()) {
                    String direction = getThirdWord();
                    player.unlockDoor(direction);
                } else {
                    System.out.println("Go where?");
                }
                return false;

        }
        return false;
    }
}
