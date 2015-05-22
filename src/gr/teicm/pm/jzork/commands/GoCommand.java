package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.items.Door;
import gr.teicm.pm.jzork.items.Item;
import gr.teicm.pm.jzork.navigation.Room;
import java.util.Iterator;

/**
 *
 * @author Walkin
 */
public class GoCommand extends Command {

    /**
     * Constructor for objects of class GoCommand
     */
    public String view;
    public Item tmp;
    
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
            if (nextRoom != null) {
                player.setCurrentRoom(nextRoom);
                if (player.currentRoom.isIsDark()) {
                    Iterator<Item> item = player.currentRoom.items.iterator();
                    while (item.hasNext() )
                    {
                        tmp = item.next();
                        if(tmp.getName().equals("switch"))
                        {
                            tmp.setIsAvailable(true);
                        }
                        else 
                        {
                            tmp.setIsAvailable(false);
                        }
                        
                    } 
                    return "The room is dark, you can't see anything. " + nextRoom.getItemList() + ".";
                } else {
                    return nextRoom.getDescription() + nextRoom.getItemList();
                }
            } else {
                return nextDoor.getDoorStatus(nextDoor.isLocked, nextDoor.isOpen);
            }
        }
    }
}
