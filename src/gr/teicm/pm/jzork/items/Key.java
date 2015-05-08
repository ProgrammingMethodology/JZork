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
public class Key extends Item implements Serializable{
    

    public Key(String id, String description, String itemDetails) {
        
        this.name = "key";
        this.id = id;
        this.description = description;
        this.itemLocDescription = itemDetails;
        this.isPickable = true;
    }

    

    
}
