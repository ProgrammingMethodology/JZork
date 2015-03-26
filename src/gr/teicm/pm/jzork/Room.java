/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Maria
 */
public class Room {
    
    private String roomName;
    private String description;
    private Map<String, Room> exits;  
    public static Room currentRoom,nextRoom;
    public static Room livingroom,kitchen,bedroom;
    
    public Room(String roomName, String description) 
    {
    	
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }
    
    public Room getExit(String direction) 
    {
        return (Room)exits.get(direction);
    }
    
    public static void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome!");
        System.out.println();
        currentRoom = Room1.livingroom;
        System.out.println(currentRoom.getLongDescription());
    }
    
    
    public String shortDescription()
    {
        return description;
    }
        
    public String getLongDescription()
    {
        return "You are in " + description + ".\n" + getExitString();
    }
    
    public Room nextRoom(String direction) 
    {
        return (Room)exits.get(direction);
    }
    
    private String getExitString()
    {
        StringBuffer result = new StringBuffer( 128 );
        result.append( "Exits:" );
        for(String direction : exits.keySet())
        {
            result.append( ' ' );
            result.append( direction );
        }
        return result.toString();
    }
    
}