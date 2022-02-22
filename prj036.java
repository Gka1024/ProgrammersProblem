package prj36;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class prj036 {
	
	public static int min_length(int[][] maps)
	{
		int h = maps.length;
		int w = maps[0].length;
		
		int[][] route = new int[h][w];
		
		game_bfs(route, maps);
		
		System.out.println(route[maps.length-1][maps[0].length - 1]);
		
		if(route[maps.length-1][maps[0].length - 1] == 0)
		{
			return -1;
		}
		
		return route[maps.length-1][maps[0].length - 1];
	}
	
	public static void game_bfs(int[][] route, int[][] maps)
	{
		int[] node = new int[2]; // Y, X;
		int[] moveY = {1, 0, -1, 0};
		int[] moveX = {0, 1, 0, -1};
		
        route[node[0]][node[1]] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty())
        {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            
            for(int i = 0; i < 4; i++)
            {
                int nowX = curX + moveX[i];
                int nowY = curY + moveY[i];
                
                if(nowX < 0 || nowX > maps.length - 1)
                {
                	continue;
                }
                
                if(nowY < 0 || nowY > maps[0].length - 1)
                {
                	continue;
                }
                
                if(route[nowX][nowY] == 0 && maps[nowX][nowY] == 1)
                {
                    route[nowX][nowY] = route[curX][curY] + 1;
                    queue.add(new int[]{nowX, nowY});
                }
            }
            
        }
			
	}
	
	public static void main(String[] args)
	{
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		
		min_length(maps);
		
	}
}
