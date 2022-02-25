package prj38;

import java.util.Arrays;
import java.util.Collections;

public class prj038 {
	public static int lifeboat(int[] people, int limit)
	{
		Arrays.sort(people);
		
		System.out.println(Arrays.toString(people));
		
		int lp = 0;
		int rp = people.length - 1;
		int count = 0;
		
		while(lp <= rp)
		{
			if(people[lp] + people[rp] > limit)
			{
				count++;
			}
			if(people[lp] + people[rp] <= limit)
			{
				lp++;
				count++;
			}
			
			rp--;
		}
		System.out.println(count);
		return 0;
	}
	
	public static void main(String[] args)
	{
		int[] people = {40, 50, 60, 90};
		int limit = 100;
		
		lifeboat(people, limit);
	}
}
