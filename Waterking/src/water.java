import java.util.*;
public class water {
    public static  void main(String args[]){
        @SuppressWarnings("resource")
		Scanner input =new Scanner(System.in);     
        System.out.println("请输入ID的个数：");
        int a=input.nextInt();
        int b[]=new int[a];
        System.out.println("请输入ID（水王发帖数大于一半）");
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
         
        System.out.println("水王为"+water);
    }
}