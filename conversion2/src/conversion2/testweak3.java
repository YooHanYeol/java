package conversion2;

import java.io.*;

public class testweak3 {

    public static int SMS(String path) {
        //  사용자 몰래 sms,mms 보내는지 체크 (MyBroadCastReceiver.java에서 확인함)
        int num = 0;
        try {
            String check = "SmsManager";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    System.out.println("SmsManager 사용 -> 취약");
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
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' SMS 체크',' SmsManager 사용 ') ");     	
        return 1;
    }
        else return 0;
    }

    public static int Catch(String path) {
        //  catch의 일반 예외
        //예외 포착은 구체적이어야합니다. 일반 예외 유형이 안전하지 않아 자동 오류 방지로 이어짐
        int num = 0;
        try {
            String check = "catch (Exception paramContext)";

            File f = new File(path);
            FileReader fr = new FileReader(String.valueOf(f));
            BufferedReader bufr = new BufferedReader(fr);
            String line = "";
            while ((line = bufr.readLine()) != null) {
                if (line.contains(check))
                    System.out.println("catch 예약 취약");
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
    		ot.update("INSERT INTO result2 (Grade,Name,Content)" + "VALUES(' 상', ' catch의 일반 예외',' catch 예약 취약 ') ");     	
        return 1;
    }
        else return 0;
    }

    public static void main(String[] args) {
        String path = "C:\\DaJaVa\\InsecureBankv2-classes\\com\\android\\insecurebankv2\\MyBroadCastReceiver.java";
        SMS(path);
        Catch(path);
    }
}