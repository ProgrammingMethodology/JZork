/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork;

/**
 *
 * @author Walkin
 */
public class Weapon extends Item {
private final int damage;
public Weapon (int weight, String name, int damage){
super(weight, name);
this.damage = damage;
}

public int setdamage(int damage){
    return damage;
}
public int getdamage(){
    return damage;
}
}
