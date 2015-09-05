package com.mosesmansaray.kata;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 05/09/2015.
 *
 * @author moses.mansaray
 */
public class PositionFinder {
  private final static Logger LOGGER = Logger.getLogger(PositionFinder.class.getName());

  public int getPosition(int[] values, int value) {
    if (values == null || values.length < 1) {
      return -1;
    }
    return getPosition(values, 0, getHigh(values), value);
  }

  private int getPosition(int[] valuesArray, int low, int high, int value) {
    LOGGER.log(Level.INFO, "Get Position of " + value + ". From " + Arrays.toString(valuesArray));
    LOGGER.log(Level.INFO, "Attempting with : low:" + low + ", high:" + high);

    if (high < low) {
      return -1;
    }

    int midPoint = getMidPoint(low, high);

    if (valuesArray[midPoint] > value) {
      int highModified = midPoint - 1;
      return getPosition(valuesArray, low, highModified, value);
    } else if (valuesArray[midPoint] < value) {
      int lowModified = midPoint + 1;
      return getPosition(valuesArray, lowModified, high, value);
    } else {
      LOGGER.log(Level.INFO, "Got Position of " + value + ". Found = " + midPoint);
      return midPoint;
    }
  }

  public int getMidPoint(int low, int high) {
    return (low + high) / 2;
  }

  public int getHigh(int[] valueArray) {
    return valueArray.length - 1;
  }

}
