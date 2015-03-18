
package gr.teicm.pm.jzork;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Walkin
 */
public class CommandWords {
   
        private HashMap commands;
        
     public CommandWords(){
         
         commands = new HashMap();
         commands.put("go", new GoCommand());
         commands.put("quit", new QuitCommand());
     }
        public Command get(String word)
        {
            return(Command) commands.get(word);
        }
        
        public void showall(){
            for(Iterator i = commands.keySet().iterator();i.hasNext(); ){
                System.out.print(i.next() +"");
            }
        }
}
