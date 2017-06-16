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
			Class.forName(driverStr);  //加载数据库驱动
			conn = DriverManager.getConnection(connStr, dbusername, dbpassword);//连接数据库
			stmt = conn.createStatement();  //实例化Statement对象（为了执行不带参数的简单SQL语句）
		} 
		catch (Exception ex) {
			System.out.println("无法同数据库建立连接！");
		} 
		
	}

public int executeUpdate(String s) {       //更新表 ，SQL语句
	
	int result = 0;
	try {
		result = stmt.executeUpdate(s);
	} catch (Exception ex) {
		System.out.println("执行更新错误！");
		System.out.println(s);
	}
	return result;
} 

public ResultSet executeQuery(String s) {   //SQL查询  
	ResultSet rs = null;
	try {
		rs = stmt.executeQuery(s);
	} catch (Exception ex) {
		System.out.println(	"执行查询错误！");
		System.out.println(s);
	}
	return rs;
}
public void execQuery(String s){   	//SQL更改
	try {
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("执行插入错误");
		System.out.println(s);
	}
}

public void close() {   //关闭连接
	try {
		stmt.close();
		conn.close();
	} catch (Exception e) {
	}
}
}
