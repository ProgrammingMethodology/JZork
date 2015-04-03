package gr.teicm.pm.jzork;

import gr.teicm.pm.jzork.items.Item;
import gr.teicm.pm.jzork.navigation.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Inventory {

    private String name;
    private String description;
    protected ArrayList<Item> inventory;
    private long health;
    protected Room currentRoom;

    public Inventory(String name, String description, long health, Room currentRoom)
    {
        this.name = name;
        this.description = description;
        this.health = health;
        inventory = new ArrayList<Item>();
        this.currentRoom = currentRoom;
    }  
    
    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public ArrayList getInventory()
    {
        return inventory;
    }
    
    public void addItem(Item item)
    {
        inventory.add(item);
    }
    
    public void removeItem(String name)
    {
        Iterator<Item> item = inventory.iterator();
        while(item.hasNext()){
            Item tmp = item.next();
            if(tmp.getName().equals(name))
                item.remove();
            }              
    }
}
