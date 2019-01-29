
/**
 * The class WebsiteComparator compares two websites first in terms of their priority and then, 
 * if it finds that their priorities match, compares them alphabetically by URL.
 *
 * @author (Rebecca Pantano)
 * @version (4/15/2018)
 */

import java.util.*;

public class WebsiteComparator implements Comparator<Website>
{
    
    public WebsiteComparator()
    {
        
    }

    /**
     * compare - this method compares two websites based on their priority and url
     * 
     * @param Website w1 - first website
     * @param Website w2 - second website
     * 
     * @return int - -1, 0, 1, based on the result of comparing
     */
    public int compare(Website w1, Website w2) {
        if (w1.getPriority().equalsIgnoreCase(w2.getPriority())) {
            if (w1.getURL().compareTo(w2.getURL()) == 0) { //url and priority are the same
                return 0;
            } else if (w1.getURL().compareTo(w2.getURL()) > 0) { //url of first is greater
                return 1;
            } else { //url of second is greater
                return -1;
            }
        } else if (w1.getPriority().equalsIgnoreCase("high")) { //priority of 1st is greater
            if (w2.getPriority().equalsIgnoreCase("medium")) {
                return 1;
            } else if (w2.getPriority().equalsIgnoreCase("low")) {
                return 1;
            }
        } else if (w1.getPriority().equalsIgnoreCase("medium")) { 
            if (w2.getPriority().equalsIgnoreCase("high")) { //priority of 2nd is greater
                return -1;
            } else if (w2.getPriority().equalsIgnoreCase("low")) { //priority of 1st is greater
                return 1;
            }
        } else if (w1.getPriority().equalsIgnoreCase("low")) { //prioirty of 2nd is greater
            if (w2.getPriority().equalsIgnoreCase("high")) {
                return -1;
            } else if (w2.getPriority().equalsIgnoreCase("medium")) {
                return -1;
            }
        }
        return 0;
        
    }
}
