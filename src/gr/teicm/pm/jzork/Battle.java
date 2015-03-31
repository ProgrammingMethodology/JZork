/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork;

import gr.teicm.pm.jzork.entities.Monsters;
import gr.teicm.pm.jzork.entities.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Walkin
 */
public final class Battle {

    public Battle(Player player, Monsters monster) throws IOException {
        System.out.println("You encounter " + monster + ": " + monster.getMDescription() + "\n");
        System.out.println("Battle with " + monster + " starts (" + player.getHealth() + " / "
                + monster.getStatus() + ")");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (player.isIsAlive() && monster.isAlive()) {
            System.out.print("Do you want to Attack? ");
            String action = in.readLine();
            monster.defend(player);
            if (action.equals("attack")) {
                player.attack();
            }
            if (monster.isAlive()) {
                player.defend(monster);
            }
        }
    }

}