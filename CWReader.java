
/**
 * This class reads in the words that should be excluded from the database when saving the words from the text files.
 *
 * @author (Rebecca Pantano)
 * @version (4/15/2018)
 */

import java.util.*;
import java.io.*;

public class CWReader
{
    private File cwFile;
    private ArrayList<String> commonWords;
    private Scanner sc;
        
    public CWReader(String fname)
    {
        cwFile = new File(fname);
        commonWords = new ArrayList<String>();
        cwReader();
    }
    
    /**
     * cwReader- this method scans the common words file and saves them to a container
     * 
     * @param none
     * @return void
     */
    private void cwReader() {
        String line;
        try {
           sc = new Scanner(cwFile);
           while (sc.hasNextLine()) {
               line = sc.nextLine();
               commonWords.add(line);
           }
           sc.close();           
        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e); 
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
    
    /**
     * getInfo- this method returns the common words scanned
     * 
     * @param none
     * @return ArrayList<String> - common words to be excluded
     */
    public ArrayList<String> getWords() {
        return commonWords;
    }

}
