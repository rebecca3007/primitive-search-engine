

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


/**
 * The test class SearchReturnTest.
 *
 * @author  (Rebecca Pantano)
 * @version (4/15/2018)
 */
public class SearchReturnTest
{
    /**
     * Default constructor for test class SearchReturnTest
     */
    public SearchReturnTest()
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
    public void testSearch() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        ArrayList<String> test2 = new ArrayList<String>();
        test2.add("lions.com high Encyclopedia.txt");
        test2.add("cooking.com low Blog.txt");
        test2.add("apparel.com medium FashionTrends.txt");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Websites w = new Websites(test2, d);
        String s = "hello";
        SearchReturn sr = new SearchReturn(d, rc, w, s);
        
        sr.search();
    } 
    
    @Test
    public void testSearchAnd() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        ArrayList<String> test2 = new ArrayList<String>();
        test2.add("lions.com high Encyclopedia.txt");
        test2.add("cooking.com low Blog.txt");
        test2.add("apparel.com medium FashionTrends.txt");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Websites w = new Websites(test2, d);
        String s = "hello and bye";
        SearchReturn sr = new SearchReturn(d, rc, w, s);
        
        sr.search();
    } 
    
    @Test
    public void testSearchOr() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        ArrayList<String> test2 = new ArrayList<String>();
        test2.add("lions.com high Encyclopedia.txt");
        test2.add("cooking.com low Blog.txt");
        test2.add("apparel.com medium FashionTrends.txt");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Websites w = new Websites(test2, d);
        String s = "hello or bye";
        SearchReturn sr = new SearchReturn(d, rc, w, s);
        
        sr.search();
    }
    
    @Test
    public void testSearchAndOr() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        ArrayList<String> test2 = new ArrayList<String>();
        test2.add("lions.com high Encyclopedia.txt");
        test2.add("cooking.com low Blog.txt");
        test2.add("apparel.com medium FashionTrends.txt");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Websites w = new Websites(test2, d);
        String s = "hello and hi or bye";
        SearchReturn sr = new SearchReturn(d, rc, w, s);
        
        sr.search();
    }
    
    @Test
    public void testSearchNegation() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        ArrayList<String> test2 = new ArrayList<String>();
        test2.add("lions.com high Encyclopedia.txt");
        test2.add("cooking.com low Blog.txt");
        test2.add("apparel.com medium FashionTrends.txt");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Websites w = new Websites(test2, d);
        String s = "hello and -hi";
        SearchReturn sr = new SearchReturn(d, rc, w, s);
        
        sr.search();
    }
    
    @Test
    public void searchAndNoMatch() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        ArrayList<String> test2 = new ArrayList<String>();
        test2.add("lions.com high Encyclopedia.txt");
        test2.add("cooking.com low Blog.txt");
        test2.add("apparel.com medium FashionTrends.txt");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Websites w = new Websites(test2, d);
        String s = "hello";
        SearchReturn sr = new SearchReturn(d, rc, w, s);
        
        sr.searchAnd();
        
        Website one = w.getWebsiteList().get(0);
        int actual = one.getMatches();
        int expected = 0;
        
        assertEquals(expected, actual);
        
    }
    
    @Test
    public void searchAndMatch() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        ArrayList<String> test2 = new ArrayList<String>();
        test2.add("lions.com high Encyclopedia.txt");
        test2.add("cooking.com low Blog.txt");
        test2.add("apparel.com medium FashionTrends.txt");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Websites w = new Websites(test2, d);
        String s = "lions";
        SearchReturn sr = new SearchReturn(d, rc, w, s);
        
        sr.searchAnd();
        
        Website one = w.getWebsiteList().get(0);
        int actual = one.getMatches();
        int expected = 1;
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void searchOrNoMatch() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        ArrayList<String> test2 = new ArrayList<String>();
        test2.add("lions.com high Encyclopedia.txt");
        test2.add("cooking.com low Blog.txt");
        test2.add("apparel.com medium FashionTrends.txt");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Websites w = new Websites(test2, d);
        String s = "hello or goodbye";
        SearchReturn sr = new SearchReturn(d, rc, w, s);
        
        sr.searchOr();
        
        Website one = w.getWebsiteList().get(0);
        
        int actual = one.getMatches();
        int expected = 0;
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void searchOrMatch() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        ArrayList<String> test2 = new ArrayList<String>();
        test2.add("lions.com high Encyclopedia.txt");
        test2.add("cooking.com low Blog.txt");
        test2.add("apparel.com medium FashionTrends.txt");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Websites w = new Websites(test2, d);
        String s = "hello or pasta";
        SearchReturn sr = new SearchReturn(d, rc, w, s);
        
        sr.searchOr();
        
        Website one = w.getWebsiteList().get(0);
        Website two = w.getWebsiteList().get(1);
        
        int actual = two.getMatches();
        int expected = 1;
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testAssess() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        ArrayList<String> test2 = new ArrayList<String>();
        test2.add("lions.com high Encyclopedia.txt");
        test2.add("cooking.com low Blog.txt");
        test2.add("apparel.com medium FashionTrends.txt");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Websites w = new Websites(test2, d);
        String s = "hello or pasta";
        SearchReturn sr = new SearchReturn(d, rc, w, s);
        
        sr.assessResult();
    }
    
    @Test
    public void testReturn() {
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        ArrayList<String> test2 = new ArrayList<String>();
        test2.add("lions.com high Encyclopedia.txt");
        test2.add("cooking.com low Blog.txt");
        test2.add("apparel.com medium FashionTrends.txt");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Websites w = new Websites(test2, d);
        String s = "hello or pasta";
        SearchReturn sr = new SearchReturn(d, rc, w, s);
        
        sr.returnResult();
    }
        
        
}
