

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class WebsiteComparatorTest.
 *
 * @author  (Rebecca Pantano)
 * @version (4/15/2018)
 */
public class WebsiteComparatorTest
{
    /**
     * Default constructor for test class WebsiteComparatorTest
     */
    public WebsiteComparatorTest()
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
    public void testCompareEverythigDifferent() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        WebsiteComparator wc = new WebsiteComparator();
        Website w = new Website("test.txt", "high", "test", d);
        Website w2 = new Website("test2.txt", "medium", "test2", d);
        
        int actual = wc.compare(w, w2);
        int expected = 1;
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCompareEverythigSame() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        WebsiteComparator wc = new WebsiteComparator();
        Website w = new Website("test.txt", "high", "test", d);
        Website w2 = new Website("test.txt", "high", "test", d);
        
        int actual = wc.compare(w, w2);
        int expected = 0;
        
        assertEquals(expected, actual);
    }
    
    @Test 
    public void testCompareSamePriority() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        WebsiteComparator wc = new WebsiteComparator();
        Website w = new Website("test.txt", "high", "test", d);
        Website w2 = new Website("test2.txt", "high", "test2", d);
        
        int actual = wc.compare(w, w2);
        int expected = -1;
        
        assertEquals(expected, actual);
    }
        
}
