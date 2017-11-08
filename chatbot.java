package chat;
import java.io.*;
import java.util.*;
public class chatbot{
	
	final static String puncs = "?!.;,";
	static HashMap<Integer,ArrayList<Integer>> counter=new HashMap<Integer,ArrayList<Integer>>();  
	static boolean isPunc(char ch) {
		return puncs.indexOf(ch) != -1;
	}


	static String find_match(String str){
		
		String resp="";
		for(int j=0;j<chatknow.KnowledgeBase.length;j++){
			if(chatknow.KnowledgeBase[j][0].equalsIgnoreCase(str)){
				Random rand=new Random();
				int i=rand.nextInt(3)+1;
				if(!counter.containsKey(j)){
					ArrayList<Integer> count=new ArrayList<>();
					count.add(i);
					counter.put(j,count);
					resp=chatknow.KnowledgeBase[j][i];
				}
				else{
					ArrayList<Integer> temp=new ArrayList<>();
					temp=counter.get(j);
					if(!temp.contains(i)){
						resp=chatknow.KnowledgeBase[j][i];
					}
					else{
						int k;
						if(i==3){
							k=1;
						}
						else if(i==2){
							k=3;
						}
						else{
							k=2;
						}
						resp=chatknow.KnowledgeBase[j][k];
						}
					}
				}
				

			}
			return resp;
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
		
	

	public static void main(String args[]){
		for(int i=0;i<5;i++){
			System.out.print('>');
			Scanner scan=new Scanner(System.in);
			String input=scan.nextLine();
			String temp=cleanString(input);
			String response=find_match(temp);
			if(response.length()==0){
				response="I DONT UNDERSTAND YOU";
			}
			if(input.equalsIgnoreCase("BYE")){
				response="BYE";
				System.out.println('>'+response);
				break;
			}
			System.out.println('>'+response);
		}
	}
	
}
