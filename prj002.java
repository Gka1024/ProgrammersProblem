package project2;
import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/81301
public class project2 {

	public static void main(String[] args) {
		String s = "";
		String[] engArray = {"zero", "one","two","three","four","five","six","seven","eight","nine","ten"};
		
		s = s + "*";
		 // �������� ����� ������ ��� ����� �������� ����. ���� �߰� ���ڿ��� �����Ͽ� �������� �ƴϵ��� ��.
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) >= 97 && s.charAt(i) <= 122)
			{ // ���� ���ڿ��� ���ĺ��� �ִٸ�
				for(int j = i + 1; j < s.length(); j++)
				{ // i ��°���� j ��°������ ���ڿ��� �����Ͽ� temp�� ����
					String temp= s.substring(i, j);
					if(Arrays.asList(engArray).contains(temp))
					{ // temp�� engArray�� �ִٸ� temp�� �ش��ϴ� ���ڿ��� engArray�� �ε����� ��ȯ�Ͽ� ���ڿ��� ����
						s = s.substring(0, i) + Arrays.asList(engArray).indexOf(temp) + s.substring(j);
						break;
					}
				}
			}
		}
		s = s.substring(0,s.length()-1); // �߰� ���ڿ� ����
		int answer = Integer.parseInt(s);
       
	}

}
