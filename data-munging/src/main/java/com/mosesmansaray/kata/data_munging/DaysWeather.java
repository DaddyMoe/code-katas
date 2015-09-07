package com.mosesmansaray.kata.data_munging;

/**
 * Created on 06/09/2015.
 *
 * @author moses.mansaray
 */
public class DaysWeather implements Comparable<DaysWeather>{

  private final int day;
  private final int maxTemperature;
  private final int minTemperature;
  private int weatherSpread;

  public DaysWeather(int day, int maxTemperature, int minTemperature) {
    this.day = day;
    this.maxTemperature = maxTemperature;
    this.minTemperature = minTemperature;
  }

  public int getDay() {
    return day;
  }

  public int getMaxTemperature() {
    return maxTemperature;
  }

  public int getMinTemperature() {
    return minTemperature;
  }

  public void setWeatherSpread(int weatherSpread) {
    this.weatherSpread = weatherSpread;
  }

  public int getWeatherSpread() {
    return weatherSpread;
  }

  @Override
  public int compareTo(DaysWeather daysWeather) {
    int compareWeatherSpread = daysWeather.getWeatherSpread();
    return this.getWeatherSpread() - compareWeatherSpread;
  }

}
