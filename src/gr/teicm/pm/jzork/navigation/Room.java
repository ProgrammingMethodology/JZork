/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.navigation;

import gr.teicm.pm.jzork.items.Door;
import gr.teicm.pm.jzork.Inventory;
import gr.teicm.pm.jzork.entities.Enemies;
import gr.teicm.pm.jzork.items.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

    
/**
 *
 * @author Babis
 */

public class Room {
    
    private String roomName;
    private String description;
    private boolean isLocked;
    private boolean isDark;
    private HashMap<String, Door> exits;  
    private ArrayList<Item> items;
    private HashMap<String, Inventory> figures;
    private ArrayList<Enemies> monsters;
    
    //private HashMap<String, Item> items;
   
  
    public Room() 
    {
        exits = new HashMap<>();
        items = new ArrayList<>();
        monsters = new ArrayList<>();
        //items = new HashMap<String, Item>();
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
    
    
    public void removeItem(String name)
    {
        Iterator<Item> item = items.iterator();
            while(item.hasNext())
            {
                Item tmp = item.next();
                if(tmp.getName().equals(name))
                    item.remove();
            }              
    }
    
    public String getItemList()
    {
        String itemList = "There is ";
        for(Item item : items) {
            itemList += item.getItemDetails() + " and ";
        }
        itemList = itemList.substring(0, itemList.length()-5);
        return itemList;
    }
    
    public ArrayList getItems()
    {
        return items;
    }

    public Inventory getInventory(String name)
    {
        return figures.get(name);      
    }
    
    public Item searchItem(String name)
    {
        Item itemFound = null;    
        for(Item item : items) 
        {
            String tmp = item.getName().toLowerCase();
            if(tmp.equals(name.toLowerCase()))
                itemFound = item;
            
        }
        return itemFound;
             
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
    
    public void addCurrentItem(Item item)
    {
        items.add(item);
    }

    public void addItem(Item pickedUp) {
        items.add(pickedUp);
    }
    public void addEnemy(Enemies monster)
    {  
        monsters.add(monster);
    }
   
    public boolean isIsDark() {
        return isDark;
    }

    public void setIsDark(boolean isDark) {
        this.isDark = isDark;
    }
    public boolean isLocked(boolean isLocked){
        return isLocked;
    }
    
   
    
   
    
}
