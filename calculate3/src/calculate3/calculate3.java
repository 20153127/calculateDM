package calculate3;
import java.sql.*;
import java.util.*;
public class calculate3 {
		
	private static String driverStr="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String connStr="jdbc:sqlserver://localhost:1433;DatabaseName=YS";
	private static String dbusername="sa";
	private static String dbpassword="123456";
	private static Connection conn=null;
	private static Statement stmt=null;
	static int zsjieguo2[]=new int [11111];
	static int zsjieguod[]=new int[11111];
	static int fsjieguo2[]=new int[11111];
	static int fsjieguod[]=new int[11111];
	public static void main(String[] args) throws SQLException {
		// TODO 自动生成的方法存根
		int numtype;
		int little,big,num;
		int select;
		Scanner in=new Scanner(System.in);
		while(true)
		{
			System.out.println("请选择1.整数2.真分数");
			numtype=in.nextInt();
			if(numtype==1)
			{
				System.out.println("请输入最小值");
				little=in.nextInt();
				System.out.println("请输入最大值");
				big=in.nextInt();
				System.out.println("请输入数量");
				num=in.nextInt();
				try
				{
					Class.forName(driverStr);
					System.out.println("加载驱动成功");
					conn=DriverManager.getConnection(connStr, dbusername, dbpassword);
					System.out.println("数据库连接成功");
					stmt=conn.createStatement();
					System.out.println("数据库连接成功");
				}
				catch(Exception ex)
				{
					System.out.println("连接数据库失败");
				}
				zs(little,big,num);
			}
			if(numtype==2)
			{
				System.out.println("请输入分母的最大值");
				big=in.nextInt();
				System.out.println("请输入数量");
				num=in.nextInt();
				try
				{
					Class.forName(driverStr);
					conn=DriverManager.getConnection(connStr, dbusername, dbpassword);
					stmt=conn.createStatement();
				}
				catch(Exception ex)
				{
					System.out.println("连接数据库失败");
				}
				fens(big,num);
			}
			conn.close();
			stmt.close();
		}
	}
	public static void zs(int litt,int bi,int sl)
	{
		String []ss=new String[100*sl];
		String s="";
		int a[]=new int [sl];
		int b[]=new int [sl];
		int flag=0;
		int flag1=0;
		int c[]=new int [sl];
		int d[]=new int[sl];
		int e[]=new int[sl];
		int fs=0,ys=0;
		Scanner in1=new Scanner(System.in);
		Random random=new Random();
		System.out.println("选择1.两位数运算2.多位数运算");
		int se=in1.nextInt();
		System.out.println("是否有乘除法1.有2.无");
		int cs=in1.nextInt();
		if(cs==1)
		{
			System.out.println("加减是否有负数1.有2.无");
			 fs=in1.nextInt();
			System.out.println("除法是否有余数1.有2.无");
			 ys=in1.nextInt();
		}
		if(cs==2)  //加减是否有负数
		{
			System.out.println("加减是否有负数1.有2.无");	
			 fs=in1.nextInt();
		}
		if(se==1) //两位数
		{
			for(int i=0;i<sl;i++)
			{
				flag1=0;
				a[i]=random.nextInt(bi-litt)+litt;
				b[i]=random.nextInt(bi-litt)+litt;
			 	if(cs==1)
				{
			 		c[i]=random.nextInt(4);
				 
				}
				if(cs==2)
				{
					c[i]=random.nextInt(2);
				}
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
					
					if(b[i]!=0)
					{
						if(ys==1)
						{
							s=" ÷ ";
						}
						if(ys==2)
						{
							if((a[i]%b[i])==0)
							{
								s=" ÷ ";
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
					System.out.println(ss[i]+" ");
					String sql="insert into dbo.table1 values('"+i+"','"+ss[i]+"')";
					try
					{
						java.sql.Statement statement=conn.createStatement();
						statement.executeUpdate(sql);
					}
					catch(SQLException EE)
					{
						EE.printStackTrace();
					}
					if(c[i]==0)
					{	
						zsjieguo2[i]=a[i]+b[i];
					}
					if(c[i]==1)
					{
						zsjieguo2[i]=a[i]-b[i];
					}
					if(c[i]==2)
					{
						zsjieguo2[i]=a[i]*b[i];
					}
					if(c[i]==3)
					{
						zsjieguo2[i]=a[i]/b[i];
					}
				}
				else
				{
					i--;
				}
			}

		}
		if(se==2) //多位数
		{
			int y=0;
			int y1=0;
			int y2=0;
			System.out.println("请选择，1.有括号2.无括号");
			int y3=in1.nextInt();
			
			for(int i=0;i<sl;i++)
			{
				
				int c1 []=new int [20000];
				flag1=0;
				y=random.nextInt(4)+3;//生成数的个数
				y1=random.nextInt(2);//有无括号
				y2=random.nextInt(2);//前后
				a[i]=random.nextInt(bi-litt)+litt;  //随机生成的前两个数
				b[i]=random.nextInt(bi-litt)+litt;
			 	if(cs==1)  //有乘除法
				{
			 		c[i]=random.nextInt(4);				 
				}
				if(cs==2) //没有乘除法
				{
					c[i]=random.nextInt(2);
				}
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
					
					if(b[i]!=0)
					{
						if(ys==1)
						{
							s=" ÷ ";
						}
						if(ys==2)
						{
							if((a[i]%b[i])==0)
							{
								s=" ÷ ";
							}
							else
								flag=1;
						}
					}
					else
						flag=1;
				}
				ss[i]=a[i]+s+b[i];
				if(c[i]==0)  //加法结果
					zsjieguod[i]=a[i]+b[i];
				if(c[i]==1)  //减法结果
					zsjieguod[i]=a[i]-b[i];
				if(c[i]==2)//乘法结果
					zsjieguod[i]=a[i]*b[i];
				if(c[i]==3)		//除法结果		
				{
					if(b[i]!=0)
					zsjieguod[i]=a[i]/b[i];
					if(b[i]==0)
						flag=1;
				}
				if(y3==1)//有括号生成
				{
					for(int  r=0;r<(y-2);r++)
					{
						y1=random.nextInt(2);//有无括号
						y2=random.nextInt(2);//前后
						d[r]=random.nextInt(bi-litt)+litt;
					
						if(cs==1)
						{
					 		c1[i]=random.nextInt(4);
						 
						}
						if(cs==2)
						{
							c1[i]=random.nextInt(2);
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
							
							if(b[i]!=0)
							{
								if(ys==1)
								{
									s=" ÷ ";
								}
								if(ys==2)
								{
									if((a[i]%b[i])==0)
									{
										s=" ÷ ";
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
						y1=random.nextInt(2);//有无括号
						y2=random.nextInt(2);//前后
						d[r]=random.nextInt(bi-litt)+litt;
					
						if(cs==1)
						{
					 		c1[i]=random.nextInt(4);
						 
						}
						if(cs==2)
						{
							c1[i]=random.nextInt(2);
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
							
							if(b[i]!=0)
							{
								if(ys==1)
								{
									s=" ÷ ";
								}
								if(ys==2)
								{
									if((a[i]%b[i])==0)
									{
										s=" ÷ ";
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
					System.out.println(ss[i]+" = ");
					String sql="insert into dbo.table2 values('"+i+"','"+ss[i]+"')";
					try
					{
						java.sql.Statement statement=conn.createStatement();
						statement.executeUpdate(sql);
					}
					catch(SQLException EE)
					{
						EE.printStackTrace();
					}
				}
				else
					i--;
		}
	  }
	
	}
	public static void fens(int bi,int sl)
	{
		String []ss=new String[sl];
		String s="";
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
		int fs=0,ys=0;
		Scanner in1=new Scanner(System.in);
		Random random=new Random();
		System.out.println("选择1.两位数运算2.多位数运算");
		int se=in1.nextInt();
		System.out.println("是否有乘除法1.有2.无");
		int cs=in1.nextInt();
		if(cs==1)
		{
			System.out.println("加减是否有负数1.有2.无");
			 fs=in1.nextInt();
			System.out.println("除法是否有余数1.有2.无");
			 ys=in1.nextInt();
		}
		if(cs==2)  //加减是否有负数
		{
			System.out.println("加减是否有负数1.有2.无");	// 1有 2没有
			 fs=in1.nextInt();
		}
		if(se==1)//两位数运算
		{
			for(int i=0;i<sl;i++)
			{
				flag1=0;
				flag2=0;
				a[i]=random.nextInt(bi-1-1)+1;
				a1[i]=random.nextInt(bi-1)+1;
				b[i]=random.nextInt(bi-1-1)+1;
				b1[i]=random.nextInt(bi-1)+1;
				if((a[i]>=a1[i])||(b[i]>=b1[i])) //判断是否为真分数
				{
					flag2=1;
				}
				else   //是真分数继续进行
				{
					flag2=0;
				}
				if(cs==1)
				{
					c[i]=random.nextInt(4);
				}
				if(cs==2)
				{
					c[i]=random.nextInt(2);
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
				int y=gongyue(a[i],a1[i]);
				int y1=gongyue(b[i],b1[i]);
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
					System.out.println(ss[i]+" ");
					String sql="insert into dbo.table3 values('"+i+"','"+ss[i]+"')";
					try
					{
						java.sql.Statement statement=conn.createStatement();
						statement.executeUpdate(sql);
					}
					catch(SQLException EE)
					{
						EE.printStackTrace();
					}
				}
				else
				{
					i--;
				}
			}

			}
		  if(se==2) //多位数式子
		  {

				int y=0;
				int y1=0;
				int y2=0;
				System.out.println("请选择，1.有括号2.无括号");
				int y3=in1.nextInt();
				
				for(int i=0;i<sl;i++)
				{
					
					int c1 []=new int [20000];
					flag1=0;
					flag2=0;
					y=random.nextInt(4)+3;//生成数的个数
					y1=random.nextInt(2);//有无括号
					y2=random.nextInt(2);//前后
					a[i]=random.nextInt(bi-1)+1;  //随机生成的前两个数
					a1[i]=random.nextInt(bi-1)+1;
					b[i]=random.nextInt(bi-1)+1;
					b1[i]=random.nextInt(bi-1)+1;
					if((a[i]>=a1[i])||(b[i]>=b1[i])) //判断是否为真分数
					{
						flag2=1;
					}
					else   //是真分数继续进行
					{
						flag2=0;
					}
				 	if(cs==1)  //有乘除法
					{
				 		c[i]=random.nextInt(4);				 
					}
					if(cs==2) //没有乘除法
					{
						c[i]=random.nextInt(2);
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
					int z=gongyue(a[i],a1[i]);
					int z1=gongyue(b[i],b1[i]);
					a[i]=a[i]/z;
					a1[i]=a1[i]/z;
					b[i]=b[i]/z1;
					b1[i]=b1[i]/z1;
					ss[i]=a[i]+"/"+a1[i]+s+b[i]+"/"+b1[i];
					if(y3==1)//有括号生成
					{
						for(int  r=0;r<(y-2);r++)
						{
							
							y1=random.nextInt(2);//有无括号
							y2=random.nextInt(2);//前后
							d[r]=random.nextInt(bi-1)+1;
							d1[r]=random.nextInt(bi-1)+1;
							int z3=gongyue(d[r],d1[r]);
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
							if(cs==1)
							{
						 		c1[i]=random.nextInt(4);
							 
							}
							if(cs==2)
							{
								c1[i]=random.nextInt(2);
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
							
							y1=random.nextInt(2);//有无括号
							y2=random.nextInt(2);//前后
							d[r]=random.nextInt(bi-1)+1;
							d1[r]=random.nextInt(bi-1)+1;
							int z4=gongyue(d[r],d1[r]);
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
							if(cs==1)
							{
						 		c1[i]=random.nextInt(4);
							 
							}
							if(cs==2)
							{
								c1[i]=random.nextInt(2);
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
						System.out.println(ss[i]+" = ");
						String sql="insert into dbo.table4 values('"+i+"','"+ss[i]+"')";
						try
						{
							java.sql.Statement statement=conn.createStatement();
							statement.executeUpdate(sql);
						}
						catch(SQLException EE)
						{
							EE.printStackTrace();
						}
					}
					else
						i--;
			}
		  
		  }
		}
	public static int gongbei(int x,int y)
	{
		int z;
		for(z=x;;z++)
		{
			if(z%x==0&&z%y==0)
				break;
		}
		return z;
	}
	public static int gongyue(int x,int y)
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

