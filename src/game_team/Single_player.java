package game_team;

import java.util.*;
import game_team.*;

public class Single_player {	
	public void show()
	{
		Scanner sc=new Scanner(System.in);		
		int TrueRate=0;		//�q������
		int k=0;	//��J����
		long time=0;	//�֭p�ɶ�
		int t=-1,guess=1;
		
		random__Not_repeat site= new random__Not_repeat();	//�üƨ��a����m
		int[] answer=site.Array();	//�a����m
		int n=site.n;	//���a��J���ѽL�j�p
		
		int[] A=new int[n*n];	//���a��J�L����m				
		
		System.out.println("==============");	
		for(int j=1;j<=n*n;j++)		//��X�ѽL
		{			
			A[j-1]=j;
			if(j<10)
				System.out.print("0"+A[j-1]+" ");	
			else
				System.out.print(A[j-1]+" ");	
			if(j%n==0)
			{
				System.out.println();						
			}			
		}		
		System.out.println("==============");			
		System.out.println("�п�J�a����m");	
		while(answer.length-TrueRate!=0)		//�L���`��
		{						
			long time1 = System.currentTimeMillis();	//�p�ɶ}�l							
			do
			{
				try 
				{
					guess=sc.nextInt();		//���a��J�a����m	
					if(guess==0 || guess>n*n)
					{
						System.out.printf("�Э��s��J�a����m(�Ʀr):\r\n");
						t=-1;
					}
					else
						t=0;
				}
				catch(InputMismatchException | ArrayIndexOutOfBoundsException e)
				{				
					System.out.printf("�Э��s��J�a����m(�Ʀr):\r\n",sc.next());
					t=-1;
				}	
			}while(t==-1);
						
			long time2 = System.currentTimeMillis();	//�p�ɵ���			
			time+=(time2-time1);	//��J��O�ɶ�
			
			if(A[guess-1]==0 || A[guess-1]==-1 )	//�O�_���ƿ�J
			{
				System.out.println("���ƿ�J�A�Э��s��J");
				continue ;
			}
			for(int i=0;i<answer.length;i++)	//�T�{��m�O�_���T
			{				
				if(answer[i]==guess)
				{					
					TrueRate++;		//�q����m							
					A[guess-1]=0;	//�ѽL�Ƭ�0
					break;
				}	
				A[guess-1]=-1;
			}	
			for(int j=1;j<=n*n;j++)		//��X�ѽL
			{			
				if(A[j-1]<10 && A[j-1]!=-1 && A[j-1]!=0)
					System.out.print("0"+j+" ");	
				else if(A[j-1]==0)			
					System.out.print(" O ");	//��J���T						
				else if(A[j-1]==-1)				
					System.out.print(" X ");	//��J���~								
				else
					System.out.print(j+" ");	
				if(j%n==0)
				{
					System.out.println();						
				}
			}	
			if(answer.length-TrueRate!=0)
				System.out.println("==============\r\n��J����:"+(k+1)+"\r\n�����a���ƥ�:"+TrueRate
					+"\r\n�Ѿl�a���ƥ�:"+(answer.length-TrueRate)+"\r\n�ֿn��O�ɶ�:"+time/1000+"��");										
			k++;
		}
		System.out.println("==============\r\n�a����������!\r\n�P�¹C��!\r\n"
				+"�z����J����:"+k+"\r\n�����a���ƥ�:"+TrueRate
				+"\r\n�Ѿl�a���ƥ�:"+(answer.length-TrueRate)+"\r\n�����v:"+(float)TrueRate/(k+1)
				+"\r\n�ֿn��O�ɶ�:"+time/1000+"��");	
	}		
}