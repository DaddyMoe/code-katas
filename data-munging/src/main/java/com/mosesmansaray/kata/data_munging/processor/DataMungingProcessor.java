package com.mosesmansaray.kata.data_munging.processor;

import com.mosesmansaray.kata.data_munging.soccer.exception.SoccerLeagueDataMungingException;

import java.util.List;

/**
 * Created on 09/09/2015.
 *
 * @author moses.mansaray
 */
public interface DataMungingProcessor<T> {

  T processDataInputRow(String row) throws SoccerLeagueDataMungingException;

  List processDataInput(String sourcePath);
}
