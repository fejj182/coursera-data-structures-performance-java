package textgen;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MarkovTextGeneratorLolTester {
    @Test
    public void wordlist_on_small_sentence()
    {
        MarkovTextGeneratorLoL generator = new MarkovTextGeneratorLoL((new Random()));
        generator.train("hi there hi Leo");
        assertEquals("hi: there->Leo->\n", generator.wordList.get(0).toString());
        assertEquals(3, generator.wordList.size());
    }
}
