/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.items.Torch;

/**
 *
 * @author Babis
 */
public class TurnOnCommand extends Command {

    public TurnOnCommand() {

    }

    @Override
    public boolean execute(Player player){
        if(hasSecondWord()) {
            String item = getSecondWord();
            if (item.equals("torch")){
                if(player.searchInventoryItem(item))
                    player.TurnOnLights();
                else
                    System.out.println("You can't find this item");
            }
        }
        else {
            System.out.println( "Turn on what?" );
        }
        return false;
    }
}
