/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

/**
 *
 * @author Walkin
 */

public class Weapon extends Item {

    public final int damage;

    public Weapon(String name, int damage) {
//super(weight, name);
        this.damage = damage;
    }

    public int setdamage(int damage) {
        return damage;
    }

    public int getdamage() {
        return damage;
    }
}
