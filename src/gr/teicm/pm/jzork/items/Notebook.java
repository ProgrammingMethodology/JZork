/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

/**
 *
 * @author Babis
 */
public class Notebook extends Item {
    
    public Notebook(String name, String description, String itemDetails){
        this.name = name;
        this.description = description;
        this.itemDetails = itemDetails;
        this.isPickable = true;
        
    }
    
    
}
