/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;

/**
 *
 * @author Maria
 */
public class InventoryCommand extends Command {

    public Player player;

    public InventoryCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(Player player) {
        if (!hasSecondWord()) {
            return getPlayersInventory();
        } else {
            return "I don't understand what you mean!";
        }

    }

    public String getPlayersInventory() {
        return player.inventory.printInventory();
    }

}
