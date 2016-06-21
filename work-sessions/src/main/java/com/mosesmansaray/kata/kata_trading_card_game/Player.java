package com.mosesmansaray.kata.kata_trading_card_game;

import java.util.List;

public class Player {
  private int health;
  private int manaSlots;
  private List<Integer> damageCards;
  private int[] hand;

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getManaSlots() {
    return manaSlots;

  }

  public void setManaSlots(int manaSlots) {
    this.manaSlots = manaSlots;
  }

  public void setDamageCards(List<Integer> damageCards) {
    this.damageCards = damageCards;
  }

  public List<Integer> getDamageCards() {
    return damageCards;
  }

  public int[] getHand() {
    return hand;
  }

  public void setHand() {

  }
}
