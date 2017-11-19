package ChatBot;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class getFunData extends getFunDataAbstract {

		private List<movieData> movieFile=new ArrayList<movieData>();
		private List<String> jokeList= new ArrayList<String>();
		
		public getFunData() throws IOException
		{	
			Path movies=Paths.get("movieDB.csv");
			BufferedReader br= Files.newBufferedReader(movies);
			String li=br.readLine();
			while(li!=null)
			{	
				String[] columnData=li.split(",");	
				movieData temp=new movieData(columnData);
				movieFile.add(temp);
				li=br.readLine();

			}
			
			Path  jokes=Paths.get("jokes.csv");
			br= Files.newBufferedReader(jokes);
			li=br.readLine();
			while(li!=null)
			{	
				jokeList.add(li);
				li=br.readLine();
			}

		}
		
		public String search(String key)
		{
			for(int i=0;i<movieFile.size();i++)
				if(key.equalsIgnoreCase(movieFile.get(i).Title))
					return movieFile.get(i).toString();
				else if(movieFile.get(i).Title.toLowerCase().replaceAll(" ","").contains(key.toLowerCase().replaceAll(" ", "")))
					return movieFile.get(i).toString();
			return "That is not a popular movie.Sorry!";
			

		}
		public String getJoke()
		{
			Random rand=new Random();
			int i=rand.nextInt(850);
			return jokeList.get(i);
		}
		public static void main(String[] args) throws IOException
		{
			Scanner in=new Scanner(System.in);
			String input=in.nextLine();
			getFunData ob=new getFunData();
			System.out.println(ob.search(input));
			in.close();
		}
		
}
	
class movieData {
		public String Title;
		public String Revenue;
		public String Genre;
		public String Rating;
		
		public movieData(String[] columnData)
		{
				Revenue=columnData[0];
				Title=columnData[1];
				Genre=columnData[3];
				Rating=columnData[2];
		}
		@Override
		public String toString()
		{
			return "Title:"+Title+"\nGenre: "+Genre+"\nRating: "+Rating;
		}

}





