/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.navigation;

/**
 *
 * @author Babis
 */
public class RoomConnector {

    public void roomConnection(Room firstRoom, String firstRoomExit, Room secondRoom, String secondRoomExit) {

        if (isConnectionPossible(firstRoomExit, firstRoom) && (isConnectionPossible(secondRoomExit, secondRoom))) {
            firstRoom.setExit(firstRoomExit, secondRoom);
            secondRoom.setExit(secondRoomExit, firstRoom);
        } else {
            System.out.println("Error trying to connect the " + secondRoom.getRoomName() + " room to the "
                    + firstRoomExit + " exit of the " + firstRoom.getRoomName() + " room");
            System.exit(0);
        }

    }

    public boolean isConnectionPossible(String direction, Room room) {
        switch (direction) {
            case "NORTH":
                return (room.getExit("NORTH")) == null;
            case "SOUTH":
                return (room.getExit("SOUTH")) == null;
            case "EAST":
                return (room.getExit("EAST")) == null;
            case "WEST":
                return (room.getExit("WEST")) == null;
            default:
                return false;
        }
    }

    public void RoomInitialize(Room room) {
        room.setExit("NORTH", null);
        room.setExit("SOUTH", null);
        room.setExit("EAST", null);
        room.setExit("WEST", null);
    }

}
