/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.interfaces;

import gr.teicm.pm.jzork.navigation.Room;

/**
 *
 * @author Babis
 */
public interface ILight {
    
    public String turnLightOn(Room currentRoom);
}
