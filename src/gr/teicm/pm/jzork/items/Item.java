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

public class Item implements Serializable {
    
    public String id;
    public String name;
    public String description;
    public String itemLocDescription;
    public String password;
    public boolean isOpen = false;
    public boolean isLocked;
    public boolean isAvailable;
    public boolean isPickable;
    
    public Item(){
        this.isAvailable = true;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getItemLocDescription() {
        return itemLocDescription;
    }

    public void setItemLocDescription(String itemLocDescription) {
        this.itemLocDescription = itemLocDescription;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    public void printDescription(String description){
        this.getDescription();
    }

    public boolean isIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isIsPickable() {
        return isPickable;
    }

    public void setIsPickable(boolean isPickable) {
        this.isPickable = isPickable;
    }
    
    

    
    
}
