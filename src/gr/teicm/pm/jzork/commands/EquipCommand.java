/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.items.Item;
import gr.teicm.pm.jzork.items.Knife;
import gr.teicm.pm.jzork.items.Revolver;
import gr.teicm.pm.jzork.items.Sword;

/**
 *
 * @author Walkin
 */
public class EquipCommand extends Command {

    public String item;

    public EquipCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(Player player) {
        if (hasSecondWord()) {item = getSecondWord();
            switch (item) {
                case "revolver":
                    if (player.inventory.isItemValid(item)) {
                        Item obj = player.inventory.searchItem(item);
                        Revolver revolver = (Revolver) obj;
                        return revolver.equip(player);
                    } else {
                        return "You can't find this item";
                    }
                case "sword":
                    if (player.inventory.isItemValid(item)) {
                        Item obj = player.inventory.searchItem(item);
                        Sword sword = (Sword) obj;
                        return sword.equip(player);
                    } else {
                        return "You can't find this item";
                    }
                case "knife":
                    if (player.inventory.isItemValid(item)) {
                        Item obj = player.inventory.searchItem(item);
                        Knife knife = (Knife) obj;
                        return knife.equip(player);
                    } else {
                        return "You can't find this item";
                    }
                default: 
                    return "You can't find this item";
            }

        }
        return "Equip what?";
    }
}

/*

 equipedItem = getSecondWord();
 boolean tmp = player.searchInventoryItem(equipedItem);
 if (tmp == true) {
 System.out.println("You equiped the " + equipedItem);
 } else if (tmp == false) {
 System.out.println("You don't have that item");
 }
 */
