package prj47;

import java.util.Arrays;

public class prj047 {
	public static boolean numList(String[] arr)
	{
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length - 1; i++)
		{
			if(arr[i+1].startsWith(arr[i]))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		String[] phone_book = {"119", "97674223", "1195524421"};
		numList(phone_book);
	}
}
