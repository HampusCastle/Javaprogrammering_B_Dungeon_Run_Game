package com.hampusborg.combat;

import com.hampusborg.gameLogic.Loot;
import com.hampusborg.shop.AItem;
import com.hampusborg.shop.Shop;

import java.util.List;
import java.util.Scanner;


public abstract class AHero extends ACharacter implements ICombat {
    private Scanner sc = new Scanner(System.in);
    private int amountOfExp;
    Shop shop = new Shop();
    private String itemName;
    private int itemPrice;


    public AHero(String name, int strength, int agility, int baseDamage, int health, int level, int intelligence, int experience, int gold) {
        super(name, strength, agility, baseDamage, health, level, intelligence, experience, gold);
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.baseDamage = baseDamage;
        this.health = health;
        this.experience = experience;
        this.gold = gold;
        this.level = level;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
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

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
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

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public int getLevel() {
        return level;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void turnIntoFrog() {
        this.strength = 1;
        this.intelligence = 1;
        this.agility = 1;
        this.baseDamage = 1;
        this.health = 1;
        this.experience = 1;
        this.gold = 1;
        this.level = 1;

        System.out.println("Ribbit! You've been turned into a frog and all your stats have been set to 1!");
        System.out.println(getStatus());
    }

    public int levelUP(int amountOfExp) {
        this.amountOfExp = amountOfExp;
        for (int i = amountOfExp; i < 100; i++) {
            setExperience(getExperience() + 1);
            System.out.println(getExperience());
            if (getExperience() == 100) {
                setLevel(getLevel() + 1);
                setExperience(0);
            }
            this.strength += 2;
            this.intelligence += 2;
            this.agility += 2;
            System.out.println("You have gained a level, you are now level: " + this.level + "! You have been awarded with increased stats" + getStatus());
        }

        return this.level;

    }

    public void viewShop(Shop shop) {
        System.out.println("These are the available items: ");
        shop.displayAvailableItems();
    }

public void purchaseItem (Shop shop, int selectedItem) {
        shop.purchaseItem(this, selectedItem);
    List<Loot> availableItems = shop.getAvailableItems();
    if (selectedItem >= 0 && selectedItem < availableItems.size()) {
        Loot choosenLoot = availableItems.get(selectedItem);
        itemName = choosenLoot.getName();
        itemPrice = shop.calculatePrice(choosenLoot);

        if (gold >= itemPrice) {
            shop.addItemToInventory(itemName);
            subtractGold(itemPrice);
            System.out.println("Purchased " + itemName + " for " + itemPrice + " gold.");
        } else {
            System.out.println("Unfortunately your funds seems to be inadequate to buy " + itemName + ".");
        }
    } else {
        System.out.println("Invalid selection.");
    }
}

    public void subtractGold(int amount) {
        if (this.gold >= amount){
            this.gold -= amount;
        } else {
            System.out.println("Insufficient founding for this purchase");
        }
    }
    public void addGold(int amount) {
        this.gold += amount;
    }

    public int attack(List<AMonster> monsters) {
        for (AMonster monster : monsters) {
            int damageDealt = calculateDamage();
            if (!monster.didDodge()) {
                if (!monster.isCriticalStrike()) {
                        damageDealt *= 2;
                        System.out.println("CRITICAL ! - That was an extraordinary hit, that one must have hurt.");
                    }
                    monster.takenDamage(damageDealt);
                } else {
                    System.out.println("The monster dodged the attack!");
                }
                if (monster.isDefeated()) {
                    System.out.println("The monster have been defeated!");
                    monsters.remove(monster);
                }
            }
        System.out.println("An attack is underway!");
        return calculateDamage();
    }
    public boolean flee(List<AMonster> monsters) throws InterruptedException {
        if (didFlee()) {
            System.out.println("The monster tires to flee but fails!");
            return false;
        } else {
            System.out.println("The player successfully fled from the battle!");
            //handle logic if the player successfully fled.
            return true;
        }
    }

}
