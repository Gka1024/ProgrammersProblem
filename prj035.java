package prj35;

import java.util.Stack;

public class prj035 {
	
	public static int bracket_turn(String str)
	{
		int count = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			str = str.substring(1) + Character.toString(str.charAt(0));
			if(isCorrect(str))
			{
				count++;
			}
		}
		
		return count;
	}
	
	public static boolean isCorrect(String str)
	{
		boolean bool = true;
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			switch(ch)
			{
				case '}':
				{
					if(!stack.isEmpty())
					{
						if(stack.peek() == '{')
						{
							stack.pop();
						}
						else
						{
							bool = false;
						}
					}
					else
					{
						bool = false;
					}
					break;
				}
				case ']':
				{
					if(!stack.isEmpty())
					{
						if(stack.peek() == '[')
						{
							stack.pop();
						}
						else
						{
							bool = false;
						}
					}
					else
					{
						bool = false;
					}
					break;
				}
				case ')':
				{
					if(!stack.isEmpty())
					{
						if(stack.peek() == '(')
						{
							stack.pop();
						}
						else
						{
							bool = false;
						}
					}
					else
					{
						bool = false;
					}
					break;
				}
				default: 
				{
					stack.add(ch);
					break;
				}
				
			}
			
			if(!bool)
			{
				break;
			}
		}
		
		if(!stack.isEmpty())
		{
			bool = false;
		}
		
		return bool;
	}
	
	public static void main(String[] args)
	{
		String s = "(((("	;
		System.out.println(bracket_turn(s));
	}
}
