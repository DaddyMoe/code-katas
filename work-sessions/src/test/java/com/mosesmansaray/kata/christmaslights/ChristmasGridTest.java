package com.mosesmansaray.kata.christmaslights;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * source : https://github.com/davidwhitney/
 * CodeDojos/tree/master/ChristmasLights
 */
public class ChristmasGridTest {

    @Test
    public void ShouldHaveDimensionsAsExpected(){
        ChristmasGrid grid = new ChristmasGrid(1000, 1000);
        assertEquals(1000, grid.getHeight());
        assertEquals(1000, grid.getWidth());
    }

    @Test
    public void OnEmptyGrid_CheckSingleCell_IsOff(){
        //Given
        ChristmasGrid grid = new ChristmasGrid(1000, 1000);
        //Then
        assertFalse(grid.statusOf(0,0));
    }

    @Test
    public void OnEmptyGrid_ActivatingSingleCell_IsOn(){
        //Given
        ChristmasGrid grid = new ChristmasGrid(1000, 1000);
        // When
        grid.activateCell(0,0);
        //Then
        assertTrue(grid.statusOf(0,0));
    }

    @Test
    public void OnEmptyGrid_ActivatingARow_allRowIsOn(){
        //Given
        ChristmasGrid grid = new ChristmasGrid(1000, 1000);
        // When
        grid.activateRange(0, 0, 999, 0);
        //Then
        for (int iC = 0; iC < 1000; iC++) {
            assertTrue(grid.statusOf(iC, 0));
        }
    }

    @Test
    public void OnEmptyGrid_ActivatingAllGrid_isAllOn(){
        //Given
        ChristmasGrid grid = new ChristmasGrid(1000, 1000);
        // When
        grid.activateRange(0, 0, 999, 999);
        //Then
        for (int iR = 0; iR < 1000; iR++) {
            for (int iC = 0; iC < 1000; iC++) {
                assertTrue(grid.statusOf(iR, iC));
            }
        }
    }

    @Test
    public void OnGridAllOn_SwitchingOffAllGrid_isAllOff(){
        //Given
        ChristmasGrid grid = new ChristmasGrid(1000, 1000);
        grid.activateRange(0, 0, 999, 999);
        // When
        grid.deactivateRange(0, 0, 999, 999);
        //Then
        for (int iR = 0; iR < 1000; iR++) {
            for (int iC = 0; iC < 1000; iC++) {
                assertFalse(grid.statusOf(iR, iC));
            }
        }
    }

}
