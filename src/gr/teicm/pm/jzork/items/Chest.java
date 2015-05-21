/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

import java.io.Serializable;

/**
 *
 * @author Maria
 */
public class Chest extends Item implements Serializable {

    public Chest(boolean isOpen, String description, String itemLocDescription) {
        this.description = description;
        this.isOpen = isOpen;
        //this.id = id;
        this.itemLocDescription = itemLocDescription;
    }

    @Override
    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

}
