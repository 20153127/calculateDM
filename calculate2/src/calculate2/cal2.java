package calculate2;
import java.util.*;
public class cal2 {
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		Scanner input=new Scanner(System.in);
		 int num=0;int little=0; int big=0; int select=0;int select2=0;
		System.out.println("请输入需要打印的数量");
		  num=input.nextInt();
		 System.out.println("请输入最小范围");
		 little=input.nextInt();
		 System.out.println("请输入最大范围");
		 big=input.nextInt();
		 System.out.println("请选择：1.整数2.分数");
		int  type=input.nextInt();
		if(type==1)
		{
		  System.out.println("是否需要乘除法1.需要2.不需要");
		  select=input.nextInt();
		 if(select==1)
		 {

				 cc(little,big,num);
			
		 }
		 if(select==2)
		 {
				 jj(little,big,num);
			
		 }
		}
		if(type==2)
		{
			System.out.println("是否需要乘除法1.需要2.不需要");
			select2=input.nextInt();
			if(select2==1)
			{
				fscc(big,num);
			}
			if(select2==2)
			{
				fsjj(big,num);
			}
		}

	}
	public static void cc(int a,int b,int c)  // 乘除
	{
	
		boolean flag=true;
		boolean flag3=true;	
		Random random=new Random();
		Scanner in=new Scanner(System.in);
		int m[]=new int [1000];
		int n[]=new int [1000];
		int p[]=new int [1000];
		System.out.println("减法是否有负数1.可以有2.无");
		int fs=in.nextInt();
		System.out.println("除法是否有余数1.可以有2.无");
		int ys=in.nextInt();
		for(int i=0;i<c;i++) //生成式子
		{
			m[i]=random.nextInt(4);
			n[i]=random.nextInt(b-a)+a;
			p[i]=random.nextInt(b-a)+a;
			int r=i-1;		
			while(r>=0)  // 判断重复，重新生成式子
			{
				if(m[i]==m[r]&&n[i]==n[r]&&p[i]==p[r])
				{
					 m[i]=random.nextInt(4);
					 n[i]=random.nextInt(b-a)+a;
					 p[i]=random.nextInt(b-a)+a;
					 r=i;
				}
				else if(m[i]==2&&m[r]==2&&n[i]==p[r]&&n[r]==p[i])
				{
					 m[i]=random.nextInt(4);
					 n[i]=random.nextInt(b-a)+a;
					 p[i]=random.nextInt(b-a)+a;
					 r=i;
				}
				else if(m[i]==0&&m[r]==0&&n[i]==p[r]&&p[i]==n[r])
				{
					 m[i]=random.nextInt(4);
					 n[i]=random.nextInt(b-a)+a;
					 p[i]=random.nextInt(b-a)+a;
					 r=i;
				}
				r--;
			}
			if(m[i]==0)
			{
				System.out.println(n[i]+"+"+p[i]);
			}
			if(m[i]==1)
			{

				if(fs==1)
				{
					System.out.println(n[i]+"-"+p[i]);
				}
				else if(fs==2)
				{
					if(n[i]>=p[i])
					{
					  System.out.println(n[i]+"-"+p[i]);					  
					}
					if(n[i]<p[i])
					{
						int j=i-1;
						flag=true;
						while(flag)
						{
							 n[i]=random.nextInt(b-a)+a;
							 p[i]=random.nextInt(b-a)+a;						
							   
								while(j>=0)  // 重复，重新生成式子
								{
									if(n[i]==n[j]&&p[i]==p[j])
									{										 
										 n[i]=random.nextInt(b-a)+a;
										 p[i]=random.nextInt(b-a)+a;
										 j=i;
									}
									j--;
								}
							 if(n[i]>p[i])
							 {  
								 System.out.println(n[i]+"-"+p[i]); 
							   flag=false;
							  }
						}
						
					}
				}
			}
			if(m[i]==2)
			{
				System.out.println(n[i]+"*"+p[i]);
			}
			if(m[i]==3)
			{
				
				if(ys==1) //   有余数   
				{
					 System.out.println(n[i]+"/"+p[i]);					 
				}
				if(ys==2) //没有余数
				{
					if(n[i]%p[i]==0)
					{
						System.out.println(n[i]+"/"+p[i]);
					}
					else if(n[i]%p[i]!=0)
					{
						flag3=true;
						while(flag3)
						{
						   n[i]=random.nextInt(b-a)+a;
						   p[i]=random.nextInt(b-a)+a;
						    int j=i-1;
							while(j>=0)  // 重复，重新生成式子
							{
								if(n[i]==n[j]&&p[i]==p[j])
								{										 
									 n[i]=random.nextInt(b-a)+a;
									 p[i]=random.nextInt(b-a)+a;
									 j=i;
								}
								j--;
							}
							if(n[i]%p[i]==0) // 如果相除没有余数
							{
								System.out.println(n[i]+"/"+p[i]);
								flag3=false;
							}
					   }
					}
				}
			
			}			
		}
	}
	public static void jj(int a,int b,int c) //加减
	{
		int u;
		boolean flag=true;
		Random random=new Random();
		Scanner in=new Scanner(System.in);
		int m[]=new int [1000];
		int n[]=new int [1000];
		int p[]=new int [1000];
		System.out.println("有无负数1.可以有2.没有");
		u=in.nextInt();
		for(int i=0;i<c;i++)
		{
			 m[i]=random.nextInt(2);
			 n[i]=random.nextInt(b-a)+a;
			 p[i]=random.nextInt(b-a)+a;

			int r=i-1;
			while(r>=0)
			{
				if(m[i]==m[r]&&n[i]==n[r]&&p[i]==p[r])
				{
					 m[i]=random.nextInt(2);
					 n[i]=random.nextInt(b-a)+a;
					 p[i]=random.nextInt(b-a)+a;
					 r=i;
				}
				if(m[i]==0&&m[r]==0&&n[i]==p[r]&&p[i]==n[r])
				{
					m[i]=random.nextInt(2);
					 n[i]=random.nextInt(b-a)+a;
					 p[i]=random.nextInt(b-a)+a;
					 r=i;
				}
				r--;
			}
			if(u==1&&m[i]==0)
			{
				System.out.println(n[i]+"+"+p[i]);
			}
			if(u==1&&m[i]==1)
			{
				System.out.println(n[i]+"-"+p[i]);
			}
			if(u==2&&m[i]==0)
			{
				System.out.println(n[i]+"+"+p[i]);
			}
			if(u==2&&m[i]==1)
			{
				if(n[i]>p[i])
					System.out.println(n[i]+"-"+p[i]);
				if(n[i]<p[i])
				{
					flag=true;
					while(flag)
					{
						n[i]=random.nextInt(b-a)+a;
					    p[i]=random.nextInt(b-a)+a;
					    int j=i-1;
						while(r>=0)  // 重复，重新生成式子
						{
							if(n[i]==n[j]&&p[i]==p[j])
							{										 
								 n[i]=random.nextInt(b-a)+a;
								 p[i]=random.nextInt(b-a)+a;
								 j=i;
							}
							j--;
						}
					    if(n[i]>=p[i])
					    {flag=false;}
					}
					System.out.println(n[i]+"-"+p[i]);
				}
			}
		}
	}
	public static void fscc(int a,int c)

	{
		int x=0;int y=0;int z=0;
		Random random=new Random();
		Scanner in=new Scanner(System.in);
		System.out.println("是否有负数1.可以有2.无");
		int fs=in.nextInt();
				
		System.out.println("是否有余数1.可以有2.无");
		int ys=in.nextInt();
		int m[]=new int [1000];
		int n[]=new int[1000];
		int o[]=new int[1000];
		int p[]=new int[1000];
		int q[]=new int[1000];
		for(int i=0;i<c;i++)
		{
			m[i]=random.nextInt(4);
			n[i]=random.nextInt(a)+1;
			o[i]=random.nextInt(a)+1;
			p[i]=random.nextInt(a)+1;
			q[i]=random.nextInt(a)+1;
			int r=i-1;
			boolean flag=true;
			boolean flag1=true;
			while(flag)
			{
				if(n[i]>=o[i])
				{
					n[i]=random.nextInt(a)+1;
					o[i]=random.nextInt(a)+1;
					if(n[i]<o[i])
					{
						flag=false;
					}
				}
				if(n[i]<o[i])
				{
					flag=false;
				}
			}
			while(flag1)
			{
				if(p[i]>=q[i])
				{
					p[i]=random.nextInt(a)+1;
					q[i]=random.nextInt(a)+1;
					if(p[i]<q[i])
					{
						flag1=false;
					}
				}
				if(p[i]<q[i])
				{
					flag1=false;
				}
			}
			while(r>=0)
			{
				if(m[i]==m[r]&&n[i]==n[r]&&o[i]==o[r]&&p[i]==p[r]&&q[i]==q[r])
				{
					m[i]=random.nextInt(4);
					n[i]=random.nextInt(a)+1;
					o[i]=random.nextInt(a)+1;
					p[i]=random.nextInt(a)+1;
					q[i]=random.nextInt(a)+1;
					r=i;
				}
				if(m[i]==0&&m[r]==0&&n[i]==n[r]&&o[i]==o[r]&&p[i]==p[r]&&q[i]==q[r])
				{
					m[i]=random.nextInt(4);
					n[i]=random.nextInt(a)+1;
					o[i]=random.nextInt(a)+1;
					p[i]=random.nextInt(a)+1;
					q[i]=random.nextInt(a)+1;
					r=i;
				}
				if(m[i]==2&&m[r]==2&&n[i]==n[r]&&o[i]==o[r]&&p[i]==p[r]&&q[i]==q[r])
				{
					m[i]=random.nextInt(4);
					n[i]=random.nextInt(a)+1;
					o[i]=random.nextInt(a)+1;
					p[i]=random.nextInt(a)+1;
					q[i]=random.nextInt(a)+1;
					r=i;
				}
				r--;
			}
			
			if(m[i]==0)
			{
				y=gongyue(p[i],q[i]);
				z=gongyue(n[i],o[i]);
				System.out.println(n[i]/z+"/"+o[i]/z+" + "+p[i]/y+"/"+q[i]/y);
			}
			if(m[i]==1)
			{
				x=gongbei(o[i],q[i]);
				y=gongyue(p[i],q[i]);
				z=gongyue(n[i],o[i]);
				if(fs==1) //可以有负数
				{
					System.out.println(n[i]/z+"/"+o[i]/z+" - "+p[i]/y+"/"+q[i]/y);
				}
				if(fs==2)  //没有负数
				{
					
					if(n[i]*x/o[i]>=p[i]*x/q[i])
					{
						System.out.println(n[i]/z+"/"+o[i]/z+" - "+p[i]/y+"/"+q[i]/y);
					}
					if(n[i]*x/o[i]<p[i]*x/q[i])
					{
						boolean flag2=true;
						int j=i-1;
						while(flag2)
						{
							n[i]=random.nextInt(a)+1;
							o[i]=random.nextInt(a)+1;
							p[i]=random.nextInt(a)+1;
							q[i]=random.nextInt(a)+1;
							while(j>=0)
							{
								if(n[i]==n[j]&&o[i]==o[j]&&p[i]==p[j]&&q[i]==q[j])
								{
									n[i]=random.nextInt(a)+1;
									o[i]=random.nextInt(a)+1;
									p[i]=random.nextInt(a)+1;
									q[i]=random.nextInt(a)+1;
									j=i;
								}
								j--;
							}
							if(n[i]*x/o[i]>=p[i]*x/q[i])
							{
								int y2=gongyue(p[i],q[i]);
								int z2=gongyue(n[i],o[i]);
								System.out.println(n[i]/z2+"/"+o[i]/z2+" - "+p[i]/y2+"/"+q[i]/y2);
								flag2=false;
							}
						}
					}
				}
			

			}//
			if(m[i]==2)
			{
				y=gongyue(p[i],q[i]);
				z=gongyue(n[i],o[i]);
				System.out.println(n[i]/z+"/"+o[i]/z+" * "+p[i]/y+"/"+q[i]/y);
			}
			if(m[i]==3)
			{
				y=gongyue(p[i],q[i]);
				z=gongyue(n[i],o[i]);
				if(ys==1)
				{
					System.out.println(n[i]/z+"/"+o[i]/z+" / "+p[i]/y+"/"+q[i]/y);
				}
				if(ys==2)
				{
					int w1=n[i]*q[i];
					int w2=p[i]*o[i];
					
					if((w1%w2)==0)
					{
						System.out.println(n[i]/z+"/"+o[i]/z+" / "+p[i]/y+"/"+q[i]/y);
					}
					if((w1%w2)!=0)
					{
						int j=i-1;
						boolean flag3=true;
						while(flag3)
						{
							n[i]=random.nextInt(a)+1;
							o[i]=random.nextInt(a)+1;
							p[i]=random.nextInt(a)+1;
							q[i]=random.nextInt(a)+1;
						
							while(j>=0)
							{
								if(n[i]==n[j]&&o[i]==o[j]&&p[i]==p[j]&&q[i]==q[j])
								{
									n[i]=random.nextInt(a)+1;
									o[i]=random.nextInt(a)+1;
									p[i]=random.nextInt(a)+1;
									q[i]=random.nextInt(a)+1;
									j=i;
								}
								j--;
							}
							int w3=n[i]*q[i];
							int w4=o[i]*p[i];
							if((w3%w4)==0)
							{
								int y1=gongyue(p[i],q[i]);
								int z1=gongyue(n[i],o[i]);
								System.out.println(n[i]/z1+"/"+o[i]/z1+" / "+p[i]/y1+"/"+q[i]/y1);
								flag3=false;
							}
						}
					}
				}
			}
		}
	}
	public static void fsjj(int a,int c)
	{
		int m[]=new int [1000];
		int n[]=new int [1000];
		int o[]=new int [1000];
		int p[]=new int [1000];
		int q[]=new int [1000];
		int x=0;int y=0;int z=0;
		Random random=new Random();
		Scanner in=new Scanner(System.in);
		int fs=0;
		System.out.println("请选择是否负数1.可以有2.无");
		fs=in.nextInt();
		for(int i=0;i<c;i++)
		{
			m[i]=random.nextInt(2);
			n[i]=random.nextInt(a)+1;
			o[i]=random.nextInt(a)+1;
			p[i]=random.nextInt(a)+1;
			q[i]=random.nextInt(a)+1;
			int r=i-1;
			boolean flag=true;
			boolean flag1=true;
			while(flag)
			{
				if(n[i]>=o[i])
				{
					n[i]=random.nextInt(a)+1;
					o[i]=random.nextInt(a)+1;
					if(n[i]<o[i])
					{
						flag=false;
					}
				}
				if(n[i]<o[i])
				{
					flag=false;
				}
			}
			while(flag1)
			{
				if(p[i]>=q[i])
				{
					p[i]=random.nextInt(a)+1;
					q[i]=random.nextInt(a)+1;
					if(p[i]<q[i])
					{
						flag1=false;
					}
				}
				if(p[i]<q[i])
				{
					flag1=false;
				}
			}
			while(r>=0)
			{
				if(m[i]==m[r]&&n[i]==n[r]&&o[i]==o[r]&&p[i]==p[r]&&q[i]==q[r])
				{
					m[i]=random.nextInt(2);
					n[i]=random.nextInt(a)+1;
					o[i]=random.nextInt(a)+1;
					p[i]=random.nextInt(a)+1;
					q[i]=random.nextInt(a)+1;
					r=i;
				}
				if(m[i]==0&&m[r]==0&&n[i]==n[r]&&o[i]==o[r]&&p[i]==p[r]&&q[i]==q[r])
				{
					m[i]=random.nextInt(2);
					n[i]=random.nextInt(a)+1;
					o[i]=random.nextInt(a)+1;
					p[i]=random.nextInt(a)+1;
					q[i]=random.nextInt(a)+1;
					r=i;
				}
				if(m[i]==2&&m[r]==2&&n[i]==n[r]&&o[i]==o[r]&&p[i]==p[r]&&q[i]==q[r])
				{
					m[i]=random.nextInt(2);
					n[i]=random.nextInt(a)+1;
					o[i]=random.nextInt(a)+1;
					p[i]=random.nextInt(a)+1;
					q[i]=random.nextInt(a)+1;
					r=i;
				}
				r--;
			}
			if(m[i]==0)
			{
				y=gongyue(p[i],q[i]);
				z=gongyue(n[i],o[i]);
				System.out.println(n[i]/z+"/"+o[i]/z+" + "+p[i]/y+"/"+q[i]/y);
			}
			if(m[i]==1)
			{
				x=gongbei(o[i],q[i]);
				y=gongyue(p[i],q[i]);
				z=gongyue(n[i],o[i]);
				if(fs==1) //可以有负数
				{
					System.out.println(n[i]/z+"/"+o[i]/z+" - "+p[i]/y+"/"+q[i]/y);
				}
				if(fs==2)  //没有负数
				{
					if(n[i]*x/o[i]>=p[i]*x/q[i])
					{
						System.out.println(n[i]/z+"/"+o[i]/z+" - "+p[i]/y+"/"+q[i]/y);
					}
					if(n[i]*x/o[i]<p[i]*x/q[i])
					{
						boolean flag2=true;
						int j=i-1;
						while(flag2)
						{
							n[i]=random.nextInt(a)+1;
							o[i]=random.nextInt(a)+1;
							p[i]=random.nextInt(a)+1;
							q[i]=random.nextInt(a)+1;
							while(j>=0)
							{
								if(n[i]==n[j]&&o[i]==o[j]&&p[i]==p[j]&&q[i]==q[j])
								{
									n[i]=random.nextInt(a)+1;
									o[i]=random.nextInt(a)+1;
									p[i]=random.nextInt(a)+1;
									q[i]=random.nextInt(a)+1;
									j=i;
								}
								j--;
							}
							if(n[i]*x/o[i]>=p[i]*x/q[i])
							{
								System.out.println(n[i]/z+"/"+o[i]/z+" - "+p[i]/y+"/"+q[i]/y);
								flag2=false;
							}
						}
					}
				}
			

			}//
			
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
