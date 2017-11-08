import java.io.*;
import java.util.*;
public class chatbot{

	static String[][] KnowledgeBase = {
		{"WHAT IS YOUR NAME", 
		 "MY NAME IS CHATBOT"
		},
		
		{"HI", 
		 "HI THERE!"
		},
		
		{"HOW ARE YOU", 
		 "I'M DOING FINE!"
		},
		  
		{"WHO ARE YOU", 
		 "I'M AN A.I PROGRAM."
		},

		{"ARE YOU INTELLIGENT", 
		 "YES,OFCORSE."
		},
		   
		{"ARE YOU REAL", 
		 "DOES THAT QUESTION REALLY MATERS TO YOU?"
		}
	};
	static String find_match(String str){
		String resp="";
		for(int j=0;j<KnowledgeBase.length;j++){
			if(KnowledgeBase[j][0].equalsIgnoreCase(str)){
				resp=KnowledgeBase[j][1];

			}
		}
		return resp;
	}

	public static void main(String args[]){
		for(int i=0;i<5;i++){
			System.out.print('>');
			Scanner scan=new Scanner(System.in);
			String input=scan.nextLine();
			String response=find_match(input);
			if (response.length()==0){
				response="I DONT UNDERSTAND YOU";
			} 
			System.out.println('>'+response);
		}
	}
	
}