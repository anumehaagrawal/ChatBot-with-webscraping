package ChatBot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WikiImage {


	String word="";
	public WikiImage(String word)
	{	
		this.word=word;
	
	}

    public void imagesearch() throws Exception
    {
        

        String url="https://www.dreamstime.com/free-photos-images/"+word+".html";
        Document document = Jsoup.connect(url).get();

        String text = document.select("div").first().text();
        System.out.println(text);

       Elements img = document.getElementsByTag("img");

       			int count=0;
                for (Element el : img) {
                	count++;
                	if(count>5) break;
                    //for each element get the src url

                    String src = el.absUrl("src");

                    System.out.println("Image Found!");

                    System.out.println("src attribute is : "+src);             
            
                }


    }
}
