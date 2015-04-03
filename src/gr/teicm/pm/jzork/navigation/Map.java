/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.navigation;

import gr.teicm.pm.jzork.items.Item;
import gr.teicm.pm.jzork.items.Torch;

/**
 *
 * @author Babis
 */
public class Map {

    private Room startRoom;

    RoomConnector connect = new RoomConnector();
    private Item torch;
    private Room hallway,outside, office;

    public Room generateMap() {

        
        // The outside:  
        outside = new Room();
        outside.setRoomName("outside");
        outside.setDescription("You are outside of a big building. There is a door to your north from where you can enter");

        // The hallway:
        hallway = new Room();
        hallway.setRoomName("hallway");
        hallway.setDescription("You are now in the hallway room. There are two doors, one to your west and one to your south");
        Torch torch = new Torch("torch");
        hallway.addItem(torch);
        
        // The Office:
        office = new Room();
        office.setRoomName("office");
        office.setDescription("You are now in the office. There is a desk with many stacks of paper. It looks like there are no other exits. Only the door you've entered to your east");

        // Exits initialization  
        connect.RoomInitialize(outside);
        connect.RoomInitialize(hallway);
        connect.RoomInitialize(office);
        
        
        // Room connection with doors
        // outside north hallway
        Door outNorthHall = new Door(outside, "north", "south", hallway, false, "Big green door");
        Door hallWestOffice = new Door(hallway, "west", "east", office, false, "wooden door");
        
       
        // Return the starting room:
        startRoom = outside;
        return startRoom;

    }
    
    public Room getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(Room startRoom) {
        this.startRoom = startRoom;
    }

}
