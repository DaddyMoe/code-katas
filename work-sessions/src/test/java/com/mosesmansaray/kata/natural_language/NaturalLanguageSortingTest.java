package com.mosesmansaray.kata.natural_language;

import com.mosesmansaray.kata.natural_language.NaturalLanguageSort;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
	* Created by moses.mansaray on 09/02/2016.
	*/
public class NaturalLanguageSortingTest {

		private static final NaturalLanguageSort NATURAL_LANGUAGE_SORT = new NaturalLanguageSort();

		@Test
		public void shouldSortInNaturalLanguage() throws Exception {
				String[] example1 = {"Z1", "Z54", "Z110", "Z207", "Z33"};
				String[] sortedToNaturalLanguage = NATURAL_LANGUAGE_SORT.sortToNaturalLanguage(example1);

				assertTrue(sortedToNaturalLanguage[0].equals("Z1"));
				assertTrue(sortedToNaturalLanguage[1].equals("Z33"));
				assertTrue(sortedToNaturalLanguage[2].equals("Z54"));
				assertTrue(sortedToNaturalLanguage[3].equals("Z110"));
				assertTrue(sortedToNaturalLanguage[4].equals("Z207"));

		}

		@Test
		public void shouldSortInNaturalLanguageWithVaryingTokensAndAlphaNumerics() throws Exception {
				String[] exampleWithDiffWithOfString = {"a", "0", "b", "1"};
				String[] sortedToNaturalLanguage = NATURAL_LANGUAGE_SORT.sortToNaturalLanguage(exampleWithDiffWithOfString);

				assertTrue(sortedToNaturalLanguage[0].equals("0"));
				assertTrue(sortedToNaturalLanguage[1].equals("1"));
				assertTrue(sortedToNaturalLanguage[2].equals("a"));
				assertTrue(sortedToNaturalLanguage[3].equals("b"));
		}

		//@Test
		public void shouldSortInNaturalLanguageWithVaryingTokens() throws Exception {
				String[] exampleWithDiffWithOfString = {"Zz1", "ZZZ54bbv", "ZZZZ110", "Z207", "Z33"};
				String[] sortedToNaturalLanguage = NATURAL_LANGUAGE_SORT.sortToNaturalLanguage(exampleWithDiffWithOfString);

				assertTrue(sortedToNaturalLanguage[0].equals("Z33"));
				assertTrue(sortedToNaturalLanguage[1].equals("Z207"));
				assertTrue(sortedToNaturalLanguage[2].equals("Zz1"));
				assertTrue(sortedToNaturalLanguage[3].equals("ZZZ54bbv"));
				assertTrue(sortedToNaturalLanguage[4].equals("ZZZZ110"));
		}

		//@Test
		public void testStringCompare() {
				String[] exampleWithDiffWithOfString = {"ab", "aa", "a", "b", "bb"};
				String[] sortedToNaturalLanguage = NATURAL_LANGUAGE_SORT.sortToNaturalLanguage(exampleWithDiffWithOfString);

				assertTrue(sortedToNaturalLanguage[0].equals("a"));
				assertTrue(sortedToNaturalLanguage[1].equals("b"));
				assertTrue(sortedToNaturalLanguage[2].equals("aa"));
				assertTrue(sortedToNaturalLanguage[3].equals("ab"));
				assertTrue(sortedToNaturalLanguage[4].equals("bb"));
		}

}
