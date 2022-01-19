package com.company;

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
            System.out.println("The money was given by next banknotes:");
            for(int i = nameOfBanknotes.length - 1; count > 0; i--) {

                if (count >= nameOfBanknotes[i]) {
                    int amountOfCurrentBanknotes = count / nameOfBanknotes[i];
                    if(amountOfCurrentBanknotes > amountOfMoneyInATM[i]) {
                        count -= amountOfMoneyInATM[i] * nameOfBanknotes[i];
                        amountOfMoneyInATM[i] -= amountOfMoneyInATM[i];
                    } else {
                        System.out.println(nameOfBanknotes[i] + ": " + amountOfCurrentBanknotes);
                        amountOfMoneyInATM[i] -= amountOfCurrentBanknotes;
                        count -= amountOfCurrentBanknotes * nameOfBanknotes[i];
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong. Try to get another sum in the next time");
        }

    }

    public void giveMoneyStrategy2(int number) {
        try {
            int count = number;
            System.out.println("The money was given by next banknotes:");
            int [] copy = new int[10];
            System.arraycopy(amountOfMoneyInATM, 0, copy, 0, 10);

            while (count > 0) {
                for(int i = 0; i < nameOfBanknotes.length - 1; i++) {
                    if (nameOfBanknotes[i] <= count && amountOfMoneyInATM[i] != 0) {
                        count -= nameOfBanknotes[i];
                        amountOfMoneyInATM[i] -= 1;
                    }
                }
            }

            for (int j = 0; j < 10; j++) {
                if (copy[j] != amountOfMoneyInATM[j]) {
                    int amount = copy[j] - amountOfMoneyInATM[j];
                    System.out.println(nameOfBanknotes[j] + ": " + amount);
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong. Try to get another sum in the next time");
        }

    }

    public void putMoney(String [] money) {
        for (String i: money) {
            switch (i) {
                case "1": setOne(getOne() + 1);
                    break;
                case "2": setTwo(getTwo() + 1);
                    break;
                case "5": setFive(getFive() + 1);
                    break;
                case "10": setTen(getTen() + 1);
                    break;
                case "20": setTwenty(getTwenty() + 1);
                    break;
                case "50": setFifty(getFifty() + 1);
                    break;
                case "100": setOneHundred(getOneHundred() + 1);
                    break;
                case "200": setTwoHundred(getTwoHundred() + 1);
                    break;
                case "500": setFiveHundred(getFiveHundred() + 1);
                    break;
                case "1000": setOneThousand(getOneThousand() + 1);
                    break;
            }
        }
    }

    public int allMoneyInATM() {
        int count = 0;
        for (int i = 0; i < nameOfBanknotes.length; i++) {
            count += nameOfBanknotes[i] * amountOfMoneyInATM[i];
        }
        return count;
    }
}
