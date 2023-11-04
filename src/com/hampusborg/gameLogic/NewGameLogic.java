package com.hampusborg.gameLogic;


import com.hampusborg.combat.AHero;
import com.hampusborg.combat.AMonster;
import com.hampusborg.playerCharacter.Ranger;
import com.hampusborg.playerCharacter.Warrior;
import com.hampusborg.playerCharacter.Wizard;
import com.hampusborg.shop.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class NewGameLogic {
    private int floor;
    private Scanner sc = new Scanner(System.in);
    private List<AMonster> monsters;
    private List<AHero> playerList;
    Shop shop = new Shop();

    public NewGameLogic() {
        this.floor = 1;
        this.monsters = new ArrayList<>();
        this.playerList = new ArrayList<>();
    }

    public void startGame(int numberOfPlayers) throws InterruptedException {
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Player " + i + ", choose your class:");

            AHero player = null;
            boolean validInput = false;

            do {
                System.out.println("1. Ranger");
                System.out.println("2. Warrior");
                System.out.println("3. Wizard");
                int choice;
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1 -> {
                            player = new Ranger();
                            validInput = true;
                        }
                        case 2 -> {
                            player = new Warrior();
                            validInput = true;
                        }
                        case 3 -> {
                            player = new Wizard();
                            validInput = true;
                        }
                        default -> System.out.println("Invalid input, please try again");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a correct number");
                    sc.next();
                }
            }while(!validInput);
            playerList.add(player);
        }
        startFloor();
    }

    private void startFloor() throws InterruptedException {
        int numberOfMonsters = generateNumberOfMonsters();
        generateMonsters(numberOfMonsters);

        while (!monsters.isEmpty() && !playerList.isEmpty()) {
            for (AHero player : playerList) {
                System.out.println("Player: " + player.getName());
                System.out.println("Choose what you want to do: ");
                System.out.println("1. Attack");
                System.out.println("2. Flee");
                System.out.println("3. Get status");
                System.out.println("4. Shop");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> player.attack();
                    case 2 -> player.flee();
                    case 3 -> player.getStatus();
                    case 4 -> shop.displayAvailableItems();
                    default -> System.out.println("Invalid input, try again");
                }
            }
        }
        floor++;
        startFloor();
    }

    private void act(AHero player) throws InterruptedException {
        if (player.flee()) {
            if (floor > 1) {
                floor--;
                System.out.println("Cowardly ways are not taken lightly here!");
                System.out.println("Do you want to continue? (yes/no)");
                String choice = sc.nextLine();

                if (choice.equalsIgnoreCase("no")) {
                    player.turnIntoFrog();
                    for (AHero p : playerList) {
                    }
                }
            }
        }
    }

    private int generateNumberOfMonsters() {
        return new Random().nextInt(floor * 3) + 1;
    }

    private void generateMonsters(int numberOfMonsters) {
        monsters.clear(); // Clear existing monsters
        for (int i = 0; i < numberOfMonsters; i++) {

        }
    }
}