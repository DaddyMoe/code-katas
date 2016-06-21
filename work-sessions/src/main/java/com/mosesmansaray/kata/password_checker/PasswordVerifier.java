package com.mosesmansaray.kata.password_checker;

/**
 * Created by moses.mansaray on 10/05/2016.
 */
public class PasswordVerifier {

  int countOfMatches = 0;


  public boolean verify(String passwordToCheck) throws Exception {

    if (passwordToCheck == null) {
      throw new Exception("Password should not be null");
    }
    countOfMatches +=1; //1

    char[] password = passwordToCheck.toCharArray();

    //length check
    if (password.length <= 8) {
      throw new Exception("Password should be longer than 8 characters");
    }
    countOfMatches +=1; //2


    //check for Caps
    if (!passwordToCheck.matches("^(?=.*[A-Z]).+$")) {
      throw new Exception("Password should contain at least one capital letter");
    }
    countOfMatches +=1; //3


    //check for lower case
    if (!passwordToCheck.matches("^(?=.*[a-z]).+$")) {
        throw new Exception("Password should contain at least one lower care letter");
    }
    countOfMatches +=1; //3


    //check for it contains a digit
    if (!passwordToCheck.matches("^(?=.*\\d).+$")) {
      if (countOfMatches <4) {
        throw new Exception("Password should contain at least one number");
      }
    }

    return true;

  }
}
