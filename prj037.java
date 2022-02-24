package prj37;

import java.util.ArrayList;

public class prj037 {
	
	public static int[] eng_relay(String[] starr, int n)
	{
		int[] ans = new int [2];
		int breakpoint = 0;
		char endchar = starr[0].charAt(0);
		ArrayList<String> word = new ArrayList<>();
		
		for(int i = 0; i < starr.length; i++)
		{
			String temp = starr[i];
			
			if(temp.length() == 1 || word.contains(temp) || endchar != temp.charAt(0))
			{
				breakpoint = i;
				break;
			}
			
			word.add(temp);
			endchar = temp.charAt(temp.length() - 1);
		}
		
		System.out.println(breakpoint);
		
		if(breakpoint != 0)
		{
			ans[0] = (breakpoint % n) + 1;
			ans[1] = (breakpoint / n) + 1;
		}
		
		return ans;
	}
	
	public static void main(String[] args)
	{
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		int n = 2;
		eng_relay(words, n);
	}
}
