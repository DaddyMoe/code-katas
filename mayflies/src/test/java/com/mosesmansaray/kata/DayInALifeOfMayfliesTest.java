package com.mosesmansaray.kata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DayInALifeOfMayfliesTest {

//    @Mock
//    MayFly mayFlyMock;

    MayFly mayFlyMock = mock(MayFly.class);

    @Test
    public void shouldReturnReturnAMayfly(){
        MayFly mayFly = new MayFly();
        assertTrue(mayFly != null);
    }

    @Test
    public void shouldReturnFindAMate(){
        MayFly mayFly = new MayFly();
        boolean mateFound = mayFly.findMate();
        assertTrue(mateFound);
    }

    @Test
    public void shouldCallProcreateIfMateFound(){
        MayFlyProcreation mayFlyProcreation = new MayFlyProcreation(mayFlyMock);
        mayFlyMock.findMate();
//        mayFlyMock.procreate();
        verify(mayFlyMock, times(1)).procreate();
    }


    @Test
    public void shouldProcreateIfMateFound(){
        MayFlyProcreation mayFlyProcreation = new MayFlyProcreation(mayFlyMock);
        mayFlyProcreation.findMate();
//        mayFlyMock.procreate();
//        assertTrue(mayFlyProcreation.procreate());
    }


}
