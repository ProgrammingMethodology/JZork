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

    public final HashMap<String, Command>  commands = new HashMap();
    public final HashMap<String, String>  desCommands = new HashMap();
    private Player player;
    private Parser parser;
    private CommandWords words;


    public CommandWords() {
       
        
    }

    public Command get(String word) {
        return commands.get(word);
    }

    public void addCommand(String word, String description, Command command) {
        commands.put( word, command );
        desCommands.put(word, description);
    }

    public String showAll()
    {
        parser = new Parser();
        player = new Player();
        words = new CommandWords();
        createCommands(parser,player,words);
        
        String results = "";
        Iterator<String> descmdSetIterator = desCommands.keySet().iterator();
        while(descmdSetIterator.hasNext()) {
            String des = descmdSetIterator.next();
            results = results + des + " :  " + desCommands.get(des) + " \n" ;
        }
        return results;
    }
    
    public void createCommands(Parser parser, Player player, CommandWords words) {
        addCommand("go", "To navigate.", new GoCommand(player));
        addCommand("quit", "To quit from the game.", new QuitCommand());
        addCommand("open", "To open an item.", new OpenCommand(player));
        addCommand("pickup", "To get an item.", new PickupCommand(player));
        addCommand("take", "To get an item.", new PickupCommand(player));
        addCommand("get", "To get an item.", new PickupCommand(player));
        addCommand("inventory", "To see your inventory.", new InventoryCommand(player));
        addCommand("turnon", "To turn on a torch or a switch.", new TurnOnCommand(player));
        addCommand("enter", "To enter. For example in a vault.", new EnterCommand(player));
        addCommand("examine", "To examine an item.", new ExamineCommand(player));
        addCommand("look", "To examine an item.", new ExamineCommand(player));
        addCommand("save", "To save your game.", new SaveCommand());
        addCommand("load", "To load your game.", new LoadCommand());
        addCommand("unlock", "To unlock an item.", new UnlockCommand(player));
        addCommand("drink", "To drink.", new DrinkCommand(player));
        addCommand("equip", "To equip an item.", new EquipCommand(player));
        addCommand("stats", "To see your statics.", new StatsCommand(player));
        addCommand("attack", "To attack enemies.", new AttackCommand());
        //parser.commandWords().addCommand("attack", new AttackCommand());
        addCommand("help", "To see the list with words you can use.", new HelpCommand(words));
        addCommand("drop", "To see the list with words you can use.", new DropCommand(player));
    }
    
}
