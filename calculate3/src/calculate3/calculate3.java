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
		// TODO �Զ����ɵķ������
		int numtype;
		int little,big,num;
		int select;
		Scanner in=new Scanner(System.in);
		while(true)
		{
			System.out.println("��ѡ��1.����2.�����");
			numtype=in.nextInt();
			if(numtype==1)
			{
				System.out.println("��������Сֵ");
				little=in.nextInt();
				System.out.println("���������ֵ");
				big=in.nextInt();
				System.out.println("����������");
				num=in.nextInt();
				try
				{
					Class.forName(driverStr);
					System.out.println("���������ɹ�");
					conn=DriverManager.getConnection(connStr, dbusername, dbpassword);
					System.out.println("���ݿ����ӳɹ�");
					stmt=conn.createStatement();
					System.out.println("���ݿ����ӳɹ�");
				}
				catch(Exception ex)
				{
					System.out.println("�������ݿ�ʧ��");
				}
				zs(little,big,num);
			}
			if(numtype==2)
			{
				System.out.println("�������ĸ�����ֵ");
				big=in.nextInt();
				System.out.println("����������");
				num=in.nextInt();
				try
				{
					Class.forName(driverStr);
					conn=DriverManager.getConnection(connStr, dbusername, dbpassword);
					stmt=conn.createStatement();
				}
				catch(Exception ex)
				{
					System.out.println("�������ݿ�ʧ��");
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
		System.out.println("ѡ��1.��λ������2.��λ������");
		int se=in1.nextInt();
		System.out.println("�Ƿ��г˳���1.��2.��");
		int cs=in1.nextInt();
		if(cs==1)
		{
			System.out.println("�Ӽ��Ƿ��и���1.��2.��");
			 fs=in1.nextInt();
			System.out.println("�����Ƿ�������1.��2.��");
			 ys=in1.nextInt();
		}
		if(cs==2)  //�Ӽ��Ƿ��и���
		{
			System.out.println("�Ӽ��Ƿ��и���1.��2.��");	
			 fs=in1.nextInt();
		}
		if(se==1) //��λ��
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
							s=" �� ";
						}
						if(ys==2)
						{
							if((a[i]%b[i])==0)
							{
								s=" �� ";
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
				for(int i1=0;i1<i;i1++)   //����
				{
					if((a[i1]==a[i])&&(b[i1]==b[i])&&(c[i1]==c[i]))
						flag1=1;			
					if((a[i1]==b[i])&&(b[i1]==a[i])&&(c[i1]==0)&&(c[i]==0))
						flag1=1;
			
					if((a[i1]==b[i])&&(b[i1]==a[i])&&(c[i1]==2)&&(c[i]==2))
						flag1=1;
				}
				if((flag==0)&&(flag1==0))  //���
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
		if(se==2) //��λ��
		{
			int y=0;
			int y1=0;
			int y2=0;
			System.out.println("��ѡ��1.������2.������");
			int y3=in1.nextInt();
			
			for(int i=0;i<sl;i++)
			{
				
				int c1 []=new int [20000];
				flag1=0;
				y=random.nextInt(4)+3;//�������ĸ���
				y1=random.nextInt(2);//��������
				y2=random.nextInt(2);//ǰ��
				a[i]=random.nextInt(bi-litt)+litt;  //������ɵ�ǰ������
				b[i]=random.nextInt(bi-litt)+litt;
			 	if(cs==1)  //�г˳���
				{
			 		c[i]=random.nextInt(4);				 
				}
				if(cs==2) //û�г˳���
				{
					c[i]=random.nextInt(2);
				}
				if(fs==1)
				{
					flag=0;
				}
				if(fs==2)// û�и���
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
							s=" �� ";
						}
						if(ys==2)
						{
							if((a[i]%b[i])==0)
							{
								s=" �� ";
							}
							else
								flag=1;
						}
					}
					else
						flag=1;
				}
				ss[i]=a[i]+s+b[i];
				if(c[i]==0)  //�ӷ����
					zsjieguod[i]=a[i]+b[i];
				if(c[i]==1)  //�������
					zsjieguod[i]=a[i]-b[i];
				if(c[i]==2)//�˷����
					zsjieguod[i]=a[i]*b[i];
				if(c[i]==3)		//�������		
				{
					if(b[i]!=0)
					zsjieguod[i]=a[i]/b[i];
					if(b[i]==0)
						flag=1;
				}
				if(y3==1)//����������
				{
					for(int  r=0;r<(y-2);r++)
					{
						y1=random.nextInt(2);//��������
						y2=random.nextInt(2);//ǰ��
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
									s=" �� ";
								}
								if(ys==2)
								{
									if((a[i]%b[i])==0)
									{
										s=" �� ";
									}
									else
										flag=1;
								}
							}
							else
								flag=1;
						}
						if(y1==1) //���������û���������
						{
							if(y2==0) //���ں���
							{
								ss[i]=ss[i]+s+d[r];
							}
							if(y2==1)  //����ǰ��
							{
								ss[i]=d[r]+s+ss[i];

							}
						}
						if(y1==0) //���������������
						{
							if(y2==0)  //���ں���
							{
								ss[i]="("+ss[i]+")"+s+d[r];
								
							}
							if(y2==1)  //���ż���ǰ��
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
						y1=random.nextInt(2);//��������
						y2=random.nextInt(2);//ǰ��
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
									s=" �� ";
								}
								if(ys==2)
								{
									if((a[i]%b[i])==0)
									{
										s=" �� ";
									}
									else
										flag=1;
								}
							}
							else
								flag=1;
						}
						if(y1==1) //û������
						{
							if(y2==0) //���ں���
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

				} //Сfor ѭ��
				
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
		System.out.println("ѡ��1.��λ������2.��λ������");
		int se=in1.nextInt();
		System.out.println("�Ƿ��г˳���1.��2.��");
		int cs=in1.nextInt();
		if(cs==1)
		{
			System.out.println("�Ӽ��Ƿ��и���1.��2.��");
			 fs=in1.nextInt();
			System.out.println("�����Ƿ�������1.��2.��");
			 ys=in1.nextInt();
		}
		if(cs==2)  //�Ӽ��Ƿ��и���
		{
			System.out.println("�Ӽ��Ƿ��и���1.��2.��");	// 1�� 2û��
			 fs=in1.nextInt();
		}
		if(se==1)//��λ������
		{
			for(int i=0;i<sl;i++)
			{
				flag1=0;
				flag2=0;
				a[i]=random.nextInt(bi-1-1)+1;
				a1[i]=random.nextInt(bi-1)+1;
				b[i]=random.nextInt(bi-1-1)+1;
				b1[i]=random.nextInt(bi-1)+1;
				if((a[i]>=a1[i])||(b[i]>=b1[i])) //�ж��Ƿ�Ϊ�����
				{
					flag2=1;
				}
				else   //���������������
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
				if(fs==1)  //�и���
				{
					flag=0;
				}
				if(fs==2)  //û�и���
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
							s=" �� ";
						}
						if(ys==2)
						{
							if(((a[i]*b1[i])%(a1[i]*b[i]))==0)
							{
								s=" �� ";
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
				for(int i1=0;i1<i;i1++)   //����
				{
					if((a[i1]==a[i])&&(a1[i1]==a1[i])&&(b[i1]==b[i])&&(b1[i]==b1[i1])&&(c[i1]==c[i]))
						flag1=1;			
					if((a[i1]==b[i])&&(b[i1]==a[i])&&(c[i1]==0)&&(c[i]==0)&&(a1[i1]==b1[i])&&(b1[i1]==a1[i]))
						flag1=1;
			
					if((a[i1]==b[i])&&(b[i1]==a[i])&&(c[i1]==2)&&(c[i]==2)&&(a1[i1]==b1[i])&&(b1[i1]==a1[i]))
						flag1=1;
				}
				if((flag==0)&&(flag1==0)&&(flag2==0))  //���
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
		  if(se==2) //��λ��ʽ��
		  {

				int y=0;
				int y1=0;
				int y2=0;
				System.out.println("��ѡ��1.������2.������");
				int y3=in1.nextInt();
				
				for(int i=0;i<sl;i++)
				{
					
					int c1 []=new int [20000];
					flag1=0;
					flag2=0;
					y=random.nextInt(4)+3;//�������ĸ���
					y1=random.nextInt(2);//��������
					y2=random.nextInt(2);//ǰ��
					a[i]=random.nextInt(bi-1)+1;  //������ɵ�ǰ������
					a1[i]=random.nextInt(bi-1)+1;
					b[i]=random.nextInt(bi-1)+1;
					b1[i]=random.nextInt(bi-1)+1;
					if((a[i]>=a1[i])||(b[i]>=b1[i])) //�ж��Ƿ�Ϊ�����
					{
						flag2=1;
					}
					else   //���������������
					{
						flag2=0;
					}
				 	if(cs==1)  //�г˳���
					{
				 		c[i]=random.nextInt(4);				 
					}
					if(cs==2) //û�г˳���
					{
						c[i]=random.nextInt(2);
					}
					if(fs==1)
					{
						flag=0;
					}
					if(fs==2)// û�и���
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
								s=" �� ";
							}
							if(ys==2)
							{
								if(((a[i]*b1[i])%(a1[i]*b[i]))==0)
								{
									s=" �� ";
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
					if(y3==1)//����������
					{
						for(int  r=0;r<(y-2);r++)
						{
							
							y1=random.nextInt(2);//��������
							y2=random.nextInt(2);//ǰ��
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
										s=" �� ";
									}
									if(ys==2)
									{
									  if(y2==0)
									  {
										if((a[i]*b1[i])%(a1[i]*b[i])==0)
										{
											s=" �� ";
										}
										else
											flag=1;
									  }
									}
							}
							if(y1==0) //���������û���������
							{
								if((y2==0)&&(flag3==0)) //���ں���
								{
									ss[i]=ss[i]+s+d[r]+"/"+d1[r];
								}
								if((y2==1)&&(flag3==0))  //����ǰ��
								{
									ss[i]=d[r]+"/"+d1[r]+s+ss[i];

								}
							}
							if(y1==1) //���������������
							{
								if((y2==0)&&(flag3==0))  //���ں���
								{
									ss[i]="("+ss[i]+")"+s+d[r]+"/"+d1[r];
									
								}
								if((y2==1)&&(flag3==0))  //���ż���ǰ��
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
					if(y3==2)  //û������
					{
						for(int  r=0;r<(y-2);r++)
						{
							
							y1=random.nextInt(2);//��������
							y2=random.nextInt(2);//ǰ��
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
										s=" �� ";
									}
									if(ys==2)
									{
										if((a[i]*b1[i])%(a1[i]*b[i])==0)
										{
											s=" �� ";
										}
										else
											flag=1;
									}
							}
						
							if(y1==1) //û������
							{
								if((y2==0)&&(flag3==0)) //���ں���
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
					} //Сfor ѭ��
					
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

