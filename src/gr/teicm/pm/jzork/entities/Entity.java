/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.entities;

import gr.teicm.pm.jzork.navigation.Room;
import java.io.Serializable;

/**
 *
 * @author Babis
 */
public class Entity implements Serializable {
    
   
    public String name;
    public String description;
    public int health;
    public int maxHealth;
    public int damage;
    public int strength;
    public int agility;
    public int luck;
    
    public boolean isAlive;
    public Room currentRoom;
    
    public Entity(String name, String description, int health, int maxHealth, int strength, int agility, int luck, boolean isAlive, Room currentRoom){
        this.name = name;
        this.description = description;
        this.health = health;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.agility = agility;
        this.luck = luck;
        this.isAlive = isAlive;
        this.currentRoom = currentRoom;
    }
    
    public Entity()
    {
        
    }
    
    //Inflicted damage
    public void minusHealth(int dmg)
    {
        health = health - dmg;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (health > maxHealth){
            health = maxHealth;
        }
        else if (health <= 0){
            isAlive = false;
        }
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        if (health > maxHealth){
            health = maxHealth;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    
    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    
    
}
