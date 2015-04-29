/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.entities;

import gr.teicm.pm.jzork.Inventory;
import gr.teicm.pm.jzork.items.Key;
import gr.teicm.pm.jzork.items.Door;
import gr.teicm.pm.jzork.navigation.Room;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Babis
 */
public class Player extends Entity implements Serializable {

    
    public Inventory inventory = new Inventory();
    public Key keyID;
    public Door doorID;
    

    public Player(String name, Room currentRoom) {

        this.name = name;
        this.currentRoom = currentRoom;
    }

    public Player() {
        currentRoom = null;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    
    public void unlockdoor(String direction){
        
        Door nextDoor = currentRoom.getExit(direction);
        nextDoor.setIsLocked(false);
        System.out.println("The door is now unlocked!");
          
    }


    
     public void attack(String enemy) {
        
         
     }


//     public void defend(Enemies monster) {
//     
//     health = (health - );
//     System.out.printf("  " + name + " is hit for %d HP of damage (%s)\n");
//     if (health == 0) {
//     System.out.println("  " + name + " has been defeated");
//     }
//     }
//     
}
