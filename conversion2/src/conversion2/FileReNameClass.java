package conversion2;
import java.io.*;
public class FileReNameClass{
	public static String FileName = "InsecureBankv2.apk";
	public FileReNameClass() {
		File file = new File("C:\\dex2jar-2.0",FileName);
		
		file.renameTo(new File("C:\\dex2jar-2.0\\InsecureBank2.zip"));
	}
	  public static void main(String[] args) {
		  new FileReNameClass();
		  System.out.println("apk -> zip 파일 변환성공");
	  }
}