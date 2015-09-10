package com.mosesmansaray.kata.data_munging.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created on 09/09/2015.
 *
 * @author moses.mansaray
 */
public class DataMungingFileReader {

  public Path getResourcePath(String sourcePathOfData) {
    Path resourcePath = null;
    URL resourceUrl = this.getClass().getResource("/" + sourcePathOfData);
    try {
      resourcePath = Paths.get(resourceUrl.toURI());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    return resourcePath;
  }

  public BufferedReader getBufferedReader(String sourcePathOfData) throws FileNotFoundException {
    Path resourcePath = getResourcePath(sourcePathOfData);
    FileReader fileReader = new FileReader(resourcePath.toString());
    return new BufferedReader(fileReader);
  }
}
