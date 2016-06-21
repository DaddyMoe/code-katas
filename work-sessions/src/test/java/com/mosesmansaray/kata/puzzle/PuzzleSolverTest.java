package com.mosesmansaray.kata.puzzle;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by moses.mansaray on 12/04/2016.
 */
public class PuzzleSolverTest {

  String randomBoardRaw =
      "3\n"   +
      "===\n" +
      "153\n" +
      "426\n" +
      "87_";

  String finalBoard =
      "3\n"   +
          "===\n" +
          "123\n" +
          "456\n" +
          "78_";

  @Test
  public void shouldBuildBoardAsExpected() throws Exception {
    PuzzleSolver puzzleSolver = new PuzzleSolver(randomBoardRaw);
    char[] board = puzzleSolver.getBoard();
    assertThat(board.length, is(9));

    // test for values
    assertThat(board[0], is('1'));
    assertThat(board[1], is('5'));
    assertThat(board[2], is('3'));
    assertThat(board[3], is('4'));
    assertThat(board[4], is('2'));
    assertThat(board[5], is('6'));
    assertThat(board[6], is('8'));
    assertThat(board[7], is('7'));
    assertThat(board[8], is('_'));
  }


  @Test
  public void shouldPrintBoard_AsExpected() throws Exception {
    //expected
    String expectedBoardValue =
        "153\n" +
        "426\n" +
        "87_\n";

    PuzzleSolver puzzleSolver = new PuzzleSolver(randomBoardRaw);
    String boardRepresentation = puzzleSolver.printBoardValue();

    assertThat(boardRepresentation, is(expectedBoardValue));
  }

//  @Test
//  public void shouldReturnSolvedBoardSolution() throws Exception {
//
//    String expectedBoardValue =
//        "123\n" +
//        "456\n" +
//        "78_\n";
//
//    PuzzleSolver puzzleSolver = new PuzzleSolver(randomBoardRaw);
//    String returnedBoardValue = puzzleSolver.getSolvedSolution();
//
//    assertThat(expectedBoardValue, is(returnedBoardValue));
//
//
//  }


  @Test
  public void shouldRecognisedSolvedBoard() throws Exception {


  }
}
