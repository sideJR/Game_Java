package game_team;

import game_team.*;
import java.util.*;

public class random__Not_repeat //亂數取不重複
{						 					
			Scanner sc=new Scanner(System.in);
			int n=0,num=0;	//棋盤大小、地鼠數目		
			int t=-1;			
			public int[] Array()
			{				
				while(t==-1)		//確認是否為例外處理
				{
					try 
					{
						n=sc.nextInt();	//輸入棋盤大小、地鼠數目
						num=sc.nextInt();
						t=0;
					}
					catch(InputMismatchException e)
					{				
						System.out.printf("請重新輸入棋盤大小、地鼠數目(數字):\r\n",sc.next()+" ",sc.next());
						t=-1;
					}					
				}
				while(num>n*n)
				{				
						System.out.println("地鼠數目大於棋盤大小，請重新輸入");
						try 
						{
							n=sc.nextInt();	//輸入棋盤大小、地鼠數目
							num=sc.nextInt();
							t=0;
						}
						catch(InputMismatchException e)
						{				
							System.out.printf("請重新輸入棋盤大小、地鼠數目(數字):\r\n",sc.next()+" ",sc.next());
							t=-1;
						}										
				}
		
				Random r = new Random();
				int[] ans = new int[num];	
				for (int i=0; i<num; i++)
					{
						ans[i] = r.nextInt(n*n)+1;		// 將隨機數(1~n*n)放入 ans[i]
						for (int j=0; j<i;)
						{			// 與前數列比較，若有相同則再取亂數
							if (ans[j]==ans[i])
							{	
								ans[i] = r.nextInt(n*n)+1;
								j=0;	// 避面重新亂數後又產生相同數字，若出現重覆，迴圈從頭開始重新比較所有數
							}
							else j++;			// 若都不重複則下一個數
						}
					}
					return ans;		
			}
}		