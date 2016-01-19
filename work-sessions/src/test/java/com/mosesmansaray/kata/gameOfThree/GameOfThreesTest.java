package com.mosesmansaray.kata.gameOfThree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Source : https://www.reddit.com/r/dailyprogrammer/comments/3r7wxz/20151102_challenge_239_easy_a_game_of_threes/
 * Created by moses.mansaray on 16/11/2015.
 */
public class GameOfThreesTest {

    public static final GameOfThrees GAME_OF_THREES = new GameOfThrees();

    @Test
    public void shouldReturnTrueForNumberDivisibleBy3(){
        //Given
//        knowledge
        int numberToCheck = 12;
        assertTrue(GAME_OF_THREES.isDivisibleBy3(numberToCheck));
    }

    @Test
    public void shouldReturnFalseForNumberDivisibleBy3(){
        //Given
        int numberToCheck = 20;
        assertFalse(GAME_OF_THREES.isDivisibleBy3(numberToCheck));
    }

    @Test
    public void shouldReturnDivisibleNumberByThree(){
        int result = GAME_OF_THREES.findDivisibleNumberOf(20);
        assertEquals(21, result);

        int result2 = GAME_OF_THREES.findDivisibleNumberOf(100);
        assertEquals(99, result2);

        int result3 = GAME_OF_THREES.findDivisibleNumberOf(1000);
        assertEquals(999, result3);

        int result4 = GAME_OF_THREES.findDivisibleNumberOf(1001);
        assertEquals(1002, result4);

        int result5 = GAME_OF_THREES.findDivisibleNumberOf(11);
        assertEquals(12, result5);
    }


    @Test
    public void shouldReturnOneAlways(){
        int result = GAME_OF_THREES.divideDownToOne(3);
        assertEquals(1, result);

        int result1 = GAME_OF_THREES.divideDownToOne(20);
        assertEquals(1, result1);

        int result2 = GAME_OF_THREES.divideDownToOne(100);
        assertEquals(1, result2);

        int result3 = GAME_OF_THREES.divideDownToOne(1000);
        assertEquals(1, result3);

        int result4 = GAME_OF_THREES.divideDownToOne(1001);
        assertEquals(1, result4);

        int result5 = GAME_OF_THREES.divideDownToOne(11);
        assertEquals(1, result5);

        int result6 = GAME_OF_THREES.divideDownToOne(31337357);
        assertEquals(1, result6);
    }

}
