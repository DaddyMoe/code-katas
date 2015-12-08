package com.mosesmansaray.kata.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by moses.mansaray on 08/12/2015.
 */
public class TicTacToeWinDetectorTest {

    TicTacToeBoard ticTacToeBoard =  new TicTacToeBoard(3, 3);
    TicTacToeWinDetector ticTacToeWinDetector = new TicTacToeWinDetector();
    int PLAYER_1 = 1;

    @Test
    public void whenNoPlayerHasWonDetectItOnBoard() {
        int[][] boardArray = {{0, 1, 1}, {2, 0, 0}, {2, 0, 0}};
        ticTacToeBoard.hackBoard(boardArray);
        assertEquals(0, ticTacToeWinDetector.detectWinningPlayer(ticTacToeBoard, 1));
    }

    @Test
    public void whenOnePlayerHasWonDetectItOnBoardForHorizontalWin() {
        int[][] boardArray = {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}};
        ticTacToeBoard.hackBoard(boardArray);
        assertEquals(1, ticTacToeWinDetector.detectWinningPlayer(ticTacToeBoard, PLAYER_1));
    }

    @Test
    public void whenOnePlayerHasWonDetectItOnBoardForHorizontalWinRow2() {
        int[][] boardArray = {{1, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        ticTacToeBoard.hackBoard(boardArray);
        assertEquals(1, ticTacToeWinDetector.detectWinningPlayer(ticTacToeBoard, PLAYER_1));
    }

    @Test
    public void whenOnePlayerHasWonDetectItOnBoardForHorizontalWinRow3() {
        int[][] boardArray = {{1, 0, 1}, {1, 1, 0}, {1, 1, 1}};
        ticTacToeBoard.hackBoard(boardArray);
        assertEquals(1, ticTacToeWinDetector.detectWinningPlayer(ticTacToeBoard, PLAYER_1));
    }

    @Test
    public void whenOnePlayerHasWonDetectItOnBoardForVerticalWin() {
        int[][] boardArray = {{1, 0, 1}, {1, 0, 0}, {1, 0, 0}};
        ticTacToeBoard.hackBoard(boardArray);
        assertEquals(1, ticTacToeWinDetector.detectWinningPlayer(ticTacToeBoard, PLAYER_1));
    }

    @Test
    public void whenOnePlayerHasWonDetectItOnBoardForVerticalWin2() {
        int[][] boardArray = {{1, 1, 0}, {1, 1, 0}, {0, 1, 0}};
        ticTacToeBoard.hackBoard(boardArray);
        assertEquals(1, ticTacToeWinDetector.detectWinningPlayer(ticTacToeBoard, PLAYER_1));
    }

    @Test
    public void whenOnePlayerHasWonDetectItOnBoardForVerticalWin3() {
        int[][] boardArray = {{0, 1, 1}, {1, 0, 1}, {0, 0, 1}};
        ticTacToeBoard.hackBoard(boardArray);
        assertEquals(1, ticTacToeWinDetector.detectWinningPlayer(ticTacToeBoard, PLAYER_1));
    }

    @Test
    public void whenOnePlayerHasWonDetectItOnBoardForDiagonalWin() {
        int[][] boardArray = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        ticTacToeBoard.hackBoard(boardArray);
        assertEquals(1, ticTacToeWinDetector.detectWinningPlayer(ticTacToeBoard, PLAYER_1));
    }

    @Test
    public void whenOnePlayerHasWonDetectItOnBoardForDiagonalWinReverse() {
        int[][] boardArray = {{0, 0, 1}, {0, 1, 0}, {1, 0, 0}};
        ticTacToeBoard.hackBoard(boardArray);
        assertEquals(1, ticTacToeWinDetector.detectWinningPlayer(ticTacToeBoard, PLAYER_1));
    }


    @Test
    public void whenOnePlayerHasWonDetectItOnBoardForDiagonalWinReverseFail() {
        int[][] boardArray = {{0, 0, 1}, {0, 1, 0}, {0, 0, 0}};
        ticTacToeBoard.hackBoard(boardArray);
        assertEquals(0, ticTacToeWinDetector.detectWinningPlayer(ticTacToeBoard, PLAYER_1));
    }

}