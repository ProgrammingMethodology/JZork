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
public class Sword extends Weapon {

    public Sword(String name, int damage) {
        super(name, damage);
        this.name = name;
    }
        public void setDamage(){
        this.setdamage(60);
    }
    public int getDamage(){
    return damage;
}
}
