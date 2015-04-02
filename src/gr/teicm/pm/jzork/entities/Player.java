/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.entities;

import gr.teicm.pm.jzork.navigation.Door;
import gr.teicm.pm.jzork.navigation.Room;

/**
 *
 * @author Babis
 */
public class Player extends Entity {

    //History list of the visited rooms
    //private Stack roomHistory;
    private Room currentRoom;

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

    //Moving to the next rooms
    public void walk(String direction) {

        Door nextDoor = currentRoom.getExit(direction);

        if (nextDoor == null) {
            System.out.println("There is no exit in that direction!");
        } else {
            Room nextRoom = nextDoor.getConnectedRoom(currentRoom);
            //roomHistory.push(currentRoom);
            if (nextRoom != currentRoom) {
                setCurrentRoom(nextRoom);
                System.out.println(nextRoom.getDescription());
            }
        }
    }
    
    public void unlockDoor(String direction) {
        
        Door nextDoor = currentRoom.getExit(direction);
        
        if (nextDoor == null) {
            System.out.println("There is no door in this direction!");
        } else {
            nextDoor.setIsOpen(true);
            System.out.println("The door has been opened!");
        }
    }

    /* public int attack() {
     return strength ;
     }

     public void defend(Monsters monster) {
     int attackStrength = monster.attack();
     health = (health > attackStrength) ? health - attackStrength : 0;
     System.out.printf("  " + name + " is hit for %d HP of damage (%s)\n");
     if (health == 0) {
     System.out.println("  " + name + " has been defeated");
     }
     }
     */
}
