
/**
 * The class Database contains all the non-common words from all the websites.
 *
 * @author (Rebecca Pantano)
 * @version (4/15/2018)
 */

import java.util.*;

public class Database 
{
    private Filter filter;
    private TreeMap<String, PriorityQueue<Website>> database;
    private WebsiteComparator wc = new WebsiteComparator();

    public Database(Filter f)
    {
        filter = f;
        database = new TreeMap<String, PriorityQueue<Website>>();
        
    }

    /**
     * addValue - this method adds a word and the website it comes from to the database
     *  
     * @param String key - word
     * @param Website website - website
     * 
     * @return void
     */
    public void addValue(String key, Website website) {
        PriorityQueue<Website> values = new PriorityQueue<Website>(wc);
        if (!database.containsKey(key)) { //if the word isn't already in the database
            values.add(website);
            database.put(key, values);
        } else if (database.containsKey(key)) { //if the word is in the database
            values = database.get(key);
            if (!values.contains(website)) { //if values doesn't already contain website
                values.add(website);
            }
            database.put(key, values);
        }
    }
    
    /**
     * filterData - removes common words from database
     * 
     * @param none
     * @return void
     */
    public void filterData() {
        this.database = filter.removeCommonWords(this.database); 
    }
    
    /** 
     * contains - returns value at a specific key if the key exists
     * 
     * @param String s - word being searched for
     * @return PriorityQueue<Website> - all the websites that contain that word
     */
    public PriorityQueue<Website> contains(String s) {
        if (database.containsKey(s)) {
            return database.get(s);
        } else {
            return null;
        }
    }
    
    /** 
     * getDatabase - returns database
     * 
     * @param none
     * @return TreeMap<String, PriorityQueue<Website>> - all the words in the database
     */
    public TreeMap<String, PriorityQueue<Website>> getDatabase() {
        return database;
    }
    
    
            
        

        
    
   
}
