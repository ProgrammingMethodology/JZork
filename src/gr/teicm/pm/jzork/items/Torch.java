/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

import gr.teicm.pm.jzork.interfaces.ILight;
import gr.teicm.pm.jzork.navigation.Room;
import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author Walkin
 */
public class Torch extends Item implements ILight, Serializable {

    public Torch( String description, String itemLocDescription) {
        this.name = "torch";
        this.description = description;
        this.itemLocDescription = itemLocDescription;
        this.isPickable = true;
    }

    public void turnOff(Room room) {
        room.setIsDark(true);
    }

    public void turnOn(Room room) {
        room.setIsDark(false);
    }

    @Override
    public String turnLightOn(Room currentRoom) {
        if (currentRoom.isIsDark()) {
            currentRoom.setIsDark(false);
            Iterator<Item> item = currentRoom.items.iterator();
                    while (item.hasNext()) {
                        Item tmp = item.next();
                        tmp.setIsAvailable(true);
                    }
            
            return "Now you can see! " + currentRoom.getDescription() + currentRoom.getItemList() + ".";
        } else {
            return "You don't need light to see. The room isn't so dark at all.";
        }
    }

}
