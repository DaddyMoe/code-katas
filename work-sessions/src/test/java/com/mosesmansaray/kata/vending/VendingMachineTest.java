package com.mosesmansaray.kata.vending;

import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class VendingMachineTest {
    private static final double DELTA = 1e-15;

    @Test
    public void testRunner() {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldReturnExpectedMoneyValue() {
        Currency nickel = Currency.NICKEL;
        Currency dime = Currency.DIME;
        Currency quarter = Currency.QUARTER;
        Currency dollar = Currency.DOLLAR;

        assertEquals(0.05, nickel.value, 2);
        assertEquals(0.10, dime.value, 2);
        assertEquals(0.25, quarter.value, 2);
        assertEquals(1.00, dollar.value, 2);

    }

    @Test
    public void shouldReturnCorrectBalance(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(Currency.NICKEL);
        vendingMachine.insertMoney(Currency.DIME);
        assertEquals(0.15, vendingMachine.returnMoneyValue(), 2);
    }

    @Test
    public void shouldReturnCorrectMoney(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(Currency.NICKEL);
        vendingMachine.insertMoney(Currency.DIME);

        List<Currency> returnCoins = vendingMachine.returnCoins();
        Assert.assertTrue(returnCoins.contains(Currency.NICKEL));
        Assert.assertTrue(returnCoins.contains(Currency.DIME));
        assertEquals(0.15, vendingMachine.returnMoneyValue(), 2);

    }

    @Test
    public void shouldReturnEmptyBalanceAfterMoneyReturn(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(Currency.QUARTER);
        vendingMachine.insertMoney(Currency.DIME);

        vendingMachine.returnMoneyValue();
        double moneyValue2 = vendingMachine.returnMoneyValue();
        Assert.assertEquals(0.00, moneyValue2, DELTA);
    }

    @Test
    public void shouldReturnCorrectNumberOfExpectedItems(){
        VendingMachine vendingMachine = new VendingMachine();
//        assertTrue(vendingMachine.getAvailable)
    }

//    TODO: Complete :
    // - Source code dojo source for specifications,, from emails/reddit-daily-programmer

}



