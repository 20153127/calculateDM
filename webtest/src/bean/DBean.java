package bean;
import java.sql.*;
public class DBean {
	private String driverStr = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String connStr = "jdbc:sqlserver://localhost:1433; DatabaseName=Test";
	private String dbusername = "sa";
	private String dbpassword = "123456";
	private Connection conn = null;
	private Statement stmt = null;
	 
	public DBean()    
	{
		try
		{
			Class.forName(driverStr);  //�������ݿ�����
			conn = DriverManager.getConnection(connStr, dbusername, dbpassword);//�������ݿ�
			stmt = conn.createStatement();  //ʵ����Statement����Ϊ��ִ�в��������ļ�SQL��䣩
		} 
		catch (Exception ex) {
			System.out.println("�޷�ͬ���ݿ⽨�����ӣ�");
		} 
		
	}

public int executeUpdate(String s) {       //���±� ��SQL���
	
	int result = 0;
	try {
		result = stmt.executeUpdate(s);
	} catch (Exception ex) {
		System.out.println("ִ�и��´���");
		System.out.println(s);
	}
	return result;
} 

public ResultSet executeQuery(String s) {   //SQL��ѯ  
	ResultSet rs = null;
	try {
		rs = stmt.executeQuery(s);
	} catch (Exception ex) {
		System.out.println(	"ִ�в�ѯ����");
		System.out.println(s);
	}
	return rs;
}
public void execQuery(String s){   	//SQL����
	try {
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("ִ�в������");
		System.out.println(s);
	}
}

public void close() {   //�ر�����
	try {
		stmt.close();
		conn.close();
	} catch (Exception e) {
	}
}
}
