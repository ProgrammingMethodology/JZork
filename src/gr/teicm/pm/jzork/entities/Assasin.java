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
public class Assasin extends Enemies implements Serializable {
    
	public Assasin(){
            
		this.setName("Assasin");
		this.setHealthM(55);
                this.SetDamage(40);
                this.setAgility(6);
                this.setLuck(4);
         
	}
}

