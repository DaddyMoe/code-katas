package com.mosesmansaray.kata;


import net.bcharris.trie.Trie;
import net.bcharris.trie.TrieImpl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Spell Checker.  If word exist in Dictionary, the word is returned as is.
 * If it does not exist the word is returned with a marker on the First Character error
 * @author moses.mansaray
 */
public class SpellCheck {

  private final Trie trie = new TrieImpl(true);

  /**
   * Constructs a spell check and eager loads the dictionary in the process
   *
   * @param path of the dictionary word file to load delimited by "\n"
   */
  public SpellCheck(String path) {
    String[] words = getWords(path);
    addWordsToTrie(words);
  }

  private String[] getWords(String path)  {
    byte[] encoded = new byte[0];
    try {
      encoded = Files.readAllBytes(Paths.get(path));
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return new String(encoded, Charset.defaultCharset()).split("\n");
  }

  private void addWordsToTrie(String[] words) {
    for (String word : words) {
      trie.insert(word);
    }
  }

  /**
   * Spell Checker.  If word exist in Dictionary.
   *
   * @param word to check for
   * @return word as is if it exist else; </b>
   * the word is returned with a marker on the First Character error
   */
  public String wordSpellingCheck(String word) {
    if (doesWordExistInDictionary(word)) {
      System.out.println(word);
      return word;
    }
    String evaluatedWord = getWordWithSquiggleMarker(word);
    System.out.println(evaluatedWord);
    return evaluatedWord;
  }

  private String getWordWithSquiggleMarker(String word) {
    int position = getPositionOfFirstCharacterError(word);
    return word.substring(0, position) + "<" + word.substring(position, word.length());
  }

  private int getPositionOfFirstCharacterError(String word) {
    int position = 0;
    for (int i = 0; i < word.length(); i++) {
      position = i + 1;
      String subWord = word.substring(0, position);
      if (!trie.contains(subWord)) {
        break;
      }
    }
    return position;
  }

  private boolean doesWordExistInDictionary(String word) {
    return trie.contains(word);
  }

}
