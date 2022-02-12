package prj27;

import java.util.Arrays;
import java.util.HashSet;

public class prj027 {
	
	public static int count = 0;
	public static HashSet<Integer> set = new HashSet<>();
	public static void primesearch(int[] arr, int [] permArr, boolean [] isVisited, int depth)
	{
		if(depth == permArr.length)
		{
			if(isPrime(permArr))
			{
				System.out.println(Integer.parseInt(Arrays.toString(permArr).replaceAll("[^0-9]", "")));
				count++;
			}
			return;
		}
		
		for(int i = 0; i < arr.length; i++)
		{
			if(!isVisited[i])
			{
				isVisited[i] = true;
				permArr[depth] = arr[i];
				primesearch(arr, permArr, isVisited, depth+1);
				isVisited[i] = false;
			}
		}
	}
	
	public static boolean isPrime(int[] arr)
	{
		int number = Integer.parseInt(Arrays.toString(arr).replaceAll("[^0-9]", ""));
		int max = (int) Math.sqrt(number);
		
		if(!set.contains(number))
		{
			set.add(number);
			if(number <= 1)
			{
				return false;
			}
			
			if(number == 2)
			{
				return true;
			}
			
			if(number % 2 == 0)
			{
				return false;
			}
			
			for(int i = 3; i <= max; i++)
			{
				if(number % i == 0)
				{
					return false;
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		String numbers = "1231";
		int[] numArr = new int[numbers.length()];
		int [] permArr;
		
		for(int i = 0; i < numbers.length(); i++)
		{
			numArr[i] = Character.getNumericValue(numbers.charAt(i));
		}

		boolean[] isVisited = new boolean[numbers.length()];
		
		for(int i = 0; i < numbers.length() ; i++)
		{
			permArr = new int[i + 1];
			primesearch(numArr, permArr, isVisited, 0);
		}
		
		System.out.println(count);
	}
}
