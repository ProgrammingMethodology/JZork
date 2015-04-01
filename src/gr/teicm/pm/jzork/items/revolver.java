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
public class revolver extends Weapon {

    public revolver(int weight, String name, int damage) {
        super(weight, name, damage);
        
         this.setdamage(100);
         
    }
    
}
