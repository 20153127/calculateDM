package maxs;
import java.util.*;
public class maxs {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); 
        int num;
        System.out.println("���������鳤��");
        num=sc.nextInt();
        int zif[]=new int[num];//�ֱ������
        int neir[]=new int[num]; //�����������
        int sum1[]=new int[num]; //���ֵ
        int d=sum1[0];
        System.out.println("�������������ݣ�");
        for(int i=0;i<num;i++)//����num����
        {
            neir[i]=sc.nextInt();
        }       
         for(int j=0;j<num;j++)   
        {
            for(int k=0;k<num;k++)   //�ֱ��0-num 1-num-0 .....
            {
                zif[k]=neir[(j+k)%num];
            }
            int sum=zif[0];//��¼�����
            int b=0;//���м�¼
        
            for(int i=0;i<num;i++)
            {
                if(b<0)
                {
                    b=zif[i]; //b<0,bΪ��Ϊ������λ�ĺ�һλ
                }
                else
                {
                    b+=zif[i];
                }
                if(sum<b)
                {
                    sum=b; //sumΪ��ǰ���������ĺ�
                }
                sum1[j]=sum;
            }
            if(d<sum1[j])
            {
                d=sum1[j]; //�õ����յ�����
            }
        }
        System.out.print("����������Ϊ��");
        System.out.print(d);
    }
}