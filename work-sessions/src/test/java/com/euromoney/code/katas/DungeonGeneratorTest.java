package com.euromoney.code.katas;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by moses.mansaray on 22/09/2015.
 */
public class DungeonGeneratorTest {

    String level1 =
            "##########\n" +
            "#   <   >#\n" +
            "##########";


    @Test
    public void shouldGenerateRoomWithExpectedSizes(){
        RoomGenerator roomGenerator = new RoomGenerator(3, 10);
        assertEquals(10, roomGenerator.getWidth());
        assertEquals(3, roomGenerator.getHeight());
    }

    @Test
    public void shouldGenerateRoomWithTopLayerAllHashes(){
        RoomGenerator roomGenerator = new RoomGenerator(3, 10);
        String room = roomGenerator.create();
        assertEquals("##########", room.split("\n")[0]);
    }

    @Test
    public void shouldGenerateRoomWithBottomLayerAllHashes(){
        RoomGenerator roomGenerator = new RoomGenerator(3, 10);
        String room = roomGenerator.create();
        assertEquals("##########", room.split("\n")[2]);
    }

    @Test
    public void shouldGenerateRoomWithMiddleLayer10Wide(){
        RoomGenerator roomGenerator = new RoomGenerator(3, 10);
        String room = roomGenerator.create();
        String roomValue = room.split("\n")[1];
        assertEquals(10, roomValue.length());
    }

    @Test
    public void shouldGenerateRoomWithUpStairsOnSecondRow(){
        RoomGenerator roomGenerator = new RoomGenerator(3, 10);
        String room = roomGenerator.create();
        assertTrue(room.split("\n")[1].contains("<"));
    }

    @Test
    public void shouldGenerateRoomWithDownStairsOnSecondRow(){
        RoomGenerator roomGenerator = new RoomGenerator(3, 10);
        String room = roomGenerator.create();
        assertTrue(room.split("\n")[1].contains(">"));
    }

    @Test
    public void shouldGenerateRoomWithOnlyTwoHashes(){
        RoomGenerator roomGenerator = new RoomGenerator(3, 10);
        String room = roomGenerator.create();
        int countOfHashes = 0;
        String line = room.split("\n")[1];

        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '#'){
                countOfHashes ++;
            }
        }

        assertEquals(2, countOfHashes);
    }

    @Test
    public void shouldGenerateRoomWithSixSpaces(){
        RoomGenerator roomGenerator = new RoomGenerator(3, 10);
        String room = roomGenerator.create();
        int countOfSpaces = 0;
        String line = room.split("\n")[1];

        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == ' '){
                countOfSpaces ++;
            }
        }

        assertEquals(6, countOfSpaces);
    }

    @Test
    public void subsequentCallsShouldGenerateDifferentRooms(){
        RoomGenerator roomGenerator = new RoomGenerator(3, 10);
        String room = roomGenerator.create();
        String room2 = roomGenerator.create();
        String room3 = roomGenerator.create();
        String room4 = roomGenerator.create();

        boolean areSame = room == room2 && room2 == room3 && room3 == room4;

        assertFalse(areSame);
    }

    @Test
    public void subsequentCallsShouldGenerateDifferentPositionsForDownStairs(){
        RoomGenerator roomGenerator = new RoomGenerator(3, 10);
        String room = roomGenerator.create();
        String room2 = roomGenerator.create();
        String room3 = roomGenerator.create();
        String room4 = roomGenerator.create();

        boolean areSame = room.indexOf('>') == room2.indexOf('>')
                && room2.indexOf('>') == room3.indexOf('>')
                && room3.indexOf('>') == room4.indexOf('>');

        assertFalse(areSame);
    }
//
//    @JsonValueFinder
//    public void shouldGenerateRoomWithDownStairsOnSecondRow(){
//        RoomGenerator roomGenerator = new RoomGenerator(3, 10);
//        String room = roomGenerator.create();
//        assertTrue(room.split("\n")[1].contains(">"));
//    }
}
