package com.mosesmansaray.kata.vending;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    private List<Currency> balanceList = new ArrayList<>();
    private Map<Items, Integer> availableItems = new HashMap<>();

    public VendingMachine() {
        this.availableItems.put(Items.A, 2);
        this.availableItems.put(Items.B, 3);
        this.availableItems.put(Items.C, 2);
    }

    private double balance = 0;

    public void insertMoney(Currency currency) {
        this.balanceList.add(currency);
        System.out.println(currency);
    }

    public double returnMoneyValue() {
        balance = 0.00;
        for (Currency currency : balanceList) {
            balance += currency.value;
        }
        resetCoins();
        return balance;
    }


    public List<Currency> returnCoins() {
        List<Currency> balanceListToReturn = this.balanceList;
        resetCoins();
        printReturnStatement(balanceListToReturn);
        return balanceListToReturn;
    }

    public void printReturnStatement(List<Currency> balanceListToReturn) {
        StringBuffer stringBuffer = new StringBuffer();

        for (Currency currency : balanceListToReturn) {
            stringBuffer.append(currency + ", ") ;
        }
        stringBuffer.append("return coin(s)");
        System.out.println(stringBuffer.toString());
    }

    private void resetCoins() {
        this.balanceList = new ArrayList<>();
    }
}
