package prj49;

public class prj049 {
	public static void main(String[] args)
	{
		int left = 13;
		int right = 17;
		int answer = 0;
		for(int i = left; i < right + 1; i++)
		{
			if(Math.sqrt((double) i) == Math.floor(Math.sqrt((double) i)))
			{
				answer -= i;
				continue;
			}
			answer += i;
		}
		
		System.out.println(answer);
	}
}
