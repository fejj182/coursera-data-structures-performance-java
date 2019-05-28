package spelling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NearbyWordsTester {
    NearbyWords w;
    List<String> retList;

    @Before
    public void setUp()
    {
        Dictionary d = new DictionaryHashSet();
        DictionaryLoader.loadDictionary(d, "data/dict.txt");
        w = new NearbyWords(d);
        retList = new ArrayList<String>();
    }

    @Test
    public void validSubstitutions()
    {
        String word = "wrencher";
        w.substitution(word, retList, true);
        assertEquals(2, retList.size());
        assertEquals("wrenched", retList.get(0));
        assertEquals("wrenches", retList.get(1));
    }

    @Test
    public void invalidSubstitutions()
    {
        String word = "abcdef";
        w.substitution(word, retList, true);
        assertEquals(0, retList.size());
    }

    @Test
    public void blankSubstitutions()
    {
        String word = "";
        w.substitution(word, retList, true);
        assertEquals(0, retList.size());
    }

    @Test
    public void validInsertions()
    {
        String word = "wrenche";
        w.insertions(word, retList, true);
        assertEquals(2, retList.size());
        assertEquals("wrenched", retList.get(0));
        assertEquals("wrenches", retList.get(1));
    }

    @Test
    public void invalidInsertions()
    {
        String word = "abcdef";
        w.insertions(word, retList, true);
        assertEquals(0, retList.size());
    }

    @Test
    public void blankInsertions()
    {
        String word = "";
        w.insertions(word, retList, true);
        assertEquals(26, retList.size()); // because each individual letter is in dict.txt
    }

    @Test
    public void validDeletion()
    {
        String word = "wring";
        w.deletions(word, retList, true);
        assertEquals(2, retList.size());
        assertEquals("ring", retList.get(0));
        assertEquals("wing", retList.get(1));
    }

    @Test
    public void invalidDeletion()
    {
        String word = "abcdef";
        w.deletions(word, retList, true);
        assertEquals(0, retList.size());
    }

    @Test
    public void blankDeletion()
    {
        String word = "";
        w.deletions(word, retList, true);
        assertEquals(0, retList.size());
    }
}
