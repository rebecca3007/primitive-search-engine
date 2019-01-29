

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class FilterTest.
 *
 * @author  (Rebecca Pantano)
 * @version (4/15/2018)
 */
public class FilterTest
{
    /**
     * Default constructor for test class FilterTest
     */
    public FilterTest()
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
    public void testRemoveCommonWordsAll() {
        ArrayList<String> cw = new ArrayList<String>();
        cw.add("this");
        cw.add("is");
        cw.add("a");
        cw.add("test");

        Filter f = new Filter(cw);
        Database d = new Database(f);
        
        Website w = new Website("test.com", "high", "test.txt", d);
        PriorityQueue<Website> ws = new PriorityQueue<Website>();
        ws.add(w);
        
        TreeMap<String, PriorityQueue<Website>> tm = new TreeMap<String, PriorityQueue<Website>>();        
        tm.put("this", ws);
        tm.put("is", ws);
        tm.put("a", ws);
        tm.put("test", ws);
        
        f.removeCommonWords(tm);
        
        assertTrue(tm.size() == 0);
    }
    
    @Test
    public void testRemoveCommonWords1() {
        ArrayList<String> cw = new ArrayList<String>();
        cw.add("this");
        cw.add("is");
        cw.add("a");
        cw.add("test");

        Filter f = new Filter(cw);
        Database d = new Database(f);
        
        Website w = new Website("test.com", "high", "test.txt", d);
        PriorityQueue<Website> ws = new PriorityQueue<Website>();
        ws.add(w);
        
        TreeMap<String, PriorityQueue<Website>> tm = new TreeMap<String, PriorityQueue<Website>>();        
        tm.put("this", ws);
        tm.put("blue", ws);
        tm.put("red", ws);
        tm.put("black", ws);
        
        f.removeCommonWords(tm);
        
        assertTrue(tm.size() == 3);
    }
    
    @Test
    public void testRemoveCommonWords3() {
        ArrayList<String> cw = new ArrayList<String>();
        cw.add("this");
        cw.add("is");
        cw.add("a");
        cw.add("test");

        Filter f = new Filter(cw);
        Database d = new Database(f);
        
        Website w = new Website("test.com", "high", "test.txt", d);
        PriorityQueue<Website> ws = new PriorityQueue<Website>();
        ws.add(w);
        
        TreeMap<String, PriorityQueue<Website>> tm = new TreeMap<String, PriorityQueue<Website>>();        
        tm.put("this", ws);
        tm.put("is", ws);
        tm.put("a", ws);
        tm.put("black", ws);
        
        f.removeCommonWords(tm);
        
        assertTrue(tm.size() == 1);
    }
    
    @Test 
    public void testRemoveCommonWordsNone() {
        ArrayList<String> cw = new ArrayList<String>();
        cw.add("this");
        cw.add("is");
        cw.add("a");
        cw.add("test");

        Filter f = new Filter(cw);
        Database d = new Database(f);
        
        Website w = new Website("test.com", "high", "test.txt", d);
        PriorityQueue<Website> ws = new PriorityQueue<Website>();
        ws.add(w);
        
        TreeMap<String, PriorityQueue<Website>> tm = new TreeMap<String, PriorityQueue<Website>>();        
        tm.put("green", ws);
        tm.put("blue", ws);
        tm.put("red", ws);
        tm.put("black", ws);
        
        f.removeCommonWords(tm);
        
        assertTrue(tm.size() == 4);
    }

        
}
