/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.navigation;

import gr.teicm.pm.jzork.entities.Burglar;
import gr.teicm.pm.jzork.items.Knife;
import gr.teicm.pm.jzork.items.Notebook;
import gr.teicm.pm.jzork.items.Torch;
import gr.teicm.pm.jzork.items.Vault;
import gr.teicm.pm.jzork.items.Revolver;
import gr.teicm.pm.jzork.items.Key;
import gr.teicm.pm.jzork.items.Sword;

/**
 *
 * @author Babis
 */
public class Map {

    private Room startRoom;

    RoomConnector connect = new RoomConnector();

    private Room hallway, outside, office, kitchen, bedroom, bathroom, closet;

    public Room generateMap() {

        // The outside:  
        outside = new Room();
        outside.setRoomName("outside");
        outside.setDescription("You are outside of a big building. There is a door to your north from where you can enter");

        // The hallway:
        hallway = new Room();
        hallway.setRoomName("hallway");
        hallway.setDescription("You are now in the hallway room. There are four doors, one to your south, one to the north, one to your west and one to your east. ");
        Torch torch = new Torch("torch", "Just a torch", "a torch on the floor");
        hallway.addItem(torch);
        Key key = new Key("key", "1", "A old key", "a key in the counter");
        hallway.addItem(key);

        // The Office:
        office = new Room();
        office.setRoomName("office");
        office.setDescription("You are now in the office. It looks like there are no other exits but the one you've entered to your east");
        office.setIsDark(true);
        Vault vault = new Vault("vault", "2314", true, "something like a vault");
        office.addItem(vault);
        Notebook notebook = new Notebook("notebook", "There is a long number written in this notebook: 010011001100. What could it be..?", "a notebook placed on the desk");
        office.addItem(notebook);

        // The Kitchen:
        kitchen = new Room();
        kitchen.setRoomName("Kitchen");
        kitchen.setDescription("You are in the kitchen. There is a door to the north and one in the south.There is a burglar standing in a corner of a room and he's staring at you.");
        kitchen.setIsDark(false);
        Knife knife = new Knife("Knife", "Just a kitchen knife", 15, "a knife on the counter");
        kitchen.addItem(knife);
        Burglar burglar = new Burglar();
        kitchen.addEnemy(burglar);

        // The Bedroom:
        bedroom = new Room();
        bedroom.setRoomName("Bedroom");
        bedroom.setDescription("You are in the bedroom. There is a door to the south where you came from and a closet to the east");
        bedroom.setIsDark(false);
        Revolver revolver = new Revolver("revolver", 100, "an old revolver on the counter");
        bedroom.addItem(revolver);

        closet = new Room();
        closet.setRoomName("closet");
        closet.setDescription("A bedroom Closet.");
        closet.setIsDark(false);
        Sword sword = new Sword("sword", 60, "an old samurai sword");
        closet.addItem(sword);

        // The bathroom
        bathroom = new Room();
        bathroom.setRoomName("Bathroom");
        bathroom.setDescription("You are in the bathroom. The only exit is the door which you came from");
        bathroom.setIsDark(false);

        // Exits initialization  
        connect.RoomInitialize(outside);
        connect.RoomInitialize(hallway);
        connect.RoomInitialize(office);
        connect.RoomInitialize(kitchen);
        connect.RoomInitialize(bedroom);
        connect.RoomInitialize(bathroom);
        connect.RoomInitialize(closet);

        // Room connection with doors
        Door outNorthHall = new Door(outside, "north", "south", hallway, false, "Big green door", "2");
        Door hallWestOffice = new Door(hallway, "west", "east", office, true, "wooden door", "1");
        Door hallEastKitchen = new Door(hallway, "east", "west", kitchen, false, "Big green door", "3");
        Door hallNorthBedroom = new Door(hallway, "north", "south", bedroom, false, "Big wooded door", "6");
        Door BedroomEastCloset = new Door(bedroom, "east", "west", closet, false, "Big Brown door", "5");
        Door hallNorthKitchen = new Door(kitchen, "north", "south", bathroom, false, "Big green door", "4");

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

}
