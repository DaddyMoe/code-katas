package com.mosesmansaray.kata.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = 2;

    private static TicTacToeBoard ticTacToeBoard = new TicTacToeBoard(3, 3);
    private static TicTacToeWinDetector ticTacToeWinDetector = new TicTacToeWinDetector();

    private static int row;
    private static int col;

    public static void main(String[] args) throws IOException {
        int[][] board = ticTacToeBoard.getBoard();
        ticTacToeBoard.printBoard();
        readPlayerMove();
    }

    private static void readPlayerMove() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Play\n");
        String s = br.readLine();
        try {
            mapInput(s);
            ticTacToeBoard.playMove(1, row, col);

            int status = ticTacToeWinDetector.detectWinningPlayer(ticTacToeBoard, PLAYER_1);
            if (status > 0) {
                System.out.println("Player : " + status + " has won.\n");
                ticTacToeBoard.resetBoard();
            }
            aITurnToPlay();
        } catch (NumberFormatException nfe) {
            System.err.print(nfe);
        }
    }

    private static void aITurnToPlay() throws IOException {
        ticTacToeBoard.aiGenerateMovement(PLAYER_2);
        int status = ticTacToeWinDetector.detectWinningPlayer(ticTacToeBoard, PLAYER_2);
        if (status > 0) {
            System.out.println("######################################");
            System.out.println("## Player : " + status + " has won. ##");
            System.out.println("######################################\n\n");

            ticTacToeBoard.resetBoard();
        }
        readPlayerMove();
    }

    private static void mapInput(String s) throws NumberFormatException {
        String[] inputs = s.split(",");
        row = Integer.parseInt(inputs[0]);
        col = Integer.parseInt(inputs[1]);
    }

}
