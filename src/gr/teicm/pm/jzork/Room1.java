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

public class Room1 extends Room{
    
    public static void createRoom() {
        livingroom = new Room("Living room", "living room");
        livingroom.setExit("east", kitchen);
    }

    public Room1(String roomName, String description) {
        super(roomName, description);
    }
} 