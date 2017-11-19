package ChatBot;
import java.io.*;


public class ExecuteShellCommand {
	String key="";
	public ExecuteShellCommand(String key)
	{
		this.key=key;
	}
	public void executeCommands() throws IOException, InterruptedException {
	
	    File tempScript = createTempScript();
	
	    try {
	        ProcessBuilder pb = new ProcessBuilder("bash", tempScript.toString(),key);
	        pb.inheritIO();
	        Process process = pb.start();
	        process.waitFor();
	    } finally {
	        tempScript.delete();
	    }
	}
	
	public String executeCommand(String command)
	{
		 {

		    StringBuffer output = new StringBuffer();

		    Process p;
		    try {
		        p = Runtime.getRuntime().exec(command);
		        p.waitFor();
		        BufferedReader reader = 
		                        new BufferedReader(new InputStreamReader(p.getInputStream()));

		        String line = "";           
		        while ((line = reader.readLine())!= null) {
		            output.append(line + "\n");
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return output.toString();

		}

	}
	
	public File createTempScript() throws IOException {
	
	    File tempScript = File.createTempFile("script", null);
	
	    Writer streamWriter = new OutputStreamWriter(new FileOutputStream(
	            tempScript));
	    PrintWriter printWriter = new PrintWriter(streamWriter);
	
	    printWriter.println("cp /home/ram_aditya/eclipse-workspace/ChatBot/src/ChatBot/new /home/ram_aditya/eclipse-workspace/ChatBot/temp");
	    printWriter.println("sed 's/<[^>]\\+>/ /g' temp > new1");
	    printWriter.println("grep -i $1.* new1  | sed '/{/d' - |tr -s '\t ' | sed -n -f instr | head -n4 > new2");
	    printWriter.println("sed -i '/disambiguation/d' new2");
	    printWriter.println("sed -i -f instr2 new2");
	    printWriter.println("cat new2");

	    printWriter.close();
	
	    return tempScript;
	}

	
	
}