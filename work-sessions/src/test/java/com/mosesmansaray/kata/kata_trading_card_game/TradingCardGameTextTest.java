package com.mosesmansaray.kata.kata_trading_card_game;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TradingCardGameTextTest {
  int[] defaultStartingManas = new int[]{0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8};


  /**
   * Each player starts the game with 30 Health and 0 Mana slots.
   *
   * @throws Exception
   */
  @Test
  public void eachPlayerShouldStartsTheGame_WithThirtyHealthandZeroManaslots() throws Exception {

    TradingCardGameText tradingCardGameText = new TradingCardGameText().ini();
    Player[] players = tradingCardGameText.getPlayers();

    for (Player player : players) {
      assertEquals(30, player.getHealth());
      assertEquals(0, player.getManaSlots());
    }

  }


  /**
   * Each player starts with a deck of 20 Damage cards with the following
   * Mana costs: 0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8
   *
   * @throws Exception
   */
  @Test
  public void eachPlayerShould_StartWithTwentyDamageCards() throws Exception {

    TradingCardGameText tradingCardGameText = new TradingCardGameText().ini();
    Player[] players = tradingCardGameText.getPlayers();

    for (Player player : players) {
      List<Integer> damageCards = player.getDamageCards();
//      assertTrue(defaultStartingManas.length);
    }

  }


    /**
     * From the deck each player receives 3 random cards has his initial hand.
     */
   // @Test
    public void eachShould_StartWithThreeRandomCardsAsInitialHand ()throws Exception {

      TradingCardGameText tradingCardGameText = new TradingCardGameText().ini();
      Player[] players = tradingCardGameText.getPlayers();

      for (Player player : players) {
        int[] damageCards = player.getHand();
        assertTrue(Arrays.equals(defaultStartingManas, (damageCards)));
      }

    }

}
