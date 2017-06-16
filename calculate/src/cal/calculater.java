package cal;
import java.util.*;
public class calculater {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	
		Scanner in=new Scanner(System.in);
		int num=0; 
	   	int large=0;
	   	int little=0;
	
		boolean flag=true;
		while(flag)     //控制需要打印题目的个数
		{
			System.out.println("请输入需要生成的题目数量");
			num=in.nextInt();
			System.out.println("请输入题目上限");
			large=in.nextInt();
			System.out.println("请输入题目下限");
			little=in.nextInt();
		
			flag=false;
		}
		String n[]=new String [num];
		for(int i=0;i<num;i++)  //避免题目重复
		{	
			n[i]=calc(little,large);	
			int j=i-1;
			while(j>=0)
			{
				if(n[i].equals(n[j]))  //题目重复时，重新生成
				{
					n[i]=calc(little,large);
					j=i;
				}
				j--;
			}
			
			System.out.println(n[i]);
	
		}

		in.close();	
	}

	public static String calc(int a,int b) //生成两个界限直接的随机数，并加上符号，
	{ 
		Scanner input=new Scanner(System.in);
		int f=0;int x=0;int y=0;
		Random random=new Random();
		String [] fh=new String [4];

			
	     f=random.nextInt(4);
		 x=random.nextInt(b-a)+a;      //生成0--b-a直接的数，然后再+a 正好得到a-b直接的随机数
	     y=random.nextInt(b-a)+a;
	     fh[0]="+";
		fh[1]="-";
		fh[2]="*";
		fh[3]="/";
		int select=0;
	    System.out.println("请输入需求的附加条件:  1.没有乘除法2.有括号运算3.加减无负数4.除法无余数");
		select=input.nextInt();
		if(select==1&&f==2)
		{
			
		}
		if(f==3&&y==0)
		{
			 y=random.nextInt(b-a)+a;
		}
		int z=x-y;
		if(f==1&&z<0)
		{  
		   int t=x;
	       x=y;
	       y=t;}
		return x+fh[f]+y+"=?";
	}

}
