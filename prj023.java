package prj23;

import java.util.Stack;

public class prj023 {
	
	public static String making_big_number(String number, int k)
	{
		if(number.length() == k)
		{
			return "0";
		}
		
		Stack<Integer> stack = new Stack<>();
		
		String answer = "";
		
		for(int i = 0; i < number.length(); i++)
		{
			int tempNum = Character.getNumericValue(number.charAt(i));
			
			if(stack.isEmpty())
			{
				stack.push(tempNum);
				continue;
			}
			
			while(stack.peek() < tempNum && k > 0)
			{
				stack.pop();
				k--;
				
				if(stack.isEmpty())
				{
					break;
				}
			}
			
			stack.push(tempNum);
			
			if(k == 0)
			{
				for(int j = i + 1; j < number.length(); j++)
				{
					stack.push(Character.getNumericValue(number.charAt(j)));
				}
				break;
			}
		}
		
		if(k != 0)
		{
			for(int i = 0; i < k; i++)
			{
				stack.pop();
			}
		}
		
		while(!stack.isEmpty())
		{
			answer = Integer.toString(stack.pop()) + answer;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		
		System.out.println(making_big_number(number, k));
	}

}


// 12345678 3