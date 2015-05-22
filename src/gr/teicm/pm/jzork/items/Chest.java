/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

import gr.teicm.pm.jzork.entities.Player;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Maria
 */
public class Chest extends Item implements Serializable {

    private final ArrayList<Item> items;

    public Chest(boolean isOpen, String description, String itemLocDescription) {
        this.name = "chest";
        this.description = description;
        this.isOpen = isOpen;
        //this.id = id;
        this.itemLocDescription = itemLocDescription;
        this.isPickable = false;
        items = new ArrayList<>();
    }

    public String openChest(Player player) {
        isOpen = true;

        String resaults = "The chest is open now. " + this.getItemList() + ".";

        Iterator<Item> item = items.iterator();
        while (item.hasNext()) {
            Item tmp = item.next();
            player.currentRoom.addItem(tmp);
            item.remove();
        }

        return resaults;
    }

    public String getItemList() {
        String itemList = "There is ";
        for (Item item : items) {
            item.setIsAvailable(true);
            itemList += item.getItemLocDescription() + " and ";
        }
        itemList = itemList.substring(0, itemList.length() - 5);
        return itemList;
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

    public void addCurrentItem(Item item) {
        items.add(item);
    }

    public void addItem(Item item) {
        items.add(item);
    }

}
