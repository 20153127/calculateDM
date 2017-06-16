<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="position:absolute;width:100%;height:100%;top:0px;left:0px;z-index:-1">
	<img src="aa.jpg" width=100% height=100%></div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<div align="center">
<%
     String[] s1= (String[])session.getAttribute("v1");
     String[] answer= (String[])session.getAttribute("v2");
     String[] daan=new String[s1.length];
     int count=0;//正确答案的个数
     for(int i=0;i<s1.length;i++)
     {
        out.print("运算式为：");
         out.print(s1[i]+"  ");
        out.print("您的输入结果为：");
         daan[i]=request.getParameter("name"+i);
         out.print(daan[i]+"   ");
         out.print("正确结果为：");
         out.print(answer[i]);
        if(daan[i].equals(answer[i]))
         {
            out.print("恭喜你答对了！");
            count++;
         }
        else
         {
             out.print("很遗憾，你答错了！");
         }
         out.print("<br>");
     }
     out.print("你一共答对的题目数：");
     out.print(count);
 %>
 	</div>
</body>
</html>