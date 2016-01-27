package com.mosesmansaray.kata.average_peed_cameras;

import com.mosesmansaray.kata.CustomFileReaderUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created on 27/01/2016.
 *
 * @author moses.mansaray
 */
public class AverageSpeedProcessor {

  private static final CustomFileReaderUtil FILE_READER_UTIL = new CustomFileReaderUtil();
  private static final Pattern PATTERN = Pattern.compile("(?:\\d*\\.)?\\d+");

  private double speedLimit;
  private String unit;
  private final List<Camera> cameras = new ArrayList<>();

  public AverageSpeedProcessor(String filePath) {
    List<String> listOfRows = FILE_READER_UTIL.getListOfRows(filePath);
    processFile(listOfRows);
  }

  private void processFile(List<String> listOfRows) {
    processSpeedLimit(listOfRows.get(0));
    processCameras(listOfRows);
  }

  private void processSpeedLimit(String firstRow) {
    Matcher matcher = PATTERN.matcher(firstRow);
    while (matcher.find()) {
      speedLimit = Double.parseDouble(matcher.group());
    }
    unit = firstRow.contains("mph") ? "mph" : "km/h";
  }

  private void processCameras(List<String> listOfRows) {
    List<String> cameraRows = listOfRows.stream().filter(row -> row.contains("Speed c")).collect(Collectors.toList());
    addCamerasToList(cameraRows);
  }

  private void addCamerasToList(List<String> cameraRows) {
    for (String cameraRow : cameraRows) {
      int number = 0, distance = 0;
      String cameraRowStripped= cameraRow.replace(" ","");
      String[] cameraRowCols = cameraRowStripped.split("is");

      Matcher matcher = PATTERN.matcher(cameraRowCols[0]);
      while (matcher.find()) number = Integer.parseInt(matcher.group());
      matcher = PATTERN.matcher(cameraRowCols[1]);
      while (matcher.find()) distance = Integer.parseInt(matcher.group());
      cameras.add(new Camera(number, distance));
    }
  }


  public double getSpeedLimit() {
    return speedLimit;
  }

  public List<Camera> getCameras() {
    return cameras;
  }

  public String getUnit() {
    return unit;
  }
}
