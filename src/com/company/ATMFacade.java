package com.company;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class ATMFacade {
    public static void atmFacade() throws IOException {
        Scanner start = new Scanner(System.in);
        System.out.println("Select the desired option:");
        System.out.println("1. to take money");
        System.out.println("2. to put money");
        System.out.println("3. to show the number of banknotes at the ATM");
        System.out.println("4. to show statistic");
        System.out.println("5. to leave");
        String answer = start.nextLine();

        if (answer.equalsIgnoreCase("1")) {
            System.out.println("How much money do you want to get?");
            Scanner num = new Scanner(System.in);
            int amountOfMoney = num.nextInt();
            int sumOfAllMoneyInATM = Banknotes.atm.toCountAllMoneyInATM(Banknotes.amountOfMoneyInATM);
            if (sumOfAllMoneyInATM < amountOfMoney) {
                System.out.println("Ooops. ATM doesn't have this sum. You can get not more than " + sumOfAllMoneyInATM);
                System.out.println("");
                atmFacade();
            } else {
                System.out.println("Choose strategy for getting money:");
                System.out.println("1. Big banknotes.");
                System.out.println("2. Banknotes of all available denominations.");
                Scanner strategy = new Scanner(System.in);
                String chosenStrategy = strategy.nextLine();

                if (chosenStrategy.equalsIgnoreCase("1")) {
                    Banknotes.atm.giveMoneyStrategy1(amountOfMoney);
                } else if (chosenStrategy.equalsIgnoreCase("2")) {
                    Banknotes.atm.giveMoneyStrategy2(amountOfMoney);
                } else {
                    System.out.println("Incorrect option");
                    System.out.println("");
                    atmFacade();
                    return;
                }

                System.out.println("Thank you for your visit!");
                System.out.println("");
                atmFacade();
            }

        } else if (answer.equalsIgnoreCase("2")) {
            System.out.println("Put banknotes separated by a space");
            Scanner puttedValue = new Scanner(System.in);
            String space = "";
            space += puttedValue.nextLine();
            String[] puttedBanknotes = space.split(" ");
            Banknotes.atm.putMoney(puttedBanknotes);
            System.out.println("Thank you for your visit!");
            System.out.println("");
            atmFacade();

        } else if (answer.equalsIgnoreCase("3")) {
            Cache cache = new Cache();
            cache.banknotes();
            System.out.println("Available sum: " + Banknotes.atm.toCountAllMoneyInATM(Banknotes.amountOfMoneyInATM));
            System.out.println("");
            atmFacade();
        } else if (answer.equalsIgnoreCase("4")) {
            System.out.println("Statistic");
            System.out.println("From the beginning of the work was TAKEN:");
            for (int i = 0; i < 10; i++) {
                System.out.println(Banknotes.nameOfBanknotes[i] + ": " + Statistic.statOfTakenMoney[i]);
            }
            System.out.println("From the beginning of the work was PLACED:");
            for (int i = 0; i < 10; i++) {
                System.out.println(Banknotes.nameOfBanknotes[i] + ": " + Statistic.statOfPlacedMoney[i]);
            }
            atmFacade();
        } else if (answer.equalsIgnoreCase("5")) {
            System.out.println("Thank you for your visit!");
            start.close();
        } else {
            System.out.println("Incorrect option. Try again");
            System.out.println("");
            atmFacade();
        }
    }
}
