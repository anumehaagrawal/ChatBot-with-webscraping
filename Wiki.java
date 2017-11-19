package ChatBot;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.*;
import java.io.*;

public class Wiki {
    
    public void search(String key) throws InterruptedException {

        URL url;

        try {
            // get URL content

            String a="https://en.wikipedia.org/wiki/"+key;
            url = new URL(a);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));
            Path dest=Paths.get("src/ChatBot/new");
            String inputLine;
            BufferedWriter writer=Files.newBufferedWriter(dest);
            while ((inputLine = br.readLine()) != null) {
            		
            		writer.write(inputLine);
                    writer.newLine();
            }
            br.close();
  
            ExecuteShellCommand ex=new ExecuteShellCommand(key);
            ex.executeCommands();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }
}