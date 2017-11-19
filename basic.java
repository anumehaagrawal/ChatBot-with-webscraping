package ChatBot;

interface basic
{
    String message1 = "The word does exist!";
    String message2 = "The word does not exist";
   
    public void readInDictionaryWords();// throws IOException
    

    public boolean wordExists(String wordToLookup);
    

}
