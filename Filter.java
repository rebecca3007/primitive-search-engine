
/**
 * This class removes the common words read in from the website words.
 *
 * @author (Rebecca Pantano)
 * @version (4/15/2018)
 */
import java.util.*;

public class Filter
{
    private ArrayList<String> commonWords;
    private ArrayList<String> filteredWords;
    
    public Filter(ArrayList<String> cw) {
        commonWords = cw;
    }
    
    /**
     * removeCommonWords - this method searches to see if there are any common words in the database 
     * and then removes them 
     * 
     * @param TreeMap<String, PriorityQueue<Website>> website - all the words in the database
     * @return void 
     */
    public TreeMap<String, PriorityQueue<Website>> removeCommonWords(TreeMap<String, PriorityQueue<Website>> website) {
        
            for (int j = 0; j < commonWords.size(); j++) {
                if (website.containsKey(commonWords.get(j))) {
                    website.remove(commonWords.get(j));
                }
            }
            return website;
    }
    
       
}
