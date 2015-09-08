package com.mosesmansaray.kata.data_munging.soccer;

/**
 * Created on 08/09/2015.
 *
 * @author moses.mansaray
 */
public class TeamLeagueStat implements Comparable<TeamLeagueStat>{

  private final int goalsScoreFor;
  private final int goalsScoreForAgainst;
  private final int goalsScoreDifference;
  private final String teamName;

  public TeamLeagueStat(String teamName, int goalsScoreFor, int goalsScoredAgainst, int goalsScoredDifference) {
    this.teamName = teamName;
    this.goalsScoreFor = goalsScoreFor;
    this.goalsScoreForAgainst = goalsScoredAgainst;
    this.goalsScoreDifference = goalsScoredDifference;
  }

  public int getGoalsScoreFor() {
    return goalsScoreFor;
  }

  public int getGoalsScoreForAgainst() {
    return goalsScoreForAgainst;
  }

  public int getGoalsScoreDifference() {
    return goalsScoreDifference;
  }

  @Override
  public int compareTo(TeamLeagueStat teamLeagueStat) {
    int comparedDiff = teamLeagueStat.getGoalsScoreDifference();
    return this.getGoalsScoreDifference() - comparedDiff;
  }

  public String getTeamName() {
    return teamName;
  }
}
