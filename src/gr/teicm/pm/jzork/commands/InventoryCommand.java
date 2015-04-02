/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.core.Game;
import gr.teicm.pm.jzork.entities.Player;

/**
 *
 * @author Maria
 */
public class InventoryCommand extends Command{

    public boolean execute(Player player) {
        if(!hasSecondWord()){
            Game game = new Game();
            game.printInventory();
        }
        else{
            System.out.println("I don't understand what you mean!");
        }
        return false;
    }
    
}
