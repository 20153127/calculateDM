import java.util.*;
public class water {
    public static  void main(String args[]){
        @SuppressWarnings("resource")
		Scanner input =new Scanner(System.in);     
        System.out.println("������ID�ĸ�����");
        int a=input.nextInt();
        int b[]=new int[a];
        System.out.println("������ID��ˮ������������һ�룩");
        for(int i=0;i<a;i++)
        {
            b[i]=input.nextInt();
        }
         
        int water=b[0];
        int k=1;
        for(int i=1;i<a;i++)
        {
            if(water!=b[i])
            {
                k=k-1;
                if(k<=0)
                {
                    water=b[i+1];
                    k=1;
                    i++;
                }
            }
            else
            {
                water=b[i];
                k=k+1;
            }
        }
         
        System.out.println("ˮ��Ϊ"+water);
    }
}