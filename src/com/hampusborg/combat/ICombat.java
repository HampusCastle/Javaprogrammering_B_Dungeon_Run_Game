package com.hampusborg.combat;

public interface ICombat {

    int attack() throws InterruptedException;
    boolean flee() throws InterruptedException;
    String getStatus() throws InterruptedException;


}
