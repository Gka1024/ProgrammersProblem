package prj30;

public class prj030 {
	
	public static int count = 0;

	public static int tiredness(int k, int[][] dungeons, int[][] array, boolean[] isVisited, int depth) {
		
		if(depth == dungeons.length)
		{
			int tiredPoint = k;
			int tempCount = 0;
			for(int i = 0; i < array.length; i++)
			{
				System.out.print(array[i][0] + " ");
				System.out.println(array[i][1]);
				
				if(tiredPoint >= array[i][0])
				{
					System.out.println(String.format("현재 피로도 : %d , 요구 피로도 : %d , 이후 피로도 %d",tiredPoint, array[i][0] , array[i][1]));
					tiredPoint -= array[i][1];
					tempCount++;
				}
				
			}
			
			System.out.println("\n");
			
			count = Math.max(count, tempCount);
			
			return count;
		}
		
		for(int i = 0; i < dungeons.length; i++)
		{
			if(!isVisited[i])
			{
				isVisited[i] = true;
				array[depth] = dungeons[i];
				tiredness(k, dungeons, array, isVisited, depth + 1);
				isVisited[i] = false;
			}
		}
		
		return 0;
	}

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 }};
		int [][] array = new int [dungeons.length][dungeons[0].length];
		boolean[] isVisited = new boolean[dungeons.length];
		
		tiredness(k, dungeons, array, isVisited, 0);
		
		System.out.println(count);
	}
}


/*
public static int tiredness(int k, int[][] dungeons) {
	
	int [][] array = new int [dungeons.length][dungeons[0].length];
	int count = 0;

	for(int i = 0; i < array.length; i++)
	{
		for(int j = 0; j < array[1].length; j++)
		{
			array[i][j] = dungeons[i][j];
		}
	}
	
	Arrays.sort(array, new Comparator<int[]>() 
	{
		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) 
			{
				return o1[1] - o2[1];
			} 
			else 
			{
				return o2[0] - o1[0];
			}
		}
	});
	
	for(int i = 0; i < array.length; i++)
	{
		if(k > array[i][0])
		{
			k -= array[i][1];
			count++;
		}
	}
	
	System.out.println(count);

	return count;
}*/
