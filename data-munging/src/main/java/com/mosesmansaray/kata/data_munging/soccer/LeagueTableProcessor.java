package com.mosesmansaray.kata.data_munging.soccer;

import com.mosesmansaray.kata.data_munging.processor.DataMungingProcessor;
import com.mosesmansaray.kata.data_munging.reader.DataMungingFileReader;
import com.mosesmansaray.kata.data_munging.soccer.exception.SoccerLeagueDataMungingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 08/09/2015.
 *
 * @author moses.mansaray
 */
public class LeagueTableProcessor implements DataMungingProcessor {
  private final static Logger LOGGER = Logger.getLogger(LeagueTableProcessor.class.getName());

  private DataMungingFileReader fileReader = new DataMungingFileReader();

  @Override
  public TeamLeagueStat processDataInputRow(String exampleLine1) throws SoccerLeagueDataMungingException {
    String[] stats = exampleLine1.trim().split("\\s+");

    if (stats.length < 9) {
      throw new SoccerLeagueDataMungingException("Data passed in is not a valid stats");
    }

    int goalsScoreFor = Integer.parseInt(stats[6]);
    int goalsScoredAgainst = Integer.parseInt(stats[8]);
    int goalsScoredDiff = goalsScoreFor - goalsScoredAgainst;
    return new TeamLeagueStat(stats[1], goalsScoreFor, goalsScoredAgainst, goalsScoredDiff);
  }

  @Override
  public List processDataInput(String sourcePath) {
    List teamLeagueStats = new ArrayList<>();
    TeamLeagueStat daysWeather;

    try {
      BufferedReader reader = fileReader.getBufferedReader(sourcePath);
      int lineNumber = 0;
      String line;

      while ((line = reader.readLine()) != null) {
        if (lineNumber >= 1) {
          try {
            daysWeather = processDataInputRow(line);
            teamLeagueStats.add(daysWeather);
          } catch (SoccerLeagueDataMungingException soccerLeagueDataMungingException) {
            LOGGER.log(Level.WARNING, soccerLeagueDataMungingException.getMessage());
          }
        }
        lineNumber++;
      }
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, "Unable to read file");
    }

    Collections.sort(teamLeagueStats);

    return teamLeagueStats;
  }

  public String getTeamWithBestGoalDifference(List teamLeagueStat) {
    TeamLeagueStat teamWithBestGoalDifference = (TeamLeagueStat) teamLeagueStat.get(teamLeagueStat.size() - 1);
    return teamWithBestGoalDifference.getTeamName();
  }
}
