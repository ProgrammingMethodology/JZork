/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.interfaces.IDrinkable;
import java.io.Serializable;

/**
 *
 * @author Babis
 */
public class Potion extends Item implements IDrinkable, Serializable {

    int percentage;

    public Potion( int percentage, String description, String itemLocDescription) {
        this.name = "potion";
        this.description = description;
        this.itemLocDescription = itemLocDescription;
        this.percentage = percentage;
        this.isPickable = true;
        

    }

    @Override
    public String drink(Player player) {
        int maxHealth = player.getMaxHealth();
        int currentHealth = player.getHealth();
        if (currentHealth == maxHealth){
            return "Your health is already full!";
        }
        else{
            player.setHealth((maxHealth / 100) * percentage + currentHealth);
            player.inventory.removeItem(this.name);
            return player.getHealth() - currentHealth + " health points have been restored";
        }
        
    }
}
