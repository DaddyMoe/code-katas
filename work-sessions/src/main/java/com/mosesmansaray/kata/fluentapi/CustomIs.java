package com.mosesmansaray.kata.fluentapi;

/**
 * Created by moses.mansaray on 27/10/2015.
 */
public class CustomIs {

    private static IsType isType;
    private static String value;
    private static boolean isInverse;

    public CustomIs(boolean inverse) {
        this.isInverse = inverse;
    }

    public static CustomIs not() {
        return new CustomIs(true);
    }

    public enum IsType {EQUAL_TO, NOT_EQUAL_TO};


    private CustomIs(IsType isType, String value) {
        this.isType = isType;
        this.value = value;
    }

    private CustomIs(String isType, String value) {
        this.isType = IsType.EQUAL_TO;
        this.value = value;
    }

    public static CustomIs equalTo(String valueToAssert) {
        if(isInverse){
            setIsType(IsType.NOT_EQUAL_TO);
            setValue(valueToAssert);
            CustomIs notEqualTo = new CustomIs(IsType.NOT_EQUAL_TO, valueToAssert);
            notEqualTo.setIsInverse(isInverse);
            return notEqualTo;
        }
        return new CustomIs("equalTo", valueToAssert);
    }


    public IsType getIsType() {

        return isType;
    }

    public static void setIsType(IsType isType) {
        CustomIs.isType = isType;
    }

    public String getValue() {
        return value;
    }

    public static void setValue(String value) {
        CustomIs.value = value;
    }

    public boolean isInverse() {
        return isInverse;
    }

    public void setIsInverse(boolean isInverse) {
        this.isInverse = isInverse;
    }
}
