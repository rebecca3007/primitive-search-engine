
/**
 * The class ResultComparator aids in ordering the search results. It does so by implementing the compare method from the API Comparator
 * and compares them on the basis of: first, number of matches, then priority, and, finally, alphabetically by title.
 *
 * @author (Rebecca Pantano)
 * @version (4/8/2018)
 */

import java.util.*;

public class ResultComparator implements Comparator<Website>
{
    
    public ResultComparator()
    {
        
    }

    /**
     * compare - this method takes two websites and compares them based on the number of matches, priority, and title. 
     * For this method, I am comparing in "reverse" order, so that the larger element goes on top in the priority queue.
     * 
     * @param Website w1 - first website
     * @param Website w2 - second website
     * 
     * @return int - -1, 0, 1, depending on the result of the comparison
     */
    public int compare(Website w1, Website w2) {
        if (w1.getMatches() == w2.getMatches()) {
            if (w1.getPriority().equalsIgnoreCase(w2.getPriority())) {
                if (w1.getTitle().compareTo(w2.getTitle()) == 0) { //all three instance vars are the same
                    return 0; 
                } else if (w1.getTitle().compareTo(w2.getTitle()) > 0) { //first title is larger
                    return -1;
                } else { //first title is smaller
                    return 1;
                }
            } else if (w1.getPriority().equalsIgnoreCase("high")) { //first website has a higher priority
                if (w2.getPriority().equalsIgnoreCase("medium")) { 
                    return -1;
                } else if (w2.getPriority().equalsIgnoreCase("low")) {
                    return -1;
                }
            } else if (w1.getPriority().equalsIgnoreCase("medium")) { 
                if (w2.getPriority().equalsIgnoreCase("high")) { //second website has a higher priority
                    return 1;
                } else if (w2.getPriority().equalsIgnoreCase("low")) { //second website has a lower priority
                    return -1;
                }
            } else if (w1.getPriority().equalsIgnoreCase("low")) { //first website has a lower priority
                if (w2.getPriority().equalsIgnoreCase("high")) {
                    return 1;
                } else if (w2.getPriority().equalsIgnoreCase("medium")) {
                    return 1;
                }
            }
        } else if (w1.getMatches() < w2.getMatches()) { //first website has less matches
            return 1;
        } 
        return -1; //first website has more matches
    }
        
}
