package com.mosesmansaray.kata.data_munging.soccer;

import com.mosesmansaray.kata.data_munging.soccer.exceptions.NotAValidLineOsStats;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class LeagueTableProcessor {
  private final static Logger LOGGER = Logger.getLogger(LeagueTableProcessor.class.getName());

  public TeamLeagueStat buildTeamLeagueStat(String exampleLine1) throws NotAValidLineOsStats {
    String[] stats = exampleLine1.trim().split("\\s+");

    if (stats.length < 9) {
      throw new NotAValidLineOsStats("Data passed in is not a valid stats");
    }

    int goalsScoreFor = Integer.parseInt(stats[6]);
    int goalsScoredAgainst = Integer.parseInt(stats[8]);
    int goalsScoredDiff = goalsScoreFor - goalsScoredAgainst;
    return new TeamLeagueStat(stats[1], goalsScoreFor, goalsScoredAgainst, goalsScoredDiff);
  }

  public List<TeamLeagueStat> buildTeamLeagueStatList(String sourcePath) {
    List<TeamLeagueStat> teamLeagueStats = new ArrayList<>();
    Path resourcePath = getResourcePath(sourcePath);

    try (BufferedReader reader = new BufferedReader(new FileReader(resourcePath.toString()))) {
      TeamLeagueStat daysWeather;
      int lineNumber = 0;
      String line;

      while ((line = reader.readLine()) != null) {
        if (lineNumber >= 1) {
          try {
            daysWeather = buildTeamLeagueStat(line);
            teamLeagueStats.add(daysWeather);
          } catch (NotAValidLineOsStats notAValidLineOsStats) {
            LOGGER.log(Level.WARNING, notAValidLineOsStats.getMessage());
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

  private Path getResourcePath(String sourcePathOfData) {
    Path resourcePath = null;
    URL resourceUrl = this.getClass().getResource("/" + sourcePathOfData);
    try {
      resourcePath = Paths.get(resourceUrl.toURI());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    return resourcePath;
  }

  public String getTeamWithBestGoalDifference(List<TeamLeagueStat> teamLeagueStat) {
    TeamLeagueStat teamWithBestGoalDifference = teamLeagueStat.get(teamLeagueStat.size() - 1);
    return teamWithBestGoalDifference.getTeamName();
  }
}
