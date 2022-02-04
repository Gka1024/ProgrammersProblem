package prj21;

public class prj021 {
	
	public static void distance_check(String [][] places)
	{
		boolean isKept = true;
		
		for(int i = 1; i < 2; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				for(int k = 0; k < 5; k++)
				{
					if(places[i][j].charAt(k) == 'P')
					{
						System.out.println(String.format("%d %d %d", i, j, k));
						manhattan(places, i, j, k, 0, isKept);
					}
				}
			}
		}
		System.out.println(isKept);
	}
	
	public static void manhattan(String[][] places, int i, int j, int k, int depth, boolean isKept)
	{
		
		if(depth == 2 || places[i][j].charAt(k) == 'X')
		{
			return;
		}
		
		if(places[i][j].charAt(k) == 'P' && depth != 0)
		{
			isKept = false;
			return;
		}
		
		if(j > 0)
		{
			manhattan(places, i, j - 1, k, depth+1, isKept);
		}
		if(j < 4)
		{
			manhattan(places, i, j + 1, k, depth+1, isKept);
		}
		if(k > 0)
		{
			manhattan(places, i, j, k - 1, depth+1, isKept);
		}
		if(k < 4)
		{
			manhattan(places, i, j, k + 1, depth+1, isKept);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		distance_check(places);
		
	}

}
