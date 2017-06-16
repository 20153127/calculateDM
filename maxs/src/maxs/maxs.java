package maxs;
import java.util.*;
public class maxs {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); 
        int num;
        System.out.println("请输入数组长度");
        num=sc.nextInt();
        int zif[]=new int[num];//分别的数组
        int neir[]=new int[num]; //数组里面的数
        int sum1[]=new int[num]; //最大值
        int d=sum1[0];
        System.out.println("请输入数组内容：");
        for(int i=0;i<num;i++)//输入num个数
        {
            neir[i]=sc.nextInt();
        }       
         for(int j=0;j<num;j++)   
        {
            for(int k=0;k<num;k++)   //分别从0-num 1-num-0 .....
            {
                zif[k]=neir[(j+k)%num];
            }
            int sum=zif[0];//记录数组和
            int b=0;//进行记录
        
            for(int i=0;i<num;i++)
            {
                if(b<0)
                {
                    b=zif[i]; //b<0,b为加为负数那位的后一位
                }
                else
                {
                    b+=zif[i];
                }
                if(sum<b)
                {
                    sum=b; //sum为当前最大子数组的和
                }
                sum1[j]=sum;
            }
            if(d<sum1[j])
            {
                d=sum1[j]; //得到最终的最大和
            }
        }
        System.out.print("最大子数组和为：");
        System.out.print(d);
    }
}