package com.mosesmansaray.kata.kata_trading_card_game;

import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by moses.mansaray on 08/03/2016.
 */
public class TradingCardGameText {


  private Player[] players;

  public TradingCardGameText ini() {
    int[] defaultStartingManasArray = new int[]{0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8};
    List<Integer> defaultStartingManas = new ArrayList(Arrays.asList(defaultStartingManasArray));
    Collections.shuffle(defaultStartingManas);

    players = new Player[2];
    players[0] = new Player();
    players[1] = new Player();

    for (Player player : players) {
      player.setManaSlots(0);
      player.setHealth(30);
      player.setDamageCards(defaultStartingManas);
      player.setHand();
    }
    return this;
  }

  public Player[] getPlayers() {
    return players;
  }
}
