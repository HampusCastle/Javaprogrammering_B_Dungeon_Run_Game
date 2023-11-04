package com.hampusborg.shop;

import com.hampusborg.combat.AHero;
import com.hampusborg.gameLogic.Loot;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    protected List<Loot> availableItems;
    private List<String> inventory;

    public Shop() {
        this.inventory = new ArrayList<String>();
    }
    public void addItemToInventory(String item) {
        inventory.add(item);
    }
    public void displayAvailableItems () {
        for (Loot item : availableItems) {
            System.out.println(item.getName() + " - Rarity: " + item.getRarity() + " - Price: " + calculatePrice(item));
        }
    }
    public int calculatePrice(Loot item) {
        int basePrice = 10;
        int price = basePrice + (item.getPower() * 5);
        return price;
    }
    public void purchaseItem(Loot item, AHero player) {
        int price = calculatePrice(item);
        if (player.getGold() >= price) {
            player.subtractGold(price);
            addItemToInventory(String.valueOf(item));
            System.out.println("You purchased " + item.getName() + " for " + price + " gold.");
        } else {
            System.out.println("You don't have enough gold to buy " + item.getName());
        }
    }
}
