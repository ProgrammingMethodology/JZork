package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import java.io.File;

public abstract class SaveLoadCommand extends Command{
    
    protected static final String DATEFORMAT = "yyyy-MM-dd-hh-mm-ss";
    protected static final String TXT = ".txt";
    protected static final String FILE_SEP = "/";
    protected static final String DEFAULT_PATH = "save";
    
    protected boolean checkIfExists(File folder) {
        return folder.exists();
    }
    
    @Override
    public abstract String execute(Player player);
}
