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
public class Parchment extends Item implements Serializable {
    
       public Parchment(String description, String itemLocDescription){
        this.name = "Parchment";
        this.description = description;
        this.itemLocDescription = itemLocDescription;
        this.isPickable = true;
        
    }
}
