/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.entities;

import java.io.Serializable;

/**
 *
 * @author Walkin
 */
public abstract class Enemies extends Entity implements Serializable {
    

 

   
    @Override
    public void setName(String name){
    this.name = name;
}

   
    
    @Override
 public void setDescription(String description){
    this.description = description;
}
 
 public void setHealthM(int Health){
     this.health = Health;
 }
 
 public void SetDamage(int Damage){
     this.damage = Damage;
 }
 

    public int getDamage(int damage){
     return damage;
 }
 
    @Override
 public void setAgility(int agility){
     this.agility = agility;
 }
 
    @Override
 public void setLuck(int luck){
     this.luck = luck;
 }
 
     public int attack(int damage) {
        return Enemies.this.damage ;
    }

//    public void defend(Player player) {
//        int attackStrength = damage;
//        health = (health - player.attack(name));
//        System.out.printf("  %s hits %s for %d HP of damage (%s)\n", player, name, attackStrength);
//        if (health == 0) {
//            System.out.println("  " + player + "The enemy is dead");
//                    
//        }
//    }

    public boolean isAlive() {
        return health > 0;
    }

}
