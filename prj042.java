package prj42;

public class prj042 {
	public static int dictionary(String s)
	{
		int num = 0;
		int[] arr = {781, 156, 31, 6, 1};
		
		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			
			switch(c)
			{
				case 'A':
				{
					num += arr[i] * 0 + 1;
					break;
				}
				case 'E':
				{
					num += arr[i] * 1 + 1;
					break;
				}
				case 'I':
				{
					num += arr[i] * 2 + 1;
					break;
				}
				case 'O':
				{
					num += arr[i] * 3 + 1;
					break;
				}
				case 'U':
				{
					num += arr[i] * 4 + 1;
					break;
				}
				default: break;
			}
		}
		
		return num;
	}
	
	public static void main(String[] args)
	{
		String word = "EIO"; // 6
		
		dictionary(word);
	}
}
/*
12

1 11 12 
2 21 22

123

1 11 111 112 113 12 121 122 123 13 131 132 133 = 1 + 3 + 9
2 11 111 112 113 12 121 122 123 13 131 132 133
3 31 311 312 313 32 321 322 323 33 331 332 333
//
12345 = 1 + 5 + 25 + 125 + 625 = 781
1234 = 1 + 5 + 25 + 125 = 156
123 = 31;
12 = 6;
1 = 1

*/