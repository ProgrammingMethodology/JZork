/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.navigation;

import gr.teicm.pm.jzork.items.Item;

/**
 *
 * @author Babis
 */
public class Door extends Item{
    
    boolean isLocked;
    boolean isOpen;
    
    
    public void lockDoor(){
        setIsLocked(true);
    }
    
    public void unlockDoor(){
        setIsLocked(false);
    }
    
    public void openDoor(){
        setIsOpen(true);
    }
    
    public void closeDoor(){
        setIsOpen(false);
    }
    
    public Door(String name, String description){
        this.name = name;
        this.description = description;
    }
        
    public boolean isIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    public void getDoorStatus(boolean isLocked, boolean isOpen){
        
        if (isLocked)
            System.out.println("The door is locked!");
        else if(!isLocked && (!isOpen))
            System.out.println("The door is closed!");
        else 
            System.out.println("The door is open!");
        
        
    }
    
}
