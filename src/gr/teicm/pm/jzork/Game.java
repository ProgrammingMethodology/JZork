package gr.teicm.pm.jzork;

import gr.teicm.pm.jzork.entities.Player;
import java.util.Scanner;

/**
 *
 * @author Maria
 */
public class Game {

    
    private Parser parser;
    private Player player;
    public Room currentRoom;
    private boolean initialized = false;
    private String name;
     
    public Game()
    {
        parser = new Parser();
        Player player = new Player(name, "description", 100, 100, 10, 10, 10, true, currentRoom );
    }
    
    public Game( Player player, Parser parser )
    {
        this.player = player;
        this.parser = parser;
    }
    
    
    public final Parser parser()
    {
        ensureInitialization();
        return parser;
    }
    
    public final Player player()
    {
        ensureInitialization();
        return player;
    }
    
    public void createPlayer()
    {
        Scanner input = new Scanner(System.in);
        System.out.print ("To start, please enter your name: ");
        name = input.next();
        Player player = new Player(name, "description", 100, 100, 10, 10, 10, true, currentRoom );
    }
    
    private void ensureInitialization()
    {
        if ( !initialized )
	    {
                initialized = true;
	        createRooms();
	    }
    }
    
    public void createRooms()
    {
        Room1.createRoom();
        Room2.createRoom();
        Room3.createRoom();
    }
    
    public void play() 
    {
        createPlayer();
        ensureInitialization();
        printWelcome();
        
        boolean finished = false;
	    while(! finished) 
            {
	        Command command = parser.getCommand();
                if(command == null)
	            System.out.println("I don't understand what you mean!");
                else
                    finished = command.execute(player);
	    }
	        System.out.println("Thank you for playing.Good bye.");
	    
    }
    
    public void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome " + name + "!");
        System.out.println();
        currentRoom = Room1.livingroom;
        System.out.println(currentRoom.getLongDescription());
    }
}
