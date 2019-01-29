
/**
 * This class reads in the input file with all the website information.
 *
 * @author (Rebecca Pantano)
 * @version (4/15/2018)
 */

import java.util.*;
import java.io.*;

public class InputReader
{
    private File input;
    private String websiteInfo;
    private ArrayList<String> totalInfo;
    private Scanner sc;
    private Scanner wsc;

    public InputReader(String fname)
    {
       input = new File(fname);
       websiteInfo  = "";
       totalInfo = new ArrayList<String>();
       inputReader();
    }

    /**
     * inputReader- this method scans the input file and breaks it up, first into lines representing websites 
     * and then into words representing the title, priority, and url of the website
     * 
     * @param none
     * @return void
     */
    private void inputReader() {
        String line;
        String word;
        try {
            sc = new Scanner(input);
            while (sc.hasNextLine()) {
                line = sc.nextLine().trim();
                wsc = new Scanner(line); 
                while (wsc.hasNext()) {
                    word = wsc.next().trim();
                    websiteInfo = websiteInfo + word + " ";
                }
                totalInfo.add(websiteInfo);
                websiteInfo = "";
                wsc.close();  
            }
            sc.close();
        } catch(FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e);
        } catch (IOException e) {
            System.out.println("IOException: " + e); 
        } 
        
    }
    
    /**
     * getInfo- this method returns the info scanned
     * 
     * @param none
     * @return ArrayList<String> - the info parsed from the input file
     */
    public ArrayList<String> getInfo() {
        return totalInfo;
    }
    
}
