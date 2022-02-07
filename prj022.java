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
		return ""; // 사용하지 않는 문장
	}
	
	public static boolean numCheck(String maxNum, String temp)
	{
		if(maxNum.matches(temp))
		{ // 만약 같다면 변환하나마나
			return false;
		}
		
		if(maxNum.length() < temp.length())
		{ // temp의 길이가 더 길다면 maxNum을 temp로 변환할 필요가 있음
			return true;
		}
		else if(maxNum.length() > temp.length())
		{ // maxNum의 길이가 더 길다면 변환할 필요가 없음
			return false;
		}
		
		for(int i = 0; i < temp.length(); i++)
		{ // 길이가 같다면 하나하나 분석
			if(Character.getNumericValue(maxNum.charAt(i)) != Character.getNumericValue(temp.charAt(i)))
			{ // 문자가 다르면 
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


