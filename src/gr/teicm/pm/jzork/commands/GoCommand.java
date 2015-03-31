
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.navigation.Room;

/**
 *
 * @author Walkin
 */
public class  GoCommand  extends Command
{
/**
* Constructor for objects of class GoCommand
*/
private Room currentRoom;

public GoCommand()
{
}

public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String direction = getSecondWord();
            player.walk(direction);
        }
        else {
            System.out.println( "Go where?" );
        }
        return false;
    }
} 
