package com.mosesmansaray.kata.gameOfThree;

/**
 * Source : https://www.reddit.com/r/dailyprogrammer/comments/3r7wxz/20151102_challenge_239_easy_a_game_of_threes/
 * Created by moses.mansaray on 16/11/2015.
 */
public class GameOfThrees {

    public boolean isDivisibleBy3(int numberToCheck) {
        return numberToCheck % 3 == 0;
    }

    public int findDivisibleNumberOf(int numberToCheck) {
        int divisibleNumber = 0;
        if (isDivisibleBy3(numberToCheck)) {
            divisibleNumber = numberToCheck;
            System.out.println(numberToCheck + " 0");
        }

        if (isDivisibleBy3(numberToCheck + 1)) {
            divisibleNumber = numberToCheck + 1;
            System.out.println(numberToCheck + " 1");
        }

        if (isDivisibleBy3(numberToCheck - 1)) {
            divisibleNumber = numberToCheck - 1;
            System.out.println(numberToCheck + " - 1");
        }

        return divisibleNumber;
    }

    public int divideDownToOne(int numberToDivideDown) {
        int dividedDownNumber = findDivisibleNumberOf(numberToDivideDown) / 3;

        if (dividedDownNumber > 1) {
            return divideDownToOne(dividedDownNumber);
        }

        System.out.println(1);
        return 1;
    }
}
