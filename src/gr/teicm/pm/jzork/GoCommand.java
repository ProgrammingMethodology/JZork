
package gr.teicm.pm.jzork;

import gr.teicm.pm.jzork.entities.Player;

/**
 *
 * @author Walkin
 */
public class  GoCommand  extends Command
{
/**
* Constructor for objects of class GoCommand
*/
public GoCommand()
{
}

public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            Direction direction = Direction.EAST; //getSecondWord();
            player.walk(direction);
        }
        else {
            System.out.println( "Go where?" );
        }
        return false;
    }
} 
