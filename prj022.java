package prj22;

import java.util.Arrays;

public class prj022 {
	
	public static String maxNumber = "";
	
	public static String maxNum(int[] array)
	{
		int arrNum = array.length;
		int [] sortArr = new int[arrNum];
		boolean[] isVisited = new boolean[arrNum];
		maxNum_dfs(array, isVisited, sortArr, 0);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] numbers = {0, 0};
		maxNum(numbers);
		
	}

}


