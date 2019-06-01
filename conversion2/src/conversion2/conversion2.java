package conversion2;
import java.io.*;
class conversion2{
	public static String FileName = "InsecureBankv2.apk";
	public static String builder(String FileName){
	try {
	 ProcessBuilder builder = new ProcessBuilder(
			  "cmd.exe", "/c", "cd \"C:\\dex2jar-2.0\" && d2j-dex2jar.bat ",FileName);
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
	  public static void main(String[] args) {
		String Conversion2Class;
		Conversion2Class = builder(FileName); 
	  }
}