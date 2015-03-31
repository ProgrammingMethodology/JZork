/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.navigation;

import java.util.HashMap;
import java.util.Map;

    
/**
 *
 * @author Babis
 */
public class Room {
    
    private String roomName;
    private String description;
    private HashMap<String, Room> exits;  
    //private HashMap<String, Item> items;
    
    
    public Room() 
    {
        exits = new HashMap<>();
        //items = new HashMap<String, Item>();
    }

    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }
    
    public Room getExit(String direction) 
    {
        return (Room)exits.get(direction);
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Room nextRoom(String direction) 
    {
        return (Room)exits.get(direction);
    }
    
    public String getExitString()
    {
        StringBuilder result = new StringBuilder( 128 );
        result.append( "Exits:" );
        exits.keySet().stream().forEach((direction) -> {
            result.append( ' ' );
            result.append( direction );
        });
        return result.toString();
    }
    
}
