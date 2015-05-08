package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.core.Parser;
import gr.teicm.pm.jzork.entities.Player;
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
    public void createCommands(Parser parser, Player player) {
        parser.commandWords().addCommand("go", new GoCommand(player));
        parser.commandWords().addCommand("quit", new QuitCommand());
        parser.commandWords().addCommand("open", new OpenCommand(player));
        parser.commandWords().addCommand("pickup", new PickupCommand(player));
        parser.commandWords().addCommand("take", new PickupCommand(player));
        parser.commandWords().addCommand("get", new PickupCommand(player));
        parser.commandWords().addCommand("inventory", new InventoryCommand(player));
        parser.commandWords().addCommand("turnon", new TurnOnCommand(player));
        parser.commandWords().addCommand("enter", new EnterCommand(player));
        parser.commandWords().addCommand("examine", new ExamineCommand(player));
        parser.commandWords().addCommand("look", new ExamineCommand(player));
        parser.commandWords().addCommand("save", new SaveCommand());
        parser.commandWords().addCommand("load", new LoadCommand());
        parser.commandWords().addCommand("unlock", new UnlockCommand(player));
        parser.commandWords().addCommand("drink", new DrinkCommand(player));
        //parser.commandWords().addCommand("attack", new AttackCommand());
        //parser.commandWords().addCommand("equip", new EquipCommand());
    }
    
}
