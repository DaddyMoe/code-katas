package com.mosesmansaray.kata.natural_language;

import java.util.*;

public class NaturalLanguageSort {

		public String[] sortToNaturalLanguage(String[] rawList) {

				List<String> strings = Arrays.asList(rawList);
				Collections.sort(strings, new NaturalLanguageComparator());
				return strings.toArray(new String[strings.size()]);
		}

		class NaturalLanguageComparator implements Comparator<String>{

				@Override
				public int compare(String o1, String o2) {

						if (o1.equalsIgnoreCase(o2)) {
								return 0;
						}

						String[] o1Tokens = o1.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
						String[] o2Tokens = o2.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

						for (int i = 0; i < o1Tokens.length; i++) {
								if (!o1Tokens[i].equalsIgnoreCase(o2Tokens[i])) {

										boolean o1TokenIsDigit = Character.isDigit(o1Tokens[i].charAt(0));
										boolean o2TokenIsDigit = Character.isDigit(o2Tokens[i].charAt(0));

										if (!(o1TokenIsDigit && o2TokenIsDigit)) {
												return o1TokenIsDigit ? -1 : 1;
										}

										if (!o1TokenIsDigit) {
											return o1Tokens[i].compareToIgnoreCase(o2Tokens[i]);
										}

										Integer o1TokenInteger = Integer.parseInt(o1Tokens[i]);
										Integer o2TokenInteger = Integer.parseInt(o2Tokens[i]);

										return o1TokenInteger.compareTo(o2TokenInteger);
								}
						}

						return 0;
				}
		}

}
