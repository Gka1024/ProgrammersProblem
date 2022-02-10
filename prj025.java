package prj25;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class prj025 {
	
	public static int Hindex(int[] array)
	{
		List<Integer> list = new ArrayList<>();
		int answer = 0;
		for(int i = 0; i < array.length; i++)
		{
			list.add(array[i]);
		}
		
		for(int i = 0; i <= array.length; i++)
		{
			list.add(i);
			Collections.sort(list);
			
			if(array.length - list.indexOf(i) >= i)
			{
				answer = i;
			}
			else
			{
				break;
			}
			
			list.remove(list.indexOf(i));
		}
		
		System.out.println(answer);
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {9,9,9,12};
		
		Hindex(citations);
	}

}
