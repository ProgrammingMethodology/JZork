/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.rooms;

import gr.teicm.pm.jzork.Direction;

/**
 *
 * @author Maria
 */
public class Hall extends Room{
    
    
    public Hall() {
        
        this.setDescription("Blablablasa");
        this.setRoomName("Hall");
        this.setExit(Direction.NORTH,null);
        this.setExit(Direction.SOUTH,null);
        this.setExit(Direction.EAST,null);
        this.setExit(Direction.WEST,null);
    } 
}
