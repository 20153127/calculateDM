package cal;
import java.util.*;
public class calculater {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	
		Scanner in=new Scanner(System.in);
		int num=0; 
	   	int large=0;
	   	int little=0;
		boolean flag=true;
		while(flag)     //������Ҫ��ӡ��Ŀ�ĸ���
		{
			System.out.println("��������Ҫ���ɵ���Ŀ����");
			num=in.nextInt();
			System.out.println("��������Ŀ����");
			large=in.nextInt();
			System.out.println("��������Ŀ����");
			little=in.nextInt();
			flag=false;
		}
		String n[]=new String [num];
		for(int i=0;i<num;i++)  //������Ŀ�ظ�
		{	
			n[i]=calc(little,large);	
			int j=i-1;
			while(j>=0)
			{
				if(n[i].equals(n[j]))  //��Ŀ�ظ�ʱ����������
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

	public static String calc(int a,int b) //������������ֱ�ӵ�������������Ϸ��ţ�
	{ 
		int f=0;int x=0;int y=0;
		Random random=new Random();
		String [] fh=new String [4];
		
	     f=random.nextInt(4);
		 x=random.nextInt(b-a)+a;      //����0--b-aֱ�ӵ�����Ȼ����+a ���õõ�a-bֱ�ӵ������
	     y=random.nextInt(b-a)+a;
	     fh[0]="+";
		fh[1]="-";
		fh[2]="*";
		fh[3]="/";
		if(f==3&&y==0)
		{
			 y=random.nextInt(b-a)+a;
		}
		int z=x-y;
		if(f==1&&z<0)
		{int t=x;
	       x=y;
	       y=t;}
		return x+fh[f]+y+"=?";
	}

}
