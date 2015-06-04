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
public class Boss extends Enemies implements Serializable {
    
    
    public Boss(){
            
		this.setName("Boss");
		this.setHealthM(180);
                this.SetDamage(28);
                this.setAgility(6);
                this.setLuck(3);
         
	}
}
