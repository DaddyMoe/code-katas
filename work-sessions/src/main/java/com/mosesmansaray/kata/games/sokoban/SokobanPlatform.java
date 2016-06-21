package com.mosesmansaray.kata.games.sokoban;

public class SokobanPlatform {

  private char[][] grid;

  public SokobanPlatform(String exampleGridDemo01) {
    setGrid(exampleGridDemo01);
  }

  public char[][] getGrid() {
    return grid;
  }

  public void setGrid(String gridData) {

    String[] rows = gridData.split("\n");

    char[] chars = gridData.toCharArray();

    grid = new char[rows.length][rows[0].length()];

    for (int i = 0; i < rows.length; i++) {
      grid[i] = rows[i].toCharArray();
    }
  }

  public boolean moveLeft() {
    //is move valid

    int[] manRowPos = new int[2];
    extractManPosition(manRowPos);

    char positionToLeft = grid[manRowPos[0]][manRowPos[1] - 1];

    if (positionToLeft == ' ' || positionToLeft == '.') {
      return moveMan(manRowPos[0], manRowPos[1]);
    }

    if (positionToLeft == 'o') {
      return moveCrateAndMan(grid[manRowPos[0]], manRowPos[1], false);
    }

    return false;

  }

  public boolean moveRight() {
    int[] manRowPos = new int[2];
    extractManPosition(manRowPos);

    char positionToRight = grid[manRowPos[0]][manRowPos[1] + 1];

    if (positionToRight == ' ' || positionToRight == '.') {
      return moveMan(manRowPos[0], manRowPos[1]);
    }

    if (positionToRight == 'o') {
      return moveCrateAndMan(grid[manRowPos[0]], manRowPos[1], true);
    }

    return false;

  }

  private void extractManPosition(int[] manRowPos) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '@') {
          manRowPos[0] = i;
          manRowPos[1] = j;
        }
      }
    }
  }

  private boolean moveMan(int manRowPos, int manColPos) {
    grid[manRowPos][manColPos - 1] = '@';
    grid[manRowPos][manColPos] = ' ';
    return true;
  }

  private boolean moveCrateAndMan(char[] chars, int manColPos, boolean isMovingRight) {

    char postionToLeftOfCrate;
    int moveBy1;
    int moveBy2;

      if (isMovingRight){
        moveBy1 = +1;
        moveBy2 = +2;
      }else{
        moveBy1 = -1;
        moveBy2 = -2;
      }


    try {
      postionToLeftOfCrate = chars[manColPos + moveBy2];
    } catch (Exception e) {
      return false;
    }


    if (postionToLeftOfCrate == ' ') {
      chars[manColPos + moveBy1] = '@';
      chars[manColPos] = ' ';
      chars[manColPos + moveBy2] = 'o';
      return true;
    }

    if (postionToLeftOfCrate == '.') {
      chars[manColPos + moveBy1] = '@';
      chars[manColPos] = ' ';
      chars[manColPos + moveBy2] = '*';
      return true;
    }

    return false;

  }


}
