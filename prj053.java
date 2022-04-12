package prj53;

import java.util.Arrays;

public class prj053 {
	public static int integer_triangle(int[][] table)
	{
		for(int i = 1; i < table.length; i++)
		{
			for(int j = 0; j < table[i].length; j++)
			{
				if(j == 0)
				{
					table[i][j] += table[i-1][j];
					continue;
				}
				
				if(j == table[i].length - 1)
				{
					table[i][j] += table[i-1][j-1];
					continue;
				}
				
				table[i][j] += Math.max(table[i-1][j-1], table[i-1][j]);
			}
		}
		return Arrays.stream(table[table.length - 1]).max().getAsInt();
	}
	
	public static void main(String[] args)
	{
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		integer_triangle(triangle);
	}
}
;