package game_team;

import java.util.*;
import game_team.*;

class player
{
	public int id;	//���aid
	public int True=0,Blow=0;	//�����B��������	
	long time=0;	//�֭p�ɶ�
}
public class Multiplayer {
	public void show()
	{
		Scanner sc=new Scanner(System.in);
		random__Not_repeat site= new random__Not_repeat();	//�üƨ��a����m
		int[] answer=site.Array();	//�a����m
		int n=site.n;	//���a��J���ѽL�j�p
		int[] A=new int[n*n];	//���a��J�L����m				
		int TrueRate=0;		//�`�q������	
		int over=0;		//���U�@�쪱�a�̾�	
		int t=-1,guess=1,num=0;

		System.out.println("�п�J���a�H��");		
		
		while(t==-1)		//�T�{�O�_���ҥ~�B�z
		{
			try 
			{
				num=sc.nextInt();	//���a�H��	
				t=0;
			}
			catch(InputMismatchException e)
			{				
				System.out.printf("�Э��s��J:\r\n",sc.next());
				t=-1;
			}
		}
		 	
		player[] user=new player[num];	//���a�}�C				
				
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
		for(int i=0;i<num;i++)
		{
			user[i]=new player();	//�إߪ��a����
			user[i].id=i;			
		}		
		while(answer.length-TrueRate!=0)
		{			
			for(int N=0;N<num;N++)	
			{										
				while(answer.length-TrueRate!=0 && over!=-1)	//�L���`��
				{										
					System.out.println("���a"+(N+1)+"�п�J�a����m");
					
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
					user[N].time+=(time2-time1);

					if(A[guess-1]==0 || A[guess-1]==-1)	//�O�_���ƿ�J
					{
						System.out.println("���ƿ�J�A�Э��s��J");
						continue ;
					}									
					for(int i=0;i<answer.length;i++)	//�T�{��m�O�_���T
					{				
						if(answer[i]==guess)
						{					
							user[N].True++;
							TrueRate++;		//�`�q����m							
							A[guess-1]=0;	//�ѽL�Ƭ�0	
							over=0;	//�����A�~��C��
							break;
						}
						else	
						{
							A[guess-1]=-1;
							over=-1;	//�������A���U�@�쪱�a				
						}					
					}							
					user[N].Blow++;				
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
							System.out.println();											
					}		
					System.out.println("���a"+(N+1)+":\r\n��J����:"+user[N].Blow+"\r\n�����a���ƥ�:"+user[N].True
						+"\r\n�Ѿl�a���ƥ�:"+(answer.length-TrueRate)
						+"\r\n�ֿn��O�ɶ�:"+user[N].time/1000+"��\r\n==============");										
				}
					over=0;						
			}
		}	
		int max=0;
		int First=0;	//�Ĥ@�W
		String s="";
		for(int k=0;k<num;k++)
		{
			if(user[k].True>max)
			{
				max=user[k].True;
				First=k;	
				s="�Ĥ@�W�����a"+(First+1)+"\r\n�z����J����:"+user[First].Blow
						+"\r\n�����a���ƥ�:"+user[First].True
						+"\r\n�����v:"+(float)user[First].True/user[First].Blow
						+"\r\n�ֿn��O�ɶ�:"+user[First].time/1000+"��";
			}	
			if(user[k].True==user[First].True && First!=k)
			{
				s="���a"+(First+1)+"�M���a"+(k+1)+"�P���Ĥ@\r\n���a"+(First+1)+"�z����J����:"+user[First].Blow
						+"\r\n�����a���ƥ�:"+user[First].True
						+"\r\n�����v:"+(float)user[First].True/user[First].Blow
						+"\r\n�ֿn��O�ɶ�:"+user[First].time/1000+"��"
						+"\r\n���a"+(k+1)+"�z����J����:"+user[k].Blow
						+"\r\n�����a���ƥ�:"+user[k].True
						+"\r\n�����v:"+(float)user[k].True/user[k].Blow
						+"\r\n�ֿn��O�ɶ�:"+user[k].time/1000+"��";
			}
		}			
		System.out.println("�a����������!\r\n�P�¹C��!\r\n==============\r\n"+s);		
	}
}