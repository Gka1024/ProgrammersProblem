package prj31;

public class prj031 {
	
	public static int[] triangle_snail(int n)
	{
		int[] turnNum = new int [n];
		int[][] table = new int[n][n];
		int[][] move = {{1, 0}, {0, 1}, {-1, -1}};
		int movePointer = 0;
		int turnNumPointer = 0;
		int yPointer = 0, xPointer = 0;
		int maxNum = n * (n+1) / 2;
		
		int[] answer = new int[maxNum];
		int answerPointer = 0;
		
		for(int i = 0; i < n; i++)
		{
			turnNum[i] = n - i;
			if(i != 0)
			{
				turnNum[i] += turnNum[i-1];
			}
		}
		
		for(int i = 1; i <= maxNum; i++)
		{
			table[yPointer][xPointer] = i;
			if(turnNum[turnNumPointer] == i)
			{
				movePointer = (movePointer + 1) % 3;
				turnNumPointer++;
			}
			yPointer += move[movePointer][0];
			xPointer += move[movePointer][1];
		}
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < i + 1; j++)
			{
				answer[answerPointer++] = table[i][j];
			}
		}
		return answer;
	}
	
	public static void main(String[] args)
	{
		int n = 6;
		triangle_snail(n);
	}
}
