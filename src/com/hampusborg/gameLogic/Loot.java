package com.hampusborg.gameLogic;

public class Loot {
    private String name;
    private String rarity;
    private int power;
    public Loot(String name, Rarity rarity, int power) {


    }

        public void setName(String name) {
            this.name = name;
        }

        public void setRarity(String rarity) {
            this.rarity = rarity;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public String getName() {
            return name;
        }

        public String getRarity() {
            return rarity;
        }

        public int getPower() {
            return power;
        }
    public enum Rarity {
        COMMON,
        UNCOMMON,
        RARE,
        EPIC,
       LEGENDARY,
    }


}
