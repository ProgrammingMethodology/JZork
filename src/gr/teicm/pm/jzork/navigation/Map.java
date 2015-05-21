/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.navigation;

import gr.teicm.pm.jzork.entities.Assasin;
import gr.teicm.pm.jzork.items.*;
import gr.teicm.pm.jzork.entities.Burglar;
import gr.teicm.pm.jzork.entities.Player;
import java.io.Serializable;


/**
 *
 * @author Babis
 */

public class Map implements Serializable {

    private Room startRoom;

    RoomConnector connect = new RoomConnector();

    private Room hallway, outside, office, kitchen, bedroom, bathroom, closet, basement,cellar;

    public Room generateMap() {

        // The outside:  
        outside = new Room();
        outside.setRoomName("outside");
        outside.setDescription("You are outside of a big building. There is a door to your north from where you can enter.");

        // The hallway:
        hallway = new Room();
        hallway.setRoomName("hallway");
        hallway.setDescription("You are now in the hallway room. There are four doors, one to your south, one to the north, one to your west and one to your east. ");
        Torch torch = new Torch("Just a torch", "a torch on the floor");
        hallway.addItem(torch);
        Key key = new Key("1", "An old key", "a key on the counter");
        hallway.addItem(key);
        

        // The Office:
        office = new Room();
        office.setRoomName("office");
        office.setDescription("You are now in the office. It looks like only an old door in the north and the one you've entered to your east.");
        office.setIsDark(true);
        LightSwitch lightSwitch = new LightSwitch ("A light switch.","a light switch on the wall");
        office.addItem(lightSwitch);
        Vault vault = new Vault("2314", true, "a 4-digit password protected vault in the wall");
        office.addItem(vault);
        Notebook notebook = new Notebook("There is a long number written in this notebook: 010011001100. What could it be..?", "a notebook placed on the desk");
        office.addItem(notebook);
        Key bedroomKey = new Key("6","An old key","an old key");
        Potion potion = new Potion(25,"A red potion that will restore a percentage of your max health points.","A red potion");
        
        bedroomKey.setIsAvailable(false);
        potion.setIsAvailable(false);
        vault.addItem(bedroomKey);
        vault.addItem(potion);
        

        
        
        // The Kitchen:
        kitchen = new Room();
        kitchen.setRoomName("Kitchen");
        kitchen.setDescription("You are in the kitchen. There is a door to the north and one in the south.There is a burglar standing in a corner of a room and he's staring at you.");
        kitchen.setIsDark(false);
        Knife knife = new Knife("Just a kitchen knife","a knife on the counter");
        kitchen.addItem(knife);
        Burglar burglar = new Burglar();
        kitchen.addEnemy(burglar);

        // The Bedroom:
        bedroom = new Room();
        bedroom.setRoomName("Bedroom");
        bedroom.setDescription("You are in the bedroom. There is a door to the south where you came from and a closet to the east");
        bedroom.setIsDark(false);

        //THe Bedroom Closet:
        closet = new Room();
        closet.setRoomName("closet");
        closet.setDescription("You are now in the bedroom closet.");
        closet.setIsDark(true);
        Sword sword = new Sword("an old samurai sword","an old samurai sword on the shelf");
        closet.addItem(sword);
        Key kitchenKey = new Key("3","An old key","an old key hanging ");
        closet.addItem(kitchenKey);

        // The bathroom
        bathroom = new Room();
        bathroom.setRoomName("Bathroom");
        bathroom.setDescription("You are in the bathroom. The only exit is the door which you came from");
        bathroom.setIsDark(false);
        
        //the basement
        basement = new Room();
        basement.setRoomName("basement");
        basement.setDescription("You are in the basement.There is a door to the north and one in the south.There is a man dressed in a cloak who looks like an Assasin standing in front of you.");
        basement.setIsDark(true);
        Key CellarKey = new Key("8","A key","and old gold key");
        basement.addItem(CellarKey);
        Assasin assasin = new Assasin();
        basement.addEnemy(assasin);
        
       //the cellar
        cellar = new Room();
        cellar.setRoomName("cellar");
        cellar.setDescription("You are in an old cellar.The only door is the one you entered.There is an small potion vile on a old table.");
        cellar.setIsDark(true);
        cellar.addItem(potion);
        Chest chest = new Chest(false, "A chest", "an old chest on the floor");
        hallway.addItem(chest);
       
        
   

        // Exits initialization  
        connect.RoomInitialize(outside);
        connect.RoomInitialize(hallway);
        connect.RoomInitialize(office);
        connect.RoomInitialize(kitchen);
        connect.RoomInitialize(bedroom);
        connect.RoomInitialize(bathroom);
        connect.RoomInitialize(closet);
        connect.RoomInitialize(basement);
        connect.RoomInitialize(cellar);

        // Room connection with doors
        Door outNorthHall = new Door(outside, "north", "south", hallway, false, "Big green door", "2");
        Door hallWestOffice = new Door(hallway, "west", "east", office, true, "wooden door", "1");
        Door hallEastKitchen = new Door(hallway, "east", "west", kitchen, false, "Big green door", "1");
        Door hallNorthBedroom = new Door(hallway, "north", "south", bedroom, false, "Big wooded door", "6");
        Door BedroomEastCloset = new Door(bedroom, "east", "west", closet, false, "Big Brown door", "5");
        Door hallNorthKitchen = new Door(kitchen, "north", "south", bathroom, false, "Big green door", "4");
        Door OfficeNorthbasement = new Door(office, "north", "south",basement , false, "wooden door", "7");
        Door BasementNorthCellar = new Door(basement, "north", "south",cellar , true, "wooden door", "8");

        // Return the starting room:
        startRoom = outside;
        return startRoom;

    }

    public Room getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(Room startRoom) {
        this.startRoom = startRoom;
    }
    
    public void createMap(boolean loaded, Player player) {
        Map map = new Map();
        if(!loaded) {
            Room starting = map.generateMap();
            player.setCurrentRoom(starting);
        }
    }

}
