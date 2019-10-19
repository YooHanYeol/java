package conversion2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class testweak {

    public static int Manifest_Provider(String path) {
        // 수출 업체
        // 내보낸 공급자를 찾았습니다. 다른 응용 프로그램에서 사용할 수 있습니다.
        int num = 0;
        try {
            String check = "<provider";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    System.out.println("수출 업체 취약"); }
            num++;
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
        if(num>0) {
        		OpenTable ot = new OpenTable();
        		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 중', ' 수출 업체',' 수출 업체 취약 ') ");
        		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 중', ' 수출 업체2',' 다른 응용 프로그램이 사용 가능한 공급자 발견 ') ");
            return 1;
        }
        else
            return 0;
    }

    public static int Manifest_Receiver(String path) {
        // 수출 수신기
        // 내보낸 수신기를 찾았습니다. 다른 응용 프로그램에서 사용할 수 있습니다.
        int num = 0;
        try {
            String check = " <receiver";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    System.out.println("수신기 취약");
                num++; 
                }
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
        if(num>0){
    		OpenTable ot = new OpenTable();
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 중', ' 수출 수신기',' 수신기 취약 ') ");
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 중', ' 수출 수신기2',' 다른 응용 프로그램이 사용 가능한 수신기 발견 ') ");
        return 1;
    }
        else
            return 0;
    }

    public static int Manifest_Accounts(String path) {
        // 계정 가져 오기 권한
        // 앱이 전화로 알려진 계정 목록을 가져올 수 있도록 허용합니다. 여기에는 설치 한 응용 프로그램에서 만든 계정이 포함될 수 있습니다. 권한이 실제로 필요한지 확인하십시오.
        int num = 0;
        try {
            String check = "android.permission.GET_ACCOUNTS";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    System.out.println("계정 취약");
                num++; }
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
        if(num>0){
    		OpenTable ot = new OpenTable();
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' 계정 가져오기 권한',' 계정 취약 ') "); 
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' 계정 가져오기 권한2',' 전화로 알려진 계정 목록 취득 가능 ') ");
        return 1;
    }
        else
            return 0;
    }

    public static int Manifest_Internet(String path) {
        // 인터넷 허가
        // 앱이 네트워크 소켓을 만들고 사용자 지정 네트워크 프로토콜을 사용할 수 있도록 허용합니다. 브라우저 및 기타 응용 프로그램은 인터넷으로 데이터를 전송하는 수단을 제공하므로 인터넷으로 데이터를 전송하는 데이 권한이 필요하지 않습니다. 권한이 실제로 필요한지 확인하십시오.
        int num = 0;
        try {
            String check = "android.permission.INTERNET";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    System.out.println("인터넷 허가 취약");
                num++;    }
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
        if(num>0){
    		OpenTable ot = new OpenTable();
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' 인터넷 허가',' 인터넷 허가 취약 ') ");  
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' 인터넷 허가2',' 앱이 네트워크 소켓 및 사용자 지정 네트워크 프로토콜 사용 가능 ') ");
        return 1;
    }
        else
            return 0;
    }

    public static int Manifest_Contacts(String path) {
        // 연락처 읽기 권한
        // 앱이 전화, 이메일 또는 특정 방식으로 다른 사람과 통신 한 빈도를 비롯하여 휴대 전화에 저장된 연락처에 대한 데이터를 읽을 수 있도록 허용합니다. 이 권한을 통해 앱은 연락처 데이터를 저장할 수 있으며 악성 앱은 사용자 모르게 연락처 데이터를 공유 할 수 있습니다.
        int num = 0;
        try {
            String check = "android.permission.READ_CONTACTS";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    System.out.println("연락처 취약");
                num++; }
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
        if(num>0){
    		OpenTable ot = new OpenTable();
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' 연락처 읽기 권한',' 연락처 취약 ') "); 
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' 연락처 읽기 권한2',' 앱이 전화에 저장된 연락처 읽기 허용 ') ");
        return 1;
    }
        else
            return 0;
    }
    public static int Manifest_Rstorage(String path) {
        // 외부 저장소 읽기
        // 앱이 SD 카드의 내용을 읽을 수 있도록 허용합니다
        int num = 0;
        try {
            String check = "android.permission.READ_EXTERNAL_STORAGE";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    System.out.println("외부 저장소 읽기 취약");
                num++; }
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
        if(num>0){
    		OpenTable ot = new OpenTable();
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' 외부 저장소 읽기',' 외부 저장소 읽기 취약 ') ");
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' 외부 저장소 읽기2',' 앱이 SD카드 내용 읽기 허용') ");
        return 1;
    }
        else
            return 0;
    }
    public static int Manifest_Wstorage(String path) {
        // 외부 저장소 쓰기
        // 앱이 SD 카드에 쓸 수 있도록 허용합니다.
        int num = 0;
        try {
            String check = "android.permission.WRITE_EXTERNAL_STORAGE";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    System.out.println("외부 저장소 쓰기 취약");
                num++; }
            bufr.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없음");
        } catch (IOException e) {
            System.out.println(e);
        }
        if(num>0){
    		OpenTable ot = new OpenTable();
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' 외부 저장소 쓰기',' 외부 저장소 쓰기 취약 ') ");
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' 외부 저장소 쓰기2',' 앱이 SD카드 내용 쓰기 허용 ') ");
        return 1;
    }
        else
            return 0;
    }


    public static void main(String[] args) {
        String path = "C:\\DaJaVa\\InsecureBankv2\\AndroidManifest.xml";
        Manifest_Provider(path);
        Manifest_Receiver(path);
        Manifest_Accounts(path);
        Manifest_Internet(path);
        Manifest_Contacts(path);
        Manifest_Rstorage(path);
        Manifest_Wstorage(path);
    }
}