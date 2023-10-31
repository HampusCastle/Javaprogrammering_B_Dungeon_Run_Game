package com.hampusborg.monsterCharacter;

import com.hampusborg.ColorScheme.IColors;
import com.hampusborg.combat.Character;

public class Kraken extends Character implements IColors {


    public Kraken() {
        super(10,10, 10, 10, 10, 10, 10, 10, 10 );
    }

    @Override
    public int attack() {

        System.out.println("The Kraken is trying to attack you using his long tentacles.");
        return 0;
    }

    @Override
    public boolean flee() {

        System.out.println("The Kraken returns to the deep waters and escapes!");
        return false;
    }
}


