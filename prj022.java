package prj22;

import java.util.Arrays;
import java.util.HashMap;

public class prj022 {
	
	public static String maxNumber = "";
	
	public static String maxNum_old(int[] array)
	{
		int arrNum = array.length;
		int [] sortArr = new int[arrNum];
		boolean[] isVisited = new boolean[arrNum];
		maxNum_dfs(array, isVisited, sortArr, 0);
		System.out.println(maxNumber);
		return maxNumber;
	}
	
	public static String maxNum_dfs(int[] array, boolean[] isVisited, int[] order, int depth)
	{
		if(depth == array.length)
		{
			String temp = Arrays.toString(order).replaceAll("[^0-9]","").replaceAll("^0+", "");
			
			if(temp.isEmpty())
			{
				temp = "0";
			}
			
			//System.out.println(temp);
			
			if(numCheck(maxNumber, temp))
			{
				maxNumber = temp;
			}
			return "";
		}
		
		for(int i = 0; i < array.length; i++)
		{
			if(!isVisited[i])
			{
				isVisited[i] = true;
				order[depth] = array[i];
				maxNum_dfs(array, isVisited, order, depth+1);
				isVisited[i] = false;
			}
		}
		return ""; // ������� �ʴ� ����
	}
	
	public static boolean numCheck(String maxNum, String temp)
	{
		if(maxNum.matches(temp))
		{ // ���� ���ٸ� ��ȯ�ϳ�����
			return false;
		}
		
		if(maxNum.length() < temp.length())
		{ // temp�� ���̰� �� ��ٸ� maxNum�� temp�� ��ȯ�� �ʿ䰡 ����
			return true;
		}
		else if(maxNum.length() > temp.length())
		{ // maxNum�� ���̰� �� ��ٸ� ��ȯ�� �ʿ䰡 ����
			return false;
		}
		
		for(int i = 0; i < temp.length(); i++)
		{ // ���̰� ���ٸ� �ϳ��ϳ� �м�
			if(Character.getNumericValue(maxNum.charAt(i)) != Character.getNumericValue(temp.charAt(i)))
			{ // ���ڰ� �ٸ��� 
				int tempNumM = Character.getNumericValue(maxNum.charAt(i));
				int tempNumT = Character.getNumericValue(temp.charAt(i));
				
				if (tempNumM < tempNumT)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		
		return false;
	}
	
	public static String maxNum(int [] array)
	{
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		int maxDigit = (int) Math.log10(array[array.length - 1]) + 1;
		System.out.println("mxdigit - "+maxDigit);
		
		HashMap <Integer,Integer> map = new HashMap<>();
		String answer = "";
		
		for(int i = 0; i < array.length; i++)
		{
			int numDigitOne = array[i] % 10;
			int tempDigit = (int) Math.log10(array[i]) + 1;
			while((int) Math.log10(array[i]) + 1 < maxDigit)
			{
				array[i] = array[i] * 10 + numDigitOne;
			}
			map.put(array[i], tempDigit);
		}
		
		Arrays.sort(array);
		System.out.println(map);
		System.out.println(Arrays.toString(array));
		
		for(int i = array.length - 1; i >= 0; i--)
		{
			answer = answer + Integer.toString(array[i]).substring(0,map.get(array[i]));
		}
		System.out.println(answer);
		return answer;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] numbers = {34, 342, 345, 5, 9};
		maxNum_old(numbers);
		
	}
}


