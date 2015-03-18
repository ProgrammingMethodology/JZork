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
public class Room3 extends Room{
    
    public static void createRoom() {
        bedroom = new Room("Bedroom", "bedroom");
        bedroom.setExit(null, kitchen, null, null);
    }

    public Room3(String roomName, String description) {
        super(roomName, description);
    }
}
