package com.mosesmansaray.kata.data_munging.weather;

import com.mosesmansaray.kata.data_munging.processor.DataMungingProcessor;
import com.mosesmansaray.kata.data_munging.reader.DataMungingFileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 06/09/2015.
 *
 * @author moses.mansaray
 */
public class WeatherDataProcessor implements DataMungingProcessor{

  private DataMungingFileReader fileReader = new DataMungingFileReader();

  public DaysWeather processDataInputRow(String day4Line) {
    day4Line = day4Line.replaceAll("\\*", "");
    String[] daysWeatherArray = day4Line.trim().split("\\s+"); //Trim and Split by one or more spaces

    int day = Integer.parseInt(daysWeatherArray[0]);
    int maxTemp = Integer.parseInt(daysWeatherArray[1]);
    int minTemp = Integer.parseInt(daysWeatherArray[2]);

    DaysWeather daysWeather = new DaysWeather(day, maxTemp, minTemp);
    int weatherSpread = getDaysWeatherSpread(daysWeather);
    daysWeather.setWeatherSpread(weatherSpread);

    return daysWeather;
  }

  public int getDaysWeatherSpread(DaysWeather daysWeather) {
    return daysWeather.getMaxTemperature() - daysWeather.getMinTemperature();
  }

  public List<DaysWeather> processDataInput(String sourcePathOfData) {
    List<DaysWeather> monthsWeather = new ArrayList<>();
    DaysWeather daysWeather;

    try {
      BufferedReader reader = fileReader.getBufferedReader(sourcePathOfData);
      String line;
      int lineNumber = 0;

      while ((line = reader.readLine()) != null) {
        if (lineNumber >= 2 && lineNumber < 32) {
          daysWeather = processDataInputRow(line);
          monthsWeather.add(daysWeather);
        }
        lineNumber++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    Collections.sort(monthsWeather);
    return monthsWeather;
  }

}
