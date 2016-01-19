package com.mosesmansaray.kata.vending;

/**
 * Created by moses.mansaray on 06/10/2015.
 */
enum Items {

    A(0.65), B(1), C(1.50);

    public double value;

    Items(double value) {
        this.value = value;
    }
}
