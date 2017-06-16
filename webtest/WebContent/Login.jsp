<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>登录界面</title>

<script type="text/javascript">
	function checkIP() {
		//js表单验证方法
		var text1=document.getElementById("username").value;//通过id获取需要验证的表单元素的值，返回username的值
		var text2=document.getElementById("password").value;//通过id获取需要验证的表单元素的值，返回password的值
   		if(text1=="")
   		{//当上面获取的值为空时
     		alert("用户名不能为空！");//弹出提示
     		return false;//返回false（不提交表单）
     	}
     	if(text2=="")
   		{//当上面获取的值为空时
     		alert("密码不能为空！");//弹出提示
     		return false;//返回false（不提交表单）
     	}
   		return true;//提交表单
	}

</script>

</head>
<body class="body_one"  background="D:/网页图片/hehua.jpg">

<div id="all">
<div id="input">
	<center>
			<form id="indexform" name="indexForm" action="LoginCheck.jsp" method="post" onsubmit="return checkIP();">
			<table border="0" align="center" cellspacing=0 padding:0 > 
					<tr>
						<td>账&nbsp;户：</td>
						<td><input type="text" id="username" name="username"class="textIn_one"></td>
					</tr>
					<tr><td rowspan="2">&nbsp;</td></tr>
					<tr>
						<td> </td>
					</tr>
					<tr>
						<td>密&nbsp;码：</td>
						<td><input type="password" id="password" name="password" class="textIn_one" ></td>
					</tr>
					<tr><td rowspan="2">&nbsp;</td></tr>
					<tr>
						<td> </td>
					</tr>
				
				</table>
				<table >
			<br>
			<tr>	
				<td><div class="button_1">
				<input type="submit" value="登录" onclick="checkIP()"style="color:#000;width:120px;height:40px;font-size: 25px;">
				</div><div class="button_2">
				<input type="reset" value="重置"style="color:#000;width:120px;height:40px;font-size: 25px;">
				</div></td>
				</tr>
			</form>
			</table>
			
		</center>
		</div>
		<p class="Copyright" align="center">Copyright &copy; 2016.Company name All rights reserved.</p>
</div>
	
</body>
</html>