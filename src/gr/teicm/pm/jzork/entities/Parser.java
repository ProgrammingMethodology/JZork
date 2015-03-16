
package gr.teicm.pm.jzork.entities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 *
 * @author Walkin
 */
public class Parser {
    
    private CommandWords commands;
    
    public Parser(){
        commands = new CommandWords();
    }  
    public Command getCommand(){
        String inputLine="";
        String word1;
        String word2;
        
        System.out.print(">");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            inputLine=reader.readLine();
        }
                catch(java.io.IOException exc){
                        System.out.println("There was an error during reading:" +exc.getMessage());
                        }
         StringTokenizer tokenizer = new StringTokenizer(inputLine);
         
if(tokenizer.hasMoreTokens())
    word1 = tokenizer.nextToken(); 

else
        word1 = null;
if(tokenizer.hasMoreTokens())
    word2 = tokenizer.nextToken(); 

else
        word2 = null;


Command command = commands.get(word1);
if(command != null) {
command.setSecondWord(word2);
}
return command;
} 
}
        
    

