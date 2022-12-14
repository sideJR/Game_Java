package game_team;

import java.util.*;
import game_team.*;

class player
{
	public int id;	//玩家id
	public int True=0,Blow=0;	//打中、打擊次數	
	long time=0;	//累計時間
}
public class Multiplayer {
	public void show()
	{
		Scanner sc=new Scanner(System.in);
		random__Not_repeat site= new random__Not_repeat();	//亂數取地鼠位置
		int[] answer=site.Array();	//地鼠位置
		int n=site.n;	//玩家輸入的棋盤大小
		int[] A=new int[n*n];	//玩家輸入過的位置				
		int TrueRate=0;		//總猜中次數	
		int over=0;		//換下一位玩家憑據	
		int t=-1,guess=1,num=0;

		System.out.println("請輸入玩家人數");		
		
		while(t==-1)		//確認是否為例外處理
		{
			try 
			{
				num=sc.nextInt();	//玩家人數	
				t=0;
			}
			catch(InputMismatchException e)
			{				
				System.out.printf("請重新輸入:\r\n",sc.next());
				t=-1;
			}
		}
		 	
		player[] user=new player[num];	//玩家陣列				
				
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
		for(int i=0;i<num;i++)
		{
			user[i]=new player();	//建立玩家物件
			user[i].id=i;			
		}		
		while(answer.length-TrueRate!=0)
		{			
			for(int N=0;N<num;N++)	
			{										
				while(answer.length-TrueRate!=0 && over!=-1)	//無限循環
				{										
					System.out.println("玩家"+(N+1)+"請輸入地鼠位置");
					
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
					user[N].time+=(time2-time1);

					if(A[guess-1]==0 || A[guess-1]==-1)	//是否重複輸入
					{
						System.out.println("重複輸入，請重新輸入");
						continue ;
					}									
					for(int i=0;i<answer.length;i++)	//確認位置是否正確
					{				
						if(answer[i]==guess)
						{					
							user[N].True++;
							TrueRate++;		//總猜中位置							
							A[guess-1]=0;	//棋盤數為0	
							over=0;	//擊中，繼續遊戲
							break;
						}
						else	
						{
							A[guess-1]=-1;
							over=-1;	//未擊中，換下一位玩家				
						}					
					}							
					user[N].Blow++;				
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
							System.out.println();											
					}		
					System.out.println("玩家"+(N+1)+":\r\n輸入次數:"+user[N].Blow+"\r\n打中地鼠數目:"+user[N].True
						+"\r\n剩餘地鼠數目:"+(answer.length-TrueRate)
						+"\r\n累積花費時間:"+user[N].time/1000+"秒\r\n==============");										
				}
					over=0;						
			}
		}	
		int max=0;
		int First=0;	//第一名
		String s="";
		for(int k=0;k<num;k++)
		{
			if(user[k].True>max)
			{
				max=user[k].True;
				First=k;	
				s="第一名為玩家"+(First+1)+"\r\n您的輸入次數:"+user[First].Blow
						+"\r\n打中地鼠數目:"+user[First].True
						+"\r\n擊中率:"+(float)user[First].True/user[First].Blow
						+"\r\n累積花費時間:"+user[First].time/1000+"秒";
			}	
			if(user[k].True==user[First].True && First!=k)
			{
				s="玩家"+(First+1)+"和玩家"+(k+1)+"同為第一\r\n玩家"+(First+1)+"您的輸入次數:"+user[First].Blow
						+"\r\n打中地鼠數目:"+user[First].True
						+"\r\n擊中率:"+(float)user[First].True/user[First].Blow
						+"\r\n累積花費時間:"+user[First].time/1000+"秒"
						+"\r\n玩家"+(k+1)+"您的輸入次數:"+user[k].Blow
						+"\r\n打中地鼠數目:"+user[k].True
						+"\r\n擊中率:"+(float)user[k].True/user[k].Blow
						+"\r\n累積花費時間:"+user[k].time/1000+"秒";
			}
		}			
		System.out.println("地鼠消滅完畢!\r\n感謝遊玩!\r\n==============\r\n"+s);		
	}
}