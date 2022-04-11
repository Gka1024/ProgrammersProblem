package prj52;

public class prj052 {
	public static int bigSquare(int[][] board)
	{
		int count = 0;
		
		for(int i = 0; i < board.length; i++)
		{
			count = Math.max(count, board[i][0]);
		}
		for(int j = 0; j < board[0].length; j++)
		{
			count = Math.max(count, board[0][j]);
		}
		
		for(int i = 1; i < board.length; i++)
		{
			for(int j = 1; j < board[0].length; j++)
			{
				if(board[i][j] == 1)
				{
					board[i][j] = Math.min(board[i-1][j], Math.min(board[i][j-1], board[i-1][j-1])) + 1;
					count = Math.max(count, board[i][j]);
				}
			}
		}
		System.out.println(count);
		return count * count;
	}
	
	public static void main(String[] args)
	{
		int[][] board = {{1}};
		
		bigSquare(board);
	}
}
