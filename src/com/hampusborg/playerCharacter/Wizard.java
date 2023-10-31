package com.hampusborg.playerCharacter;

import com.hampusborg.ColorScheme.IColors;
import com.hampusborg.combat.Character;

public class Wizard extends Character implements IColors {


    public Wizard() {
        super(10, 10, 99, 10, 10, 10, 10, 10, 10);
    }
    @Override
    public int calculateDamage() {
       return this.baseDamage + this.intelligence * 2 / 4 + 1;

         //Best practice? - return getBaseDamage() + (this.getIntelligence() * 2 / 4 + 1);//baseDamage + (styrka * 2 / 4 + 1).
} }
