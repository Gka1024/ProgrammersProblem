package prj41;

import java.util.Arrays;
import java.util.HashMap;

public class prj041 {
	public static String uncomplete_hash(String[] p, String[] c)
	{
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < p.length; i++)
		{
			if(map.containsKey(p[i]))
			{
				map.put(p[i], map.get(p[i]) + 1);
			}
			else
			{
				map.put(p[i], 1);
			}
		}
		
		for(int i = 0; i < c.length; i++)
		{
			if(map.get(c[i]) == 1)
			{
				map.remove(c[i]);
			}
			else
			{
				map.put(p[i], map.get(p[i]) - 1);
			}
		}
		
		String name = map.keySet().toString().substring(1, map.keySet().toString().length() - 1);
		
		System.out.println(name);
		
		return name;
	}
	
	public static String uncomplete_sort(String[] p, String[] c)
	{
		Arrays.sort(p);
		Arrays.sort(c);
		
		for(int i = 0; i < p.length; i++)
		{
			if(i == c.length)
			{
				System.out.println(p[i]);
				return p[i];
			}

			if(p[i] != c[i])
			{
				System.out.println(p[i]);
				return p[i];
			}
		}
		
		return "";
	}
	
	public static void main(String[] args)
	{
		
		String[] p = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] c = {"josipa", "filipa", "marina", "nikola"};
		
		uncomplete_sort(p, c);
	}
}
