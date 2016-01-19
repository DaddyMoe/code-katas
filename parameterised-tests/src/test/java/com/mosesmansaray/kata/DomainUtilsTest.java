package com.mosesmansaray.kata;


import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class DomainUtilsTest {

		private String domain;
		private boolean expected;

		public DomainUtilsTest(String domain, boolean expected) {
				this.domain = domain;
				this.expected = expected;
		}

		@Parameters(name= "{index}: isValid({0})={1}")
		public static Iterable<Object[]> data() {
				return Arrays.asList(new Object[][] {
												{ "bbc.com", true },
												{ "google.com", true },
												{ "bbc-.com", false },
												{ "frt#$krr.com", false },
												{ "3113ghjk", false },
												{ "-bbc.com", false }
								}
				);
		}

		@Test
		public void test_validDomains() {
				assertEquals(expected,DomainUtils.isValidDomainName(domain));
		}

}