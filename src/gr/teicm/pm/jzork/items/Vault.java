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
    
    private String password;
    private boolean available;
    private boolean isOpen = false;
    
    public Vault(String name, String password, boolean available){
        this.name = name;
        this.password = password;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    
    public boolean tryPassword(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the vault's password: ");
        String pass = input.next();
        
        while (!pass.equals(password) || pass.equals("quit")){
            System.out.println("Wrong Password! Try again or type exit to quit");
        }
        return pass.equals(password);
       
    }
    
}
