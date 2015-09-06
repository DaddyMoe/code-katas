package com.mosesmansaray.kata.data_munging;

import org.junit.Test;

/**
 * Created on 06/09/2015.
 *
 * @author moses.mansaray
 */
public class WeatherDataTest {
  String errorMsg;

  private static final String day4Line = "   4  77    59    68          51.1       0.00         110  9.1 130  12  8.6  62 40 1021.1\n";
  private final static String day9Line = "   9  86    32*   59       6  61.5       0.00         240  7.6 220  12  6.0  78 46 1018.6\n";

  @Test
  public void shouldReturnDaysWeatherDay(){
    errorMsg = "day number not as expected";

  }

  @Test
  public void shouldReturnDaysWeatherMaxTemperature(){
    errorMsg = "Max Temperature not as expected";

  }

  @Test
  public void shouldReturnDaysWeatherMinTemperature(){
    errorMsg = "Min Temperature not as expected";


  }

  @Test
  public void shouldReturnDaysWeatherTemperatureSpread(){
    errorMsg = "Day's Temperature spread not as expected";


  }

  @Test
  public void shouldReturnListOfWeatherDataFromGivenSourcePath(){
    errorMsg = "Did not return a List as expected";

  }

  @Test
  public void shouldReturnExpectedListOfWeatherDataFromGivenSourcePath(){
    errorMsg = "Size of returned list is not as expected";
    int expectedSizeOfList = 30;
  }

  @Test
  public void shouldReturnASortedListOfWeatherData(){
    errorMsg = "list is not sort as expected";
    //assertion e.g : expected day4 in index4, day6 in index9 and day11 in index29 etc

  }




}
