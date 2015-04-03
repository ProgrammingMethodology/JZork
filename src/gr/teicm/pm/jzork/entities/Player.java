/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.entities;

import gr.teicm.pm.jzork.Inventory;
import gr.teicm.pm.jzork.items.Item;
import gr.teicm.pm.jzork.navigation.Door;
import gr.teicm.pm.jzork.navigation.Room;
import java.util.Scanner;

/**
 *
 * @author Babis
 */
public class Player extends Entity {

    //History list of the visited rooms
    //private Stack roomHistory;
    public Room currentRoom;
    Inventory inventory = new Inventory();

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
                if (currentRoom.isIsDark()) {
                    System.out.println("The room is dark, you can't see anything");
                } else {
                    System.out.println(nextRoom.getDescription());
                }
            }
        }
    }

    public void openDoor(String direction) {

        Door nextDoor = currentRoom.getExit(direction);

        if (nextDoor == null) {
            System.out.println("There is no door in this direction!");
        } else {
            nextDoor.setIsOpen(true);
            System.out.println("The door has been opened!");
        }
    }

    public void pickItem(String itemName) {
        Item pickedUp = currentRoom.searchItem(itemName);
        if (pickedUp != null) {
            inventory.addItem(pickedUp);
            System.out.println("You picked up an item");
            currentRoom.removeItem(itemName);
        } else {
            System.out.println("Cant find tha item");
        }
    }

    public void TurnOnLights(){
        currentRoom.setIsDark(false);
        System.out.println("Now you can see!");
        System.out.println(currentRoom.getDescription());
    }
    
    public void getPlayersInventory() {
        inventory.printInventory();
    }

    public boolean searchInventoryItem(String itemName) {
        boolean tmp = inventory.searchItem(itemName);
        return tmp;
    }

    public boolean tryVaultPass(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the vault's password: ");
        String pass = input.next();
        
        String vaultPass = currentRoom.searchItem("vault").getPassword();
        
        
        while (!pass.equals(vaultPass) || pass.equals("exit")){
            System.out.println("Wrong Password! Try again or type exit to quit");
            pass = input.next();
        }
        return pass.equals(vaultPass);
       
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
