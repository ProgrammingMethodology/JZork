package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.navigation.Door;
import gr.teicm.pm.jzork.navigation.Room;

/**
 *
 * @author Walkin
 */
public class GoCommand extends Command {

    /**
     * Constructor for objects of class GoCommand
     */
    public Player player;
    private Room currentRoom;
    public String view;

    public GoCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(Player player) {
        if (hasSecondWord()) {
            String direction = getSecondWord();
            return walk(direction);
        } else {
            return "Go where?";
        }

    }

    public String walk(String direction) {

        Door nextDoor = player.currentRoom.getExit(direction);

        if (nextDoor == null) {
            return "There is no exit in that direction!";
        } else {
            Room nextRoom = nextDoor.getConnectedRoom(player.currentRoom);
            if (nextRoom != currentRoom) {
                player.setCurrentRoom(nextRoom);
                if (player.currentRoom.isIsDark()) {
                    return "The room is dark, you can't see anything";
                } else {
                    return nextRoom.getDescription() + nextRoom.getItemList() + ".";
                }
            }
        }
        return null;
    }
}
