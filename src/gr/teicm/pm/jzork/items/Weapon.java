/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.interfaces.IEquipable;
import java.io.Serializable;

/**
 *
 * @author Walkin
 */
public class Weapon extends Item implements Serializable, IEquipable {

    public int damage;

    public Weapon() {
    }

    public int setdamage(int damage) {
        return damage;
    }

    public int getdamage() {
        return damage;
    }

    @Override
    public String equip(Player player) {
        if (player.getEquipedWeapon() != null) {
            player.inventory.addItem(player.getEquipedWeapon());
        }
        player.setEquipedWeapon(this);
        player.inventory.removeItem(this.name);
        player.setFullDamage(player.getDamage() + this.getdamage());
        return "You have equiped " + this.getName();
    }
}
