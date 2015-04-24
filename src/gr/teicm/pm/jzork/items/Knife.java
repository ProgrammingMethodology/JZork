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
public class Knife extends Item {

    public Knife(String name, String description, int damage, String itemDetails) {
        this.name = name;
        this.description = description;
        this.itemDetails = itemDetails;
        this.isPickable = true;
    }
}
