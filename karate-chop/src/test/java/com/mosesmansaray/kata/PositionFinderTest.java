package com.mosesmansaray.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created on 05/09/2015.
 *
 * @author moses.mansaray
 */
public class PositionFinderTest {
  private final PositionFinder positionFinder = new PositionFinder();

  @Test
  public void shouldReturnHighGivenArray() {
    String errorMsg = "midpoint not as expected";

    int[] valueArray = {1, 2, 3, 4, 5};
    int high = positionFinder.getHigh(valueArray);
    assertEquals(errorMsg, 4, high);
  }

  @Test
  public void shouldReturnMidPointOfGivenTwoPoint() {
    assertMidPointIsAsExpected(0, 3, 1);
    assertMidPointIsAsExpected(0, 4, 2);
    assertMidPointIsAsExpected(0, 5, 2);
    assertMidPointIsAsExpected(0, 6, 3);
    assertMidPointIsAsExpected(3, 6, 4);
    assertMidPointIsAsExpected(0, 7, 3);
  }

  private void assertMidPointIsAsExpected(int low, int high, int expectedMidPoint) {
    String errorMsg = "midpoint not as expected";

    int actualMidPoint;
    actualMidPoint = positionFinder.getMidPoint(low, high);
    assertEquals(errorMsg, expectedMidPoint, actualMidPoint);
  }

  @Test
  public void shouldReturnNegativeIntForEmptyArray() {
    String errorMsg = "response not a negative int";

    int position = positionFinder.getPosition(new int[]{}, 3);
    assertTrue(errorMsg, position < 0);
  }

  @Test
  public void shouldReturnNegativeIntForNullArray() {
    String errorMsg = "response not a negative int";

    int position = positionFinder.getPosition(null, 3);
    assertTrue(errorMsg, position < 0);
  }

  @Test
  public void shouldReturnPositivePositionIfValueExistInArray() {
    String errorMsg = "position is not greater than 0";

    int[] valueArray = {1, 2, 3, 4, 5};
    int position = positionFinder.getPosition(valueArray, 3);
    assertTrue(errorMsg, position > 0);
  }

  @Test
  public void shouldReturnNegativePositionIfValueDoesNotExistInArray() {
    String errorMsg = "position is not less than 0";

    int[] valueArray = {1, 2, 3, 4, 5};
    int position = positionFinder.getPosition(valueArray, 9);
    assertTrue(errorMsg, position < 0);
  }

  @Test
  public void shouldReturnPositionAsExpected() {
    assertPositionIsAsExpected(new int[]{0, 2, 9, 50, 800, 909, 990}, 800, 4);
    assertPositionIsAsExpected(new int[]{1, 2, 5, 6, 7, 9, 60}, 5, 2);
    assertPositionIsAsExpected(new int[]{1, 2, 5, 6, 7, 9, 60, 80, 90}, 90, 8);
    assertPositionIsAsExpected(new int[]{1, 2, 5, 6, 7, 9, 60, 80, 90}, 60, 6);
    assertPositionIsAsExpected(new int[]{1, 2, 5, 6, 7, 9, 60, 80, 90}, 2, 1);
  }

  private void assertPositionIsAsExpected(int[] valueArray, int value, int expectedPosition) {
    String errorMsg = "position not as expected";

    int actualPosition = positionFinder.getPosition(valueArray, value);
    assertEquals(errorMsg, expectedPosition, actualPosition);
  }

  @Test
  public void chopTestOfExerciseData(){
    assertPositionIsAsExpected(new int[]{}, 3, -1);
    assertPositionIsAsExpected(new int[]{1}, 3, -1);
    assertPositionIsAsExpected(new int[]{1}, 1, 0);
    //
    assertPositionIsAsExpected(new int[]{1,3,5}, 1, 0);
    assertPositionIsAsExpected(new int[]{1,3,5}, 3, 1);
    assertPositionIsAsExpected(new int[]{1,3,5}, 5, 2);
    assertPositionIsAsExpected(new int[]{1,3,5}, 0, -1);
    assertPositionIsAsExpected(new int[]{1,3,5}, 2, -1);
    assertPositionIsAsExpected(new int[]{1,3,5}, 4, -1);
    assertPositionIsAsExpected(new int[]{1,3,5}, 6, -1);
    //
    assertPositionIsAsExpected(new int[]{1,3,5,7}, 1, 0);
    assertPositionIsAsExpected(new int[]{1,3,5,7}, 3, 1);
    assertPositionIsAsExpected(new int[]{1,3,5,7}, 5, 2);
    assertPositionIsAsExpected(new int[]{1,3,5,7}, 7, 3);
    assertPositionIsAsExpected(new int[]{1,3,5,7}, 0, -1);
    assertPositionIsAsExpected(new int[]{1,3,5,7}, 2, -1);
    assertPositionIsAsExpected(new int[]{1,3,5,7}, 4, -1);
    assertPositionIsAsExpected(new int[]{1,3,5,7}, 6, -1);
    assertPositionIsAsExpected(new int[]{1,3,5,7}, 8, -1);
  }

  //TODO: more tests can be done here for edge and special case code implementation

}
