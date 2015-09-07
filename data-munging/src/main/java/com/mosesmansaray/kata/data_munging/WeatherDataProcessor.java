package com.mosesmansaray.kata.data_munging;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 06/09/2015.
 *
 * @author moses.mansaray
 */
public class WeatherDataProcessor {

  public DaysWeather buildWeatherDay(String day4Line) {
    day4Line = day4Line.replaceAll("\\*", "");
    String[] daysWeatherArray = day4Line.trim().split("\\s+");

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

  public List<DaysWeather> getWeatherFromSource(String sourcePathOfData) {
    List<DaysWeather> monthsWeather = new ArrayList<>();

    Path resourcePath = getResourcePath(sourcePathOfData);

    try (BufferedReader reader = new BufferedReader(new FileReader(resourcePath.toString()))) {
      String line;
      int lineNumber = 0;
      while ((line = reader.readLine()) != null) {
        if (lineNumber >= 2 && lineNumber < 32) {
          DaysWeather daysWeather = buildWeatherDay(line);
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

  private Path getResourcePath(String sourcePathOfData) {
    Path resourcePath = null;
    URL resourceUrl = this.getClass().getResource("/" + sourcePathOfData);
    try {
      resourcePath = Paths.get(resourceUrl.toURI());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    return resourcePath;
  }
}
