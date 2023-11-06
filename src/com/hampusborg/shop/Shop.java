package com.hampusborg.shop;

import com.hampusborg.combat.AHero;
import com.hampusborg.gameLogic.Loot;
import com.hampusborg.gameLogic.Rarity;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Loot> swordsList;
    private List<Loot> shieldList;
    private List<Loot> helmetList;
    private List<Loot> cloakList;
    private List<Loot> armorList;

    private Loot heldSword;
    private Loot heldShield;
    private Loot heldHelmet;
    private Loot heldCloak;
    private Loot heldArmor;
    private List<Loot> availableItems;
    private List<String> inventory;

    public Shop() {
        this.availableItems = new ArrayList<>();
        this.inventory = new ArrayList<String>();
        allItems();
    }

    private void allItems() {
        availableItems.add(new Loot("Mithril Coat", Rarity.EPIC, 100));
        availableItems.add(new Loot("Gondorian Armor", Rarity.LEGENDARY, 200));
        availableItems.add(new Loot("Andúril", Rarity.COMMON, 300));
        availableItems.add(new Loot("En väst eller så", Rarity.UNCOMMON, 400));
        availableItems.add(new Loot("En sjukt cool hjälm", Rarity.RARE, 500));
    }

    public void displayAvailableItems() {
        for (Loot item : availableItems) {
            System.out.println(item.getName() + " - Rarity: " + item.getRarity() + " - Price: " + calculatePrice(item));
        }
    }

    public void addItemToInventory(String item) {
        inventory.add(item);
    }

    public int calculatePrice(Loot item) {
        int basePrice = 10;
        int price = basePrice + (item.getPower() * 5);
        return price;
    }

    public boolean purchaseItem(AHero player, int selectedItem) {
        if (selectedItem >= 0 && selectedItem < availableItems.size()) {
            Loot itemPurchased = availableItems.get(selectedItem);
            int price = calculatePrice(itemPurchased);
            if (player.getGold() >= price) {
                player.subtractGold(price);
                addItemToInventory(itemPurchased.getName());
                System.out.println("You purchased " + itemPurchased.getName() + " for " + price + " gold.");
                return true;
            } else {
                System.out.println("You don't have enough gold to buy " + itemPurchased.getName());
            }
        } else {
            System.out.println("Invalid selection");
        }
        return false;
    }

    public void sellEquippedSword(AHero player) {
        if (heldSword != null) {
            int price = calculatePrice(heldSword);
            player.addGold(price);
            swordsList.add(heldSword);
            heldSword = null;
        } else {
            System.out.println("You don't have an equipped sword to sell.");
        }
    }

    // Method to purchase sword
    public boolean purchaseSword(AHero player, int selectedItem) {
        sellEquippedSword(player); // Ask to sell the equipped sword first
        if (selectedItem >= 0 && selectedItem < swordsList.size()) {
            Loot addSword = swordsList.get(selectedItem);
            int price = calculatePrice(addSword);
            if (player.getGold() >= price) {
                heldSword = addSword;
                player.subtractGold(price);
                swordsList.remove(addSword);
                return true;
            } else {
                System.out.println("You don't have enough gold to buy this item");
            }
        }
        return false;
    }
}