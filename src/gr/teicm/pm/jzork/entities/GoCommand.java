
package gr.teicm.pm.jzork.entities;

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
String direction = getSecondWord();
player.walk(direction);
}
else {

System.out.println("Go where?");
}
return false;
}
} 
