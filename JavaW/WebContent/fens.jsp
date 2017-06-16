<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分数二级菜单</title>
<style type="text/css"> 
 a:link,a:visited{font-size:30px ;text-decoration:none; color:#FF0000} 
 a:hover,a:active{font-size:40px} 
</style>
</head>
<body >
	<div style="position:absolute;width:100%;height:100%;top:0px;left:0px;z-index:-1">
	<img src="b.jpg" width=100% height=100%></div>
	<br/>
	<br/>
	<br/>
	<marquee onmouseover=stop() onmouseout=start() scrollamount="12" direction="left">
	 <a href="#" class=a>吾乃常山赵子龙，阁下是否敢应战</a>
	</marquee>
	<br/>
	<br/>
	<br/>
	<br/>
	<div align="center">
	<form name="form3" method=post action="fes.jsp">
	<center> 分数四则运算</center>
	<table align="center">
	<tr>
	<td>请输入需要生成的题目数量</td>
	<td><input name="shuliang" id="shuliang" type="text" > </td>
	</tr>
	 <tr>
	 <td>请输入分母的最大值</td>
	 <td> <input name="zuida" id="zuida" type="text"> </td>
	 </tr>
	 <tr>
	 <td> 请选择是否需要括号1有2没有</td>
	 <td> <input name="kuohao" id="kuohao" type="text"> </td>
	 </tr>
	 <tr>
	  <td>请选择生成算式的位数1两位数2多位数</td>
	  <td><input name="weishu" id="weishu" type="text"> </td>
	 </tr>
	 <tr>
	  <td>加减有无负数</td>
	  <td><input name="fs" id="fs" type="text"> </td>
	  </tr>
	  <tr>
	  <td> 除法有无余数</td>
	  <td><input name="ys" id="ys"type="text"></td>
	  </tr>
	</table>
		<center><input type="submit" value="开始出题"> </center>
	</form> 
	</div>
</body>
</html>