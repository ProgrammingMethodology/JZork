/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork;

import java.util.Enumeration;
import java.util.Hashtable;
/**
 *
 * @author Maria
 */
public class Room {
    
    private String roomName;
    private String description;
    public static Hashtable exits;
    public static Room activateRoom,nextRoom;
    public static Room livingroom,kitchen,bedroom;
    
    public Room(String roomName, String description) 
    {
    	this.roomName = roomName;
        this.description = description;
        exits = new Hashtable();
    }
    
    public void setExit(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            exits.put("north", north);
        if(east != null)
            exits.put("east", east);
        if(south != null)
            exits.put("south", south);
        if(west != null){
            exits.put("west", west);
        }
            
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
        activateRoom = Room1.livingroom;
        System.out.println(activateRoom.getLongDescription());
    }
    
    
    public String shortDescription()
    {
        return description;
    }
        
    public String getLongDescription()
    {
        return "You are in " + description + ".\n" + exitString();
    }
    
    public String exitString()
    {
        String returnString = "You see a door to the";
        Enumeration keys;
        keys = exits.keys();
        while(keys.hasMoreElements())
            returnString += " " + keys.nextElement();
        return returnString;
    }
    
    public String getRoomName(){
    	
    	return roomName;
    }

}