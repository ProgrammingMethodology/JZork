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
import java.util.Scanner;

/**
 *
 * @author Babis
 */
public class Vault extends Item implements Serializable {

    private ArrayList<Item> items;

    public Vault(String password, boolean available, String itemLocDescription) {
        this.name = "vault";
        this.password = password;
        this.isAvailable = available;
        this.itemLocDescription = itemLocDescription;
        this.isLocked = true;
        this.isPickable = false;
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
            item.setIsAvailable(true);
            itemList += item.getItemLocDescription() + " and ";
        }
        itemList = itemList.substring(0, itemList.length() - 5);
        return itemList;
    }

    public String enterPassword(Player player) {
        if (isLocked) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter the vault's password: ");
            String pass = input.next();

            while (!pass.equals(password) || pass.equals("quit")) {
                System.out.println("Wrong Password! Try again or type exit to quit");
                pass = input.next();
            }
            if (pass.equals(password)) {
                isLocked = false;
                String outcome = "The vault has been opened." + this.getItemList();
                Iterator<Item> item = items.iterator();
                while (item.hasNext()) {
                    Item tmp = item.next();
                    player.currentRoom.addItem(tmp);
                    item.remove();
                }
                return outcome;
            } else {
                return "The vault remains locked";
            }
        } else {
            return "The vault is already open";
        }
    }

    public void addCurrentItem(Item item) {
        items.add(item);
    }

    public void addItem(Item pickedUp) {
        items.add(pickedUp);
    }

}
