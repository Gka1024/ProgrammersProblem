package prj43;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class prj043 {
	public static int camo(String[][] arr)
	{
		HashMap<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		int ans = 1;
		
		for(int i = 0; i < arr.length; i++)
		{
			String[] strArr = arr[i];
			if(!map.containsKey(strArr[1]))
			{
				map.put(strArr[1], 1);
				list.add(strArr[1]);
				continue;
			}
			map.put(strArr[1], map.get(strArr[1]) + 1);
		}
		
		for(int i = 0; i < list.size(); i++)
		{
			ans *= (map.get(list.get(i)) + 1);
		}
		System.out.println(ans);
		
		return 0;
	}
	
	public static void main(String[] args)
	{
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		camo(clothes);
	}
}
