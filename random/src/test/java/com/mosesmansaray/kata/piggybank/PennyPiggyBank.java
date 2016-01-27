package com.mosesmansaray.kata.piggybank;

import org.junit.Test;

/**
 * Created on 12/01/2016.
 *
 * @author moses.mansaray
 */
public class PennyPiggyBank {

  private int numberOfDaysInAYear = 365 * 3;
  private int startOfPenny = 1;

  @Test
  public void printTotalSavingsAYear(){
    int savings = 0;

    for (int pennyToSave = startOfPenny; pennyToSave <= numberOfDaysInAYear; pennyToSave++) {
      savings += pennyToSave;
    }
    StringBuilder sb = new StringBuilder(String.valueOf(savings));
    sb.insert(sb.length() -2, ".");
    System.out.println("Total Savings A year = " + sb.toString());
  }

}
