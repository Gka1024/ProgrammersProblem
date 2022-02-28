package prj40;

import java.util.Arrays;

public class prj040 {
	public static int[] array_cut(int n, long left, long right)
	{
		int arrlen = (int) (right - left + 1);
		
		int[] arr = new int[arrlen];
		
		int[][] table = new int[n][n];
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				table[i][j] = (i > j) ? i + 1 : j + 1;
			}
		}
		
		for(long i = left; i < right + 1; i++)
		{
			arr[(int) (i - left)] = Math.max((int) (i / n) + 1, (int) (i % n) + 1);
		}
		System.out.println(Arrays.toString(arr));
		return arr;
	}
	
	public static void main(String[] args)
	{
		int n = 4;
		long left = 7;
		long right = 14;
		
		array_cut(n, left, right);
	}
}
