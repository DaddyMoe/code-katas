package com.mosesmansaray.kata.matchsticks;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by moses.mansaray on 12/01/2016.
 */
public class SantasList {

    String filepath;

    public SantasList(String input) {
        this.filepath = input;
    }

    public SantasList() {
    }


    public int getCharacterSafeInMemoryFromFile() {
        String schedule2 = null;
        String path = getClass().getClassLoader().getResource(filepath).getPath();
        try {
            byte[] allBytes = Files.readAllBytes((Paths.get(path)));
            schedule2 = new String(allBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getCharacterSafeInMemory(schedule2);
    }

    public int getCharacterSafeInMemory(String textToTest) {
        int fileCharacterCount = getFileCharacterCount(new String(textToTest));
        String characterInMem = new String(textToTest).replace("\n", "");
        int diff = characterInMem.length() - fileCharacterCount;
        return diff;
    }

    public int getFileCharacterCount(String textToTest) {
        String[] textFile = textToTest.split("\n");
        int count = 0;
        for (String s : textFile) {
            //TODO: Escape HEX characters before count
            count += getCharacterCount(s);
        }
        return count;
    }


    public int getCharacterCount(String lineToTest) {
        String replacedLine = lineToTest.replace("\\\"", "\\").replace("\\x27", "'").replace("\n", "");

        //TODO: Escape HEX characters before count
        return replacedLine.length() - 2;
    }


}
