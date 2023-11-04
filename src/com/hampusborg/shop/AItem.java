package com.hampusborg.shop;

public abstract class AItem {

    public static String itemName;
    public static int itemPrice;


    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public void setPower(int power) {
        this.itemPrice = itemPrice;
    }

    public String getName() {
        return itemName;
    }

    public int getPower() {
        return itemPrice;
    }

    public AItem(String itemName, int itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
}


