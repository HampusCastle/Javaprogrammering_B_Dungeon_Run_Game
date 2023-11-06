package com.hampusborg.playerCharacter;

import com.hampusborg.ColorScheme.IColors;
import com.hampusborg.combat.AHero;

public class Wizard extends AHero implements IColors {


    public Wizard() {
        super("Wizard", 10, 99, 10, 10, 10, 10, 10, 10);
    }

    @Override
    public int calculateDamage() {
        return getBaseDamage() + (this.getIntelligence() * 2 / 4 + 1);
    }
}
