package com.mosesmansaray.kata.data_munging.weather;

import com.mosesmansaray.kata.data_munging.processor.DataMungingProcessor;
import com.mosesmansaray.kata.data_munging.soccer.exception.SoccerLeagueDataMungingException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created on 06/09/2015.
 *
 * @author moses.mansaray
 */
public class WeatherDataProcessorTest {

  private String errorMsg;
  private final DataMungingProcessor dataMungingProcessor = new WeatherDataProcessor();


  private static final String day4Line = "   4  77    59    68          51.1       0.00         110  9.1 130  12  8.6  62 40 1021.1\n";
  private final static String day9Line = "   9  86    32*   59       6  61.5       0.00         240  7.6 220  12  6.0  78 46 1018.6\n";

  @Test
  public void shouldReturnDaysWeatherDay() throws SoccerLeagueDataMungingException {
    errorMsg = "day number not as expected";
    DaysWeather expectedDaysWeather = new DaysWeather(4, 77, 59);
    DaysWeather daysWeather = (DaysWeather) dataMungingProcessor.processDataInputRow(day4Line);

    assertEquals(errorMsg, expectedDaysWeather.getDay(), daysWeather.getDay());
  }

  @Test
  public void shouldReturnDaysWeatherMaxTemperature() throws SoccerLeagueDataMungingException {
    errorMsg = "Max Temperature not as expected";

    DaysWeather expectedDaysWeather = new DaysWeather(4, 77, 59);
    DaysWeather daysWeather = (DaysWeather) dataMungingProcessor.processDataInputRow(day4Line);

    assertEquals(errorMsg, expectedDaysWeather.getMaxTemperature(), daysWeather.getMaxTemperature());
  }

  @Test
  public void shouldReturnDaysWeatherMinTemperature() throws SoccerLeagueDataMungingException {
    errorMsg = "Min Temperature not as expected";
    DaysWeather expectedDaysWeather = new DaysWeather(4, 77, 59);
    DaysWeather daysWeather = (DaysWeather) dataMungingProcessor.processDataInputRow(day4Line);

    assertEquals(errorMsg, expectedDaysWeather.getMinTemperature(), daysWeather.getMinTemperature());
  }

  @Test
  public void shouldReturnDaysWeatherMinTemperatureWithoutSpecialCharacter() throws SoccerLeagueDataMungingException {
    errorMsg = "Max Temperature not as expected";

    DaysWeather expectedDaysWeather = new DaysWeather(9, 86, 32);
    DaysWeather daysWeather = (DaysWeather) dataMungingProcessor.processDataInputRow(day9Line);

    assertEquals(errorMsg, expectedDaysWeather.getMinTemperature(), daysWeather.getMinTemperature());
  }

  @Test
  public void shouldReturnDaysWeatherTemperatureSpread() throws SoccerLeagueDataMungingException {
    errorMsg = "Day's Temperature spread not as expected";

    int expectedDaysWeatherSpread = 54;
    DaysWeather daysWeather = (DaysWeather) dataMungingProcessor.processDataInputRow(day9Line);
    int daysWeatherSpread = ((WeatherDataProcessor) dataMungingProcessor).getDaysWeatherSpread(daysWeather);

    assertEquals(errorMsg, expectedDaysWeatherSpread, daysWeatherSpread);
  }

  @Test
  public void shouldReturnListOfWeatherDataFromGivenSourcePath() {
    errorMsg = "Did not return a List as expected";

    List monthsWeather = dataMungingProcessor.processDataInput("weather.dat");

    assertTrue(errorMsg, monthsWeather != null);
  }

  @Test
  public void shouldReturnExpectedListOfWeatherDataFromGivenSourcePath() {
    errorMsg = "Size of returned list is not as expected";
    int expectedSizeOfList = 30;

    List monthsWeather = dataMungingProcessor.processDataInput("weather.dat");

    assertEquals(errorMsg, expectedSizeOfList, monthsWeather.size());
  }

  @Test
  public void shouldReturnASortedListOfWeatherData() {
    errorMsg = "list is not sort as expected";
    //assertion e.g : expected day4 in index4, day6 in index9 and day11 in index29 etc
    List<DaysWeather> monthsWeather = dataMungingProcessor.processDataInput("weather.dat");

    for (int i = 0; i < monthsWeather.size()-1; i++) {
      int weatherSpread1 = monthsWeather.get(i).getWeatherSpread();
      int weatherSpread2 = monthsWeather.get(i + 1).getWeatherSpread();
      assertTrue(errorMsg, weatherSpread1 <= weatherSpread2);
      printData(monthsWeather);
    }
  }

  private void printData(List<DaysWeather> monthsWeather) {
    for (DaysWeather daysWeather : monthsWeather) {
      System.out.println("Day = " + daysWeather.getDay() + " Has a spread of " + daysWeather.getWeatherSpread());
    }
  }

}
