package gr.teicm.pm.jzork.core;

import gr.teicm.pm.jzork.commands.CommandWords;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *
 * @author Walkin
 */
public class Parser {

    private CommandWords commands;

    public Parser() {
        commands = new CommandWords();
    }

    public Command getCommand() {
        String inputLine = "";
        String word1,word2,word3,word4;
        
        System.out.print(">");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine();
        } catch (java.io.IOException exc) {
            System.out.println("There was an error during reading:" + exc.getMessage());
        }
        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if (tokenizer.hasMoreTokens()) {
            String lowerword1 = tokenizer.nextToken().toLowerCase();
            word1 = lowerword1;
            word1 = cleanseLine(word1);
        } else {
            word1 = null;
        }
        if (tokenizer.hasMoreTokens()) {
            String lowerword2 = tokenizer.nextToken().toLowerCase();
            word2 = lowerword2;
            word2 = cleanseLine(word2);
            if (word2==null && tokenizer.hasMoreTokens()){
                String lowerword3 = tokenizer.nextToken().toLowerCase();
                word3 = lowerword3;
                word2 = cleanseLine(word3);
            } 
        } else {
            word2 = null;
        }
        if (tokenizer.hasMoreTokens()) {
            String lowerword3 = tokenizer.nextToken().toLowerCase();
            word3 = lowerword3;
            word3 = cleanseLine(word3);
            if (word3==null && tokenizer.hasMoreTokens()){
                String lowerword4 = tokenizer.nextToken().toLowerCase();
                word4 = lowerword4;
                word3 = cleanseLine(word4);
            }
        } else {
            word3 = null;
        }
        
        
        Command command = commands.get(word1);
        
        if (command != null) {
            command.setSecondWord(word2);
            command.setThirdWord(word3);
        }
        
        
        return command;
    }

    public CommandWords commandWords() {
        return commands;
    }
    
    private String cleanseLine(String word) {
        String [] ignoredWords = {
          "at",
          "the",
          "a",
          "an",
          "to"
        };
        HashSet ignored = new HashSet(Arrays.asList(ignoredWords));
        StringTokenizer tokenizer = new StringTokenizer(word);
        StringBuilder sb = new StringBuilder();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!ignored.contains(token)) {
                sb.append(token).append(" ");
            }
        }
        String result = sb.toString();
        if (result.endsWith(" ")) {
            result = result.substring(0, result.length()-1);
        }
        else
            result = null;
        return result;   
    }
}
