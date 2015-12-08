package com.mosesmansaray.kata.fibonacciIshSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moses.mansaray on 20/10/2015.
 */
public class FibonacciIshSequence {

    private int startingWith = 1;

    public FibonacciIshSequence() {
    }

    public FibonacciIshSequence(int startsWith) {
        this.startingWith = startsWith;
    }


    public int getNextFibo(int which) {
        if (which == 0){
            return 0;
        }
        if(which <= 2) {
            return startingWith;
        } else {
            return getNextFibo(which - 2) + getNextFibo(which - 1);
        }
    }

    public String getFibs(int valueToMatch) {
        int count = 0;
        List fibs = new ArrayList<>();

        while (true) {

            if (valueToMatch == 0){
                fibs.add(valueToMatch);
                break;
            }

            if (count ==0){
                fibs.add(count++);
                continue;
            }else if(!isDivisibleByMinimum(startingWith, valueToMatch)){
                startingWith ++;
                continue;
            }

            int fib = getNextFibo(count);
            fibs.add(fib);

            if (fib == valueToMatch){
                break;
            }

            if (fib > valueToMatch){
                startingWith ++;
                count = 0;
                fibs = new ArrayList<>();
                continue;
            }

            count ++;
        }

        return getFlattenString(fibs);
    }

    /**
     * This has drastically reduce the response time for eg getFibs(123456789)) from 18secs to 152ms
     * @param count
     * @param valueToMatch
     * @return
     */
    private boolean isDivisibleByMinimum(int count, int valueToMatch) {
        return valueToMatch%count ==0;
    }

    /**
     * Strip all characters in this quote : ",[]"
     *
     * @param fibs
     * @return String of fibs
     */
    private String getFlattenString(List fibs) {
//        return fibs.toString().replaceAll(",|\\[|\\]", "");
        return fibs.toString().replaceAll("[~,\\[\\]]", "");
//        [~xyz]	[^xyz]	A negative character set. Matches any characters NOT between brackets.
    }

}
