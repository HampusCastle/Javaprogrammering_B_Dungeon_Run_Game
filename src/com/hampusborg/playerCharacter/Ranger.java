package com.hampusborg.playerCharacter;

import com.hampusborg.combat.AHero;
import com.hampusborg.combat.ICombat;

public class Ranger extends AHero implements ICombat {
    public Ranger() {
        super("Ranger", 10, 10, 10, 10, 10, 10, 10, 10);
    }
}

