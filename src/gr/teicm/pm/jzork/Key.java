/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork;



/**
 *
 * @author Walkin
 */
public class Key extends Item {
    private final String doorFit;
    
public Key (int weight, String name, String doorFit){
    
    super(weight, name);
    this.doorFit = doorFit;
}

    

    
public String getDoor()
{
    return doorFit;
}
}