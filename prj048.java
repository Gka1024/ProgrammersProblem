package prj48;

import java.util.Set;
import java.util.HashSet;

public class prj048 {
	public static int doorlen(String str)
	{
		int moveX = 0, moveY = 0;
		int curX, curY;
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < str.length(); i++) 
		{
			char ch = str.charAt(i);
			curX = moveX;
			curY = moveY;
			if(ch == 'U' && moveY < 5)
			{
				moveY++;
			}
			if(ch == 'D' && moveY > -5)
			{
				moveY--;
			}
			if(ch == 'L' && moveX > -5)
			{
				moveX--;
			}
			if(ch == 'R' && moveX < 5)
			{
				moveX++;
			}
			
			String moveXY = Integer.toString(moveX) + Integer.toString(moveY);
			String curXY = Integer.toString(curX) + Integer.toString(curY);
			
			if(!set.contains(moveXY + curXY) && !set.contains(curXY + moveXY) && !(moveXY + curXY).matches(curXY + moveXY))
			{
				set.add(moveXY + curXY);
				set.add(curXY + moveXY);
			}
		}
		System.out.println(set.size());
		return set.size() / 2;
	}
	
	public static void main(String[] args)
	{
		String dirs = "UDU";
		doorlen(dirs);
	}
}

/*
 public static int doorlen(String str)
	{
		boolean[][] map = new boolean[21][21];
		
		int moveX = 10, moveY = 10;
		int count = 0;
		
		for(int i = 0; i < str.length(); i++) 
		{
			char ch = str.charAt(i);
			switch(ch)
			{
				case 'U' :
				{
					if(moveY <= 0)
					{
						break;
					}
					moveY--;
					if(!map[moveY][moveX])
					{
						count++;
					}
					map[moveY--][moveX] = true;
					break;
				}
				case 'D' :
				{
					if(moveY >= 21)
					{
						break;
					}
					moveY++;
					if(!map[moveY][moveX])
					{
						count++;
					}
					map[moveY++][moveX] = true;
					break;
				}
				case 'L' :
				{
					if(moveX <= 0)
					{
						break;
					}
					moveX--;
					if(!map[moveY][moveX])
					{
						count++;
					}
					map[moveY][moveX--] = true;
					break;
				}
				case 'R' :
				{
					if(moveX >= 21)
					{
						break;
					}
					moveX++;
					if(!map[moveY][moveX])
					{
						count++;
					}
					map[moveY][moveX++] = true;
					break;
				}
				default : break;
			}
			
		}
		System.out.println(count);
		return count;
	} */
