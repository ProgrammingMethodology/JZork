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
public class Key extends Item {
    public String id;
    public String keyID;

    public Key(String name, String keyID, String description, String itemDetails) {
        this.ID = id;
        this.name = name;
        this.description = description;
        this.itemDetails = itemDetails;
        this.keyID = keyID;
        this.isPickable = true;

    }

    public String getKeyID() {
        return keyID;
    }

    
}
