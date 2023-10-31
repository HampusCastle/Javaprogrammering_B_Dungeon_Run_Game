package com.hampusborg.monsterCharacter;

import com.hampusborg.ColorScheme.IColors;
import com.hampusborg.combat.Character;

public class Troll extends Character implements IColors {
    public Troll() {
        super(10, 10, 10, 10, 10, 10, 10, 10, 10);
    }

    @Override
    public int attack() {

        System.out.println("The Troll throws a rock at you!");
        return 0;
    }

    @Override
    public boolean flee() {

        System.out.println("The troll is scared and panics, and runs away from the fight");
        return false;
    }
}
