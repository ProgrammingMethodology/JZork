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
public class PickupCommand extends Command{

    public PickupCommand()
    {
        
    }
    public boolean execute(Player player) {
        if(hasSecondWord()) {
            String command = getSecondWord();
            player.take(command);
        }
        else {
            System.out.println( "Pick up what?" );
        }
        
        return false;
    }
    
}
