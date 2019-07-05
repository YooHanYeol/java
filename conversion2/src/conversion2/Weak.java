package conversion2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Weak {

    public static void Manifest_Debug(String path) {
        // 디버그 모드 확인 (AndroidManifest.xml 파일에서 확인 가능)
        // 디버그 모드면 외부에서 임의의 코드를 주입 가능, 개발시에만 사용해야함
        try {
            String check = "android:debuggable=\"true\"";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    // 라인 중 android:debuggable="true" 포함한 라인 찾음
                    System.out.println("디버그 모드 작동 중 -> 취약");
            }
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void Manifest_Backup(String path) {
        // 백업 허용 확인 (AndroidManifest.xml 파일에서 확인 가능)
        // 악의적 사용자가 adb를 사용하여 앱의 개인 데이터를 자신의 PC에 가져올 수 있음.
        try {
            String check = "android:allowBackup=\"true\"";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    // 라인 중 android:allowBackup="true" 포함한 라인 찾음
                    System.out.println("adb를 통해 백업 허용 중 -> 취약");
            }
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void Manifest_Location(String path) {
        // 사용자의 위치 정보 접근 확인 (AndroidManifest.xml 파일에서 확인 가능)
        // Wi-Fi와 같은 네트워크 위치 소스를 통해 위치 얻어짐. 기본 권한으로 설정되어 있으면 위험함.
        try {
            String check = "android.permission.ACCESS_COARSE_LOCATION";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    // 라인 중 android.permission.ACCESS_COARSE_LOCATION 포함한 라인 찾음
                    System.out.println("위치 정보 접근 허용 -> 취약");
            }
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public static void Manifest_Phone(String path) {
        // Phone 권한 확인 (AndroidManifest.xml 파일에서 확인 가능)
        // 장치의 전화번호, 네트워크정보, 진행중인 통화의 상태 읽어오기, 사용자의 통화 기록 읽기 가능
        try {
            String check = "android.permission.READ_CALL_LOG";
            String check2 = "android.permission.READ_PHONE_STATE";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    // 라인 중 android.permission.READ_CALL_LOG 포함한 라인 찾음
                    System.out.println("사용자의 통화 기록 읽기 허용 -> 취약");
                if (line.contains(check2))
                	// 라인 중 android.permission.READ_PHONE_STATE 포함된 라인 찾음
                	System.out.println("장치의 전화 번호, 네트워크 정보, 진행중인 통화의 상태 읽어오기 허용 -> 취약");
            }
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public static void Manifest_Activity(String path) {
        // 액티비티 컴포넌트 확인 (AndroidManifest.xml 파일에서 확인 가능)
        // 다른 에플리케이션의 Activity를 실행 할 수 있음.
    	try {
    		int i = 0;
    		int count = 0;
            String check = "activity android:exported=\"true\"";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                
				if (line.contains(check))
                    // 라인 중 android:exported="true" 포함한 라인 찾음
                    //System.out.println("다른 애플리케이션의 Activity 실행가능 -> 취약");
                	i++;
					count = i;
            }
            if (i > 0)
            {
            System.out.println("노출된 Activity 갯수 : "+count+" -> 취약");
            }
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String path = "C:\\apktool\\InsecureBankv2\\AndroidManifest.xml";
        Manifest_Debug(path);
        Manifest_Backup(path);
        Manifest_Location(path);
        Manifest_Phone(path);
        Manifest_Activity(path);
    }
}