

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class DatabaseTest.
 *
 * @author  (Rebecca Pantano)
 * @version (4/15/2018)
 */
public class DatabaseTest
{
    /**
     * Default constructor for test class DatabaseTest
     */
    public DatabaseTest()
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
    public void testAddValue() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        Website w = new Website("test.com", "low", "test.txt", d); 
        
        d.addValue("blue", w);
        
        PriorityQueue<Website> actual = d.contains("blue");
        
        assertTrue(actual.size() == 1);
    }
    
    @Test
    public void testAddExistingValue() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        Website w = new Website("test.com", "low", "test.txt", d); 
        
        d.addValue("blue", w);
        d.addValue("red", w);
        
        PriorityQueue<Website> actual = d.contains("blue");
        
        assertTrue(actual.size() == 1);
    }
    
    @Test
    public void testAddExistingKey() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        Website w = new Website("test.com", "low", "test.txt", d); 
        Website w2 = new Website("test2.com", "high", "test2.txt", d);
        
        d.addValue("blue", w);
        d.addValue("blue", w2);
        
        PriorityQueue<Website> actual = d.contains("blue");
        
        assertTrue(actual.size() == 2);
    }
    
    @Test 
    public void testFilterDataEmptyCW() {
        ArrayList<String> test = new ArrayList<String>();
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        Website w = new Website("test.com", "low", "test.txt", d); 
        Website w2 = new Website("test2.com", "high", "test2.txt", d);
        
        d.addValue("blue", w);
        d.addValue("blue", w2);
        
        TreeMap<String, PriorityQueue<Website>> tm = d.getDatabase();
        d.filterData();
        TreeMap<String, PriorityQueue<Website>> tm2 = d.getDatabase();
        
        
        assertEquals(tm, tm2);
    }
    
    @Test 
    public void testFilterDataNoMatchingCW() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("red");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        Website w = new Website("test.com", "low", "test.txt", d); 
        Website w2 = new Website("test2.com", "high", "test2.txt", d);
        
        d.addValue("blue", w);
        d.addValue("blue", w2);
        
        TreeMap<String, PriorityQueue<Website>> tm = d.getDatabase();
        d.filterData();
        TreeMap<String, PriorityQueue<Website>> tm2 = d.getDatabase();
        
        
        assertEquals(tm, tm2);
    }
    
    @Test 
    public void testFilterData() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("red");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        Website w = new Website("test.com", "low", "test.txt", d); 
        Website w2 = new Website("test2.com", "high", "test2.txt", d);
        
        d.addValue("blue", w);
        d.addValue("blue", w2);
        d.addValue("red", w);
        
        TreeMap<String, PriorityQueue<Website>> tm = d.getDatabase();
        d.filterData();
        
        
        assertTrue(tm.size() == 1);
    }
    
    @Test
    public void testDoesNotContain() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("red");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        Website w = new Website("test.com", "low", "test.txt", d); 
        Website w2 = new Website("test2.com", "high", "test2.txt", d);
        
        d.addValue("blue", w);
        d.addValue("blue", w2);
        d.addValue("red", w);
        
        PriorityQueue<Website> actual = d.contains("black");
        PriorityQueue<Website> expected = null;
        
        assertEquals(expected, actual);
    }
    
    //test fails even though results match
    @Test
    public void testContains() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("red");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        Website w = new Website("test.com", "low", "test.txt", d); 
        Website w2 = new Website("test2.com", "high", "test2.txt", d);
        
        d.addValue("blue", w);
        d.addValue("blue", w2);
        d.addValue("red", w);
        d.addValue("black", w2);
        
        PriorityQueue<Website> result = new PriorityQueue<Website>();
        result.add(w2);
        
        PriorityQueue<Website> actual = d.contains("black");
        PriorityQueue<Website> expected = result;
        
        assertEquals(expected, actual);
    }
    
    //test fails even though results match
    @Test
    public void testContainsMoreThanOne() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("red");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        Website w = new Website("test.com", "low", "test.txt", d); 
        Website w2 = new Website("test2.com", "high", "test2.txt", d);
        WebsiteComparator wc = new WebsiteComparator();
        
        d.addValue("blue", w);
        d.addValue("blue", w2);
        d.addValue("red", w);
        d.addValue("black", w2);
        
        PriorityQueue<Website> result = new PriorityQueue<Website>(wc);
        result.add(w);
        result.add(w2);
        
        PriorityQueue<Website> actual = d.contains("blue");
        PriorityQueue<Website> expected = result;
        
        assertEquals(expected, actual);
    }
    
    
        
    
        
        
    
    
    
    
}
