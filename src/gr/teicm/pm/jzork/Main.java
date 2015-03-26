/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork;

/**
 *
 * @author Maria
 */
public class Main {
    //private Parser parser;
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Game main = new Game() {};
        main.play();
        try {
        } catch (Exception e) {
            System.err.println("There was a problem.");
        }
    }
    
}
