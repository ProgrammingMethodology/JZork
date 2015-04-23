/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.items;

import java.util.Scanner;

/**
 *
 * @author Babis
 */
public class Vault extends Item{
    
    
    
    
    public Vault(String name, String password, boolean available, String itemDetails){
        this.name = name;
        this.password = password;
        this.isAvailable = available;
        this.itemDetails = itemDetails;
        this.isOpen = false;
    }

    
    public boolean enterPassword(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the vault's password: ");
        String pass = input.next();
        
        while (!pass.equals(password) || pass.equals("quit")){
            System.out.println("Wrong Password! Try again or type exit to quit");
        }
        return pass.equals(password);
       
    }
    
}
