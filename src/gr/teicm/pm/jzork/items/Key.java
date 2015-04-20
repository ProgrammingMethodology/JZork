/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

import gr.teicm.pm.jzork.navigation.Room;

/**
 *
 * @author Walkin
 */
public class Key extends Item {
    public String id;
    public  String keyID;
    public String Description;

    public Key(String name, String keyID, String description) {
        this.ID = id;
        this.name = name;
        this.description = description;
        this.keyID = keyID;
    }

    public String getKeyID() {
        return keyID;
    }

    
}
