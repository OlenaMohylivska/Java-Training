package com.company;

import java.util.ArrayList;

public class ATM extends Banknotes {
    int one;
    int two;
    int five;
    int ten;
    int twenty;
    int fifty;
    int oneHundred;
    int twoHundred;
    int fiveHundred;
    int oneThousand;

    ATM(int one, int two, int five, int ten, int twenty, int fifty, int oneHundred, int twoHundred, int fiveHundred, int oneThousand) {
        this.one = one;
        this.two = two;
        this.five = five;
        this.ten = ten;
        this.twenty = twenty;
        this.fifty = fifty;
        this.oneHundred = oneHundred;
        this.twoHundred = twoHundred;
        this.fiveHundred = fiveHundred;
        this.oneThousand = oneThousand;
    }

    public void giveMoneyStrategy1(int number) {
        try {
            int count = number;
            int [] copyAmountOfMoneyInATM = new int[10];
            System.arraycopy(amountOfMoneyInATM, 0, copyAmountOfMoneyInATM, 0, 10);
            ArrayList<String> reportOfOperation = new ArrayList<String>(0);

            int [] copyArrayOfTakenMoneyStat = new int[10];
            System.arraycopy(Statistic.statOfTakenMoney, 0, copyArrayOfTakenMoneyStat, 0, 10);

            for(int i = nameOfBanknotes.length - 1; count > 0; i--) {

                if (count >= nameOfBanknotes[i] && copyAmountOfMoneyInATM[i] != 0) {
                    int reqNumbOfCurrBanknotes = count / nameOfBanknotes[i];

                    if(reqNumbOfCurrBanknotes > copyAmountOfMoneyInATM[i]) {
                        count -= copyAmountOfMoneyInATM[i] * nameOfBanknotes[i];
                        reportOfOperation.add(nameOfBanknotes[i] + ": " + copyAmountOfMoneyInATM[i]);
                        copyArrayOfTakenMoneyStat[i] += copyAmountOfMoneyInATM[i];
                        copyAmountOfMoneyInATM[i] -= copyAmountOfMoneyInATM[i];

                    } else {
                        reportOfOperation.add(nameOfBanknotes[i] + ": " + reqNumbOfCurrBanknotes);
                        copyArrayOfTakenMoneyStat[i] += reqNumbOfCurrBanknotes;
                        copyAmountOfMoneyInATM[i] -= reqNumbOfCurrBanknotes;
                        count -= reqNumbOfCurrBanknotes * nameOfBanknotes[i];
                    }
                }
            }
            // to confirm right behavior and show output
            if (Banknotes.atm.toCountAllMoneyInATM(copyAmountOfMoneyInATM) + number == Banknotes.atm.toCountAllMoneyInATM(amountOfMoneyInATM)) {
                amountOfMoneyInATM = copyAmountOfMoneyInATM;
                System.out.println("The money was given by next banknotes:");
                reportOfOperation.forEach(e -> System.out.println(e));
                Statistic.statOfTakenMoney = copyArrayOfTakenMoneyStat;
            }
        } catch (Exception e) {
            System.out.println("Something went wrong. Try to get another sum in the next time");
        }
    }

    public void giveMoneyStrategy2(int number) {
        int [] copyArrayOfTakenMoneyStat = new int[10];
        System.arraycopy(Statistic.statOfTakenMoney, 0, copyArrayOfTakenMoneyStat, 0, 10);

        try {
            int sum = number;
            int [] copyAmountOfMoneyInATM = new int[10];
            System.arraycopy(amountOfMoneyInATM, 0, copyAmountOfMoneyInATM, 0, 10);
            int counter = 0;

            while (sum > 0) {
                counter++;
                if (counter == 20) throw new Exception("ATM doesn't have appropriate banknotes.");
                for(int i = 0; i < nameOfBanknotes.length; i++) {
                    if (nameOfBanknotes[i] <= sum && copyAmountOfMoneyInATM[i] != 0) {
                        sum -= nameOfBanknotes[i];
                        copyAmountOfMoneyInATM[i] -= 1;
                    }
                }
            }
            // to confirm right behavior and show output
            if (Banknotes.atm.toCountAllMoneyInATM(copyAmountOfMoneyInATM) + number == Banknotes.atm.toCountAllMoneyInATM(amountOfMoneyInATM)) {
                System.out.println("The money was given by next banknotes:");

                for (int j = 0; j < 10; j++) {
                    if (copyAmountOfMoneyInATM[j] != amountOfMoneyInATM[j]) {
                        int amount = amountOfMoneyInATM[j] - copyAmountOfMoneyInATM[j];
                        Statistic.statOfTakenMoney[j] += amount;
                        amountOfMoneyInATM[j] = copyAmountOfMoneyInATM[j];
                        System.out.println(nameOfBanknotes[j] + ": " + amount);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " Try to get another sum or strategy. ");
        }
    }

    public void putMoney(String [] money) {
        for (String i: money) {
            switch (i) {
                case "1": setOne(getOne() + 1);
                    Statistic.statOfPlacedMoney[0] += 1;
                    break;
                case "2": setTwo(getTwo() + 1);
                    Statistic.statOfPlacedMoney[1] += 1;
                    break;
                case "5": setFive(getFive() + 1);
                    Statistic.statOfPlacedMoney[2] += 1;
                    break;
                case "10": setTen(getTen() + 1);
                    Statistic.statOfPlacedMoney[3] += 1;
                    break;
                case "20": setTwenty(getTwenty() + 1);
                    Statistic.statOfPlacedMoney[4] += 1;
                    break;
                case "50": setFifty(getFifty() + 1);
                    Statistic.statOfPlacedMoney[5] += 1;
                    break;
                case "100": setOneHundred(getOneHundred() + 1);
                    Statistic.statOfPlacedMoney[6] += 1;
                    break;
                case "200": setTwoHundred(getTwoHundred() + 1);
                    Statistic.statOfPlacedMoney[7] += 1;
                    break;
                case "500": setFiveHundred(getFiveHundred() + 1);
                    Statistic.statOfPlacedMoney[8] += 1;
                    break;
                case "1000": setOneThousand(getOneThousand() + 1);
                    Statistic.statOfPlacedMoney[9] += 1;
                    break;
            }
        }
    }

    public int toCountAllMoneyInATM(int [] arrayOfMoney) {
        int count = 0;
        for (int i = 0; i < nameOfBanknotes.length; i++) {
            count += nameOfBanknotes[i] * arrayOfMoney[i];
        }
        return count;
    }
}
