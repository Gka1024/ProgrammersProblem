package prj46;

public class prj046 {
	public static int numOfZero = 0;
	public static int numOfOne = 0;
	
	public static void quad_compress(int[][] arr, int top, int left, int bottom, int right)
	{
		boolean isUnified = true;
		
		for(int i = top; i < bottom + 1; i++)
		{
			for(int j = left; j < right + 1; j++)
			{
				if(arr[top][left] != arr[i][j])
				{
					isUnified = false;
					break;
				}
			}
			if(!isUnified)
			{
				break;
			}
		}
		
		if(isUnified)
		{
			if(arr[top][left] == 1)
			{
				numOfOne++;
			}
			else
			{
				numOfZero++;
			}
			System.out.println("isUnified!");
			return;
		}
		
		if(!isUnified)
		{
			quad_compress(arr, top, left, (top + bottom) / 2, (left + right) / 2);
			quad_compress(arr, top, (left + right) / 2 + 1, (top + bottom) / 2, right);
			quad_compress(arr, (top + bottom) / 2 + 1, left, bottom, (left + right) / 2);
			quad_compress(arr, (top + bottom) / 2 + 1, (left + right) / 2 + 1, bottom, right);
		}
	}
	
	public static void main(String[] args)
	{
		int [][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
		quad_compress(arr, 0, 0, arr.length - 1, arr[0].length - 1);
		
		int[] answer = new int[2];
		answer[0] = numOfZero;
		answer[1] = numOfOne;
	}
}
