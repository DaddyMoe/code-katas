package com.mosesmansaray.kata.tictactoe;

import com.mosesmansaray.kata.tictactoe.TicTacToeBoard;

public class TicTacToeWinDetector {

    int[][] board;

    public int detectWinningPlayer(TicTacToeBoard ticTacToeBoard, int player) {
        board = ticTacToeBoard.getBoard();
        Integer winStatus = getHorizontalWinStatus(player);
        if (winStatus > 0) return winStatus;

        winStatus = getVerticalWinStatus(player);
        if (winStatus > 0) return winStatus;

        winStatus = getDiagonalWinStatus(player);
        if (winStatus > 0) return winStatus;

        winStatus = getDiagonalReverseWinStatus(player);
        if (winStatus > 0) return winStatus;

        return 0;
    }

    private Integer getDiagonalReverseWinStatus(int player) {
        int count2 = 2;
        int boardItemValueDiagonalReverse = 0;
        for (int row = 0; row < board.length; row++) {
            boardItemValueDiagonalReverse = player;
            if (board[row][count2] != player) {
                boardItemValueDiagonalReverse = 0;
                continue;
            }
            count2--;
        }
        return boardItemValueDiagonalReverse;
    }

    private Integer getDiagonalWinStatus(int player) {
        int count = 0;
        int boardItemValue = 0;
        for (int row = 0; row < board.length; row++) {
            boardItemValue = player;
            if (board[row][count] != player) {
                boardItemValue = 0;
                break;
            }
            count++;
        }
        return boardItemValue;
    }

    private Integer getVerticalWinStatus(int player) {
        int boardItemValue = player;
        for (int column = 0; column < board.length; column++) {
            boardItemValue = player;
            for (int[] row : board) {
                if (row[column] != player) {
                    boardItemValue = 0;
                    break;
                }
            }
            if (boardItemValue > 0) {
                return boardItemValue;
            }
        }
        return boardItemValue;
    }

    private Integer getHorizontalWinStatus(int player) {
        int boardItemValue = player;

        for (int[] row : board) {
            boardItemValue = player;
            for (int column : row) {
                if (column != player) {
                    boardItemValue = 0;
                }
            }
            if (boardItemValue > 0) {
                return boardItemValue;
            }
        }
        return boardItemValue;
    }

}
