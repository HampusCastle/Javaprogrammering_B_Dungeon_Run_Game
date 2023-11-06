package com.hampusborg.startGame;

import com.hampusborg.gameLogic.GameLogic;
import com.hampusborg.monsterCharacter.Ghúl;
import com.hampusborg.monsterCharacter.Caragor;
import com.hampusborg.playerCharacter.Wizard;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        GameLogic gl = new GameLogic();
        Wizard wizard = new Wizard();
        Ghúl balrog = new Ghúl();
        Caragor kraken = new Caragor();


        gl.startGame();





    }
}