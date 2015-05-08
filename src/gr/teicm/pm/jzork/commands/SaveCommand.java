/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.entities.Player;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveCommand extends SaveLoadCommand {
    
    public SaveCommand() {
        File defaultFolder = new File(DEFAULT_PATH);
        
        if(!defaultFolder.exists()) {
            defaultFolder.mkdir();
        }
    }
    
    @Override
    public String execute(Player player) {

        File folder = new File(DEFAULT_PATH + FILE_SEP + player.getName());
        FileOutputStream fOut;
        ObjectOutputStream oos;
        
        if(!checkIfExists(folder)) 
            folder.mkdir();
        
        Date now = new Date();
        SimpleDateFormat f = new SimpleDateFormat(DATEFORMAT);
        File file = new File(folder.getAbsolutePath() + FILE_SEP + f.format(now) + TXT);       
        
        try {
            fOut = new FileOutputStream(file);
            oos = new ObjectOutputStream(fOut);
            oos.writeObject(player);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "I'm sorry, didn't saved.Try again.";
        }
        
        return "saved";
    }
}
