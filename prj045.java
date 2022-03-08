package prj45;

public class prj045 {
	public static void binary_change_repeat(String str)
	{
		int zeroCount = 0;
		int changeCount = 0;
		int[] ans = new int[2];
		
		while(!str.matches("1"))
		{
			zeroCount += str.length() - str.replace("0", "").length();
			changeCount++;
			str = Integer.toBinaryString(str.replace("0","").length());
		}
		
		ans[0] = changeCount;
		ans[1] = zeroCount;
		
		System.out.println(zeroCount);
		System.out.println(changeCount);
	}
	
	public static void main(String[] args)
	{
		String s = "110010101001";
		
		binary_change_repeat(s);
	}
}
