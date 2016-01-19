package com.mosesmansaray.kata.vending;

/**
 * Created by moses.mansaray on 06/10/2015.
 */
enum Currency {

    NICKEL(0.05), DIME(0.10), QUARTER(0.25), DOLLAR(1.00);

    public double value;

    Currency(double value) {
        this.value = value;
    }
}
