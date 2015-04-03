/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

import gr.teicm.pm.jzork.navigation.Room;

/**
 *
 * @author Walkin
 */
public class Torch extends Item {

    //private final int LightStr;
    Room currentRoom;
    
    public Torch(String name) {
        this.name = name;
    }

    
    public void turnOff(Room room){
        room.setIsDark(true);
    }
    
    public void turnOn(Room room){
        room.setIsDark(false);
    }
         
    
    /*
    public int getLightStr() {
        return LightStr;
    }
    */
}

