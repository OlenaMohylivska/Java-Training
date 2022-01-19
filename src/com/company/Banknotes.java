package com.company;

import com.sun.tools.javac.Main;

import java.io.IOException;

public class Banknotes extends Main {
    static int[] nameOfBanknotes = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
    public static ATM atm = new ATM(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    public static int[] amountOfMoneyInATM = {atm.one, atm.two, atm.five, atm.ten, atm.twenty, atm.fifty, atm.oneHundred, atm.twoHundred, atm.fiveHundred, atm.oneThousand};

    public int getOne() {
        return this.amountOfMoneyInATM[0];
    }

    public void setOne(int one) {
        this.amountOfMoneyInATM[0] = one;
    }

    public int getTwo() {
        return amountOfMoneyInATM[1];
    }

    public void setTwo(int two) {
        this.amountOfMoneyInATM[1] = two;
    }

    public int getFive() {
        return amountOfMoneyInATM[2];
    }

    public void setFive(int five) {
        this.amountOfMoneyInATM[2] = five;
    }

    public int getTen() {
        return amountOfMoneyInATM[3];
    }

    public void setTen(int ten) {
        this.amountOfMoneyInATM[3] = ten;
    }

    public int getTwenty() {
        return amountOfMoneyInATM[4];
    }

    public void setTwenty(int twenty) {
        this.amountOfMoneyInATM[4] = twenty;
    }

    public int getFifty() {
        return amountOfMoneyInATM[5];
    }

    public void setFifty(int fifty) {
        this.amountOfMoneyInATM[5] = fifty;
    }

    public int getOneHundred() {
        return amountOfMoneyInATM[6];
    }

    public void setOneHundred(int oneHundred) {
        this.amountOfMoneyInATM[6] = oneHundred;
    }

    public int getTwoHundred() {
        return amountOfMoneyInATM[7];
    }

    public void setTwoHundred(int twoHundred) {
        this.amountOfMoneyInATM[7] = twoHundred;
    }

    public int getFiveHundred() {
        return amountOfMoneyInATM[8];
    }

    public void setFiveHundred(int fiveHundred) {
        this.amountOfMoneyInATM[8] = fiveHundred;
    }

    public int getOneThousand() {
        return amountOfMoneyInATM[9];
    }

    public void setOneThousand(int oneThousand) {
        this.amountOfMoneyInATM[9] = oneThousand;
    }
}
