package ChatBot;
import java.util.Scanner;    

import java.io.IOException;     
import java.util.ArrayList;     
import java.io.*;             
 
public class Dictionary implements basic
{
    static ArrayList<String> words;
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = in.nextLine();
        Dictionary obj = new Dictionary();
        s=s.toLowerCase();
        if(obj.wordExists(s) == true)
        {
            System.out.println(message1);
        }   
        else
            System.out.println(message2);
        
    }   
   
    public Dictionary() 
    {
       
        words = new ArrayList<String>();
        readInDictionaryWords();        
    }
    


    public void readInDictionaryWords() 
    {
        
        File dictionaryFile = new File("words.txt");    
        
        if( ! dictionaryFile.exists()) {
            System.out.println("*** Error *** \n" +
                               "Your dictionary file has the wrong name or is " +
                               "in the wrong directory.  \n" +
                               "Aborting program...\n\n");
            System.exit( -1);    // Terminate the program
        }
        try
        {
        Scanner inputFile = new Scanner( dictionaryFile);
         while( inputFile.hasNext()) {
            String line =inputFile.nextLine();
            
            line = line.trim();
           
            words.add(line.toLowerCase() );
            
        }
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
       
    }

    public boolean wordExists(String wordToLookup)
    {
        if( words.contains( wordToLookup)) {
            return true;    // words was found in dictionary
        }
        else {
            return false;   // word was not found in dictionary    
        }
    }

}
