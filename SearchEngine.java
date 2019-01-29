
/**
 * This class has the main method and is reponsible for prompting the user to search.
 *
 * @author (Rebecca Pantano)
 * @version (4/2018)
 */
import java.util.*; 

public class SearchEngine
{
    public static void main (String [] args) {
        if (args.length == 2) {
            SearchEngine s = new SearchEngine();
            String websites = args[0];
            String commonWords = args[1];
            s.run(websites, commonWords);
        } else {
            System.out.println("ERROR: invalid input");
        }
    }
    
    /**
     * run - this method has all the necessary info to run the program
     * 
     * @param String ws - name of the text file with all the websites (input file)
     * @param String cw - name of the text file with all the common words
     * 
     * @return void
     */
    public void run(String ws, String cw) {
        InputReader ir = new InputReader(ws);
        CWReader cwr = new CWReader(cw);
        
        Filter f = new Filter(cwr.getWords());
        Database d = new Database(f);
        Websites w = new Websites(ir.getInfo(), d); 
        d.filterData();
        
        ResultComparator rc = new ResultComparator();
        
        userInput(d, rc, w);
           
    }
    
    /**
     * userInput - this method prompts the user to search and then uses that input to search the database and 
     * return the websites with the most matches
     * 
     * @param Database d - database with all the words from the websites
     * @param ResultComparator rc - comparator for the priority queue with all the websites that match the search
     * @param Websites w - class that contains all the websites the "search engine" has
     * 
     * @return void
     */
    public void userInput(Database d, ResultComparator rc, Websites w) {
        int numOfSearches = 0; 
        String st = "";
        String newSearch = "";        

        Scanner s = new Scanner(System.in);
        
        while(numOfSearches == 0 || newSearch.equalsIgnoreCase("y")) {
            
            System.out.println("Search: ");
            st = s.nextLine();
            
            SearchReturn sr = new SearchReturn(d, rc, w, st);
            
            long startTime = System.nanoTime();
            sr.searchAndReturn();
            long endTime = System.nanoTime();
            
            System.out.println("Time To Search : " + (endTime-startTime));
            
            numOfSearches++;
            System.out.println("New Search? Enter y.");
            String foo = s.nextLine();
            newSearch = new Scanner( foo ).next();
            w.setMatchesToZero();
        
            
        }
        s.close();
    }
    
}
