package gr.teicm.pm.jzork;

/**
 *
 * @author Maria
 */
public enum Direction {
    NORTH("north"), 
    SOUTH("south"), 
    WEST("west"), 
    EAST("east");
    
    private String liveral;
    
    Direction(String name)
    {
        this.liveral = name;
    }
    String gerName()
    {
       return liveral; 
    }
    
}