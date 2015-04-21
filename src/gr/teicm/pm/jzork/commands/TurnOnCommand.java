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

public class TurnOnCommand extends Command {

    public Player player;
    
    public TurnOnCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(Player player){
        if(hasSecondWord()) {
            String item = getSecondWord();
            if (item.equals("torch")){
                if(player.inventory.searchItem(item))
                    return turnOnLights();
                else
                    return "You can't find this item";
            }
        }
        else {
            return "Turn on what?";
        }
        return null;
    }
    
    public String turnOnLights(){
        if(player.currentRoom.isIsDark()){
        player.currentRoom.setIsDark(false);
        return "Now you can see!\n" + player.currentRoom.getDescription();
        }
        else
            return "You don't need light to see. The room isn't so dark at all.";
    }
    
}

