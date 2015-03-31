/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork;

import java.io.Serializable;

/**
 *
 * @author Walkin
 */
public class Item implements Serializable {
private final int weight;
private final String name;
public Item(int weight, String name){
this.weight = weight;
this.name = name;
}
//Getters and setters
public String getName(){
return name;
}
public int getWeight(){
return weight;
}
//public boolean containsProperty(String key) {
//return properties.containsKey(key);
//}
public boolean equals(Object obj) {
if (obj == null) {
return false;
}
if (obj instanceof Item) {
Item i = (Item) obj;
return name.equals(i.name);
}
return false;
}



}
