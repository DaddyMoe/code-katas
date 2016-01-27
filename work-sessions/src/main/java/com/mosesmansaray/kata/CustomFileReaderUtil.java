package com.mosesmansaray.kata;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * File reader utility class for file loading
 *
 * Created on 27/01/2016.
 *
 * @author moses.mansaray
 */
public class CustomFileReaderUtil {


  public List<String> getListOfRows(String filePath) {
    try {
      String path = this.getClass().getClassLoader().getResource(filePath).getPath();
      return Files.readAllLines(Paths.get(path), Charset.defaultCharset());
    } catch (IOException e) {
      //log error and instantiate empty
      return new ArrayList<>();
    }
  }
}
