/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

import gr.teicm.pm.jzork.interfaces.ILight;
import gr.teicm.pm.jzork.navigation.Room;

/**
 *
 * @author Walkin
 */
public class Torch extends Item implements ILight{

    //private final int LightStr;
    //Room currentRoom;

    public Torch(String name, String description, String itemDetails) {
        this.name = name;
        this.description = description;
        this.itemDetails = itemDetails;
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
            return "Now you can see!\n" + currentRoom.getDescription() + currentRoom.getItemList() + ".";
        } else {
            return "You don't need light to see. The room isn't so dark at all.";
        }
    }

    /*
     public int getLightStr() {
     return LightStr;
     }
     */
}
