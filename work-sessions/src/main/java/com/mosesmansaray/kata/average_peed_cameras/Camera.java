package com.mosesmansaray.kata.average_peed_cameras;

/**
 * Created on 27/01/2016.
 *
 * @author moses.mansaray
 */
public class Camera {
  private int number;
  private int meters;

  public Camera(int number, int meters) {
    this.number = number;
    this.meters = meters;
  }

  public int getNumber() {
    return number;
  }

  public int getMeters() {
    return meters;
  }
}
