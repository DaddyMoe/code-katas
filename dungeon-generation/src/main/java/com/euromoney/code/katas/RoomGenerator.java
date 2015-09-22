package com.euromoney.code.katas;

import java.util.Random;

/**
 * Created by moses.mansaray on 22/09/2015.
 */
public class RoomGenerator {
    public int width;
    public int height;

    public RoomGenerator(int height, int width) {
        this.width = width;
        this.height =height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String create() {

        String top = "##########\n";
        String bottom = "##########";
        String middle = "#    >   #";

        Random random = new Random();
        int randomPosition = random.nextInt(7 - 1 + 1) + 1;
        StringBuilder stringBuilder = new StringBuilder(middle);
        stringBuilder.setCharAt(randomPosition, '<');


        return top +
                stringBuilder.toString() + "\n" +
                bottom;
    }
}
