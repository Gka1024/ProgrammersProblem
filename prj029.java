package prj29;

import java.util.Arrays;

public class prj029 {

	public static int[] carpet(int brown, int yellow)
	{
		int[] answer = new int [2];
		
		for(int i = 1; i <= yellow; i++)
		{
			System.out.println(i);
			
			if(yellow % i == 0)
			{
				if(brown == (2 * i) + ((yellow / i) * 2) + 4)
				{
					answer[0] = (yellow / i) + 2;
					answer[1] = i + 2;
					System.out.println(Arrays.toString(answer));
					break;
				}
			}
		}
		
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}
	
	public static void main(String[] args)
	{
		int brown = 8;
		int yellow = 1;
		
		carpet(brown, yellow);
	}
}
