package com.hampusborg.monsterCharacter;

import com.hampusborg.ColorScheme.IColors;
import com.hampusborg.combat.Character;

public class Uruk extends Character implements IColors {
    public Uruk() {
        super(10, 10, 10, 10, 10, 10, 10, 10, 10);
    }

    @Override
    public int attack() {

        System.out.println("The Uruk throws himself at you, trying to cut your head of!");
        return 0;
    }

    @Override
    public boolean flee() {

        System.out.println("The Uruk feels threatened by your being, and questions himself in this fight. He decides to flee!");
        return false;
    }
}
