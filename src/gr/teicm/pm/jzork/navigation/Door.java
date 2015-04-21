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
public class Door extends Item {

    public boolean isLocked;
    private boolean isOpen = false;
    private final Room firstRoom;
    private final Room secondRoom;
    public String doorID;

    @SuppressWarnings("LeakingThisInConstructor")
    public Door(Room firstRoom, String firstRoomDir, String secRoomDir, Room secondRoom, boolean isLocked, String description, String doorID) {
        this.firstRoom = firstRoom;
        this.secondRoom = secondRoom;
        this.description = description;
        this.isLocked = isLocked;
        this.doorID = doorID;
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
            this.getDoorStatus(isLocked, isOpen);
            return currentRoom;
        }
    }

    public String getDoorStatus(boolean isLocked, boolean isOpen) {

        if (isLocked) {
            return "The door is locked!";
        } else if (!isOpen) {
            return "The door is closed!";
        } else if (isOpen) {
            return "The door is open!";
        } else if (!isLocked) {
            return "The door is already unlocked";
        }
        return null;

    }

    public void lockDoor(String keyID) {
        if (keyID.equals(doorID)) {
            setIsLocked(true);
        }
    }

    public void unlockDoor(String keyID) {
        if (keyID.equals(doorID)) {
            setIsLocked(false);
        }
    }

    public void openDoor() {
        setIsOpen(true);
    }

    public void closeDoor() {
        setIsOpen(false);
    }

    public boolean isIsLocked() {
        return isLocked;
    }

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
