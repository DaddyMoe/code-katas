package com.mosesmansaray.kata.games.sokoban;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by moses.mansaray on 05/04/2016.
 */
public class SokobanPlatformTest {


  @Test
  public void shouldSetUpGridBasedOnInputs() throws Exception {

    SokobanPlatform sokobanPlatform = new SokobanPlatform(exampleGridDemo01);
    char[][] grid = sokobanPlatform.getGrid();

    assertThat("wrong col size", 3, is(grid.length));
    assertThat("wrong row size", 5, is(grid[0].length));
    assertThat("wrong man pos", '@', is(grid[1][3]));
    assertThat("wrong crate pos", 'o', is(grid[1][2]));
    assertThat("wrong storage pos", '.', is(grid[1][1]));

  }


  String exampleGridDemo01 =
      "#####\n" +
      "#.o@#\n" +
      "#####";

  @Test
  public void shouldAllowForValidMove() throws Exception {
    SokobanPlatform sokobanPlatform = new SokobanPlatform(exampleGridDemo01);

    boolean successful = sokobanPlatform.moveLeft();
    char[][] grid = sokobanPlatform.getGrid();

    assertThat("move was successful", successful, is(true));

    assertThat("wrong col size", 3, is(grid.length));
    assertThat("wrong row size", 5, is(grid[0].length));
    assertThat("wrong space pos", ' ', is(grid[1][3]));
    assertThat("wrong man pos", '@', is(grid[1][2]));
    assertThat("wrong crate as storage pos", '*', is(grid[1][1]));


  }

  @Test
  public void shouldDisAllowForInValidMoveOntoCrate() throws Exception {

    String exampleGridDemo01 =
        "#####\n" +
        "#oo@#\n" +
        "#####";

    SokobanPlatform sokobanPlatform = new SokobanPlatform(exampleGridDemo01);

    boolean successful = sokobanPlatform.moveLeft();
    char[][] grid = sokobanPlatform.getGrid();

    assertThat("move was successful", successful, is(false));

    assertThat("wrong col size", 3, is(grid.length));
    assertThat("wrong row size", 5, is(grid[0].length));
    assertThat("wrong crate as storage pos", 'o', is(grid[1][1]));
    assertThat("wrong man pos", 'o', is(grid[1][2]));
    assertThat("wrong space pos", '@', is(grid[1][3]));

  }

  @Test
  public void shouldDisAllowForInValidMoveOntoWall() throws Exception {

    String exampleGridDemo01 =
        "#####\n" +
        "#@  #\n" +
        "#####";

    SokobanPlatform sokobanPlatform = new SokobanPlatform(exampleGridDemo01);

    boolean successful = sokobanPlatform.moveLeft();
    char[][] grid = sokobanPlatform.getGrid();

    assertThat("move was successful", successful, is(false));

    assertThat("wrong col size", 3, is(grid.length));
    assertThat("wrong row size", 5, is(grid[0].length));
    assertThat("wrong crate as storage pos", '@', is(grid[1][1]));
    assertThat("wrong man pos", ' ', is(grid[1][2]));
    assertThat("wrong space pos", ' ', is(grid[1][3]));

  }

  @Test
  public void shouldAllowForInValidMoveToTheRight() throws Exception {
    String exampleGridDemo01 =
        "#####\n" +
        "#@o.#\n" +
        "#####";


    SokobanPlatform sokobanPlatform = new SokobanPlatform(exampleGridDemo01);

    boolean successful = sokobanPlatform.moveRight();
    char[][] grid = sokobanPlatform.getGrid();

    assertThat("move was successful", successful, is(true));

    assertThat("wrong col size", 3, is(grid.length));
    assertThat("wrong row size", 5, is(grid[0].length));
    assertThat("wrong crate as storage pos", ' ', is(grid[1][1]));
    assertThat("wrong man pos", '@', is(grid[1][2]));
    assertThat("wrong space pos", '*', is(grid[1][3]));

  }

}
