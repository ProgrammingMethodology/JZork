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
    private boolean isDark;
    private HashMap<String, Door> exits;  
    //private HashMap<String, Item> items;
    
    
    public Room() 
    {
        exits = new HashMap<>();
        //items = new HashMap<String, Item>();
    }

    public void setExit(String direction, Door door)
    {
        exits.put(direction, door);
    }
    
    public Door getExit(String direction) 
    {
        return (Door)exits.get(direction);
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
