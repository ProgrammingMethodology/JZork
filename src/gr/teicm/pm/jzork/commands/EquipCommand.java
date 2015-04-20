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
 * @author Walkin
 */
public class EquipCommand extends Command {
    public String equipedItem;
    
     public EquipCommand() {
    }
      @Override
    public boolean execute(Player player) {
        if (!hasSecondWord()) {
            System.out.println("Equip what?");
        }
            else if(hasSecondWord()){
            equipedItem = getSecondWord();
            boolean tmp = player.searchInventoryItem(equipedItem);
                       if(tmp == true){
              System.out.println("You equiped the "+ equipedItem);
            }
                       else if(tmp == false){
                           System.out.println("You don't have that item");
                       }
                       
}
        return false;
      
    }
}
      
     


 
