package spelling;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class WPTreeTester {
    Dictionary dict;
    WPTree tree;

    @Before
    public void setUp()
    {
        dict = new DictionaryHashSet();
        DictionaryLoader.loadDictionary(dict, "data/grader_dict.txt");
        tree = new WPTree(new NearbyWords(dict));
    }

    @Test
    public void test_path_with_one_step()
    {
        List<String> path = tree.findPath("pool", "spool");
        assertEquals(2, path.size());
        assertEquals("pool", path.get(0));
        assertEquals("spool", path.get(1));
    }

    @Test
    public void test_path_with_two_steps()
    {
        List<String> path = tree.findPath("pool", "spoon");
        assertEquals(3, path.size());
        assertEquals("pool", path.get(0));
        assertEquals("spool", path.get(1));
        assertEquals("spoon", path.get(2));
    }

    @Test
    public void test_impossible_path()
    {
        List<String> path = tree.findPath("foal", "needless");
        assertEquals(0, path.size());
    }

    @Test
    public void test_path_with_non_existent_word()
    {
        try {
            List<String> path = tree.findPath("needle", "kitten");
            fail("Not catching non existent word");
        } catch (IllegalArgumentException e) {

        }
    }
}
