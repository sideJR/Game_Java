package game_team;

import game_team.*;
import java.util.*;

public class random__Not_repeat //�üƨ�������
{						 					
			Scanner sc=new Scanner(System.in);
			int n=0,num=0;	//�ѽL�j�p�B�a���ƥ�		
			int t=-1;			
			public int[] Array()
			{				
				while(t==-1)		//�T�{�O�_���ҥ~�B�z
				{
					try 
					{
						n=sc.nextInt();	//��J�ѽL�j�p�B�a���ƥ�
						num=sc.nextInt();
						t=0;
					}
					catch(InputMismatchException e)
					{				
						System.out.printf("�Э��s��J�ѽL�j�p�B�a���ƥ�(�Ʀr):\r\n",sc.next()+" ",sc.next());
						t=-1;
					}					
				}
				while(num>n*n)
				{				
						System.out.println("�a���ƥؤj��ѽL�j�p�A�Э��s��J");
						try 
						{
							n=sc.nextInt();	//��J�ѽL�j�p�B�a���ƥ�
							num=sc.nextInt();
							t=0;
						}
						catch(InputMismatchException e)
						{				
							System.out.printf("�Э��s��J�ѽL�j�p�B�a���ƥ�(�Ʀr):\r\n",sc.next()+" ",sc.next());
							t=-1;
						}										
				}
		
				Random r = new Random();
				int[] ans = new int[num];	
				for (int i=0; i<num; i++)
					{
						ans[i] = r.nextInt(n*n)+1;		// �N�H����(1~n*n)��J ans[i]
						for (int j=0; j<i;)
						{			// �P�e�ƦC����A�Y���ۦP�h�A���ü�
							if (ans[j]==ans[i])
							{	
								ans[i] = r.nextInt(n*n)+1;
								j=0;	// �׭����s�üƫ�S���ͬۦP�Ʀr�A�Y�X�{���СA�j��q�Y�}�l���s����Ҧ���
							}
							else j++;			// �Y�������ƫh�U�@�Ӽ�
						}
					}
					return ans;		
			}
}		