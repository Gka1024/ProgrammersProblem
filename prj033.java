package prj33;

import java.util.Arrays;

public class prj033 {
	
	public static int delivery(int[][] array, int n, int k)
	{
		int[][] map = new int[n+1][n+1];//
		boolean [] isVisited = new boolean[n+1];
		int[] FirstTolength = new int[n + 1];
		int count = 0;
		
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map.length; j++)
			{
				map[i][j] = 500001;
			}
		}
		
		for(int i = 0; i < array.length; i++)
		{
			int[] arr = array[i];
			
			map[arr[0]][arr[1]] = Math.min(arr[2], map[arr[0]][arr[1]]);
			map[arr[1]][arr[0]] = Math.min(arr[2], map[arr[1]][arr[0]]);
		}
		
		for(int i = 0; i < n + 1; i++)
		{
			FirstTolength[i] = map[1][i];
		}
		
		FirstTolength[1] = 0;
		isVisited[1] = true;
		
		for(int i = 0; i < n - 1; i++)
		{
			int min = 500001;
			int index = 0;
			for(int j = 2; j <= n; j++)
			{
				if(!isVisited[j])
				{
					if(FirstTolength[j] < min)
					{
						min = FirstTolength[j];
						index = j;
					}
				}
				
			}
			isVisited[index] = true;
			
			for(int j = 2; j < n + 1; j++)
			{
				if(FirstTolength[index] + map[index][j] < FirstTolength[j])
				{
					FirstTolength[j] = FirstTolength[index] + map[index][j];
				}
			}
		}
		
		for(int i = 0; i < FirstTolength.length; i++)
		{
			if(FirstTolength[i] <= k)
			{
				count++;
			}
		}
		
		System.out.println(Arrays.toString(FirstTolength));
		System.out.println(count);
		return count;
	}
	
	public static void main(String[] args)
	{
		int[][] array = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int n = 6;
		int k = 4;
		
		delivery(array, n, k);
		
		
	}
}
