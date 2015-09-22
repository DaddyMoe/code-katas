package com.mosesmansaray.kata;

public class MayFly implements Runnable{

    public boolean mateFound;

    public boolean isMateFound() {
        return mateFound;
    }

    public void setMateFound(boolean mateFound) {
        this.mateFound = mateFound;
    }

    public boolean findMate() {
        mateFound = true;
        if(mateFound){
            procreate();
        }
        return false;
    }


    public void procreate() {

    }


    @Override
    public void run() {

    }
}
