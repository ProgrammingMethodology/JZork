
package gr.teicm.pm.jzork.entities;

/**
 *
 * @author Walkin
 */
public class QuitCommand extends Command
{
/**
* Constructor for objects of class QuitCommand
*/
public QuitCommand()
{
}

public boolean execute(Player player)
{
if(getSecondWord() == null) {
return true;
}
else {
System.out.println("I cannot quit...");
return false;
}
}
} 
