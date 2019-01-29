

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class WebsiteTest.
 *
 * @author  (Rebecca Pantano)
 * @version (4/15/2018)
 */
public class WebsiteTest
{
    /**
     * Default constructor for test class WebsiteTest
     */
    public WebsiteTest()
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
    public void testAddEmpty() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Website w = new Website("test.txt", "high", "test", d);
        
        PriorityQueue<Website> actual = d.contains("anyword");
        PriorityQueue<Website> expected = null;
        
        assertEquals(expected, actual);
    }
    
    //this test returns false even though the values of actual and expected match 
    @Test
    public void testAdd() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Website w = new Website("lions", "high", "Encyclopedia.txt", d);
        
        PriorityQueue<Website> ex = new PriorityQueue<Website>();
        ex.add(w);
        
        PriorityQueue<Website> actual = d.contains("lions");
        PriorityQueue<Website> expected = ex;
        
        assertEquals(expected, actual);
    }
    
    //tested with a word I know is uppercase in the file
    @Test
    public void testAddNoUppercase() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Website w = new Website("lions", "high", "Encyclopedia.txt", d);
        
       
        PriorityQueue<Website> actual = d.contains("Lions");
        PriorityQueue<Website> expected = null;
        
        assertEquals(expected, actual);
    }
    
        
}
