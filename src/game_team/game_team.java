package game_team;

import java.util.*;
import game_team.*;
import java.util.Random;

public class game_team {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);		
		int guess,sum=1,TrueRate=0;
		
		System.out.println("�q�a���C���}�l�A�п�J�C���Ҧ�:1)��H���a�� 2)�V�ԼҦ� ");		
		int t=-1;	
		int mode=0;		
		while(t==-1)		//�T�{�O�_���ҥ~�B�z
		{
			try 
			{
				mode=sc.nextInt();	//��J�Ҧ�
				t=0;
			}
			catch(InputMismatchException e)
			{				
				System.out.printf("�Э��s��J:\r\n",sc.next());
				t=-1;
			}
		}
		switch(mode)
		{
			case 1:	
				System.out.println("�п�J�ѽL�j�p�B�a���ƥ�");	
				Single_player single=new Single_player();				
				single.show();
				break;
			case 2:		
				System.out.println("�п�J�ѽL�j�p�B�a���ƥ�");	
				Multiplayer multi=new Multiplayer();				
				multi.show();
				break;
			default:
				System.out.println("��J�Ҧ����s�b�A�п�J1 or 2");
				mode=sc.nextInt();
				switch(mode)
				{
					case 1:	
						System.out.println("�п�J�ѽL�j�p�B�a���ƥ�");	
						Single_player single2=new Single_player();				
						single2.show();
						break;
					case 2:		
						System.out.println("�п�J�ѽL�j�p�B�a���ƥ�");	
						Multiplayer multi2=new Multiplayer();				
						multi2.show();
						break;	
					default:
						System.out.println("���C�����A�X�z");	
				}
		}		
	}
}