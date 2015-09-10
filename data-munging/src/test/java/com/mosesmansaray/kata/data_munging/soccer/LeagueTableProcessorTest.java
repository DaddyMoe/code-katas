package com.mosesmansaray.kata.data_munging.soccer;

import com.mosesmansaray.kata.data_munging.soccer.exception.SoccerLeagueDataMungingException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created on 08/09/2015.
 *
 * @author moses.mansaray
 */
public class LeagueTableProcessorTest {

  private static final String exampleLine1 = "    1. Arsenal         38    26   9   3    79  -  36    87\n";
  private static final String exampleLine2 = "   -------------------------------------------------------\n";
  private static final String exampleLine3 = "    3. Manchester_U    38    24   5   9    87  -  45    77\n";
  private String errorMsg;
  private final LeagueTableProcessor leagueTableProcessor = new LeagueTableProcessor();

  @Test
  public void shouldReturnTheNameOfTeam() throws SoccerLeagueDataMungingException {
    errorMsg = "Goals scored is not as expected";

    TeamLeagueStat teamLeagueStat = leagueTableProcessor.processDataInputRow(exampleLine1);
    assertEquals(errorMsg, "Arsenal", teamLeagueStat.getTeamName());

    teamLeagueStat = leagueTableProcessor.processDataInputRow(exampleLine3);
    assertEquals(errorMsg, "Manchester_U", teamLeagueStat.getTeamName());
  }

  @Test
  public void shouldReturnTheGoalsScoredFor() throws SoccerLeagueDataMungingException {
    errorMsg = "Goals scored is not as expected";

    TeamLeagueStat teamLeagueStat = leagueTableProcessor.processDataInputRow(exampleLine1);
    assertEquals(errorMsg, 79, teamLeagueStat.getGoalsScoreFor());

    teamLeagueStat = leagueTableProcessor.processDataInputRow(exampleLine3);
    assertEquals(errorMsg, 87, teamLeagueStat.getGoalsScoreFor());
  }

  @Test(expected = SoccerLeagueDataMungingException.class)
  public void shouldReturnException() throws SoccerLeagueDataMungingException {
    leagueTableProcessor.processDataInputRow(exampleLine2);
  }

  @Test
  public void shouldReturnTheGoalScoredAgainst() throws SoccerLeagueDataMungingException {
    errorMsg = "Goals scored against is not as expected";

    TeamLeagueStat teamLeagueStat = leagueTableProcessor.processDataInputRow(exampleLine1);
    assertEquals(errorMsg, 36, teamLeagueStat.getGoalsScoreForAgainst());

    teamLeagueStat = leagueTableProcessor.processDataInputRow(exampleLine3);
    assertEquals(errorMsg, 45, teamLeagueStat.getGoalsScoreForAgainst());
  }

  @Test
  public void shouldReturnTheGoalsScoredForAndAgainstDifference() throws SoccerLeagueDataMungingException {
    errorMsg = "Goals difference not as expected";

    TeamLeagueStat teamLeagueStat = leagueTableProcessor.processDataInputRow(exampleLine1);
    assertEquals(errorMsg, 43, teamLeagueStat.getGoalsScoreDifference());

    teamLeagueStat = leagueTableProcessor.processDataInputRow(exampleLine3);
    assertEquals(errorMsg, 42, teamLeagueStat.getGoalsScoreDifference());
  }

  @Test
  public void shouldReturnListOfTheLeagueTable() {
    errorMsg = "Result is not a list as expected";

    List teamLeagueStat = leagueTableProcessor.processDataInput("football.dat");

    assertTrue(errorMsg, teamLeagueStat != null);
  }

  @Test
  public void shouldReturnListLengthOfLeagueTableAsExpected() {
    errorMsg = "Did not match the expected number teams in the League Table List";

    List teamLeagueStat = leagueTableProcessor.processDataInput("football.dat");

    assertEquals(errorMsg, 20, teamLeagueStat.size());
  }

  @Test
  public void shouldReturnAListOfLeagueTableSortedByGoalsDifference() {
    errorMsg = "Returned list is not sorted";

    List teamLeagueStat = leagueTableProcessor.processDataInput("football.dat");

    assertEquals(errorMsg, 20, teamLeagueStat.size());
    assertEquals(errorMsg, "Leicester", ((TeamLeagueStat)teamLeagueStat.get(0)).getTeamName());
    assertEquals(errorMsg, "Sunderland", ((TeamLeagueStat)teamLeagueStat.get(3)).getTeamName());
    assertEquals(errorMsg, "Newcastle", ((TeamLeagueStat)teamLeagueStat.get(15)).getTeamName());
    assertEquals(errorMsg, "Manchester_U", ((TeamLeagueStat)teamLeagueStat.get(18)).getTeamName());
  }

  @Test
  public void shouldReturnTheTeamWithTheSmallestGoalDifference() {
    errorMsg = "Did not match the team with the smallest goal difference";

    LeagueTableProcessor leagueTableProcessor = new LeagueTableProcessor();
    List teamLeagueStat = leagueTableProcessor.processDataInput("football.dat");

    String teamWithBestGoalDifference = leagueTableProcessor.getTeamWithBestGoalDifference(teamLeagueStat);

    assertEquals(errorMsg, "Arsenal", teamWithBestGoalDifference);
  }

}

