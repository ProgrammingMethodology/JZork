/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.*;
import gr.teicm.pm.jzork.entities.Player;

/**
 *
 * @author Maria
 */

public class HelpCommand extends Command {
    
    private final CommandWords commandWords;

    public HelpCommand(CommandWords words) {
        
        commandWords = words;
        
    }

    @Override
    public String execute(Player player) {
        
        return "Your command words are:\n" + commandWords.showAll();
    }
    
}
