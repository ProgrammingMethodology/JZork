/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.items.Item;
import gr.teicm.pm.jzork.items.LightSwitch;
import gr.teicm.pm.jzork.items.Torch;

/**
 *
 * @author Babis
 */
public class TurnOnCommand extends Command {

    
    public Item obj;
    public String item;

    public TurnOnCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(Player player) {
        if (hasSecondWord()) {
            item = getSecondWord();
            switch (item) {
                case "torch":
                    if (player.inventory.isItemValid(item)) {
                        obj = player.inventory.searchItem(item);
                        Torch torch = (Torch) obj;
                        return torch.turnLightOn(player.currentRoom);
                    } else {
                        return "You can't find this item";
                    }
                case "switch":
                    if (player.currentRoom.isItemValid(item)) {
                        obj = player.currentRoom.searchItem(item);
                        LightSwitch lightSwitch = (LightSwitch) obj;
                        return lightSwitch.turnLightOn(player.currentRoom);
                    } else {
                        return "You can't find this item";
                    }
                default: 
                    return "You can't find this item";
            }

        }
        return "Turn on what?";
    }
       
    
}
