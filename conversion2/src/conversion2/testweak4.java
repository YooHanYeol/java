package conversion2;

import java.io.*;

public class testweak4 {

    public static int Log(String path) {
        //  로그에서 확인되지 않은 출력
        //  민감한 정보는 정보가 공개 될 수 있으므로 기록해서는 안됩니다.
        int num = 0;
        try {
            String check = "username + \":\" + DoLogin.this.password)";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    System.out.println("민감정보 로그 취약");
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
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' 로그 확인',' 민감정보 로그 취약 ') ");     	
        return 1;
    }
        else return 0;
    }

    public static void main(String[] args) {
        String path = "C:\\DaJaVa\\InsecureBankv2-classes\\com\\android\\insecurebankv2\\DoLogin.java";
        Log(path);
    }
}