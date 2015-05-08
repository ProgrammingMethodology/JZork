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
 * @author Babis
 */
public class StatsCommand extends Command {

    public StatsCommand(Player player) {
        this.player = player;
    }
    
    @Override
    public String execute(Player player) {
        if (!hasSecondWord()) {
            return player.printStats(player);
        } else {
            return "I don't understand what you mean!";
        }

    }
    
}
