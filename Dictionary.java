package chat;
import java.util.Scanner;    

import java.io.IOException;     
import java.util.ArrayList;     
import java.io.*;               
 
public class Dictionary
{
    static ArrayList<String> words;
    
    public static void main(String args[])throws IOException
    {
        DataInputStream in = new DataInputStream(System.in);
        System.out.println("Enter the string");
        String s = in.readLine();
        Dictionary obj = new Dictionary();
        s=s.toLowerCase();
        if(obj.wordExists(s) == true)
        {
            System.out.println("The word does exist!");
        }   
        else
            System.out.println("The word does not exist");
        
    }   
   
    public Dictionary() throws IOException
    {
       
        words = new ArrayList<String>();
        readInDictionaryWords();        
    }
    


    public void readInDictionaryWords() throws IOException
    {
        
        File dictionaryFile = new File("words.txt");    
        
        if( ! dictionaryFile.exists()) {
            System.out.println("*** Error *** \n" +
                               "Your dictionary file has the wrong name or is " +
                               "in the wrong directory.  \n" +
                               "Aborting program...\n\n");
            System.exit( -1);    // Terminate the program
        }
        Scanner inputFile = new Scanner( dictionaryFile);
       
        while( inputFile.hasNext()) {
            String line =inputFile.nextLine();
            
            line = line.trim();
           
            words.add(line.toLowerCase() );
            
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
