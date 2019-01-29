

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


/**
 * The test class SearchEngineTest.
 *
 * @author  (Rebecca Pantano)
 * @version (4/15/2018)
 */
public class SearchEngineTest
{
    /**
     * Default constructor for test class SearchEngineTest
     */
    public SearchEngineTest()
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
    
    //run program with the common word file in place of input file and vv
    //this test should fail bc of an exception
    @Test 
    public void testRunSwitched() {
        SearchEngine se = new SearchEngine();

        se.run("CommonWords.txt", "InputFile.txt");
    }
    
    //this test should fail bc of an exception
    @Test
    public void testUserInputWrong() {
        SearchEngine se = new SearchEngine();
        
        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");
        test.add("test3");
        
        Filter f = new Filter(test);
        Database d = new Database(f);
        ResultComparator rc = new ResultComparator();
        Websites w = new Websites(test, d);
        
        se.userInput(d, rc, w);
    
    
    }
    
    
    
    
        
}
