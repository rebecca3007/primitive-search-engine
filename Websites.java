
/**
 * The class Websites uses the input file to create new instances of the Website class.
 * 
 * This class has no tests because it only scans a file and gets and sets values
 *
 * @author (Rebecca Pantano)
 * @version (4/15/2018)
 */

import java.util.*;

public class Websites
{
    private ArrayList<String> webInfo;
    private ArrayList<Website> websites = new ArrayList<Website>(); 
    private Scanner sc;
    private String word;
    private ArrayList<String> info;
    
    
    public Websites(ArrayList<String> wInfo, Database d) {
       webInfo = wInfo;  
       info = new ArrayList<String>();
       websites = createWebsites(d);
    }
    
    /**
     * createWebsites: this method scans the input file and uses it to create an instance of website 
     * for each line in the file
     * 
     * @param Database d - takes the object of database taken by the constructor and then passes it to the Website object
     * @return ArrayList<Website> - all the websites given by the input file so that whenever the Websites constructor is 
     * called, the websites will be generated
     */
    private ArrayList<Website> createWebsites(Database d) {
        for (int i = 0; i < webInfo.size(); i++) {
            sc = new Scanner(webInfo.get(i));
            while(sc.hasNext()) {
                word = sc.next().trim();
                info.add(word);
            }
            sc.close();    
            websites.add(new Website(info.get(0), info.get(1), info.get(2), d));
            info = new ArrayList<String>();
        }
        return websites;
    }
    
    /**
     * getWebsiteList - returns an array list of all the websites in the program
     * 
     * @param none
     * @return ArrayList<Website> - all the websites the program contains
     */
    public ArrayList<Website> getWebsiteList() {
        return websites;
    }
    
    /** 
     * setMatchesToZero - resets the matches of each website after each user search
     * 
     * @param none
     * @return void
     */
    public void setMatchesToZero() {
        for (int i = 0; i < websites.size(); i++) {
            websites.get(i).setMatches(0);
        }
    }
        
    
    
    
}
