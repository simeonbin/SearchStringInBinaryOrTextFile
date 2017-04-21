/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simeon
 */

    import java.util.regex.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Print all the strings that match a given pattern from a file.
 */
public class SearchStringInBinaryOrTextFile {    
    static ArrayList<String> patternList = new ArrayList<>(25);
    static ArrayList<String> fileList = new ArrayList<>(25);
    
    
  public static void main(String[] args) throws IOException {
      int linenum = 0; int numOfOccur = 0;
      
    patternList.add("Alice");  patternList.add("Hello");  patternList.add("world");
    patternList.add("Solarwinds");  patternList.add("Sherlock");  patternList.add("EULA");
    patternList.add("Lorem");  patternList.add("Trust");  patternList.add("Watson"); 
     patternList.add("failure");  patternList.add("Hatter");  patternList.add("success"); 
      
    fileList.add("pg11.txt");  fileList.add("pg1661.txt");  fileList.add("lorem.txt");
    fileList.add("cacerts");  fileList.add("solarwinds.png");  fileList.add("story.jpg");
    fileList.add("eula.rtf"); 
      
    // The RE pattern
  //  Pattern patt = Pattern.compile("[A-Za-z][a-z]+");
  
    for (int iPattern=0; iPattern < patternList.size(); iPattern++ ) {
        
    String patternString = patternList.get(iPattern);
    System.out.println("String Pattern Searched: " + patternString );    
  
    Pattern patt = Pattern.compile(patternString);
    
    for (int iFile=0; iFile < fileList.size(); iFile++) {
        
        numOfOccur = 0;
        String fileString = fileList.get(iFile);
        System.out.println("File Searched: " + fileString );
        
    // Use of  FileReader and BufferedReader
    BufferedReader r = new BufferedReader(new FileReader(fileString));

    // For each line of input, try matching in it.
    String line;
    while ((line = r.readLine()) != null) {
        
      linenum++;
      // For each match in the line, extract and print it.
      Matcher m = patt.matcher(line);
      
      while (m.find()) {
          numOfOccur++;
          
       //  System.out.println(m.group(0));

        // Get the starting position of the text
        int start = m.start(0);
        // Get ending position
        int end = m.end(0);
        
        // Print whatever matched.
        // Use CharacterIterator.substring(offset, end);
        System.out.println(line.substring(start, end));
        System.out.println(" Line is: " + line);
        System.out.println(" Line #: " + linenum + " Starting Position: " + start);
        
      } // end while
      
    }  // end while
    
    System.out.println("----------------------------------");
    System.out.println("Number of Occurences: " + numOfOccur);
    System.out.println("===================================");
    System.out.println();
    System.out.println();
    
     } // end for iFile
    
    } // end for iPattern
    
  } // end main  
  
}   // end class


    
    
    

