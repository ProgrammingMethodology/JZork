/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.navigation;

import gr.teicm.pm.jzork.items.Door;
import gr.teicm.pm.jzork.entities.Enemies;
import gr.teicm.pm.jzork.items.Item;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author Babis
 */
public class Room implements Serializable {

    private String roomName;
    private String description;
    private boolean isDark;
    private final HashMap<String, Door> exits;
    public ArrayList<Item> items;
    private final TreeMap<String, Enemies> monsters =
            new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public Room() {
        exits = new HashMap<>();
        items = new ArrayList<>();
    }


    public void removeItem(String name) {
        Iterator<Item> item = items.iterator();
        while (item.hasNext()) {
            Item tmp = item.next();
            if (tmp.getName().equals(name)) {
                item.remove();
            }
        }
    }

    public String getItemList() {
        String itemList = "There is ";
        for (Item item : items) {
            if (item.isAvailable) {
                itemList += item.getItemLocDescription() + " and ";
            }
        }
        itemList = (items.isEmpty()) ? "" : itemList.substring(0, itemList.length() - 5) + ".";
        return itemList;
    }

    public ArrayList getItems() {
        return items;
    }


    public Item searchItem(String name) {
        Item itemFound = null;
        for (Item item : items) {
            String tmp = item.getName().toLowerCase();
            if (tmp.equals(name.toLowerCase())) {
                itemFound = item;
            }

        }
        return itemFound;

    }

    public boolean isItemValid(String name) {

        for (Item item : items) {
            String tmp = item.getName().toLowerCase();
            if (tmp.equals(name.toLowerCase())) {
                return true;
            }

        }
        return false;

    }

    public void setExit(String direction, Door door) {
        exits.put(direction, door);
    }

    public Door getExit(String direction) {
        return (Door) exits.get(direction);
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

    public void addCurrentItem(Item item) {
        items.add(item);
    }

    public void addItem(Item pickedUp) {
        items.add(pickedUp);
    }

    public void addEnemy(Enemies monster)
    {  
        if(!monsters.containsKey(monster.getName()))
            monsters.put(monster.getName(), monster);     
    }
    
    public TreeMap<String, Enemies> getEnemies () {
        return monsters;
    }

    public boolean isIsDark() {
        return isDark;
    }

    public void setIsDark(boolean isDark) {
        this.isDark = isDark;
    }

    public boolean isLocked(boolean isLocked) {
        return isLocked;
    }

}
