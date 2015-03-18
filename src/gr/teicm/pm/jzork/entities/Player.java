/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.entities;

import java.util.Stack;
import gr.teicm.pm.jzork.Room;

/**
 *
 * @author Babis
 */
public class Player extends Entity{
    
    //History list of the visited rooms
    private Stack roomHistory;
    
    
    public Player(String name, String description, int health, int maxHealth, int strength, int agility, int luck, boolean isAlive, Room currentRoom) {
       super(name, description, health, maxHealth, strength, agility, luck, isAlive, currentRoom);
       roomHistory = new Stack<Room>();
    }
    
    //Moving to the next rooms
    public void walk(String direction){
	        
       Room nextRoom = currentRoom.getExit(direction);
	
       if (nextRoom == null)
	    System.out.println("There is no exit in that direction!");
       else {
       	    roomHistory.push(currentRoom);
	    setCurrentRoom(nextRoom);
	    System.out.println(nextRoom.getLongDescription());
       }
    }
    
}
