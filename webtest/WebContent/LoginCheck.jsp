<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="java.io.IOException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录中...</title>

</head>
<body>
	
		<jsp:useBean id="db" class="bean.DBean" scope="page" /> 
		<%    //凭借db来  调用bean.DBean程序
		String password=(String)request.getParameter("password");//获取文本里面输入的密码
		String username=(String)request.getParameter("username");//获取从文本里面输入的账号
		session.setAttribute("password",password);   //把从文本里面获取的面值，保存在变量password中
		session.setAttribute("username",username);  
         
 
            	String sql="select * from Test.dbo.userTable where username="+"'"+username+"'";//SQL查询语句，查询username
				ResultSet rs=db.executeQuery(sql);//执行SQL语句
				if(rs.next()) //查询下一个数据，即password
				{
			    	if(password.equals(rs.getObject("password")))  //从数据库中调用密码
			    	{
			    		session.setAttribute("LoginID",username);//将账号保存到LoginID中，方便以后调用
			    		response.sendRedirect("Main.jsp");	//	调到主函数页面	    		
			    	}
			    	else
			    	{
			    		out.print("<script language='javaScript'> alert('密码输入错误，请重新输入！');</script>");//密码不对，提示重新输入
			    		response.setHeader("refresh", "1;url=Login.jsp");//刷新页面，转到登录输入页面进行重新输入
			    	}
				}
				else{
					out.print("<script language='javaScript'> alert('账号输入有误，请重新输入！');</script>");//账号不对提示重新输入
					response.sendRedirect("Login.jsp");//调到输入页面
				}
				rs.close();//关闭数据库调用
				db.close();	//停止java文件的调用
			
 
		
		%>
</body>
</html>