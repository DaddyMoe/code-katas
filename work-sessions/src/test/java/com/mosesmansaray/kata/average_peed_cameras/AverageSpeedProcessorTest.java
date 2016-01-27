package com.mosesmansaray.kata.average_peed_cameras;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Source : https://www.reddit.com/r/dailyprogrammer/comments/
 * 2hcwzn/09242014_challenge_181_intermediate_average_speed/
 * Created on 27/01/2016.
 *
 * @author moses.mansaray
 */
public class AverageSpeedProcessorTest {


  @Test
  public void shouldReturnSpeedLimitForSampleData(){
    AverageSpeedProcessor processor = new AverageSpeedProcessor("camera_test_sample.log");
    double resultSpeed = processor.getSpeedLimit();
    assertEquals("speed limit is not as expected", 60.00, resultSpeed, 0);
  }

  @Test
  public void shouldReturnListOfCameras(){
    AverageSpeedProcessor processor = new AverageSpeedProcessor("camera_test_sample.log");
    List<Camera> cameras = processor.getCameras();
    assertEquals("number of cameras not as expected", 4, cameras.size(), 0);
  }


  @Test
  public void shouldReturnListOfCamerasWithExpectMetrics(){
    AverageSpeedProcessor processor = new AverageSpeedProcessor("camera_test_sample.log");
    List<Camera> cameras = processor.getCameras();
    assertEquals("camera number not as expected", 1, cameras.get(0).getNumber());
    assertEquals("camera distance not as expected", 0, cameras.get(0).getMeters());

    assertEquals("camera number not as expected", 2, cameras.get(1).getNumber());
    assertEquals("camera distance not as expected", 600, cameras.get(1).getMeters());

    assertEquals("camera number not as expected", 3, cameras.get(2).getNumber());
    assertEquals("camera distance not as expected", 855, cameras.get(2).getMeters());

    assertEquals("camera number not as expected", 4, cameras.get(3).getNumber());
    assertEquals("camera distance not as expected", 1355, cameras.get(3).getMeters());
  }

}
