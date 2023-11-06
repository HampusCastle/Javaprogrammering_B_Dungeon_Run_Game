package com.hampusborg.shop;

import com.hampusborg.gameLogic.Loot;
import com.hampusborg.gameLogic.Rarity;

public abstract class AItem {
    protected String name;
    protected int power;
    protected Rarity rarity;

    public AItem(String name, int power, Rarity rarity) {
        this.name = name;
        this.power = power;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public int getPower(int floorLevel) {
        return power + (floorLevel * 2);
    }

    public Rarity getRarity() {
        return rarity;
    }
}




