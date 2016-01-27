package com.mosesmansaray.kata.vhs_recording_problem;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Source:
 * www.reddit.com/r/dailyprogrammer/comments/3u6o56/20151118_challenge_242_intermediate_vhs_recording/
 *
 * @author moses.mansaray
 */
public class VHSRecorderScheduleTest {

  @Test
  public void shouldReturnScheduleListFromFile() {
    VHSRecorderSchedule schedule = new VHSRecorderSchedule("vhs_recording_problem/input01.text");
    assertEquals(4, schedule.getSchedule().size());
  }

  @Test
  public void shouldReturnStartTime(){
    VHSRecorderSchedule schedule = new VHSRecorderSchedule("vhs_recording_problem/input01.text");
    assertEquals(1555, schedule.getProgramme("1555 1645").getStart());
  }

  @Test
  public void shouldReturnEndTime(){
    VHSRecorderSchedule schedule = new VHSRecorderSchedule("vhs_recording_problem/input01.text");
    assertEquals(1645, schedule.getProgramme("1555 1645").getEnds());
  }

  @Test
  public void shouldReturnProgrammeList(){
    VHSRecorderSchedule schedule = new VHSRecorderSchedule("vhs_recording_problem/input01.text");
    assertEquals(4, schedule.getProgrammes().size());
  }

  @Test
  public void shouldReturnNonClashingList(){
    VHSRecorderSchedule schedule = new VHSRecorderSchedule("vhs_recording_problem/input01.text");
    assertEquals(3, schedule.getNonClashingSchedule().size());
  }

  @Test
  public void shouldReturnNonClashingListForSet1(){
    VHSRecorderSchedule schedule = new VHSRecorderSchedule("vhs_recording_problem/inputSet1.text");
    assertEquals(4, schedule.getNonClashingSchedule().size());
  }

  @Test
  public void shouldReturnNonClashingListForSet2(){
    VHSRecorderSchedule schedule = new VHSRecorderSchedule("vhs_recording_problem/inputSet2.text");
    assertEquals(3, schedule.getNonClashingSchedule().size());
  }

  @Test
  public void shouldReturnNonClashingListAndName(){
    VHSRecorderSchedule schedule = new VHSRecorderSchedule("vhs_recording_problem/bonus1");
    List<VHSRecorderSchedule.Programme> nonClashingSchedule = schedule.getNonClashingSchedule();
    assertEquals(3, nonClashingSchedule.size());
    assertEquals("Pokémon", nonClashingSchedule.get(0).getProgrammeName());
    assertEquals("Law & Order", nonClashingSchedule.get(1).getProgrammeName());
    assertEquals("The Fresh Prince of Bel-Air", nonClashingSchedule.get(2).getProgrammeName());
  }

  //TODO: Bonus 2
}
