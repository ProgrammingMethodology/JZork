/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork;

/**
 *
 * @author Maria
 */
public class Room2 extends Room{
    
    public static void createRoom() {
        kitchen = new Room("Kitchen", "kitchen");
        kitchen.setExit(bedroom, livingroom, null, null);
    }

    public Room2(String roomName, String description) {
        super(roomName, description);
    }   
}
