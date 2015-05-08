/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.entities;

import gr.teicm.pm.jzork.Inventory;
import gr.teicm.pm.jzork.navigation.Room;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Babis
 */
public class Player extends Entity implements Serializable {

    
    public Inventory inventory = new Inventory();
    
    
    public Player(String name) {

        this.name = name;
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
    
    public void createPlayer(boolean loaded, Player player) {
        Scanner input = new Scanner(System.in);
        System.out.print("To start, please enter your name: ");
        name = input.next();
        
        if(!loaded) {
            player = new Player();
            player.setName(name);
        } else {
            System.out.println("Loading game . . .");
        }
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
