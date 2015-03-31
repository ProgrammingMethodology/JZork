package gr.teicm.pm.jzork;

import static gr.teicm.pm.jzork.Direction.EAST;
import static gr.teicm.pm.jzork.Direction.NORTH;
import static gr.teicm.pm.jzork.Direction.SOUTH;
import static gr.teicm.pm.jzork.Direction.WEST;
import gr.teicm.pm.jzork.rooms.Hall;
import gr.teicm.pm.jzork.rooms.Outside;
import gr.teicm.pm.jzork.rooms.Room3;
import gr.teicm.pm.jzork.rooms.Room;
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
    private Outside outside;
    private Room test;
    private Hall hall;
    
    

    public Game() {
        parser = new Parser();
        Player player = new Player();
    }

    public Game(Player player, Parser parser) {
        this.player = player;
        this.parser = parser;
    }

    public final Parser parser() {
        ensureInitialization();
        return parser;
    }

    public final Player player() {
        ensureInitialization();
        return player;
    }

    public void createPlayer() {
        Scanner input = new Scanner(System.in);
        System.out.print("To start, please enter your name: ");
        name = input.next();
        player = new Player();
        player.setName(name);
        player.setCurrentRoom(currentRoom);
    }

    private void ensureInitialization() {
        if (!initialized) {
            initialized = true;
            createRooms();
        }
    }

    public void createRooms() {
        Outside outside = new Outside();
        Hall hall = new Hall();
        Room3 room3 = new Room3();
        
        roomConnection(outside,EAST,hall,WEST);
        roomConnection(hall,NORTH,room3,SOUTH);
    }

    public void play() {
        createPlayer();
        ensureInitialization();
        createRooms();
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            if (command == null) {
                System.out.println("I don't understand what you mean!");
            } else {
                finished = command.execute(player);
            }
        }
        System.out.println("Thank you for playing.Good bye.");

    }

    public void roomConnection(Room firstRoom, Direction firstRoomExit, Room secondRoom, Direction secondRoomExit ){
        
        
        if (isConnectionPossible(firstRoomExit,firstRoom) && (isConnectionPossible(secondRoomExit,secondRoom))){
            firstRoom.setExit(firstRoomExit, secondRoom);
            secondRoom.setExit(secondRoomExit, firstRoom);
        }
        else{
            System.out.println("Error trying to connect the " + secondRoom.getRoomName() + " room to the " 
                    + firstRoomExit + " exit of the " + firstRoom.getRoomName() + " room" );
            System.exit(0);
        }
        
    }

    public boolean isConnectionPossible(Direction direction, Room room) {
        switch (direction) {
            case NORTH:
                return (room.getExit(Direction.NORTH)) == null;
            case SOUTH:
                return (room.getExit(Direction.SOUTH)) == null;
            case EAST:
                return (room.getExit(Direction.EAST)) == null;
            case WEST:
                return (room.getExit(Direction.WEST)) == null;
            default: 
                return false;
        }
    }

    
     public void printWelcome()
     {
        System.out.println();
        System.out.println("Welcome " + name + "!");
        System.out.println();
        currentRoom = outside;
        System.out.println(currentRoom.getLongDescription());
     }
     
}
