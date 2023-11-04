package com.hampusborg.gameLogic;


import com.hampusborg.ColorScheme.IColors;
import com.hampusborg.combat.AHero;
import com.hampusborg.combat.AMonster;
import com.hampusborg.monsterCharacter.Balrog;
import com.hampusborg.playerCharacter.Ranger;
import com.hampusborg.playerCharacter.Warrior;
import com.hampusborg.playerCharacter.Wizard;
import com.hampusborg.shop.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Status.getStatus;

public class GameLogic implements IColors {
    private Scanner sc = new Scanner(System.in);

    private List<AMonster> monsterList = new ArrayList<>();
    List<AHero> playerList = new ArrayList<>();
    List<Loot> shopItems = new ArrayList<>();
    private Random r = new Random();
    Shop shop = new Shop();
    String name;
    Wizard wizard = new Wizard();
    Warrior warrior = new Warrior();
    Ranger ranger = new Ranger();



    public GameLogic() throws InterruptedException {


    }

    private void addPlayer() {
       boolean isChoosing = true;
        do {
            System.out.println("Choose a hero: 1 - Ranger, 2 - Wizard, 3 - Warrior, 4 - Start the adventure of a lifetime");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> playerList.add(new Ranger());
                case 2 -> playerList.add(new Wizard());
                case 3 -> playerList.add(new Warrior());
                case 4 -> isChoosing = false;
                default -> System.out.println("Wrong input, please choose another Hero or finish your selection.");
            }
        } while (isChoosing);
    }
        public void startGame ( int numberOfPlayers){
            for (int i = 0; i < numberOfPlayers; i++) {
            }

            int floor = 1;
            int maxFloors = 10;
            while (floor <= maxFloors) {
                int numberOfMonsters = r.nextInt(5) + floor;

                for (int i = 0; i < numberOfMonsters; i++) {
                    monsterList.add(new Balrog());
                }

                System.out.println("This is floor " + floor + ":");
                System.out.println("Number of monsters: " + numberOfMonsters);
                System.out.println("Players in the game:");
                for (AHero aHero : playerList) {
                    System.out.println("Player name: " + aHero.getName() + ", Level: " + aHero.getLevel());
                }

                floor++;

                monsterList.clear();
            }
        }

        public void Play () throws InterruptedException {
            boolean isPlaying = false;
        }
            public void act() throws InterruptedException {
                do {
                    System.out.println("You now have a choice to make, fight or flee.");
                    System.out.println("1. Fight");
                    System.out.println("2. Try to escape this madness");
                    System.out.println("3. Overview of stats");
                    System.out.println("Choose wisely");

                    switch (sc.nextLine()) {
                        case "1" -> wizard.attack();
                        case "2" -> System.out.println(wizard.flee());
                        case "3" -> System.out.println(wizard.getStatus());
                        default -> System.out.println("Invalid input, try again");
                    }
                } while(!sc.hasNextInt());

                shop.displayAvailableItems();

                }
            }





            //for (int floor = 1; floor <= 10; floor++) {
            //    System.out.println("Entering floor " + floor + ":");
             //   for (AHero aHero : playerList) {
             //       for (AMonster monster : monsterList) {
             //           monster.takeDamage(aHero.attack());
              //          aHero.takeDamage(monster.attack());




