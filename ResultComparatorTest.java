

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class ResultComparatorTest.
 *
 * @author  (Rebecca Pantano)
 * @version (4/15/2018)
 */
public class ResultComparatorTest
{
    /**
     * Default constructor for test class ResultComparatorTest
     */
    public ResultComparatorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void compareSameMatches() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Website w = new Website("test.txt", "high", "test", d);
        Website w2 = new Website("test2.txt", "medium", "test2", d);
        w.setMatches(1);
        w2.setMatches(1);
        
        int actual = rc.compare(w, w2);
        int expected = -1;
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void compareSameMatchesPriority() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Website w = new Website("test.txt", "high", "test", d);
        Website w2 = new Website("zest.txt", "high", "zest", d);
        w.setMatches(1);
        w2.setMatches(1);
        
        int actual = rc.compare(w, w2);
        int expected = 1;
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void compareSameEverything() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Website w = new Website("test.txt", "high", "test", d);
        Website w2 = new Website("test.txt", "high", "test", d);
        w.setMatches(1);
        w2.setMatches(1);
        
        int actual = rc.compare(w, w2);
        int expected = 0;
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void compareDifferentEverything() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Website w = new Website("test.txt", "high", "test", d);
        Website w2 = new Website("best.txt", "low", "best", d);
        w.setMatches(2);
        w2.setMatches(1);
        
        int actual = rc.compare(w, w2);
        int expected = -1;
        
        assertEquals(expected, actual);
    }
        
}
