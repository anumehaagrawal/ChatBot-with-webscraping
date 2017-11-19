package ChatBot;
import java.io.IOException;
import java.util.*;
public class chatBot {

		
		final static String puncs = "?!.;,";
		static HashMap<Integer,ArrayList<Integer>> counter=new HashMap<Integer,ArrayList<Integer>>();  
		static boolean isPunc(char ch) {
			return puncs.indexOf(ch) != -1;
		}
	


		static String find_match(String str)
		{
			
			int matchLength=-1;
			String resp="";
			String finalResp="";
			for(int j=0;j<ChatKnow.KnowledgeBase.length;j++)
				for(int t=0;t<ChatKnow.KnowledgeBase[j][0].length;t++)
				{	int test=keywordMatch(ChatKnow.KnowledgeBase[j][0][t],str);
					if(ChatKnow.KnowledgeBase[j][0][t].equalsIgnoreCase(str) || test!=-1)
					{
							Random rand=new Random();
							int i=rand.nextInt(ChatKnow.KnowledgeBase[j][1].length);
							if(!counter.containsKey(j)){
								ArrayList<Integer> count=new ArrayList<>();
								if(ChatKnow.KnowledgeBase[j][0][t].equalsIgnoreCase(str))
									count.add(i);
									counter.put(j,count);
								resp=ChatKnow.KnowledgeBase[j][1][i];
							}
							else
							{
								ArrayList<Integer> temp=new ArrayList<>();
								temp=counter.get(j);
								if(!temp.contains(i))
								{	
										if(ChatKnow.KnowledgeBase[j][0][t].equalsIgnoreCase(str))
										{
											temp.add(i);
											counter.put(j,temp);
										}
										resp=ChatKnow.KnowledgeBase[j][1][i];
								}
								else
								{
										int newResp;
										if(temp.size()!=ChatKnow.KnowledgeBase[j][1].length)
										{
											while(true)
											{
												newResp =rand.nextInt(ChatKnow.KnowledgeBase[j][1].length);
												if(newResp!=i) {resp=ChatKnow.KnowledgeBase[j][1][newResp];break;}
													
											}
										}
										else
										{
											newResp=rand.nextInt(ChatKnow.KnowledgeBase[j][1].length);
											resp=ChatKnow.KnowledgeBase[j][1][newResp];
										}
										if(ChatKnow.KnowledgeBase[j][0][t].equalsIgnoreCase(str))
										{	
											temp.add(newResp);
											counter.put(j,temp);
										}	
								}
							}
					}
					
					if(ChatKnow.KnowledgeBase[j][0][t].equalsIgnoreCase(str) )
					{	
						
						return resp;
					}
					else if(test!=-1)
					{
						if(test>matchLength)
						{
							matchLength=test;
							finalResp=resp;

						}
					}
				}
			if(finalResp!=null)
			for(int j=0;j<ChatKnow.KnowledgeBase.length;j++)
				for(int i=0;i<ChatKnow.KnowledgeBase[j][1].length;i++)
				{
					if(ChatKnow.KnowledgeBase[j][1][i].equals(finalResp))
					{	ArrayList<Integer> temp=new ArrayList<Integer>();
						if(!counter.containsKey(j))
							temp.add(i);							
						else
						{	temp=counter.get(j);
							temp.add(i);
						}
						counter.put(j,temp);
						
					}
				}
			return finalResp;
		}
		


		static int  keywordMatch(String s1,String s2)
		{
			
			String sub="";
			String base="";
			if(s1.length()> s2.length())
			{
				sub=s2;
				base=s1;
			}
			else
			{
				sub=s1;
				base=s2;
			}
			String[] stripSub=sub.split(" ");
			String[] stripBase=base.split(" ");
			int matchLength=stripSub.length;
			for(;matchLength>0;matchLength--)
			{
				for(int j=0;j<stripSub.length-matchLength+1;j++)
				{	String temp="";
					for(int k=j;k<j+matchLength;k++)
							temp+=(stripSub[k]+" ");
					for(int t=0;t<stripBase.length-matchLength+1;t++)
					{	String temp2="";
						for(int x=t;x<t+matchLength;x++)
							temp2+=(stripBase[x]+" ");
						if(temp2.equalsIgnoreCase(temp))
							return matchLength;
					}
					
						
				}
			}
			
			
			return -1;
		}

		static String cleanString(String str) {

			StringBuffer temp = new StringBuffer(str.length());
			char prevChar = 0;
			for(int i = 0; i <str.length(); ++i) {
				if(str.charAt(i) == ' ' && prevChar == ' ' ) {
					continue;
				} else if(!isPunc(str.charAt(i))) {
					temp.append(str.charAt(i));
				}
				prevChar = str.charAt(i);
			}
			return temp.toString();
		}
			
		

		public static void main(String args[]) throws Exception{

			Scanner scan=new Scanner(System.in);
			while(true){
				
				System.out.print('>');
	
				String input=scan.nextLine();
				if(input.equalsIgnoreCase("BYE")){
					String response="BYE-BYE!";
					System.out.println('>'+response);
					break;
				}
				String temp=cleanString(input);
				String response=find_match(temp);
				if(response.length()==0){
					System.out.println(">"+"I DONT UNDERSTAND YOU");
				}
				else if (response.equals("1"))
				{	String[] key=input.split(" ");
					getFunData ob=new getFunData();
					System.out.println(ob.search(key[key.length-2]));
				}
				else if (response.equals("2"))
				{
					getFunData ob=new getFunData();
					System.out.println(ob.getJoke());
				}
				else if (response.equals("3"))
				{
					String[] key=input.split(" ");
					WikiImages wik=new WikiImages(key[key.length-2]);
					wik.imagesearch();
				}
				else if(response.equals("4"))
				{
					
					String[] key=input.split(" ");
					Wiki wik=new Wiki();
					wik.search(key[key.length-2]);
				}
				else if(response.equals("5"))
				{

					String[] key=input.split(" ");
					WikiImage wik=new WikiImage(key[key.length-2]);
					wik.imagesearch();
				}
				else if (response.equals("6"))
                {
                    String[] key=input.split(" ");
                    String s = key[key.length-1];
                    Dictionary obj = new Dictionary();
                    s=s.toLowerCase();
                    if(obj.wordExists(s) == true)
                    {
                        System.out.println("word exists");
                    }  
                    else
                        System.out.println("word doesnt exist");
                }




				
				else
					System.out.println(">"+response);
				

			}
			scan.close();
		
		}
		
	
}
