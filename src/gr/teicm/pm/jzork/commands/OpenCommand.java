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

    @Override
    public boolean execute(Player player) {
        if (hasSecondWord()) {
            item = getSecondWord();
        }
        else{
            System.out.println("Open what?");
        }

        switch (item) {
            case "door":
                if (hasThirdWord()) {
                    String direction = getThirdWord();
                    player.openDoor(direction);
                } else {
                    System.out.println("In which direction?");
                }
                return false;

        }
        return false;
    }
}
