//package gr.teicm.pm.jzork;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//
//import gr.teicm.pm.jzork.entities.Player;
//
///**
// *
// * @author Walkin
// */
//public  class PickUpCommand extends Command{
//    private Player holder;
//public PickUpCommand()
//{
// 
//this.holder = null;
//}
///**
//* Creates an item like normal but also specifies the holder
//*
//* @param name the item's name
//* @param desc the item's description
//* @param holder the item's holder
//*/
//public PickUpCommand(String name, String desc, Player holder){
//super();
//this.holder = holder;
//}
//
//
//     public boolean execute(Player player) {
//         
//       if(this.holder != player){
//    player.getInventory().add(player);
//    player.getCurrentRoom().getItems().remove(player);
//    this.holder = player;
//    System.out.println("You took the "+this);
//    } else {
//    System.out.println("You're already carrying the "+this);
//    }
//       
//       if(this.holder == player){
//    player.getInventory().remove(player);
//    player.getCurrentRoom().getItems().add(player);
//    this.holder = null;
//    System.out.println("You dropped the "+this);
//    } else {
//    System.out.println("You're not holding the "+this);
//    }
//        return false;
//       
//    }
//
//    
//}
