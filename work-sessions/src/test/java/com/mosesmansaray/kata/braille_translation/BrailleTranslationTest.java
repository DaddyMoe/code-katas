package com.mosesmansaray.kata.braille_translation;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by moses.mansaray on 26/04/2016.
 */
public class BrailleTranslationTest {


  @Test
  public void exapleTest() throws Exception {
    Map<String, String[]> characterDictionary = new HashMap<String, String[]>();

    String[] a = {"*o", "oo", "oo"};
    String[] b = {"*o", "*o", "oo"};
    String[] c = {"**", "oo", "oo"};
    String[] d = {"**", "o*", "oo"};

    String[] e = {"*o", "o*", "oo"};
    String[] f = {"**", "*o", "oo"};
    String[] g = {"**", "**", "oo"};
    String[] h = {"*o", "**", "oo"};

    String[] i = {"o*", "*o", "oo"};
    String[] j = {"o*", "**", "oo"};
    String[] k = {"*o", "oo", "*o"};
    String[] l = {"*o", "*o", "*o"};

    String[] m = {"**", "oo", "*o"};
    String[] n = {"**", "o*", "*o"};
    String[] o = {"*o", "o*", "*o"};
    String[] p = {"**", "*o", "*o"};

    String[] q = {"**", "**", "*o"};
    String[] r = {"*o", "**", "*o"};
    String[] s = {"o*", "*o", "*o"};
    String[] t = {"o*", "**", "*o"};

    String[] u = {"*o", "oo", "**"};
    String[] v = {"*o", "*o", "**"};
    String[] w = {"o*", "**", "o*"};
    String[] x = {"**", "oo", "**"};

    String[] y = {"**", "o*", "**"};
    String[] z = {"*o", "o*", "**"};

    String[] hash = {"o*", "o*", "**"};
    String[] one = {"*o", "oo", "oo"};
    String[] two = {"*o", "*o", "oo"};
    String[] three = {"**", "oo", "oo"};
    String[] four = {"**", "o*", "oo"};


    characterDictionary.put("a", a);
    characterDictionary.put("b", b);
    characterDictionary.put("c", c);
    characterDictionary.put("d", d);
    characterDictionary.put("e", e);
    characterDictionary.put("f", f);
    characterDictionary.put("g", g);
    characterDictionary.put("h", h);
    characterDictionary.put("i", i);
    characterDictionary.put("j", j);
    characterDictionary.put("k", k);
    characterDictionary.put("l", l);
    characterDictionary.put("m", m);
    characterDictionary.put("n", n);
    characterDictionary.put("o", o);
    characterDictionary.put("p", p);
    characterDictionary.put("q", q);
    characterDictionary.put("r", r);
    characterDictionary.put("s", s);
    characterDictionary.put("t", t);
    characterDictionary.put("u", u);
    characterDictionary.put("v", v);
    characterDictionary.put("w", w);
    characterDictionary.put("x", x);
    characterDictionary.put("y", y);
    characterDictionary.put("z", z);



    characterDictionary.put("#", new String[]{"o*", "o*", "**"});
    characterDictionary.put("1", new String[]{"*o", "oo", "oo"});
    characterDictionary.put("2", new String[]{"*o", "*o", "oo"});
    characterDictionary.put("3", new String[]{"**", "oo", "oo"});
    characterDictionary.put("4", new String[]{"**", "o*", "oo"});

    characterDictionary.put("5", new String[]{"*o", "o*", "oo"});
    characterDictionary.put("6", new String[]{"**", "*o", "oo"});
    characterDictionary.put("7", new String[]{"**", "**", "oo"});
    characterDictionary.put("8", new String[]{"*o", "**", "oo"});
    characterDictionary.put("9", new String[]{"o*", "*o", "oo"});
    characterDictionary.put("0", new String[]{"o*", "**", "oo"});


  }
}
