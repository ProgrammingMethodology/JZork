/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.entities;

import java.io.Serializable;

/**
 *
 * @author Walkin
 */
public class Dog extends Enemies implements Serializable {
    	public Dog(){
		this.setName("Dog");
		this.setHealth(30);
                this.setDamage(15);
                this.setAgility(1);
                this.setLuck(1);
               
	
                
	}
}
