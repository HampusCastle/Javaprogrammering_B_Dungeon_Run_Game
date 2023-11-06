package com.hampusborg.gameLogic;

public class Loot {
    private String name;
    private Rarity rarity;
    private int itemPower;
    public Loot(String name, Rarity rarity, int itemPower) {
    this.name = name;
    this.rarity = rarity;
    this.itemPower = itemPower;


    }

        public void setName(String name) {
            this.name = name;
        }

        public void setPower(int power) {
            this.itemPower = itemPower;
        }

        public String getName() {
            return name;
        }

        public Rarity getRarity() {
            return rarity;
        }

        public int getItemPower() {
            return itemPower;
        }

public void usedLoot (){

    }

}

