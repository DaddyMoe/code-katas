package com.mosesmansaray.kata.puzzle;

import java.util.Arrays;

/**
 * Created by moses.mansaray on 12/04/2016.
 */
public class PuzzleSolver {

  private char[] board;
  private int width;

  public PuzzleSolver(String randomBoardRaw) {

    String[] split = randomBoardRaw.split("\n");
    width = Integer.valueOf(split[0]);

    String values = "";
    for (int i = 2; i < split.length; i++) {
      values = values + split[i];
    }

    board = values.toCharArray();

  }

  public char[] getBoard() {

    return board;

  }


  public String printBoardValue() {

    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < width; i++) {

      stringBuilder.append(board, i*width, width).append("\n");

    }

    return stringBuilder.toString();

  }


//  public String getSolvedSolution() {
//
//    Arrays.sort(board);
//
//    return String.valueOf();
//
//  }
}
