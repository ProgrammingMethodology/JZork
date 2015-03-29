package gr.teicm.pm.jzork.rooms;

/**
 *
 * @author Maria
 */
public interface IRoom {
    
    public void setExit(Room north, Room east, Room south, Room west);
    public Room getExit(String direction);
    public String shortDescription();
    public String getLongDescription();
}
