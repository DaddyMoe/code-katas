package com.mosesmansaray.kata.data_munging.soccer;

import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created on 08/09/2015.
 *
 * @author moses.mansaray
 */
public class LeagueTable {

  private String errorMsg;

  @Test
  public void shouldReturnTheGoalsScoredFor(){
    errorMsg = "Goals scored is not as expected";
    throw new NotImplementedException();
  }

  @Test
  public void shouldReturnTheGoalScoredAgainst(){
    errorMsg = "Goals scored against is not as expected";
    throw new NotImplementedException();
  }

  @Test
  public void shouldReturnTheGoalsScoredForAndAgainstDifference(){
    errorMsg = "Goals difference not as expected";
    throw new NotImplementedException();
  }

  @Test
  public void shouldReturnListOfTheLeagueTable(){
    errorMsg = "Result is not a list as expected";
    throw new NotImplementedException();
  }

  @Test
  public void shouldReturnListLengthOfLeagueTableAsExpected(){
    errorMsg = "Did not match the expected number teams in the League Table List";
    throw new NotImplementedException();
  }

  @Test
  public void shouldReturnAListOfLeagueTableSortedByGoalsDifference(){
    errorMsg = "Returned list is not sorted";
    throw new NotImplementedException();
  }

  @Test
  public void shouldReturnTheTeamWithTheSmallestGoalDifference(){
    errorMsg = "Did not match the team with the smallest goal difference";
    throw new NotImplementedException();
  }

}
