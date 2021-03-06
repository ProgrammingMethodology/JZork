/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.entities;

import gr.teicm.pm.jzork.Inventory;
import gr.teicm.pm.jzork.items.Weapon;
import gr.teicm.pm.jzork.navigation.Room;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Babis
 */
public class Player extends Entity implements Serializable {

    
    public Inventory inventory = new Inventory();
    public Weapon equipedWeapon;
    
    
    public Player(String name) {

        this.name = name;
        currentRoom = null;
        this.maxHealth = 100;
        this.health = 75;
        this.damage = 5;
        this.fullDamage = this.damage;
        
    }

    public Player() {
        currentRoom = null;
        this.maxHealth = 100;
        this.health = 75;
        this.damage = 5;
        this.fullDamage = this.damage;
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

    public Weapon getEquipedWeapon() {
        return equipedWeapon;
    }

    public void setEquipedWeapon(Weapon equipedWeapon) {
        this.equipedWeapon = equipedWeapon;
    }
    
    public String printStats(Player player){
        
        return "Your stats are:" + "\nHealth: " +player.getHealth() 
                + "/" + player.getMaxHealth() +"\nDamage: " + player.getFullDamage();  
    }

    public boolean isAlive() {
        return health > 0;
    }
    
//     public int attack(String enemy) {
//        return Player.this.damage;
//         
//     }
//
//
//     public void defend(Enemies monster) {
//     
//     health = (health - monster.damage  );
//     System.out.printf("  " + name + " is hit for %d HP of damage (%s)\n");
//     if (health == 0) {
//     System.out.println("  " + name + " has been defeated");
//     }
//     }
     
}
