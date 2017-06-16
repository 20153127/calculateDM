<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.Connection,java.sql.DriverManager,java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="position:absolute;width:100%;height:100%;top:0px;left:0px;z-index:-1">
	<img src="c.jpg" height=100% width=100%></div>
	<div align="center">
<%!
 	class gg
 	{
       int gongbei(int x,int y)
	 {
		 int z;
		 for(z=x;;z++)
		 {
			if(z%x==0&&z%y==0)
				break;
		 }
		 return z;
	 }
	   int gongyue(int x,int y)
	  {
		  int z;
		  for(z=x;z>0;z--)
		  {
			 if(x%z==0&&y%z==0)
			 	break;
		  }
		return z;
	  }
 	}
%>
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
	String zuid=request.getParameter("zuida");
	String fss=request.getParameter("fs");
	String yss=request.getParameter("ys");
	gg g=new gg();
	if(Integer.parseInt(weishu)==1)
	{
		int fenzi=0;
		int fenmu=0;
		int huajian=0;
		String j=request.getParameter("shuliang");
		int sl=Integer.valueOf(j);
		int bi=Integer.valueOf(zuid);
		String []ss=new String[sl];
		String daan[] =new String [sl];
		String jj[]=new String[sl];
		String s="";
		int ans=0;
		String ans1[]=new String[sl];
		int a[]=new int [sl];
		int a1[]=new int[sl];
		int b[]=new int [sl];
		int b1[]=new int[sl];
		int flag=0;
		int flag1=0;
		int flag2=0;
		int flag3=0;
		int c[]=new int [sl];
		int d[]=new int[sl];
		int d1[]=new int[sl];
		int e[]=new int[sl];
		int fs=Integer.valueOf(fss);
		int ys=Integer.valueOf(yss);
			for(int i=0;i<sl;i++)
			{
				daan[i]="name"+i;
				flag1=0;
				flag2=0;
				a[i]=(int)(Math.random()*(bi-1-1)+1);
				a1[i]=(int)(Math.random()*(bi-1)+1);
				b[i]=(int)(Math.random()*(bi-1-1)+1);
				b1[i]=(int)(Math.random()*(bi-1)+1);
				c[i]=(int)(Math.random()*4);
				if((a[i]>=a1[i])||(b[i]>=b1[i])) //判断是否为真分数
				{
					flag2=1;
				}
				else   //是真分数继续进行
				{
					flag2=0;
				}
					
				if(fs==1)  //有负数
				{
					flag=0;
				}
				if(fs==2)  //没有负数
				{
				   if(c[i]==1)
				   {
						if((a[i]*b1[i]-a1[i]*b[i])>=0)
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
					fenzi=(a[i]*b1[i])+(a1[i]*b[i]);
					fenmu=a1[i]*b1[i];
						huajian=g.gongyue(fenzi, fenmu);
						int o=fenzi/huajian;
						int p=fenmu/huajian;
						if(o<p)
						{
							jj[i]=o+"/"+p;
						}
						if((o>p)&&(o%p!=0))
						{
							int you=o/p;
							o=o-p*you;
							jj[i]=you+"|"+o+"/"+p;
						}
						if((o>p)&&(o%p==0))
						{
							int you=o/p;
							jj[i]=""+you;
						}
						
				}
				if(c[i]==1)
				{
					s=" - ";
					fenzi=(a[i]*b1[i])-(a1[i]*b[i]);
					fenmu=a1[i]*b1[i];
					if(fenzi>0)
					{
						huajian=g.gongyue(fenzi, fenmu);
						int o=fenzi/huajian;
						int p=fenmu/huajian;
						if(o<p)
						{
							jj[i]=o+"/"+p;
						}
						if((o>p)&&(o%p!=0))
						{
							int you=o%p;
							o=o-p*you;
							jj[i]=you+"|"+o+"/"+p;
						}
						if((o>p)&&(o%p==0))
						{
							int you=o%p;
							jj[i]=""+you;
						}
					}
					if(fenzi<0)
					{
						int t=0-fenzi;
						huajian=g.gongyue(t, fenmu);
						int o=fenzi/huajian;
						int p=fenmu/huajian;
						if(o<p)
						{
							jj[i]=o+"/"+p;
						}
						if((o>p)&&(o%p!=0))
						{
							int you=o/p;
							o=o-p*you;
							jj[i]=you+"|"+o+"/"+p;
						}
						if((o>p)&&(o%p==0))
						{
							int you=o/p;
							jj[i]=""+you;
						}
					}
					if(fenzi==0)
					{
						jj[i]=""+0;
					}
				}
				if(c[i]==2)
				{
					s=" * ";
					fenzi=a[i]*b[i];
					fenmu=a1[i]*b1[i];
					huajian=g.gongyue(fenzi, fenmu);
					int o=fenzi/huajian;
					int p=fenmu/huajian;
					if(o<p)
					{
						jj[i]=o+"/"+p;
					}
					if((o>p)&&(o%p!=0))
					{
						int you=o/p;
						o=o-p*you;
						jj[i]=you+"|"+o+"/"+p;
					}
					if((o>p)&&(o%p==0))
					{
						int you=o/p;
						jj[i]=""+you;
					}
				}
				if(c[i]==3)
				{
					
						if(ys==1)
						{
							s=" ÷ ";
							fenzi=a[i]*b1[i];
							fenmu=a1[i]*b[i];
							huajian=g.gongyue(fenzi,fenmu);
							int o=fenzi/huajian;
							int p=fenmu/huajian;
							
							if(o<p)
							{
								jj[i]=o+"/"+p;
							}
							if((o>p)&&(o%p!=0))
							{
								int you=o/p;
								o=o-p*you;
								jj[i]=you+"|"+o+"/"+p;
							}
							if((o>p)&&(o%p==0))
							{
								int you=o/p;
								jj[i]=""+you;
							}
						}
						if(ys==2)
						{
							if(((a[i]*b1[i])%(a1[i]*b[i]))==0)
							{
								s=" ÷ ";
								fenzi=a[i]*b1[i];
								fenmu=a1[i]*b[i];
								huajian=g.gongyue(fenzi,fenmu);
								int o=fenzi/huajian;
								int p=fenmu/huajian;
								if(o<p)
								{
									jj[i]=o+"/"+p;
								}
								if((o>p)&&(o%p!=0))
								{
									int you=o%p;
									o=o-p*you;
									jj[i]=you+"|"+o+"/"+p;
								}
								if((o>p)&&(o%p==0))
								{
									int you=o%p;
									jj[i]=you+"";
								}
							}
							else
							{
								flag=1;
							}
						}
	
				}
				int y=g.gongyue(a[i],a1[i]);
				int y1=g.gongyue(b[i],b1[i]);
				a[i]=a[i]/y;
				a1[i]=a1[i]/y;
				b[i]=b[i]/y1;
				b1[i]=b1[i]/y1;
				ss[i]=a[i]+"/"+a1[i]+s+b[i]+"/"+b1[i];
				for(int i1=0;i1<i;i1++)   //查重
				{
					if((a[i1]==a[i])&&(a1[i1]==a1[i])&&(b[i1]==b[i])&&(b1[i]==b1[i1])&&(c[i1]==c[i]))
						flag1=1;			
					if((a[i1]==b[i])&&(b[i1]==a[i])&&(c[i1]==0)&&(c[i]==0)&&(a1[i1]==b1[i])&&(b1[i1]==a1[i]))
						flag1=1;
			
					if((a[i1]==b[i])&&(b[i1]==a[i])&&(c[i1]==2)&&(c[i]==2)&&(a1[i1]==b1[i])&&(b1[i1]==a1[i]))
						flag1=1;
				}
				if((flag==0)&&(flag1==0)&&(flag2==0))  //输出
				{
					
					String sql="INSERT INTO size VALUES ('"+ss[i]+"','"+jj[i]+"')";				
					stmt.executeUpdate(sql);
					ans1[i]=jj[i];
					out.print(ss[i]);
					
					%>
					<br> 
					<form  name="form4" method="post" action="fscheck.jsp">
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
			session.setAttribute("v2", ans1);
			%>
		<input type="submit" value="统计结果"> </form>
		<% 
	}
	if(Integer.parseInt(weishu)==2)
	{
		String j=request.getParameter("shuliang");
		int sl=Integer.valueOf(j);
		int bi=Integer.valueOf(zuid);
		String []ss=new String[sl];
		String daan[] =new String [sl];
		String s="";
		int ans=0;
		String ans1[]=new String[sl];
		int a[]=new int [sl];
		int a1[]=new int[sl];
		int b[]=new int [sl];
		int b1[]=new int[sl];
		int flag=0;
		int flag1=0;
		int flag2=0;
		int flag3=0;
		int c[]=new int [sl];
		int d[]=new int[sl];
		int d1[]=new int[sl];
		int e[]=new int[sl];
		int fs=Integer.valueOf(fss);
		int ys=Integer.valueOf(yss);
		int y=0;
		int y1=0;
		int y2=0;

		
		for(int i=0;i<sl;i++)
		{
			String j1=request.getParameter("kuohao");
			int y3=Integer.valueOf(j1);
			int c1 []=new int [20000];
			flag1=0;
			flag2=0;
			y=(int)(Math.random()*4+3);//生成数的个数
			y1=(int)(Math.random()*2);//有无括号
			y2=(int)(Math.random()*2);//前后
			a[i]=(int)(Math.random()*(bi-1-1)+1);
			a1[i]=(int)(Math.random()*(bi-1)+1);
			b[i]=(int)(Math.random()*(bi-1-1)+1);
			b1[i]=(int)(Math.random()*(bi-1)+1);
			c[i]=(int)(Math.random()*4);
			if((a[i]>=a1[i])||(b[i]>=b1[i])) //判断是否为真分数
			{
				flag2=1;
			}
			else   //是真分数继续进行
			{
				flag2=0;
			}
			if(fs==1)
			{
				flag=0;
			}
			if(fs==2)// 没有负数
			{
			   if(c[i]==1)
			   {
					if((a[i]*b1[i]-a1[i]*b[i])>=0)
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
			}
			if(c[i]==1)
			{
				s=" - ";
			}
			if(c[i]==2)
			{
				s=" * ";
			}
			if(c[i]==3)
			{
				
					if(ys==1)
					{
						s=" ÷ ";
					}
					if(ys==2)
					{
						if(((a[i]*b1[i])%(a1[i]*b[i]))==0)
						{
							s=" ÷ ";
						}
						else
						{
							flag=1;
						}
					}

			}
			int z=g.gongyue(a[i],a1[i]);
			int z1=g.gongyue(b[i],b1[i]);
			a[i]=a[i]/z;
			a1[i]=a1[i]/z;
			b[i]=b[i]/z1;
			b1[i]=b1[i]/z1;
			c1[i]=(int)(Math.random()*4);
			ss[i]=a[i]+"/"+a1[i]+s+b[i]+"/"+b1[i];
			if(y3==1)//有括号生成
			{
				for(int  r=0;r<(y-2);r++)
				{
					
					y1=(int)(Math.random()*2);//有无括号
					y2=(int)(Math.random()*2);//前后
					d[r]=(int)(Math.random()*(bi-1-1)+1);
					d1[r]=(int)(Math.random()*(bi-1)+1);
					int z3=g.gongyue(d[r],d1[r]);
					d[r]=d[r]/z3;
					d1[r]=d1[r]/z3;
					if(d[r]>=d1[r])
					{
						flag3=1;
					}
					else
					{
						flag3=0;
					}
					if(c1[i]==0)
					{
						s=" + ";
					}
					if(c1[i]==1)
					{
						s=" - ";
					}
					if(c1[i]==2)
					{
						s=" * ";
					}
					if(c1[i]==3)
					{
						

							if(ys==1)
							{
								s=" ÷ ";
							}
							if(ys==2)
							{
							  if(y2==0)
							  {
								if((a[i]*b1[i])%(a1[i]*b[i])==0)
								{
									s=" ÷ ";
								}
								else
									flag=1;
							  }
							}
					}
					if(y1==0) //随机数生成没有括号情况
					{
						if((y2==0)&&(flag3==0)) //加在后面
						{
							ss[i]=ss[i]+s+d[r]+"/"+d1[r];
						}
						if((y2==1)&&(flag3==0))  //加在前面
						{
							ss[i]=d[r]+"/"+d1[r]+s+ss[i];

						}
					}
					if(y1==1) //随机数生成了括号
					{
						if((y2==0)&&(flag3==0))  //加在后面
						{
							ss[i]="("+ss[i]+")"+s+d[r]+"/"+d1[r];
							
						}
						if((y2==1)&&(flag3==0))  //括号加在前边
						{
							ss[i]=d[r]+"/"+d1[r]+s+"("+ss[i]+")";

						}
					}
					for(int i2=0;i2<i;i2++)
					{
						if(ss[i2]==ss[i])
							flag1=1;
						else
							flag1=0;
					}
					if(flag3!=0)
						r--;
				}
			}
			if(y3==2)  //没有括号
			{
				for(int  r=0;r<(y-2);r++)
				{
					c1[i]=(int)(Math.random()*4);
					y1=(int)(Math.random()*2);//有无括号
					y2=(int)(Math.random()*2);//前后
					d[r]=(int)(Math.random()*(bi-1-1)+1);
					d1[r]=(int)(Math.random()*(bi-1)+1);
					int z4=g.gongyue(d[r],d1[r]);
					d[r]=d[r]/z4;
					d1[r]=d1[r]/z4;
					if(d[r]>=d1[r])
					{
						flag3=1;
					}
					else
					{
						flag3=0;
					}

					if(c1[i]==0)
					{
						s=" + ";
					}
					if(c1[i]==1)
					{
						s=" - ";
					}
					if(c1[i]==2)
					{
						s=" * ";
					}
					if(c1[i]==3)
					{
						if(ys==1)
							{
								s=" ÷ ";
							}
							if(ys==2)
							{
								if((a[i]*b1[i])%(a1[i]*b[i])==0)
								{
									s=" ÷ ";
								}
								else
									flag=1;
							}
					}
				
					if(y1==1) //没有括号
					{
						if((y2==0)&&(flag3==0)) //加在后面
						{
							ss[i]=ss[i]+s+d[r]+"/"+d1[r];

						}
						if((y2==1)&&(flag3==0))	
						{
							ss[i]=d[r]+"/"+d1[r]+s+ss[i];

						}
					}
					for(int i2=0;i2<i;i2++)
					{
						if(ss[i2]==ss[i])
							flag1=1;
						else
							flag1=0;
					}
			
					if(flag3!=0)
						r--;
			} //小for 循环
			
		}
			
			if((flag==0)&&(flag1==0)&&(flag2==0)&&(flag3==0))
			{
				out.print(ss[i]);
				%>
				<br> 
				<form  name="form5" method="post" action="fscheck.jsp">
				 请输入答案<input name=<%=daan[i] %> type="text" id="daan">
				 <br/>		
				<% 		
			}
			else
				i--;
	  }
		session.setAttribute("v1", ss);
		session.setAttribute("v2", ans1);
		%>
	<input type="submit" value="统计结果"> </form>
	<% 
	}
%>
	</div>
</body>
</html>