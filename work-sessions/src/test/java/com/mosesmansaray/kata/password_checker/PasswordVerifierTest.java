package com.mosesmansaray.kata.password_checker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by moses.mansaray on 10/05/2016.
 */
public class PasswordVerifierTest {


  public static final PasswordVerifier VERIFIER = new PasswordVerifier();

  /**
   *  1.1 - password should be larger than 8 chars
   */
  @Test
  public void shouldBeLargerThan8Chars() throws Exception {
    boolean isOk = VERIFIER.verify("1234Cn56789");
    assertThat(isOk, is(true));
  }

  @Test(expected = Exception.class)
  public void shouldThrowExceptionIfLessThan8Chars() throws Exception {
    VERIFIER.verify("1234567");
  }



  /**
   *  1.2 - password should not be null
   */
  @Test(expected = Exception.class)
  public void shouldThrowExceptionIfPasswordIsNull() throws Exception {
    VERIFIER.verify(null);
  }

  @Test
  public void shouldThrowExceptionIfPasswordIsNullWithMessage() throws Exception {
    try {
      VERIFIER.verify(null);
    } catch (Exception e) {
      assertThat(e.getMessage(), is("Password should not be null"));
    }
  }



  /**
   *  1.3 - password should have one Capital letter at least
   */
  @Test(expected = Exception.class)
  public void shouldThrowExceptionIfPasswordDoesNotContainACapitalLetter() throws Exception {
    VERIFIER.verify("wdwodowodowwdwd");
  }


  @Test
  public void shouldThrowExceptionIfPasswordDoesNotContainACapitalLetterWithMessage() throws Exception {
    try {
      VERIFIER.verify("wdwodowodowwdwd");
    } catch (Exception e) {
      assertThat(e.getMessage(), is("Password should contain at least one capital letter"));
    }
  }

  @Test
  public void shouldReturnOkIfPasswordContainACapitalLetter() throws Exception {
    VERIFIER.verify("wdwodow6odDowwdwd");
  }



  /**
   *  1.4 - password should have one lowercase letter at least
   */
  @Test(expected = Exception.class)
  public void shouldThrowExceptionIfPasswordDoesNotContainAlowerCaseLetter() throws Exception {
    VERIFIER.verify("CCCCCCCCCCEDDFDFDFDFDFDF");
  }


  @Test
  public void shouldThrowExceptionIfPasswordDoesNotContainAlowerCaseLetterMessage() throws Exception {
    try {
      VERIFIER.verify("CCCCCCCCCCEDDFDFDFDFDFDF");
    } catch (Exception e) {
      assertThat(e.getMessage(), is("Password should contain at least one lower care letter"));
    }
  }

  @Test
  public void shouldReturnOKIfPasswordDoesContainAlowerCaseLetter() throws Exception {
    VERIFIER.verify("CCCCCCcCC7CCEDFDFDFDF");
  }


  //password should have one number at least
  /**
   *  1.4 - password should have one number at least
   */
  // TODO: Fix
//  @Test(expected = Exception.class)
  public void shouldThrowExceptionIfPasswordDoesNotContainANumberDigit() throws Exception {
    VERIFIER.verify("CCCCCCCssssDFDFDF");
  }


  @Test
  public void shouldThrowExceptionIfPasswordDoesNotContainANumberDigitMessage() throws Exception {
    try {
      VERIFIER.verify("CCCCCCCCCCEDDFDsFDFDFDFDF");
    } catch (Exception e) {
      assertThat(e.getMessage(), is("Password should contain at least one number"));
    }
  }

  @Test
  public void shouldReturnOkIfPasswordDoesNotContainANumberDigit() throws Exception {
    boolean isOk = VERIFIER.verify("CCCCCCcCCCCEDFDFDF0DF");
    assertThat(isOk, is(true));
  }


  /**
   * 2. Add feature: Password is OK if at least three of the previous conditions is true
   *
   */
  @Test
  public void shouldReturnOkIfAtLeastThreeOfThePreviousConditionsIsTrue() throws Exception {
    VERIFIER.verify("wwwwwwwCyyyyyy");
  }


  /**
   * 3. Add feature: password is never OK if item 1.4 is not true.
   *
   */
  @Test(expected = Exception.class)
  public void shouldAlwaysThrowIfItDoesNotContainLowerCase() throws Exception {
    boolean isOk = VERIFIER.verify("CCCC34343434CCCC");
    assertThat(isOk, is(true));

  }




}
