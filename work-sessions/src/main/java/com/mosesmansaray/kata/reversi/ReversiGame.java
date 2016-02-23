package com.mosesmansaray.kata.reversi;

/**
 * @author moses.mansaray
 *
 * source : https://www.reddit.com/r/dailyprogrammer/comments/468pvf/20160217_challenge_254_intermediate_finding_legal/
 */
public class ReversiGame {
  private int boardSize;
  private String[][] board;
  private String currentPlayer;
  private String waitingPlayer;

  public ReversiGame(int boardSize) {
    this.boardSize = boardSize;
    board = new String[boardSize][boardSize];
  }

  public void setBoardsCurrent(String boardInput) {
    String[] rawBoardInputRows = boardInput.split("\n");
    setCurrentPlayer(rawBoardInputRows[0]);
    configureCurrentBoard(rawBoardInputRows);
  }

  private void configureCurrentBoard(String[] rawBoardInputRows) {
    for (int row = 0; row < boardSize; row++) {
      for (int col = 0; col < boardSize; col++) {
        getBoard()[row][col] = String.valueOf(rawBoardInputRows[row +1].charAt(col));
      }
    }
  }

  public String[][] getBoardForValidMoves() {
    for (int row = 0; row < boardSize; row++) {
      for (int col = 0; col < boardSize; col++) {
        String currentPlayed = getBoard()[row][col];
        if (!currentPlayed.equalsIgnoreCase(waitingPlayer)) {
          continue;
        }
        if (!getBoard()[row][col+1].equalsIgnoreCase(currentPlayed)) {
          continue;
        }
        if (getBoard()[row][col-1].equalsIgnoreCase("-")){
          getBoard()[row][col]="*";
        }
      }
    }
    return getBoard();
  }


  public String getCurrentPlayer() {
    return currentPlayer;
  }

  public void setCurrentPlayer(String currentPlayer) {
    this.currentPlayer = currentPlayer;
    waitingPlayer = currentPlayer.equalsIgnoreCase("X") ? "O" : "X";
  }

  public String[][] getBoard() {
    return board;
  }

}
