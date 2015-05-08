/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

import java.io.Serializable;

/**
 *
 * @author Babis
 */
public class Notebook extends Item implements Serializable {
    
    public Notebook(String description, String itemLocDescription){
        this.name = "notebook";
        this.description = description;
        this.itemLocDescription = itemLocDescription;
        this.isPickable = false;
        
    }
    
    
}
