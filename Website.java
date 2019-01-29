
/**
 * The class Website is responsible for holding all the necessary info for each website (title, URL, priority, etc)
 * and for scanning in the website content. It is also responsible for adding elements to the Database.
 *
 * @author (Rebecca Pantano)
 * @version (4/15/2018)
 */

import java.util.*;
import java.io.*;

public class Website
{
    
    private File website;
    private String title;
    private String priority;
    private String url;
    private ArrayList<String> data;
    private Database database;
    private int matches;
    
    public Website(String url, String priority, String wname, Database d) {
        this.website = new File(wname);
        this.title = wname;
        this.priority = priority;
        this.url = url;
        this.database = d;
        data = new ArrayList<String>();
        readWebsite();
        addToDatabase();
    }
    
    /**
     * readWebsite - this method scans the text file for the website and saves each word to a temporary ArrayList
     * 
     * @param none
     * @return void
     */
    private void readWebsite() {
        String line;
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(website));
            while((line = reader.readLine()) != null)
            {
                line = line.trim();
                line = line.replaceAll("[^a-zA-z\\s]", "");
                String [] words = line.split(" ");
                for(int i = 0; i<words.length; i++)
                {
                    data.add(words[i]);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e);
        } catch (IOException e) { 
            System.out.println("Exception: " + e);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
    
    /**
     * addToDatabase - cycles through the words in the temp ArrayList and adds them to the TreeMap in Database
     * 
     * @param none
     * @return void
     */
    public void addToDatabase() {
        for (int i = 0; i < data.size(); i++) {
            String temp = data.get(i).toLowerCase();
            database.addValue(temp, this);
        }
    }
    
    /**
     * getTitle - returns title of the website
     * 
     * @param none
     * @return String - website title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * getURL - returns url of the website
     * 
     * @param none
     * @return String- website url
     */
    public String getURL() {
        return url;
    }
    
    /**
     * getPriority - returns the priority of the website
     * 
     * @param none
     * @return String - priority of the website
     */
    public String getPriority() {
        return priority;
    }
    
    /**
     * getMatches - returns number of matches
     * 
     * @param none
     * @return int - number of matches from the search
     */
    public int getMatches() {
        return matches;
    }
    
    /**
     * setMatches - sets number of matches
     * 
     * @param int m - number of matches
     * @return void
     */
    public void setMatches(int m) {
        this.matches = m;
    }
    
    /** 
     * toString - takes all the pertinent data of the class and turns it in a string
     * 
     * @param none
     * @return String - data of the website (title, url, priority, number of matches)
     */
    public String toString() {
        String info = "";
        info = "Title: " + title +  " URL: " + url + " Priority : " + priority + " Matches: " + matches;
        
        return info;
    }
            
}
