package prj28;

public class prj028 {
	
	public static int joystick(String name)
	{
		int count = 0;
		int min = name.length();
		int nxtIdx;
		
		for(int i = 0; i < name.length(); i++)
		{
			count += Math.min((int)(name.charAt(i) - 'A'), 91 - name.charAt(i));
			
			nxtIdx = i+1;
			while (nxtIdx < name.length() && name.charAt(nxtIdx) == 'A')
			{
				nxtIdx++;
			}
			min = Math.min(min, (2 * i) + name.length() - nxtIdx);
		}
		
		count += min;
		
		return count;
	}

	
	public static void printUNICODE()
	{
		for(int i = 0; i < 26; i++)
		{
			System.out.println((char) ('A' + i) +" - "+ (((int)'A') + i));
		}
	}
	
	public static void main(String[] args)
	{
		//printUNICODE();
		
		String name = "JEROEN"; // ERAB
		
		joystick(name);
	}
}
