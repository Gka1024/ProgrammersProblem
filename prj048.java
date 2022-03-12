package prj48;

public class prj048 {
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
		
		return count;
	}
	
	public static void main(String[] args)
	{
		String dirs = "ULURRDLLU";
		doorlen(dirs);
	}
}
