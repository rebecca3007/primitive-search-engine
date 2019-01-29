
/**
 * The class SearchReturn will receive and analyze the user input and search the database.
 *
 * @author (Rebecca Pantano)
 * @version (4/15/2018)
 */
import java.util.*;
import java.io.*;

public class SearchReturn
{
    
    private Websites w;
    private Database database;
    private String searchTerm;
    private String term;
    private ArrayList<String> and = new ArrayList<String>();
    private ArrayList<String> or = new ArrayList<String>();
    private PriorityQueue<Website> searchResults;
    private PriorityQueue<Website> temp;
    
    public SearchReturn(Database d, ResultComparator rc, Websites w, String s) {
        database = d;
        searchResults = new PriorityQueue<Website>(rc);
        this.w = w; 
        searchTerm = s;
    }
    
    /**
     * search: this method uses the user input and separates it into the words before the "or" and after the "or"
     * whether or not "or" exists.
     * 
     * @param none
     * @return void
     */
    public void search() {
        Scanner sc;

        try {
            ArrayList<String> currentList = and; //current list starts out being "and"
            sc = new Scanner(searchTerm);
            while (sc.hasNext()) {
                term = sc.next();
                if (!term.equalsIgnoreCase("or")) { //if the term is not or
                    if (!term.equalsIgnoreCase("and")) { //if the term is not and
                        currentList.add(term); 
                    }
                } else {
                    currentList = or; //if the term is or, the current list is switched to "or"
                }
            } 
            sc.close();
        } catch (NoSuchElementException e) {
            System.out.println("no search term");
        }
        
    }
    
    /**
     * searchAnd - this method searches for the words before the "or" in the database
     * 
     * @param none
     * @return void
     */
    public void searchAnd() {
        for (int i = 0; i < and.size(); i++) {
            String searchFor = and.get(i);
            if (searchFor.charAt(0) == '-') {
                //if the word not being searched for (due to a negation) exists in the database this block of code
                //finds the websites that don't contain it and adds 1 to their number of matches
                searchFor = searchFor.substring(1);
                if (database.contains(searchFor) != null) {
                    temp = database.contains(searchFor);
                    for (int j = 0; j < w.getWebsiteList().size(); j++) {
                        Website ws = w.getWebsiteList().get(j);
                        if (!temp.contains(ws)) {
                            int prevMatches = ws.getMatches();
                            int newMatches = prevMatches + 1;
                            ws.setMatches(newMatches);
                        }
                    }
                }
            } else {
                if (database.contains(searchFor) != null) {
                    //if the word being searched for exists in the database this block of code
                    //finds the websites that don't contain it and adds 1 to their number of matches
                    temp = database.contains(searchFor);
                    for (int j = 0; j < w.getWebsiteList().size(); j++) {
                        Website ws = w.getWebsiteList().get(j);
                        if (temp.contains(ws)) {
                            int prevMatches = ws.getMatches();
                            int newMatches = prevMatches + 1;
                            ws.setMatches(newMatches);
                        }
                    }
                
                }
            }
        }        
    }
    
    /**
     * searchOr - this method searches for the words after the "or" in the database
     * 
     * @param none
     * @return void
     */
    public void searchOr() {
        for (int i = 0; i < or.size(); i++) {
            String searchFor = or.get(i);
            if (searchFor.charAt(0) == '-') {
                //if the word not being searched for (due to a negation) exists in the database this block of code
                //finds the websites that don't contain it and adds 1 to their number of matches
                searchFor = searchFor.substring(1);
                if (database.contains(searchFor) != null) {
                    temp = database.contains(searchFor);
                    for (int j = 0; j < w.getWebsiteList().size(); j++) {
                        Website ws = w.getWebsiteList().get(j);
                        if (!temp.contains(ws)) {
                            int prevMatches = ws.getMatches();
                            int newMatches = prevMatches + 1;
                            ws.setMatches(newMatches);
                        }
                    }
                }
            } else {
                //if the word being searched for exists in the database this block of code
                //finds the websites that contain it  and adds 1 to their number of matches
                if (database.contains(searchFor) != null) { 
                    temp = database.contains(searchFor);
                    for (int j = 0; j < w.getWebsiteList().size(); j++) {
                        Website ws = w.getWebsiteList().get(j);
                        if (temp.contains(ws)) {
                            int prevMatches = ws.getMatches();
                            int newMatches = prevMatches + 1;
                            ws.setMatches(newMatches);
                        }
                    }
                
                }
            }
        }        
        
    }
    
    /**
     * assessResult - this method "sorts" all the websites by adding them to a priority queue that uses 
     * ResultComparator as its comparator
     * 
     * @param none
     * @return void
     */
    public void assessResult() {
        ArrayList<Website> ws = w.getWebsiteList();
        
        for (int i = 0; i < ws.size(); i++) {
            searchResults.add(ws.get(i));
        }
        
    }
    
    /**
     * assessResult - this method removes the first 5 elements (the ones that match the search the most)
     * from the priority queue
     * 
     * @param none
     * @return void
     */
    public void returnResult() {
        Website tempW;
        
        for (int i = 1; i < 6; i++) {
            tempW = searchResults.poll();
            System.out.println("Result " + i + ": " + tempW.toString());
        }
    }
    
    /**
     * searchAndReturn - this method calls all the methods necessary to search the database and respond to the 
     * user query 
     * 
     * @param none
     * @return void
     */
    public void searchAndReturn() {
        search();
        searchAnd();
        searchOr();
        assessResult();
        returnResult();
    }
            
    
}
