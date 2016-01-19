package com.mosesmansaray.kata.fibonacciIshSequence;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/3opin7/20151014_challenge_236_intermediate_fibonacciish/
 */
public class FibonacciIshSequenceTest {
    private static final String realWorldExpected = "0 7 7 14 21 35 56 91 147 238 385 623 1008 1631 2639 4270 " +
            "6909 11179 18088 29267 47355 76622 123977 200599 324576 525175 849751 1374926 2224677 3599603 " +
            "5824280 9423883 15248163 24672046 39920209 64592255 104512464 169104719 273617183 442721902 " +
            "716339085 1159060987 1875400072 3034461059 4909861131 7944322190 12854183321 20798505511 " +
            "33652688832 54451194343 88103883175 142555077518 230658960693 373214038211 603872998904 " +
            "977087037115 1580960036019 2558047073134 4139007109153 6697054182287 10836061291440 " +
            "17533115473727 28369176765167 45902292238894 74271469004061 120173761242955 " +
            "194445230247016 314618991489971 509064221736987 823683213226958 " +
            "1332747434963945 2156430648190903 3489178083154848 " +
            "5645608731345751 9134786814500599 " +
            "14780395545846350 " +
            "23915182360346949 " +
            "38695577906193299";

    @Test
    public void shouldReturnNextValue(){
        FibonacciIshSequence fibonacciIshSequence = new FibonacciIshSequence(1);
        assertEquals(0, fibonacciIshSequence.getNextFibo(0));
        assertEquals(1, fibonacciIshSequence.getNextFibo(1));
        assertEquals(1, fibonacciIshSequence.getNextFibo(2));
        assertEquals(2, fibonacciIshSequence.getNextFibo(3));
        assertEquals(3, fibonacciIshSequence.getNextFibo(4));
        assertEquals(5, fibonacciIshSequence.getNextFibo(5));
        assertEquals(8, fibonacciIshSequence.getNextFibo(6));
        assertEquals(13, fibonacciIshSequence.getNextFibo(7));
    }


    @Test
    public void shouldReturnFibsStartingWith3(){
        FibonacciIshSequence fibonacciIshSequence = new FibonacciIshSequence(3);
        assertEquals(0, fibonacciIshSequence.getNextFibo(0));
        assertEquals(3, fibonacciIshSequence.getNextFibo(1));
        assertEquals(3, fibonacciIshSequence.getNextFibo(2));
        assertEquals(6, fibonacciIshSequence.getNextFibo(3));
        assertEquals(9, fibonacciIshSequence.getNextFibo(4));
        assertEquals(15, fibonacciIshSequence.getNextFibo(5));
        assertEquals(24, fibonacciIshSequence.getNextFibo(6));
        assertEquals(39, fibonacciIshSequence.getNextFibo(7));
    }

    @Test
    public void shouldReturnListOfFibsLowerOrEqualsTo9(){
        FibonacciIshSequence fibonacciIshSequence = new FibonacciIshSequence();
        String actualFibs = fibonacciIshSequence.getFibs(9);
        assertEquals("0 3 3 6 9", actualFibs);
    }

    @Test
    public void shouldAllPassForChallengeExamples(){
        FibonacciIshSequence fibonacciIshSequence = new FibonacciIshSequence();
        assertEquals("0 1 1 2 3 5 8 13 21", fibonacciIshSequence.getFibs(21));
        assertEquals("0 4 4 8 12 20 32 52 84", fibonacciIshSequence.getFibs(84));
        assertEquals("0", fibonacciIshSequence.getFibs(0));
        assertEquals("0 17 17 34 51 85 136 221 357 578", fibonacciIshSequence.getFibs(578));
        assertEquals("0 41152263 41152263 82304526 123456789", fibonacciIshSequence.getFibs(123456789));
    }
}
