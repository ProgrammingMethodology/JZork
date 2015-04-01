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

    private final String keyID;
    private String description;

    public Key(String keyID, String description) {

        this.description = description;
        this.keyID = keyID;
    }

    public String getKeyID() {
        return keyID;
    }

    
}
