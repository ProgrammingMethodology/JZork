package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Walkin
 */
public class CommandWords {

    private HashMap commands;

    public CommandWords() {

        commands = new HashMap();
    }

    public Command get(String word) {
        return (Command) commands.get(word);
    }

    public void addCommand(String word, Command command) {
        commands.put(word, command);
    }

    public void showall() {
        for (Iterator i = commands.keySet().iterator(); i.hasNext();) {
            System.out.print(i.next() + "");
        }
    }
}
