package com.mosesmansaray.kata.tictactoe;

public class TicTacToeBoard {

    private static final int PLAYED = 8;

    int[][] board;

    public TicTacToeBoard(int row, int col) {
        board = new int[row][col];
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean isAvailable(int row, int col) {
        if (board[row][col] == 0) {
            return true;
        }
        return false;
    }

    public boolean playMove(int player, int row, int col) {

        if (!isAvailable(row, col)) {
            return false;
        }
        board[row][col] = player;
        System.out.println("Player : " + player + " your move was successful : Next Player\n");
        printBoard();
        return true;
    }

    public void hackBoard(int[][] boardArray) {
        board = boardArray;
    }

    public int[] aiGenerateMovement(int player) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (playMove(player, row, col)) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[0];
    }


    public void printBoard() {
        for (int[] rows : board) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int anInt : rows) {
                stringBuilder.append(anInt + " ");
            }
            System.out.println("| " + stringBuilder.toString() + "|");
        }

    }

    public void resetBoard(){
        System.out.println("######################################");
        System.out.println("######## Resetting Board :############");
        System.out.println("######################################");

        for (int[] row : board) {
            for (int i = 0; i < row.length; i++) {
                row[i] =0;
            }
        }
        printBoard();
    }

}
