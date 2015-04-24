/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.interfaces.IDrinkable;

/**
 *
 * @author Babis
 */
public class HealingPotion extends Item implements IDrinkable {

    int percentage;

    public HealingPotion(String name, String description, String itemDetails, int percentage) {
        this.name = name;
        this.description = description;
        this.itemDetails = itemDetails;
        this.percentage = percentage;
        this.isPickable = true;

    }

    @Override
    public void drink(Player player) {
        int max = player.getMaxHealth();
        int currentHealth = player.getHealth();
        player.setHealth((max / 100) * percentage + currentHealth);
    }
}
