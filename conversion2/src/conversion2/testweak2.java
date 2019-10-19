package conversion2;

import java.io.*;

public class testweak2 {

    public static int Base64Encode(String path) {
        //  Base64 인코딩 (CryptoClass.java 에서 확인함)
        //  Base64 인코딩 방법은 안전한 인코딩 방법이 아님
        int num = 0;
        try {
            String check = "Base64.encode";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    System.out.println("Base64 인코딩 사용 -> 취약");
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
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' Base64 인코딩',' Base64 인코딩 사용 ') ");     	
        return 1;
    }
        else return 0;
    }

    public static int Base64Decode(String path) {
        //  Base64 디코드 (CryptoClass.java 에서 확인함)
        int num = 0;
        try {
            String check = "Base64.decode";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    System.out.println("Base64 디코드 사용 -> 취약");
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
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' Base64 디코드',' Base64 디코드 사용 ') ");     	
        return 1;
    }
        else return 0;
    }

    public static void main(String[] args) {
        String path = "C:\\DaJaVa\\InsecureBankv2-classes\\com\\android\\insecurebankv2\\CryptoClass.java";
        Base64Encode(path);
        Base64Decode(path);
    }
}
