package com.mosesmansaray.kata.playing_with_lights;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by moses.mansaray on 01/03/2016.
 */
public class PlayingWithLight {
  String[] rowData;

  public int[] getSwitchGrid() {
    return switchGrid;
  }

  int[] switchGrid;


  /**
   * initialise from raw string
   *
   * @param rawData representation of the grid and child's run
   */
  public PlayingWithLight(String rawData) {
    rowData = rawData.split("\n");
    switchGrid = new int[Integer.parseInt(rowData[0])];
    initializeAllSwitchesToOff(switchGrid);

  }


  /**
   * Initialize grid from file
   * @param filePath representation of the grid and child's run
   * @param fromPath
   */
  public PlayingWithLight(String filePath, boolean fromPath) {
    try {
      String path = getClass().getClassLoader().getResource(filePath).getPath();
      List<String> strings = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
      rowData = new String[strings.size()];
      rowData = strings.toArray(rowData); //TODO: List to Array!!! = this can be optimized
      switchGrid = new int[Integer.parseInt(rowData[0])];
      initializeAllSwitchesToOff(switchGrid);
    } catch (IOException e) {
      // log?throw?alternative
    }
  }

  //Alternatively use default int initialization of, taking -1 to toggle
  private void initializeAllSwitchesToOff(int[] switchGrid) {
    for (int i = 0; i < switchGrid.length; i++) {
      switchGrid[i] = -1;
    }
  }

  public void toggleRange(int startingPos, int endPos) {

    if (startingPos <= endPos) {
      int i = startingPos;
      while (i <= endPos) {
        switchGrid[i] = switchGrid[i] * -1;
        i++;
      }
    }else {
      int i = startingPos;
      while (i >= endPos) {
        switchGrid[i] = switchGrid[i] * -1;
        i--;
      }

    }
  }

  public void toggleRows() {
    for (int i = 1; i < rowData.length; i++) {
      String[] split = rowData[i].split(" ");
      toggleRange(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
  }

  public int getTotalNumberOfSwitchesOn() {
    int count = 0;
    for (int i = 0; i < switchGrid.length; i++) {
        if (switchGrid[i] == 1){
          count ++;
        }
    }
    return count;
  }
}
