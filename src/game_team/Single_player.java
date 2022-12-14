package game_team;

import java.util.*;
import game_team.*;

public class Single_player {	
	public void show()
	{
		Scanner sc=new Scanner(System.in);		
		int TrueRate=0;		//猜中次數
		int k=0;	//輸入次數
		long time=0;	//累計時間
		int t=-1,guess=1;
		
		random__Not_repeat site= new random__Not_repeat();	//亂數取地鼠位置
		int[] answer=site.Array();	//地鼠位置
		int n=site.n;	//玩家輸入的棋盤大小
		
		int[] A=new int[n*n];	//玩家輸入過的位置				
		
		System.out.println("==============");	
		for(int j=1;j<=n*n;j++)		//輸出棋盤
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
		System.out.println("請輸入地鼠位置");	
		while(answer.length-TrueRate!=0)		//無限循環
		{						
			long time1 = System.currentTimeMillis();	//計時開始							
			do
			{
				try 
				{
					guess=sc.nextInt();		//玩家輸入地鼠位置	
					if(guess==0 || guess>n*n)
					{
						System.out.printf("請重新輸入地鼠位置(數字):\r\n");
						t=-1;
					}
					else
						t=0;
				}
				catch(InputMismatchException | ArrayIndexOutOfBoundsException e)
				{				
					System.out.printf("請重新輸入地鼠位置(數字):\r\n",sc.next());
					t=-1;
				}	
			}while(t==-1);
						
			long time2 = System.currentTimeMillis();	//計時結束			
			time+=(time2-time1);	//輸入花費時間
			
			if(A[guess-1]==0 || A[guess-1]==-1 )	//是否重複輸入
			{
				System.out.println("重複輸入，請重新輸入");
				continue ;
			}
			for(int i=0;i<answer.length;i++)	//確認位置是否正確
			{				
				if(answer[i]==guess)
				{					
					TrueRate++;		//猜中位置							
					A[guess-1]=0;	//棋盤數為0
					break;
				}	
				A[guess-1]=-1;
			}	
			for(int j=1;j<=n*n;j++)		//輸出棋盤
			{			
				if(A[j-1]<10 && A[j-1]!=-1 && A[j-1]!=0)
					System.out.print("0"+j+" ");	
				else if(A[j-1]==0)			
					System.out.print(" O ");	//輸入正確						
				else if(A[j-1]==-1)				
					System.out.print(" X ");	//輸入錯誤								
				else
					System.out.print(j+" ");	
				if(j%n==0)
				{
					System.out.println();						
				}
			}	
			if(answer.length-TrueRate!=0)
				System.out.println("==============\r\n輸入次數:"+(k+1)+"\r\n打中地鼠數目:"+TrueRate
					+"\r\n剩餘地鼠數目:"+(answer.length-TrueRate)+"\r\n累積花費時間:"+time/1000+"秒");										
			k++;
		}
		System.out.println("==============\r\n地鼠消滅完畢!\r\n感謝遊玩!\r\n"
				+"您的輸入次數:"+k+"\r\n打中地鼠數目:"+TrueRate
				+"\r\n剩餘地鼠數目:"+(answer.length-TrueRate)+"\r\n擊中率:"+(float)TrueRate/(k+1)
				+"\r\n累積花費時間:"+time/1000+"秒");	
	}		
}