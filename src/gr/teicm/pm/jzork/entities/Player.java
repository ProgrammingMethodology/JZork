/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.entities;

import gr.teicm.pm.jzork.navigation.Room;

/**
 *
 * @author Babis
 */
public class Player extends Entity{
    
    //History list of the visited rooms
    //private Stack roomHistory;
    private Room currentRoom;
   
    
    public Player(String name, Room currentRoom){
        
        this.name = name;
        this.currentRoom = currentRoom;
    }
    
    public Player()
    {
        currentRoom = null;
    }
    
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }
    
    
    //Moving to the next rooms
    public void walk(String direction){
        
       Room nextRoom = currentRoom.getExit(direction);
	
       if (nextRoom == null)
	    System.out.println("There is no exit in that direction!");
       else {
       	    //roomHistory.push(currentRoom);
	    setCurrentRoom(nextRoom);
	    System.out.println(nextRoom.getDescription());
       }
    }
    
}