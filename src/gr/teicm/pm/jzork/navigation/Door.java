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
    
    
    private boolean isLocked = false;
    private boolean isOpen = false;
    private Room firstRoom;
    private Room secondRoom;
    private String doorID;
    private String firstRoomDir;
    private String secRoomDir;

    
    public Door(String name, String description){
        this.name = name;
        this.description = description;
    }
    
    public Door(Room firstRoom, String firstRoomDir, String secRoomDir, Room secondRoom,String description ){
        this.firstRoom = firstRoom;
        this.firstRoomDir = firstRoomDir;
        this.secRoomDir = secRoomDir;
        this.secondRoom = secondRoom;
        this.description = description;
        RoomConnector connect = new RoomConnector();
        connect.roomConnection(firstRoom, firstRoomDir, secondRoom, secRoomDir);
    }
    
    
    public void lockDoor(String keyID){
        if(keyID.equals(doorID))
        setIsLocked(true);
    }
    
    public void unlockDoor(String keyID){
        if(keyID.equals(doorID))
        setIsLocked(false);
    }
    
    public void openDoor(){
        setIsOpen(true);
    }
    
    public void closeDoor(){
        setIsOpen(false);
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
