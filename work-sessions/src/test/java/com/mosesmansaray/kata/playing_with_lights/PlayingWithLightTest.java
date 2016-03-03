package com.mosesmansaray.kata.playing_with_lights;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Source : https://www.reddit.com/r/dailyprogrammer/
 * comments/46zm8m/20160222_challenge_255_easy_playing_with_light
 *
 * @author moses.mansaray
 */
public class PlayingWithLightTest {
  String rawExample = "10\n" +
      "3 6\n" +
      "0 4\n" +
      "7 3\n" +
      "9 9";

  String challengeInput = "1000\n" +
      "616 293\n" +
      "344 942\n" +
      "27 524\n" +
      "716 291\n" +
      "860 284\n" +
      "74 928\n" +
      "970 594\n" +
      "832 772\n" +
      "343 301\n" +
      "194 882\n" +
      "948 912\n" +
      "533 654\n" +
      "242 792\n" +
      "408 34\n" +
      "162 249\n" +
      "852 693\n" +
      "526 365\n" +
      "869 303\n" +
      "7 992\n" +
      "200 487\n" +
      "961 885\n" +
      "678 828\n" +
      "441 152\n" +
      "394 453";

//  @Test
//  public void shouldReturnExpectSwitchGrid() {
//    PlayingWithLight playingWithLight = new PlayingWithLight(rawExample);
//    int[] switchGridBitset = playingWithLight.getSwitchGridBitset();
//    assertEquals(10, switchGridBitset.length);
//  }
//
//  @Test
//  public void shouldReturnExpectSwitchGrid_AllOff() {
//    PlayingWithLight playingWithLight = new PlayingWithLight(rawExample);
//    int[] switchGridBitset = playingWithLight.getSwitchGridBitset();
//    for (int i = 0; i < 10; i++) {
//      assertEquals(-1, switchGridBitset[i]);
//    }
//  }
//
//  @Test
//  public void shouldOnlySwitchOnExpectedRange() {
//    PlayingWithLight playingWithLight = new PlayingWithLight(rawExample);
//    playingWithLight.toggleRange(3, 6);
//    int[] switchGridBitset = playingWithLight.getSwitchGridBitset();
//
//    for (int i = 3; i <= 6; i++) {
//      assertEquals(1, switchGridBitset[i]);
//    }
//  }

//  // Manual toggle
//  @Test
//  public void shouldOnlySwitchOnExpectedRange_AndToggleIfSwitchAgain() {
//    PlayingWithLight playingWithLight = new PlayingWithLight(rawExample);
//    playingWithLight.toggleRange(3, 6);
//    playingWithLight.toggleRange(0, 4);
//
//    int[] switchGridBitset = playingWithLight.getSwitchGridBitset();
//
//    assertEquals(-1, switchGridBitset[3]);
//    assertEquals(-1, switchGridBitset[4]);
//    assertEquals(1, switchGridBitset[5]);
//    assertEquals(1, switchGridBitset[6]);
//  }
//
//  // auto toggle
//  @Test
//  public void shouldOnlySwitchOnExpectedRange_AndToggleThroughAllRows() {
//    PlayingWithLight playingWithLight = new PlayingWithLight(rawExample);
//    playingWithLight.toggleRows();
//    int[] switchGridBitset = playingWithLight.getSwitchGridBitset();
//
//    assertEquals(1, switchGridBitset[0]);
//    assertEquals(1, switchGridBitset[1]);
//    assertEquals(1, switchGridBitset[2]);
//    assertEquals(1, switchGridBitset[3]);
//    assertEquals(1, switchGridBitset[4]);
//    assertEquals(-1, switchGridBitset[5]);
//    assertEquals(-1, switchGridBitset[6]);
//    assertEquals(1, switchGridBitset[7]);
//    assertEquals(-1, switchGridBitset[8]);
//    assertEquals(1, switchGridBitset[9]);
//  }

  @Test
  public void shouldReturnTotalLeftSwitchedOn() {
    PlayingWithLight playingWithLight = new PlayingWithLight(rawExample);
    playingWithLight.toggleRows();
    int numberOfSwitchesOn = playingWithLight.getTotalNumberOfSwitchesOn();
    assertEquals(7, numberOfSwitchesOn);
  }

  @Test
  public void shouldReturnTotalLeftSwitchedOnForChallengeFile() {
    PlayingWithLight playingWithLight = new PlayingWithLight("lots_of_switches.txt", true);
    playingWithLight.toggleRows();
    int numberOfSwitchesOn = playingWithLight.getTotalNumberOfSwitchesOn();
    assertEquals(2500245, numberOfSwitchesOn);
  }


  @Test
  public void shouldReturnTotalLeftSwitchedOnForChallengeExample() {
    PlayingWithLight playingWithLight = new PlayingWithLight(challengeInput);
    playingWithLight.toggleRows();
    int numberOfSwitchesOn = playingWithLight.getTotalNumberOfSwitchesOn();
    assertEquals(423, numberOfSwitchesOn);
  }



}
