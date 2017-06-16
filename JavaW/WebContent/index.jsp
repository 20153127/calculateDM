<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.Connection,java.sql.DriverManager,java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>整数页面</title>
<style type="text/css"> 
 a:link,a:visited{font-size:30px ;text-decoration:none; color:#2E8B57} 
 a:hover,a:active{font-size:40px} 
</style>
</head>
<body>
	<div style="position:absolute;width:100%;height:100%;top:0px;left:0px;z-index:-1">
	<img src="e.jpg" width=100% height=100%></div>
	<br/>
	<div align="center" >
<%
	String driverStr = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	Class.forName(driverStr).newInstance();
	String connStr = "jdbc:sqlserver://localhost:1433; DatabaseName=Webys";
	String dbusername = "sa";
	String dbpassword = "123456";
	Connection conn=null;
	java.sql.Statement stmt=null;
	
	conn=DriverManager.getConnection(connStr, dbusername, dbpassword);
	stmt=conn.createStatement();
	String weishu=request.getParameter("weishu");
	String kuohao=request.getParameter("kuohao");
	String zuix=request.getParameter("zuixiao");
	String zuid=request.getParameter("zuida");
	String fss=request.getParameter("fs");
	String yss=request.getParameter("ys");
	if(Integer.parseInt(weishu)==1)
	{
		int ans=0;
		String j=request.getParameter("shuliang");
		int sl=Integer.valueOf(j);
		int litt=Integer.valueOf(zuix);
		int bi=Integer.valueOf(zuid);
		String []ss=new String[sl];
		String s="";
		String daan[] =new String [sl];
		String ans2[]=new String[sl];
		int a[]=new int [sl];
		int b[]=new int [sl];
		int flag=0;
		int flag1=0;	
		int c[]=new int [sl];
		int d[]=new int[sl];
		int e[]=new int[sl];
		int fs=Integer.valueOf(fss);
		int ys=Integer.valueOf(yss);
		for(int i=0;i<sl;i++)
		{
			daan[i]="name"+i;
			flag1=0;
			a[i]=(int)(Math.random()*(bi-litt)+1+litt);
			b[i]=(int)(Math.random()*(bi-litt)+1+litt);
		 	c[i]=(int)(Math.floor((Math.random()*4)));
			if(fs==1)
			{
				flag=0;
			}
			if(fs==2)
			{
			   if(c[i]==1)
			   {
					if((a[i]-b[i])>=0)
					{
						flag=0;
					}
					else
					{
						flag=1;
					}
			   }
			}
		
			if(c[i]==0)
			{
				s=" + ";
				ans=a[i]+b[i];
			}
			if(c[i]==1)
			{
				s=" - ";
				ans=a[i]-b[i];
			}
			if(c[i]==2)
			{
				s=" * ";
				ans=a[i]*b[i];
			}
			if(c[i]==3)
			{
				
				if(b[i]!=0)
				{
					if(ys==1)
					{
						s=" ÷ ";
						ans=a[i]/b[i];
					}
					if(ys==2)
					{
						if((a[i]%b[i])==0)
						{
							s=" ÷ ";
							ans=a[i]/b[i];
						}
						else
						{
							flag=1;
						}
					}
				}
				else
					flag=1;
			}
			ss[i]=a[i]+s+b[i];
			for(int i1=0;i1<i;i1++)   //查重
			{
				if((a[i1]==a[i])&&(b[i1]==b[i])&&(c[i1]==c[i]))
					flag1=1;			
				if((a[i1]==b[i])&&(b[i1]==a[i])&&(c[i1]==0)&&(c[i]==0))
					flag1=1;
		
				if((a[i1]==b[i])&&(b[i1]==a[i])&&(c[i1]==2)&&(c[i]==2))
					flag1=1;
			}
			if((flag==0)&&(flag1==0))  //输出
			{
				String sql="INSERT INTO size VALUES ('"+ss[i]+"','"+ans+"')";
				stmt.executeUpdate(sql);
				ans2[i]=""+ans;
				out.print(ss[i]); 
				
				%>
				<br> 
				<form name="form2" method="post" action="zscheck2.jsp">
				 请输入答案<input name=<%=daan[i] %> type="text" id="daan">
				 <br/>				 

						<% 	
		  	}
			else
			{
				i--;
			}
			
		}
		
		session.setAttribute("v1", ss);
		session.setAttribute("v2", ans2);
		%>
	<input type="submit" value="统计结果"> </form>
	<% 
	}
		 if(Integer.parseInt(weishu)==2)
		 {
			 String j=request.getParameter("shuliang");
				int sl=Integer.valueOf(j);
				int litt=Integer.valueOf(zuix);
				int bi=Integer.valueOf(zuid);
				String []ss=new String[sl];
				String s="";
				String daan[] =new String [sl];
				int a[]=new int [sl];
				int b[]=new int [sl];
				int flag=0;
				int flag1=0;
				String [] ans2=new String[sl];
				int ans=0;
				int c[]=new int [sl];
				int d[]=new int[sl];
				int e[]=new int[sl];
				int fs=Integer.valueOf(fss);
				int ys=Integer.valueOf(yss);
				int y=0;
				int y1=0;
				int y2=0;
				String j1=request.getParameter("kuohao");
				int y3=Integer.valueOf(j1);
				for(int i=0;i<sl;i++)
				{
					daan[i]="name"+i;
					int c1 []=new int [20000];
					flag1=0;
					y=(int )(Math.random()*4+3);//生成数的个数
					y1=(int )(Math.random()*2);//有无括号
					y2=(int )(Math.random()*2);//前后
					a[i]=(int)(Math.random()*(bi-litt)+1+litt);
					b[i]=(int)(Math.random()*(bi-litt)+1+litt);
				 	c[i]=(int)(Math.floor((Math.random()*4)));
					if(fs==1)
					{
						flag=0;
					}
					if(fs==2)// 没有负数
					{
					   if(c[i]==1)
					   {
							if((a[i]-b[i])>=0)
							{
								flag=0;
							}
							else
							{
								flag=1;
							}
					   }
					}
				
					if(c[i]==0)
					{
						s=" + ";
						ans=a[i]+b[i];
					}
					if(c[i]==1)
					{
						s=" - ";
						ans=a[i]-b[i];
					}
					if(c[i]==2)
					{
						s=" * ";
						ans=a[i]*b[i];
					}
					if(c[i]==3)
					{
						
						if(b[i]!=0)
						{
							if(ys==1)
							{
								s=" ÷ ";
								ans=a[i]/b[i];
							}
							if(ys==2)
							{
								if((a[i]%b[i])==0)
								{
									s=" ÷ ";
									ans=a[i]/b[i];
								}
								else
									flag=1;
							}
						}
						else
							flag=1;
					}
					ss[i]=a[i]+s+b[i];

					if(y3==1)//有括号生成
					{
						for(int  r=0;r<(y-2);r++)
						{
							y1=(int )(Math.random()*2);//有无括号
							y2=(int )(Math.random()*2);//前后
							d[r]=(int)(Math.random()*(bi-litt)+1+litt);
						 	c1[i]=(int )(Math.random()*4);
		
							if(c1[i]==0)
							{
								s=" + ";
								ans=ans+d[r];
							}
							if(c1[i]==1)
							{
								s=" - ";
								ans=ans-d[r];
							}
							if(c1[i]==2)
							{
								s=" * ";
								ans=ans*d[r];
							}
							if(c1[i]==3)
							{
								
								if(b[i]!=0)
								{
									if(ys==1)
									{
										s=" ÷ ";
										ans=ans/d[r];
									}
									if(ys==2)
									{
										if((a[i]%b[i])==0)
										{
											s=" ÷ ";
											ans=ans/d[r];
										}
										else
											flag=1;
									}
								}
								else
									flag=1;
							}
							if(y1==1) //随机数生成没有括号情况
							{
								if(y2==0) //加在后面
								{
									ss[i]=ss[i]+s+d[r];
								}
								if(y2==1)  //加在前面
								{
									ss[i]=d[r]+s+ss[i];

								}
							}
							if(y1==0) //随机数生成了括号
							{
								if(y2==0)  //加在后面
								{
									ss[i]="("+ss[i]+")"+s+d[r];
									
								}
								if(y2==1)  //括号加在前边
								{
									ss[i]=d[r]+s+"("+ss[i]+")";

								}
							}
							for(int i2=0;i2<i;i2++)
							{
								if(ss[i2]==ss[i])
									flag1=1;
								else
									flag1=0;
							}
						}
					}
					if(y3==2)
					{
						for(int  r=0;r<(y-2);r++)
						{
							y1=(int)(Math.random()*2);//有无括号
							y2=(int)(Math.random()*2);//前后
							d[r]=(int)(Math.random()*(bi-litt)+1+litt);
						 		c1[i]=(int)(Math.random()*4);

							if(c1[i]==0)
							{
								s=" + ";
								ans=ans+d[r];
							}
							if(c1[i]==1)
							{
								s=" - ";
								ans=ans-d[r];
							}
							if(c1[i]==2)
							{
								s=" * ";
								ans=ans*d[r];
							}
							if(c1[i]==3)
							{
								
								if(b[i]!=0)
								{
									if(ys==1)
									{
										s=" ÷ ";
										ans=ans/d[r];
									}
									if(ys==2)
									{
										if((a[i]%b[i])==0)
										{
											s=" ÷ ";
											ans=ans/d[r];
										}
										else
											flag=1;
									}
								}
								else
									flag=1;
							}
							if(y1==1) //没有括号
							{
								if(y2==0) //加在后面
								{
									ss[i]=ss[i]+s+d[r];

								}
								if(y2==1)	
								{
									ss[i]=d[r]+s+ss[i];

								}
							}
							for(int i2=0;i2<i;i2++)
							{
								if(ss[i2]==ss[i])
									flag1=1;
								else
									flag1=0;
							}

					} //小for 循环
					
				}
					
					if((flag==0)&&(flag1==0))
					{
						String sql="INSERT INTO size VALUES ('"+ss[i]+"','"+ans+"')";
						stmt.executeUpdate(sql);
						ans2[i]=""+ans;
						out.print(ss[i]+" "); %>
						<br> 
					<form name="form2" method="post" action="zscheck2.jsp">
						 请输入答案<input name=<%=daan[i] %> type="text" id="daan">
				 	<br/>				 
						<% 
					
					}
					else
						i--;
			}
				session.setAttribute("v1", ss);
				session.setAttribute("v2", ans2);%>
				<input type="submit" value="统计结果"> </form>
				<% 
				
		  }	
		  %>
	</div>
</body>
</html>