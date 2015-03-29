/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.rooms;

import gr.teicm.pm.jzork.Direction;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Maria
 */
public class Room {
    
    private String roomName;
    private String description;
    private Map<Direction, Room> exits;  
    
    
    public Room() 
    {
        exits = new HashMap<>(); 
    }

    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        
    public String getLongDescription()
    {
        return "You are in " + description + ".\n" + getExitString();
    }
    
    
    
    public void setExit(Direction direction, Room room)
    {
        exits.put(direction, room);
    }
    
    public Room getExit(Direction direction) 
    {
        return (Room)exits.get(direction);
    }
    

    
    
    public Room nextRoom(Direction direction) 
    {
        return (Room)exits.get(direction);
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    private String getExitString()
    {
        StringBuffer result = new StringBuffer( 128 );
        result.append( "Exits:" );
        for(Direction direction : exits.keySet())
        {
            result.append( ' ' );
            result.append( direction );
        }
        return result.toString();
    }
    
}