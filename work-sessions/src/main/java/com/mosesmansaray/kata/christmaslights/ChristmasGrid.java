package com.mosesmansaray.kata.christmaslights;

/**
 * Created by moses.mansaray on 15/12/2015.
 */
public class ChristmasGrid {

    private int height;
    private int width;
    private int[][] gridMatrix;

    public ChristmasGrid(int width, int height) {
        setWidth(width);
        setHeight(height);
        initializeGrid();
        
    }

    private void initializeGrid() {
        gridMatrix = new int[width][height];
        for (int x = 0; x < gridMatrix.length ; x++) {
            for (int y = 0; y < gridMatrix[x].length; y++) {
                gridMatrix[x][y]=0;
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean statusOf(int x, int y) {
        if (gridMatrix[x][y] == 1){
            return true;
        }
        return false;
    }

    public void activateCell(int x, int y) {
        gridMatrix[x][y] = 1;
    }
    public void deActivateCell(int x, int y) {
        gridMatrix[x][y] = 0;
    }

    public void activateRange(int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                activateCell(x,y);
            }
            
        }
    }

    public void deactivateRange(int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                deActivateCell(x,y);
            }
        }
    }
}
