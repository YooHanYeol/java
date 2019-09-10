package conversion2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OpenTable {
	java.sql.Connection con = null;
    // 데이터베이스와 연결을 위한 객체
    java.sql.Statement stmt = null;
    // SQL문을 데이터베이스에 보내기위한 객체
    java.sql.ResultSet rs = null;
    // SQL문 질의에 의해 생성된 테이블을 저장하는 객체
    
    String driver = "com.mysql.jdbc.Driver";
    //JDBC Driver Class = com.mysql.jdbc.Driver
    
    OpenTable(){
    	connect();
    }
    
	void connect() {
 
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String pw = "1234";

        // 데이터베이스에 연결하기위한 정보
        
        try {
        	Class.forName(driver);
        	this.con = java.sql.DriverManager.getConnection(url, user, pw);
        	this.stmt = con.createStatement();
        }
        catch(Exception e)
        {
        	System.out.println("connection error:" +e);
        }
	}
	
	void update(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		}
		catch(Exception e) {
			System.out.println("update error:"+e);
		}
	}
	void select(String dbSelect) {
		try {
			this.rs = this.stmt.executeQuery(dbSelect);
		}
		catch(Exception e) {
			System.out.println("select error:"+e);
		}
	}
	
	void close() {
		try {
			con.close();
		}
		catch(Exception e) {
			System.out.println("close error:"+e);
		}
	}
}        
        
        
        
        