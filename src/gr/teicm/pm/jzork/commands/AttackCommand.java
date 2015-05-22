/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.commands;

import gr.teicm.pm.jzork.core.Command;
import gr.teicm.pm.jzork.core.Game;
import gr.teicm.pm.jzork.entities.Enemies;
import gr.teicm.pm.jzork.entities.Player;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Walkin
 */
public class AttackCommand extends Command {

    private String enemy;
    private final Random rand;

    public AttackCommand() {
        rand = new Random();
    }

    @Override
    public String execute(Player player) {
        if (!hasSecondWord()) {
            return "Attack what?";
        } else {
            enemy = getSecondWord();
            Enemies e = null;

            if ((e = getEnemy(player)) != null) {
                if (player.getEquipedWeapon() == null) {
                    System.out.print("Do you want to attack with your bare hands?"
                            + " [y/n]: ");
                    String choise;
                    while (true) {

                        Scanner scanner = new Scanner(System.in);
                        choise = scanner.next();

                        if (!choise.equalsIgnoreCase("y") && !choise.equalsIgnoreCase("n")) {
                            System.out.print("Please enter 'y' or 'n'. Try again: ");
                            continue;
                        } else if(choise.equalsIgnoreCase("n")) {
                            return "Equip your weapon.";
                        }

                        break;
                    }

                }
                rand.setSeed(System.currentTimeMillis());
                player.setLuck(rand.nextInt(10) + 1);
                System.out.println("You are attacking " + enemy);
                try {
                    Thread.sleep(2000l);
                } catch (InterruptedException ex) {
                }
                System.out.println(enemy + "'s health is " + e.getHealth());
                try {
                    Thread.sleep(2000l);
                } catch (InterruptedException ex) {
                }
                System.out.println("Your health is " + player.getHealth());
                try {
                    Thread.sleep(2000l);
                } catch (InterruptedException ex) {
                }

                rand.setSeed(System.currentTimeMillis());
                switch (rand.nextInt(player.getLuck())) {
                    case 0:
                        System.out.println("Bad luck! You've missed.");
                        break;
                    default:
                        e.setHealth(e.getHealth() - player.getFullDamage());
                        System.out.println("You've succesfully attacked "
                                + enemy + "!");
                        if (e.isAlive()) {
                            System.out.println(enemy + "'s health is now " + e.getHealth());
                        } else {
                            try {
                                player.getCurrentRoom().getEnemies()
                                        .put(enemy, e.getClass().newInstance());
                            } catch (InstantiationException | IllegalAccessException ex) {
                            }
                            Game.updatePlayer(player);
                            return "You win! " + enemy + " is dead.";
                        }
                        break;

                }
                try {
                    Thread.sleep(2000l);
                } catch (InterruptedException ex) {
                }

                System.out.println(enemy + " attacks back!");
                try {
                    Thread.sleep(2000l);
                } catch (InterruptedException ex) {
                }

                rand.setSeed(System.currentTimeMillis());
                switch (rand.nextInt(player.getLuck())) {
                    case 0:
                        Game.updatePlayer(player);
                        return "You are lucky! " + enemy + " missed.";
                    default:
                        player.setHealth(player.getHealth() - e.getDamage());
                        if (!player.isAlive()) {
                            Game.updatePlayer(player);
                            return "You are dead!";
                        }
                        break;
                }

                Game.updatePlayer(player);
                return "Your health now is " + player.getHealth();

            } else {
                return "There is no " + enemy + " in the room.";
            }
        }

    }

    private Enemies getEnemy(Player player) {
        TreeMap<String, Enemies> enemies = player.getCurrentRoom().getEnemies();
        if (!enemies.isEmpty()) {
            if (enemies.containsKey(enemy)) {
                return enemies.get(enemy);
            }
        }

        return null;
    }
}
