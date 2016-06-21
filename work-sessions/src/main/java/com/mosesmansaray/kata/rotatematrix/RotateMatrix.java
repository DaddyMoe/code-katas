package com.mosesmansaray.kata.rotatematrix;

/**
 * KATA: rotates a metrix
 *
 * @author moses.mansaray.
 */
public class RotateMatrix {

  String[][] rawMatrix;
  private static int lengthOfSquare;


  public RotateMatrix(String inputMatrix) {

    rawMatrix = initRawMatrix(inputMatrix);
    lengthOfSquare = rawMatrix.length;
  }

  private String[][] initRawMatrix(String rawString) {

    String[] split = rawString.split("\n");
    String[][] result = new String[split.length][split.length];

    for (int indexRow = 0; indexRow < split.length; indexRow++) {
      String[] columns = split[indexRow].split(" ");
      result[indexRow] = columns;
    }

    return result;
  }

  String[][] rotate(int rotateBy) {

    String[][] rotated = new String[lengthOfSquare][lengthOfSquare];

    if (rotateBy == 90) {
      rotated = rotateBy90();
    }

    return rotated;
  }

  private String[][] rotateBy90() {

    String[][] rotated = new String[lengthOfSquare][lengthOfSquare];

    for (int i = lengthOfSquare; i > 0; i--) {
      for (int j = 0; j < lengthOfSquare; j++) {
        rotated[lengthOfSquare - i][j] = rawMatrix[lengthOfSquare - (j + 1)][lengthOfSquare - (i)];
      }
    }
    return rotated;
  }

  String[][] getRawMatrix() {
    return this.rawMatrix;
  }
}
