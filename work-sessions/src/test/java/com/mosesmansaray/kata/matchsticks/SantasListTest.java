package com.mosesmansaray.kata.matchsticks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by moses.mansaray on 12/01/2016.
 */
public class SantasListTest {

    public static final String TEXT_TO_TEST = "\"\"" + "\n" +
            "\"abc\"" + "\n" +
            "\"aaa\\\"aaa\"" + "\n" +
            "\"\\x27\"";

    @Test
    public void shouldIgnoreQuotesForCharacterCount(){
        String lineToTest = "\"\"";
        SantasList santasList = new SantasList();
        int characterCount = santasList.getCharacterCount(lineToTest);
        assertEquals(0, characterCount);
    }

    @Test
    public void shouldIgnoreQuotesButCountContentForCharacterCount(){
        String lineToTest = "\"abc\"";
        SantasList santasList = new SantasList();
        int characterCount = santasList.getCharacterCount(lineToTest);
        assertEquals(3, characterCount);
    }

    @Test
    public void shouldIgnoreEscapeCharactersForCharacterCount(){
        String lineToTest = "\"aaa\\\"aaa\"";
        SantasList santasList = new SantasList();
        int characterCount = santasList.getCharacterCount(lineToTest);
        assertEquals(7, characterCount);
    }

    @Test
    public void shouldDetectEncodedCharactersForCharacterCount(){
        String lineToTest = "\"\\x27\"";
        SantasList santasList = new SantasList();
        int characterCount = santasList.getCharacterCount(lineToTest);
        assertEquals(1, characterCount);
    }

    @Test
    public void shouldDetectCorrectNumCharsInMemomryOnFull4Lines() {
        SantasList santasList = new SantasList();
        int characterCount = santasList.getFileCharacterCount(TEXT_TO_TEST);
        assertEquals(11, characterCount);
    }

    @Test
    public void shouldDetectCorrectNumCharsSavedInMemoryOnFull4Lines() {
        SantasList santasList = new SantasList();
        int safeInMemoryCount = santasList.getCharacterSafeInMemory(TEXT_TO_TEST);
//        assertEquals(12, safeInMemoryCount);
    }

    //TODO: complete loading via file.... should be no diff
    @Test
    public void shouldReturnCharacterDifferenceFromFileInput(){
        SantasList santasList = new SantasList("input.txt");
        int totalCountDiff = santasList.getCharacterSafeInMemoryFromFile();
        assertTrue(totalCountDiff >0);
    }


}
