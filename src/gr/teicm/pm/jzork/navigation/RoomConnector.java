/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.navigation;

import gr.teicm.pm.jzork.items.Door;

/**
 *
 * @author Babis
 */
public class RoomConnector {

    public void roomConnection(Room firstRoom, String firstRoomExit, Room secondRoom, String secondRoomExit, Door door) {

        if (isConnectionPossible(firstRoomExit, firstRoom) && (isConnectionPossible(secondRoomExit, secondRoom))) {
            firstRoom.setExit(firstRoomExit, door);
            secondRoom.setExit(secondRoomExit, door);
        } else {
            System.out.println("Error trying to connect the " + secondRoom.getRoomName() + " room to the "
                    + firstRoomExit + " exit of the " + firstRoom.getRoomName() + " room");
            System.exit(0);
        }

    }

    public boolean isConnectionPossible(String direction, Room room) {
        switch (direction) {
            case "north":
                return (room.getExit("north")) == null;
            case "south":
                return (room.getExit("south")) == null;
            case "east":
                return (room.getExit("east")) == null;
            case "west":
                return (room.getExit("west")) == null;
            default:
                return false;
        }
    }

    public void RoomInitialize(Room room) {
        room.setExit("north", null);
        room.setExit("south", null);
        room.setExit("east", null);
        room.setExit("west", null);
    }

}
