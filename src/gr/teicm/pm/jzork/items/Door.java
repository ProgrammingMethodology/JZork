/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

import gr.teicm.pm.jzork.navigation.Room;
import gr.teicm.pm.jzork.navigation.RoomConnector;
import java.io.Serializable;

/**
 *
 * @author Babis
 */
public class Door extends Item implements Serializable{

    
    private final Room firstRoom, secondRoom;
    public final String firstRoomDir, secRoomDir;

    @SuppressWarnings("LeakingThisInConstructor")
    public Door(Room firstRoom, String firstRoomDir, String secRoomDir, Room secondRoom, boolean isLocked, String description, String id) {
        this.firstRoom = firstRoom;
        this.secondRoom = secondRoom;
        this.firstRoomDir = firstRoomDir;
        this.secRoomDir = secRoomDir;
        this.description = description;
        this.isLocked = isLocked;
        this.id = id;
        this.isPickable = false;

        RoomConnector connect = new RoomConnector();
        connect.roomConnection(firstRoom, firstRoomDir, secondRoom, secRoomDir, this);
    }

    public Room getConnectedRoom(Room currentRoom) {
        if (!isLocked && isOpen) {
            if (currentRoom == firstRoom) {
                return secondRoom;
            } else {
                return firstRoom;
            }
        } else {
            return null;
        }
    }

    public String getDoorStatus(boolean isLocked, boolean isOpen) {

        if (isLocked) {
            return "The door is locked!";
        } else if (!isOpen) {
            return "The door is closed!";
        } else if (isOpen) {
            return "The door is open!";
        } else {
            return "The door is already unlocked";
        }

    }

    public void lockDoor(String keyID) {
        if (keyID.equals(id)) {
            setIsLocked(true);
        }
    }

    public void unlockDoor(String keyID) {
        if (keyID.equals(id)) {
            setIsLocked(false);
        }
    }

    

    public void closeDoor() {
        setIsOpen(false);
    }

    @Override
    public boolean isIsLocked() {
        return isLocked;
    }

    @Override
    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    @Override
    public boolean isIsOpen() {
        return isOpen;
    }

    @Override
    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

}
