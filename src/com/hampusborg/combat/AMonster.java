package com.hampusborg.combat;

import com.hampusborg.gameLogic.Loot;
import com.hampusborg.gameLogic.Rarity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public abstract class AMonster extends ACharacter implements ICombat {
    String name;
    private int goldLoot;
    List<Loot> itemLoot;
    int playerLevel;
    List<String> loot;
    private Random r = new Random();
    private Scanner sc = new Scanner(System.in);

    public AMonster(String name, int strength, int agility, int baseDamage, int health, int level, int intelligence, int experience, int gold) {
        super(name, strength, agility, baseDamage, health, level, intelligence, experience, gold);

        this.goldLoot = generateGoldLoot();
        this.itemLoot = generateItemLoot();
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHasDied(boolean hasDied) {
        this.hasDied = hasDied;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isHasDied() {
        return hasDied;
    }

    public void looting() {
        // Generate gold and items when looting
        this.goldLoot = generateGoldLoot();
        this.itemLoot = generateItemLoot();
    }

    public int generateGoldLoot() {
        Random random = new Random();
        return random.nextInt(50) + 10;
    }

    public List<Loot> generateItemLoot() {
        List<Loot> lootDrops = new ArrayList<>();

        int commonDrops = 50;
        int uncommonDrops = 30;
        int rareDrops = 15;
        int epicDrops = 4;
        int legendaryDrops = 1;

        Rarity[] rarities = Rarity.values();
        Random r = new Random();

        int dropChance = r.nextInt(100);
        Rarity rarity;
        if (dropChance < commonDrops) {
            rarity = Rarity.COMMON;
        } else if (dropChance < commonDrops + uncommonDrops) {
            rarity = Rarity.UNCOMMON;
        }else if (dropChance < commonDrops + uncommonDrops + rareDrops) {
            rarity = Rarity.RARE;
        }else if (dropChance < commonDrops + uncommonDrops + rareDrops + epicDrops){
            rarity = Rarity.EPIC;
        }else {
            rarity = Rarity.LEGENDARY;
        }
        int power = calculateLootPower(rarity, playerLevel);
        Rarity rarity = rarities[r.nextInt(rarities.length)];
        Loot loot = new Loot("Item Name", rarity, power);
        lootDrops.add(loot);
        return lootDrops;
        }

    private int calculateLootPower(Rarity rarity, int playerLevel) {
        return playerLevel * rarityMultiplier(rarity);
    }
    private int rarityMultiplier(Rarity rarity) {
        switch (rarity) {
            case COMMON:
                return 1;
            case UNCOMMON:
                return 2;
            case RARE:
                return 3;
            case EPIC:
                return 4;
            case LEGENDARY:
                return 5;
            default:
                return 0;
        }
    }
    public int getGoldLoot() {
        return this.goldLoot;
    }
public int takeDamage(int damageReceived) {
    this.health -= damageReceived;
    return damageReceived;
} }








