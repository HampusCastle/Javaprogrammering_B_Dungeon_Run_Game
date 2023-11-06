package com.hampusborg.gameLogic;

import com.hampusborg.combat.AHero;
import com.hampusborg.combat.AMonster;
import com.hampusborg.monsterCharacter.*;
import com.hampusborg.playerCharacter.Ranger;
import com.hampusborg.playerCharacter.Warrior;
import com.hampusborg.playerCharacter.Wizard;
import com.hampusborg.shop.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private int floor;
    private Scanner scanner = new Scanner(System.in);
    private List<AMonster> monsters;
    private List<AHero> playerList;
    private Shop shop;

    public GameLogic() {
        this.floor = 1;
        this.monsters = new ArrayList<>();
        this.playerList = new ArrayList<>();
        this.shop = new Shop();
    }

    public void startGame(int numberOfPlayers) throws InterruptedException {
        createPlayers(numberOfPlayers);
        startFloor();
    }

    private void createPlayers(int numberOfPlayers) {
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Player " + i + ", choose your class:");
            AHero player = playerClass();
            playerList.add(player);
        }
    }

    private AHero playerClass() {
        AHero player = null;
        boolean validInput = false;

        do {
            System.out.println("1. Ranger\n2. Warrior\n3. Wizard");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> player = new Ranger();
                    case 2 -> player = new Warrior();
                    case 3 -> player = new Wizard();
                    default -> System.out.println("Invalid input, please try again");
                }
                if (player != null) validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a correct number");
                scanner.next();
            }
        } while (!validInput);

        return player;
    }

    private void startFloor() throws InterruptedException {
        while (!monsters.isEmpty() && !playerList.isEmpty()) {
            for (AHero player : playerList) {
                playerAction(player);
            }
            if (playerWantsToShop()) {
                shop.displayAvailableItems();
                if (playerWantsToReturnToBattle()) {
                    returnToBattle();
                }
            }
            floor++;
        }
    }

    private void playerAction(AHero player) throws InterruptedException {
        System.out.println("Player: " + player.getName() + "\nChoose what you want to do: ");
        System.out.println("1. Attack\n2. Flee\n3. Get status\n4. Shop");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> player.attack();
            case 2 -> player.flee();
            case 3 -> player.getStatus();
            case 4 -> {
                player.viewShop(shop);
                System.out.println("Do you want to continue shopping? (1 for Yes, 0 for No)");
                int continueShopping = scanner.nextInt();
                if (continueShopping == 1) {
                    System.out.println("Enter the item number you want to buy:");
                    int selection = scanner.nextInt();
                    shop.purchaseItem(player, selection);
                }
            }
            default -> System.out.println("Invalid input, try again");
        }
    }

    private boolean playerWantsToShop() {
        System.out.println("Do you want to enter the shop? (1 for Yes, 0 for No)");
        int choice = scanner.nextInt();
        return choice == 1;
    }

    private boolean playerWantsToReturnToBattle() {
        System.out.println("Do you want to return to battle? (1 for Yes, 0 for No)");
        int choice = scanner.nextInt();
        return choice == 1;
    }

    private void returnToBattle() throws InterruptedException {
        System.out.println("Returning to battle!");
        startFloor();
    }

    private int generateNumberOfMonsters() {
        return new Random().nextInt(floor * 3) + 1;
    }

    private void generateMonsters(int numberOfMonsters) {
        monsters.clear();
        Random r = new Random();
        for (int i = 0; i < numberOfMonsters; i++) {
        }
        int monsterType = r.nextInt(4);
        AMonster monster = null;
        switch (monsterType) {
            case 1 -> monster = new Troll();
            case 2 -> monster = new Uruk();
            case 3 -> monster = new Caragor();
            case 4 -> monster = new Ghúl();
            default -> monster = new Orc();

        }
        monsters.add(monster);
    }
}
