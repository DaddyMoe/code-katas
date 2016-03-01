package com.mosesmansaray.kata.playing_with_lights;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * Created by moses.mansaray on 01/03/2016.
 */
public class PlayingWithLight {
  String[] rows;
  int sizeOfRows;
  boolean[] switchGrid;
  ;

  public static void main(String[] args){
    final long startTime = System.nanoTime();
    PlayingWithLight playingWithLight = new PlayingWithLight("lots_of_switches.txt", true);
    playingWithLight.toggleRows();
    System.out.println(playingWithLight.getTotalNumberOfSwitchesOn());
    System.out.println("Took: " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime) );
  }

  public boolean[] getSwitchGrid() {
    return switchGrid;
  }

  /**
   * initialise from raw string
   *
   * @param rawData representation of the grid and child's run
   */
  public PlayingWithLight(String rawData) {
    rows = rawData.split("\n");
    sizeOfRows = rows.length;
    switchGrid = new boolean[sizeOfRows];
  }


  /**
   * Initialize grid from file
   * @param filePath representation of the grid and child's run
   * @param fromPath
   */
  public PlayingWithLight(String filePath, boolean fromPath) {
    try {
      String path = getClass().getClassLoader().getResource(filePath).getPath();
      byte[] encoded = Files.readAllBytes(Paths.get(path));
      rows = new String(encoded).split("\n");
      sizeOfRows = rows.length;
      switchGrid = new boolean[Integer.parseInt(rows[0])];
    } catch (IOException e) {
    }
  }

  public void toggleRange(int startingPos, int endPos) {
    if (startingPos <= endPos) {
      int i = startingPos;
      while (i <= endPos) {
        switchGrid[i] = switchGrid[i];
        i++;
      }
    } else {
      int i = startingPos;
      while (i >= endPos) {
        switchGrid[i] = !switchGrid[i];
        i--;
      }

    }
  }

  public void toggleRows() {
//    System.out.println("start of toggle: ");
//    startTime = System.nanoTime();
    for (int i = 1; i < sizeOfRows; i++) {
      String[] split = rows[i].split(" ");
      toggleRange(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
//    System.out.println("end of toggle: " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime) );
  }

  public int getTotalNumberOfSwitchesOn() {
//    System.out.println("Start of count: ");
//    startTime = System.nanoTime();
    int count = 0;
    for (int i = 0; i < switchGrid.length; i++) {
        if (switchGrid[i]){
          count ++;
        }
    }
//    TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
//    System.out.println("end of count: " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));
    return count;
  }
}
