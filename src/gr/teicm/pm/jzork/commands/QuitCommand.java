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
    public boolean execute(Player player) {
        if (getSecondWord() == null) {
            return true;
        } else {
            System.out.println("I cannot quit...");
            return false;
        }
    }
}
