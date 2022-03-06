package prj44;

public class prj044 {
	public static long[] under2dif(long[] arr)
	{
		long[] ans = new long[arr.length];
		
		for(int i = 0; i < arr.length; i++)
		{
			StringBuilder sb = new StringBuilder(Long.toBinaryString(arr[i]));
			boolean isChanged = false;
			
			for(int j = sb.length() - 1; j >= 0; j--)
			{
				if(sb.charAt(j) == '0')
				{
					sb.setCharAt(j, '1');
					if(j + 1 < sb.length())
					{
						sb.setCharAt(j + 1, '0');
					}
					isChanged = true;
					break;
				}
			}
			if(!isChanged)
			{
				sb.insert(0, "1");
				sb.setCharAt(1, '0');
			}
			
			ans[i] = Long.parseLong(sb.toString(), 2);
		}
		
		return ans;
	}
	
	public static void main(String[] args)
	{
		long[] numbers = {1023, 7};
		under2dif(numbers);
	}
}
