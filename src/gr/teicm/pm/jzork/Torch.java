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
public class Torch extends Item {
private final int LightStr;
public Torch (int weight, String name, int str){
super(weight, name);
this.LightStr = str;
}
public int getLightStr()
{
return LightStr;
}
}