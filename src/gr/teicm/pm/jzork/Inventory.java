package gr.teicm.pm.jzork;

import gr.teicm.pm.jzork.items.Item;
import gr.teicm.pm.jzork.navigation.Room;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {

    
    
    protected ArrayList<Item> inventory;
    protected Room currentRoom;

    public Inventory(){
        inventory = new ArrayList<>();
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
    
    
    public void printInventory() {
        String allitems = "";
        for (Item item : inventory) {
            allitems += "\n" + item.getName();
        }
        if (allitems.length() > 0) {
            System.out.println("Your inventory:" + allitems);
        } else {
            System.out.println("Your inventory is empty");
        }
    }
    
    public boolean searchItem(String name)
    {
        Item itemFound = null;    
        for(Item item : inventory) 
        {
            String tmp = item.getName().toLowerCase();
            if(tmp.equals(name.toLowerCase()))
                return true;
            
        }
        return false;
             
    }
    
    
    
}
