package maxshzu;
import java.util.*;
public class max {
	 
    public static void main(String[] args) {
        int a[]=  new   int[5];
        int start = 0,end = 0;
        int max = a[0],s = a[0];
        Scanner in=new Scanner(System.in);
        System.out.println("������5���������飺");
        for(int i=0;i<5;i++)
        {
        	a[i]=in.nextInt();
        }
        for(int i=0;i<a.length;i++)
        {
            s = a[i];
            if(s > max)
            {
                max = s;
                start = i;
                end = i;
            }
            for(int j=i+1;j<a.length;j++)
            {
                s+=a[j];
                if(s > max)
                {
                    max = s;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println("���������Ϊ��");
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println("���������ĺ��ǣ�"+max);
        System.out.println("���������Ϊ��");
        for(int i = start;i<=end;i++)
        {         
            System.out.print(a[i]+" ");
        }
    }
 
}
