package prj32;

public class prj032 {
	
	public static int tournament(int A, int B)
	{
		int count = 0;
		
		while(A != B)
		{
			A = (A + 1) / 2;
			B = (B + 1) / 2;
			count++;
		}
		
		System.out.println(count);
		return count;
	}

	public static void main(String[] args)
	{
		tournament(15, 7);
	}
}
