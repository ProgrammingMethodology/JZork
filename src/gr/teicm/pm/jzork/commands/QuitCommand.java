package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;

/**
 *
 * @author Walkin
 */
public class QuitCommand extends Command {

    /**
     * Constructor for objects of class QuitCommand
     */
    public QuitCommand() {
    }

    @Override
    public String execute(Player player) {
        if (getSecondWord() == null) {
            return "quit";
        } else {
            return "I cannot quit...";
            
        }
    }
}
