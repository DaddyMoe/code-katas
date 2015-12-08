package com.mosesmansaray.kata.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeBoardTest {

    public static final int PLAYER_1 = 1;
    public static final int PLAYER_2 = 2;
    public static final int ROW_1 = 1;
    public static final int COL_1 = 1;

    @Test
    public void shouldReturnBoardAsExpected(){
        TicTacToeBoard ticTacToeBoard =  new TicTacToeBoard(3,3);
        int[][] board = ticTacToeBoard.getBoard();
        assertEquals("", 3, board.length);
        assertEquals("", 3, board[0].length);
    }

    @Test
    public void onANewBoardAPositionIsAvailable() {
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard(3,3);
        assertTrue(ticTacToeBoard.isAvailable(1, 1));
    }

    @Test
    public void whenUserPlayMoveIsRecordedOnBoard() {
        TicTacToeBoard ticTacToeBoard =  new TicTacToeBoard(3,3);
        ticTacToeBoard.playMove(PLAYER_1, ROW_1, COL_1);
        assertFalse(ticTacToeBoard.isAvailable(ROW_1, COL_1));
    }


    @Test
    public void whenPositionAvailableCanMoveTo() {
        TicTacToeBoard ticTacToeBoard =  new TicTacToeBoard(3,3);
        assertTrue(ticTacToeBoard.playMove(PLAYER_1, ROW_1, COL_1));
    }

    @Test
    public void whenPositionNotAvailableCantMoveTo() {
        TicTacToeBoard ticTacToeBoard =  new TicTacToeBoard(3,3);
        ticTacToeBoard.playMove(PLAYER_1, ROW_1, COL_1);
        assertFalse(ticTacToeBoard.playMove(PLAYER_2, ROW_1, COL_1));
    }

    @Test
    public void whenGeneratePlayerMovementMove() {
        TicTacToeBoard ticTacToeBoard =  new TicTacToeBoard(3, 3);
        int[][] boardArray = {{1, 1, 2}, {2, 1, 2}, {2, 1, 0}};
        ticTacToeBoard.hackBoard(boardArray);
        int[] position = ticTacToeBoard.aiGenerateMovement(PLAYER_2);
        assertNotNull(position);
        assertTrue(position.length == 2);
        assertTrue(position[0] == 2);
        assertTrue(position[1] == 2);
    }

    @Test
    public void whenGeneratePlayerMovementAndBoardFullCantMove() {
        TicTacToeBoard ticTacToeBoard =  new TicTacToeBoard(3, 3);
        int[][] boardArray = {{1, 1, 2}, {2, 1, 2}, {2, 1, 2}};
        ticTacToeBoard.hackBoard(boardArray);
        int[] position = ticTacToeBoard.aiGenerateMovement(PLAYER_2);
        assertNotNull(position);
        assertTrue(position.length == 0);
    }

}
