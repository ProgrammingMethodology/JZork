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

public class Item {
    public String ID;
    public int weight;
    public String name;
    public String description;
    public String itemDetails;
    public String password;
    public boolean isOpen;
    
    public Item(int weight, String name, String description) {
        this.weight = weight;
        this.name = name;
        this.description = description;
    }
    
    public Item(){
    }
    
    public void setID(String id){
        this.ID = id;
    }
    
    public String getID(){
        return ID;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
    
    public String getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
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
    
    

    
    
}
