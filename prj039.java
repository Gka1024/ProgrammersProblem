package prj39;

public class prj039 {
	
	public static int jump_teleport(int n)
	{
		int count = 0;
		while(n > 0)
		{
			if(n % 2 == 1)
			{
				count++;
			}
			
			n /= 2;
		}
		
		System.out.println(count);
		return 0;
	}
	
	public static void main(String[] args)
	{
		jump_teleport(5000);
	}
}
