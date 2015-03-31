/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.pm.jzork.entities;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Walkin
 */
public final class Monsters {

    private final String name;
    private final String Mdescription;
    private int hitPoints;
    private final int minDamage;
    private final int maxDamage;
    private final static Random random = new Random();
    private final static Set<Integer> monstersSeen = new HashSet<Integer>();
    private final static int NUM_MONSTERS = 1;

    public static Monsters newRandomInstance() {
        if (monstersSeen.size() == NUM_MONSTERS) {
            monstersSeen.clear();
        }
        int i;
        do {
            i = random.nextInt(NUM_MONSTERS);
        } while (monstersSeen.contains(i));
        monstersSeen.add(i);
        return new Monsters("goblin","enemy", 18, 1, 2);
       
    }

   

    private Monsters(String name, String Mdescription, int hitPoints, int minDamage, int maxDamage) {
        this.name = name;
        this.Mdescription = Mdescription;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.hitPoints = hitPoints;
    }

    @Override
    public String toString() {
        return name;
    }

    public String setMDescription(){
        return Mdescription;
    }
    public String getMDescription() {
        return Mdescription;
    }

    public String getStatus() {
        return "Monster HP: " + hitPoints;
    }

    public int attack() {
        return random.nextInt(maxDamage - minDamage + 1) + minDamage;
    }

    public void defend(Player player) {
        int attackStrength = player.getStrength();
        hitPoints = (hitPoints > attackStrength) ? hitPoints - attackStrength : 0;
        System.out.printf("  %s hits %s for %d HP of damage (%s)\n", player, name, attackStrength,
                getStatus());
        if (hitPoints == 0) {
            System.out.println("  " + player + "The enemy is dead");
                    
        }
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

}
