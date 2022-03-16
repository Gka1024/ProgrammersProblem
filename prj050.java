package prj50;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class prj050 {
	public static int[] pick2nPlus(int[] arr)
	{
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr.length; j++)
			{
				if(i == j)
				{
					continue;
				}
				set.add(arr[i] + arr[j]);
			}
		}
		
		List<Integer> list = new ArrayList<>(set);
		
		list.sort(Comparator.naturalOrder());
		int[] ans = list.stream().mapToInt(i->i).toArray();
		return ans;
	}
	
	public static void main(String[] args)
	{
		int[] numbers = {2, 1, 3, 4, 1};
		
		pick2nPlus(numbers);
		
		
	}
}
