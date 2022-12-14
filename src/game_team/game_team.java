package game_team;

import java.util.*;
import game_team.*;
import java.util.Random;

public class game_team {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);		
		int guess,sum=1,TrueRate=0;
		
		System.out.println("猜地鼠遊戲開始，請輸入遊戲模式:1)單人闖地鼠 2)混戰模式 ");		
		int t=-1;	
		int mode=0;		
		while(t==-1)		//確認是否為例外處理
		{
			try 
			{
				mode=sc.nextInt();	//輸入模式
				t=0;
			}
			catch(InputMismatchException e)
			{				
				System.out.printf("請重新輸入:\r\n",sc.next());
				t=-1;
			}
		}
		switch(mode)
		{
			case 1:	
				System.out.println("請輸入棋盤大小、地鼠數目");	
				Single_player single=new Single_player();				
				single.show();
				break;
			case 2:		
				System.out.println("請輸入棋盤大小、地鼠數目");	
				Multiplayer multi=new Multiplayer();				
				multi.show();
				break;
			default:
				System.out.println("輸入模式不存在，請輸入1 or 2");
				mode=sc.nextInt();
				switch(mode)
				{
					case 1:	
						System.out.println("請輸入棋盤大小、地鼠數目");	
						Single_player single2=new Single_player();				
						single2.show();
						break;
					case 2:		
						System.out.println("請輸入棋盤大小、地鼠數目");	
						Multiplayer multi2=new Multiplayer();				
						multi2.show();
						break;	
					default:
						System.out.println("此遊戲不適合您");	
				}
		}		
	}
}