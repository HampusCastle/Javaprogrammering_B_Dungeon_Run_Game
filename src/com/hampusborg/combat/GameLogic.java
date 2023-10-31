package com.hampusborg.combat;


import com.hampusborg.ColorScheme.IColors;
import com.hampusborg.playerCharacter.Warrior;
import com.hampusborg.playerCharacter.Wizard;

import java.util.Scanner;

public class GameLogic implements IColors {

    private Scanner sc = new Scanner(System.in);
    public void Play(){
        Wizard gandalf = new Wizard();
        System.out.println(gandalf.getStatus());
    }
    void chosePath() throws InterruptedException {
        System.out.println("Here lies the choices in what path you, as the player chooses to go \n Remember that this alters the attributes and level of difficulty...");
        Thread.sleep(3000);
        System.out.println("1. " + RED + "Mage");
        System.out.println("2. " + GREEN + "Warrior");

        do {

            switch (sc.nextLine()) {
                case "1" -> {
                    Wizard wizard = new Wizard();
                }
                case "2" -> {
                    Warrior warrior = new Warrior();
                }
                default -> System.out.println("Wrong input, please select a class!");

            }

            System.out.println("Now wee need to figure out what opponent we want to face! \nRemember the different monsters have varied attributes and difficulty...");
            Thread.sleep(5000);
            System.out.println("1." + GREEN + "Orc");
            System.out.println("2. " + YELLOW + "Uruk");
            System.out.println("3. " + PURPLE + "Troll");
            System.out.println("4. " + RED + "Kraken");
            System.out.println("5. " + BLUE + "Balrog");
            System.out.println("Which opponent would you like to face?");
            switch(sc.nextLine()) {
                case "1" -> {
                    System.out.println("You will face the Orc, a simple but persistent opponent!");
                    Thread.sleep(3000);
                }
                case "2" -> {System.out.println("The Uruk, similar to the Orc but quite a bit stronger. This will be interesting");
                    Thread.sleep(3000);
            }
            case "3" -> {
                System.out.println("The Troll, a rather large monster with great pitching arm, watch out for flying rocks!");
                Thread.sleep(3000);
            }
            case "4" -> {
                System.out.println("The Kraken, a vicious water animal with not only one, but 6 arms to avoid.");
                Thread.sleep(3000);
            }
            case "5" -> {
                System.out.println("The Balrog, the biggest and baddest demon of them all, make sure to keep a fire blanket close");
                Thread.sleep(3000);
            }
        }

    }while(true);
    } }
