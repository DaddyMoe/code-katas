package com.mosesmansaray.kata.fluentapi;

import com.mosesmansaray.kata.fluentapi.CustomAssert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Source : https://github.com/davidwhitney/CodeDojos/tree/master/BuildingFluentApis
 */
public class BuildingFluentApisTest {

    @Test
    public void testSetup(){
        assertFalse(false);
    }

    @Test(expected = Exception.class)
    public void shouldThrowException() throws Exception {
        CustomAssert customAssert = new CustomAssert();
        customAssert.that("", null);
    }

    @Test
    public void shouldNotThrowException() throws Exception {
        CustomAssert customAssert = new CustomAssert();
        customAssert.that("", CustomIs.equalTo("Hello"));
    }


    // Story 1 - Asserting equality
    @Test
    public void shouldReturnTrueForEquality() throws Exception {
        CustomAssert customAssert = new CustomAssert();
//        assertTrue(customAssert.that("Hello", CustomIs.equalTo("Hello")));
    }

    // Story 2 - Asserting inverse equality - Part One
    @Test
    public void shouldReturnTrueForInverse() throws Exception {
        CustomAssert customAssert = new CustomAssert();
        CustomIs inverseCustomIs = CustomIs.not();
        assertTrue(inverseCustomIs.isInverse());
    }

    // Story 2 - Asserting inverse equality - Part two
    @Test
    public void shouldReturnTrueForInverseEqualitye() throws Exception {
        CustomAssert customAssert = new CustomAssert();
        CustomIs customIs = CustomIs.not().equalTo("Hello");
        assertTrue(customAssert.that("Hellsdso", customIs));
    }
}
