package conversion2;
import java.io.*;
class Zip2{
	public static String FileName = "classes-dex2jar.jar";
	public static String builder(String FileName) {
	try {
	 ProcessBuilder builder = new ProcessBuilder(
			  "cmd.exe", "/c", "cd \"C:\\dex2jar-2.0\" && jar xvf ",FileName);
	 builder.redirectErrorStream(true);
	 Process p = builder.start();
	 BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	 while (true) {
		  String line;
		  line = r.readLine();
		  if (line == null) {break;}
		  System.out.println(line);
	  }
	 }
	catch (IOException e) {
        e.printStackTrace();
    }
	return null;
	}
	
	  public static void main(String[] args)  {
		builder(FileName); 
	  }
}