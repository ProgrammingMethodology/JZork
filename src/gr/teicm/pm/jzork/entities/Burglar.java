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
public class Burglar extends Enemies implements Serializable {
	public Burglar(){
		this.setName("Burglar");
		this.setHealthM(55);
                this.setDamage(25);
                this.setAgility(4);
                this.setLuck(1);
               
	
                
	}
}