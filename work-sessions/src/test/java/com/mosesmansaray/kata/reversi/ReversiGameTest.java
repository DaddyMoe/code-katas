package com.mosesmansaray.kata.reversi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author moses.mansaray
 *
 * source :https://www.reddit.com/r/dailyprogrammer/comments/468pvf/20160217_challenge_254_intermediate_finding_legal/
 */
public class ReversiGameTest {

  ReversiGame reversiGame;

  String boardInput = "" +
      "X\n" +
      "--------\n" +
      "--------\n" +
      "--------\n" +
      "---OX---\n" +
      "---XO---\n" +
      "--------\n" +
      "--------\n" +
      "--------";

  @Before
  public void setUp() {
    reversiGame = new ReversiGame(8);
    reversiGame.setBoardsCurrent(boardInput);
  }

  @Test
  public void shouldReturnBoard_ForGivenDimensions(){
    String[][] board = reversiGame.getBoard();
    assertEquals(8, board.length);
    assertEquals(8, board[0].length);
  }

  @Test
  public void shouldReturnNextPlay_ForCurrentProgress(){
    String actualPlayer = reversiGame.getCurrentPlayer();
    assertEquals("X", actualPlayer);
  }

  @Test
  public void shouldSetupBoard_forGivenInputs(){
    String[][] board = reversiGame.getBoard();
    assertEquals("O", board[3][3]);
    assertEquals("X", board[3][4]);
    assertEquals("X", board[4][3]);
    assertEquals("O", board[4][4]);
  }

  //@Test
  public void shouldReturnBoardForValidHorizontalMoves(){
    String[][] board = reversiGame.getBoardForValidMoves();
    assertEquals("*", board[2][3]);
    assertEquals("*", board[3][2]);
    assertEquals("X", board[3][5]);
    assertEquals("X", board[5][4]);

    //PreviousPlayer States
    assertEquals("O", board[3][3]);
    assertEquals("X", board[3][4]);
    assertEquals("X", board[4][3]);
    assertEquals("O", board[4][4]);
  }

  @Test
  public void shouldReturnBoardForValidVerticalMoves(){
    String[][] board = reversiGame.getBoardForValidMoves();


    //PreviousPlayer States
    assertEquals("O", board[3][3]);
    assertEquals("X", board[3][4]);
    assertEquals("X", board[4][3]);
    assertEquals("O", board[4][4]);
  }

}
