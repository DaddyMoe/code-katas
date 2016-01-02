package com.mosesmansaray.kata.vhs_recording_problem;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 01/01/2016.
 *
 * @author moses.mansaray
 */
public class VHSRecorderSchedule {

  private List<String> schedule;

  public VHSRecorderSchedule(String scheduleFilePath) {
    try {
      String path = getClass().getClassLoader().getResource(scheduleFilePath).getPath();
      schedule = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
    } catch (IOException e) {
      //log error and instantiate empty
      schedule = new ArrayList<>();
    }
  }

  public List<String> getSchedule() {
    return schedule;
  }

  public Programme getProgramme(String programmeLine) {
    List<String> programmeDetails = Arrays.asList(programmeLine.split(" "));
    int start = Integer.parseInt(programmeDetails.get(0));
    int end = Integer.parseInt(programmeDetails.get(1));
    String programmeName = "";
    if (programmeDetails.size() >2){
      StringBuilder builder = new StringBuilder();
      for (int i = 2; i < programmeDetails.size(); i++) {
        builder.append(programmeDetails.get(i) + " ");
      }
      programmeName = builder.toString().trim();
    }
    return new Programme(start, end, programmeName);
  }

  public List<Programme> getProgrammes() {
    List<Programme> programmes = new ArrayList<>();
    for (String s : schedule) {
      programmes.add(getProgramme(s));
    }
    return programmes;
  }

  public List<Programme> getNonClashingSchedule() {
    List<Programme> nonClashingProgrammes = new ArrayList<>();
    List<Programme> programmes = getProgrammes();
    int lastAdded = 0;
    for (int i = 0; i < programmes.size(); i++) {
      //adds first programme regardless?
      if (i == 0) {
        nonClashingProgrammes.add(programmes.get(0));
        lastAdded = 0;
        continue;
      }
      //if end time of previous program is less or equals to the next programme
      int fixer = 1;
      if (programmes.get(lastAdded).getEnds() <= programmes.get(i).getStart()) {
        nonClashingProgrammes.add(programmes.get(i));
        lastAdded = i;
      }
    }
    return nonClashingProgrammes;
  }

  public class Programme {
    int start;
    int ends;
    private String programmeName;

    public Programme(int start, int end, String programmeName) {
      this.ends = end;
      this.start = start;
      this.programmeName = programmeName;
    }

    public int getStart() {
      return start;
    }

    public int getEnds() {
      return ends;
    }

    public String getProgrammeName() {
      return programmeName;
    }

    public void setProgrammeName(String programmeName) {
      this.programmeName = programmeName;
    }
  }

}
