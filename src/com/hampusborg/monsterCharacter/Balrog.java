package com.hampusborg.monsterCharacter;

import com.hampusborg.ColorScheme.IColors;
import com.hampusborg.combat.Character;

public class Balrog extends Character implements IColors {


    public Balrog() {
        super(10, 10, 10, 10, 10, 10, 10, 10, 10);
    }

    @Override
    public boolean flee() {
        System.out.println("The Balrog expands it's fiery wings and flees");
        return false;
    }
}