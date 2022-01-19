package com.company;

import java.io.IOException;

public class Cache {

    public static void banknotes() throws IOException {
        for  (int i = 0; Banknotes.amountOfMoneyInATM.length > i; i++) {
            System.out.println("Banknote " + Banknotes.nameOfBanknotes[i] + ": " + Banknotes.amountOfMoneyInATM[i]);
        }
    }
}
