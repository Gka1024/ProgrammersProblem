package prj54;

import java.util.Arrays;

public class prj054 {
	public static void main(String[] args)
	{
		int[] times = {6, 8, 10};
		int n = 10;
		
		Arrays.sort(times);
		
		immigration(times, n);
	}
	
	public static long immigration(int[] times, int n)
	{
		long left = 1;
		long right = (long)times[times.length - 1] * n;
		long middle = 0, answer = right;
		
		while(left < right)
		{
			middle = (left + right) / 2;
			long people = 0;
			
			for(int i = 0; i < times.length; i++)
			{
				people += middle / times[i];
			}
			System.out.println(people + "|"+ left + "|" +middle + "|" + right);
			
			if(people < n)
			{
				left = middle + 1;
			}
			else
			{
				right = middle;
				answer = Math.min(answer, middle);
			}
			
		}
		
		System.out.println(answer);
		return answer;
	}
}
