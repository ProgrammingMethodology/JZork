/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

import java.io.Serializable;

/**
 *
 * @author Walkin
 */

public class Revolver extends Weapon implements Serializable {

    public Revolver(String name, int damage, String itemDetails) {
        super(name, damage);
        this.name = name;
        this.itemDetails = itemDetails;
        
    }
 
    
}
