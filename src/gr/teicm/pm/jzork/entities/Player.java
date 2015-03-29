/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.entities;

import gr.teicm.pm.jzork.Direction;
import gr.teicm.pm.jzork.rooms.Room;

/**
 *
 * @author Babis
 */
public class Player extends Entity{
    
    
    public Player() {
        this.setMaxHealth(100);
        this.setHealth(100);
        this.setAgility(10);    
        this.setLuck(10);
        this.setStrength(10);
        this.setIsAlive(true);
        this.setCurrentRoom(null);
    }
    
    //Moving to the next rooms
    public void walk(Direction direction){
	        
       Room nextRoom = currentRoom.getExit(direction);
	
       if (nextRoom == null)
	    System.out.println("There is no exit in that direction!");
       else {
	    setCurrentRoom(nextRoom);
	    System.out.println(nextRoom.getLongDescription());
       }
    }
    
}
