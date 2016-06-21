package com.mosesmansaray.kata.rotatematrix;

import org.junit.Test;

import java.lang.reflect.Array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * // TODO : Description
 *
 * @author moses.mansaray.
 */
public class RotateMatrixTest {

  private static final String INPUT_MATRIX =
      "1 2 3 4\n" +
      "5 6 7 8\n" +
      "9 a b c\n" +
      "d e f g";

  @Test
  public void shouldReturnInputIntoArrayMatrix() throws Exception {

    // Given
    RotateMatrix rotateMatrix = new RotateMatrix(INPUT_MATRIX);

    // When
    String[][] result = rotateMatrix.getRawMatrix();

    // Then
    assertThat(result.length, is(4));
    assertThat(result[0].length, is(4));
    assertThat(result[1].length, is(4));
    assertThat(result[0], is(new String[]{"1", "2", "3", "4"}));
    assertThat(result[1], is(new String[]{"5", "6", "7", "8"}));
    assertThat(result[2], is(new String[]{"9", "a", "b", "c"}));
    assertThat(result[3], is(new String[]{"d", "e", "f", "g"}));

  }


  @Test
  public void shouldReturnRotatedMatrixArray_forA90DegreeRotation() throws Exception {

    // Given
    RotateMatrix rotateMatrix = new RotateMatrix(INPUT_MATRIX);

    // When
    String[][] result = rotateMatrix.rotate(90);

    // Then
    assertThat(result.length, is(4));
    assertThat(result[0].length, is(4));
    assertThat(result[1].length, is(4));
    assertThat(result[0], is(new String[]{"d", "9", "5", "1"}));
    assertThat(result[1], is(new String[]{"e", "a", "6", "2"}));
    assertThat(result[2], is(new String[]{"f", "b", "7", "3"}));
    assertThat(result[3], is(new String[]{"g", "c", "8", "4"}));
  }

}
