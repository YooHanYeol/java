package conversion2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Weak2 {

    public static int PostLogin_Rooting(String path) {
        // 루팅탐지 (PostLogin.java 파일에서 확인 가능)
        // 사용자가 Root권한을 획득하여 시스템을 사용가능
    	int num = 0;
        try {
        	int i = 0;
        	int count = 0;
            String check = "/system/app/Superuser.apk";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    // 라인 중 /system/app/Superuser.apk 포함한 라인 찾음
                	i++;
					count = i;
            }
            if (i > 0)
            {
            System.out.println("노출된 루팅 갯수 : "+count+" -> 취약");
            num++;
            }
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
        if(num>0)
        	return 1;
        else
        	return 0;
    }

    public static int PostLogin_Su(String path) {
        // Su 권한 확인 (PostLogin.java 파일에서 확인 가능)
        // 응용 프로그램이 시스템 명령을 실행할 수 있습니다.
    	int num = 0;
        try {
        	String check = "/system/xbin/which\", \"su";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    // 라인 중 "/system/xbin/which", "su" 포함한 라인 찾음
                    System.out.println("시스템 명령 실행중 -> 취약");
                	num++;
            }
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
        if(num>0)
        	return 1;
        else
        	return 0;
    }
    
    public static void main(String[] args) {
        String path = "C:\\apktool\\InsecureBankv2-dex2jar.jar.src\\com\\android\\insecurebankv2\\PostLogin.java";
        PostLogin_Rooting(path);
        PostLogin_Su(path);

    }
}