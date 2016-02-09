package com.mosesmansaray.kata;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created on 27/01/2016.
 *
 * @author moses.mansaray
 */
public class CustomFileReaderUtilTest {

  @Test
  public void shouldReadAndReturnLinesFromFileAsExpected(){
    CustomFileReaderUtil readerUtil = new CustomFileReaderUtil();
    List<String> rows = readerUtil.getListOfRows("file_loader_test_file.log", this);
    assertEquals("", 5, rows.size());
  }
}
