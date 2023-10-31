package com.hampusborg.monsterCharacter;

import com.hampusborg.ColorScheme.IColors;
import com.hampusborg.combat.Character;

public class Orc extends Character implements IColors {


    public Orc() {
        super(10, 10, 10, 10, 10, 10, 10, 10, 10);
    }

    @Override
    public int attack() {

        System.out.println("The Orc throws an axe at you!");
        return 0;
    }

    @Override
    public boolean flee() {

        System.out.println("The Orc uses his bodyguard to throw sand at you, then he runs into hiding!");
        return false;
    }
}
