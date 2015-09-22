package com.mosesmansaray.kata;


public class MayFlyProcreation {

    private MayFly mayFly;

    public MayFlyProcreation(MayFly mayFly) {
        this.mayFly = mayFly;
    }

    public boolean findMate() {
        mayFly.mateFound = true;
        if(mayFly.mateFound){
            mayFly.procreate();
        }
        return false;
    }




}
