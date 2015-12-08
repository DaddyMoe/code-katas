package com.mosesmansaray.kata.fluentapi;

import static com.mosesmansaray.kata.fluentapi.CustomIs.*;

/**
 * Created by moses.mansaray on 27/10/2015.
 */
public class CustomAssert {

    public boolean that(String valueToTest, CustomIs customAssertTask) throws Exception {

        if (customAssertTask == null){
            throw new Exception("Assertion Empty");
        }

        if (customAssertTask.getIsType().equals(IsType.EQUAL_TO)){
            return valueToTest.equals(customAssertTask.getValue());
        }

        if (customAssertTask.getIsType().equals(IsType.NOT_EQUAL_TO)){
            return !valueToTest.equals(customAssertTask.getValue());
        }

        throw new Exception("Could not find IsType");
    }
}
