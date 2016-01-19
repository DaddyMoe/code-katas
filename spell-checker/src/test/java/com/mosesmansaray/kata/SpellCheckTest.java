package com.mosesmansaray.kata;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class SpellCheckTest{


  @Test
  public void shouldReturnWordsAsIsForAGoodSpelling() {
    SpellCheck spellCheck = new SpellCheck("src/test/resources/enable1.txt");
    assertEquals("something", spellCheck.wordSpellingCheck("something"));
  }

  @Test
  public void shouldReturnWordWithPointerForBadSpelling() {
    SpellCheck spellCheck = new SpellCheck("src/test/resources/enable1.txt");

    assertEquals("someX<thing", spellCheck.wordSpellingCheck("someXthing"));
    assertEquals("accomo<date", spellCheck.wordSpellingCheck("accomodate"));
    assertEquals("acknowleg<ement", spellCheck.wordSpellingCheck("acknowlegement"));
    assertEquals("arguem<int", spellCheck.wordSpellingCheck("arguemint"));

    assertEquals("comitm<ment", spellCheck.wordSpellingCheck("comitmment"));
    assertEquals("deducta<bel", spellCheck.wordSpellingCheck("deductabel"));

    assertEquals("depin<dant", spellCheck.wordSpellingCheck("depindant"));
    assertEquals("exista<nse", spellCheck.wordSpellingCheck("existanse"));
    assertEquals("forword<e", spellCheck.wordSpellingCheck("forworde"));
    assertEquals("herra<ss", spellCheck.wordSpellingCheck("herrass"));

    assertEquals("inadva<rtent", spellCheck.wordSpellingCheck("inadvartent"));
    assertEquals("judgema<nt", spellCheck.wordSpellingCheck("judgemant"));
    assertEquals("ocur<rance", spellCheck.wordSpellingCheck("ocurrance"));
    assertEquals("parog<ative", spellCheck.wordSpellingCheck("parogative"));
    assertEquals("supa<rseed", spellCheck.wordSpellingCheck("suparseed"));
  }


}
