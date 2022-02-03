package prj5;

public class main {
 // https://programmers.co.kr/learn/courses/30/lessons/43165
	private static int targetNum(int [] numbers, int target, int depth, int sum)
	{
		int count = 0;
		if(depth == numbers.length)
		{
			if(sum == target)
			{
				return 1;
			}
			return 0;
		}
		
		count += targetNum(numbers, target, depth+1, sum + numbers[depth]);
		count += targetNum(numbers, target, depth+1, sum - numbers[depth]);

		return count;
	}
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		int temp = targetNum(numbers, target, 0, 0);
		System.out.println("temp : "+ temp);
	}
}

/* ����Լ��� ���� �ʰ� Ǭ ����Դϴ�. �ش� ���������� ��Ÿ�� ������ �߻��մϴ�. �ð� ���⵵�� O(n^2) �Դϴ�.
int count = 0;

for (int i = 0; i < (int) Math.pow(2, numbers.length); i++) {
	int number = 0;
	String s = String.format("%05d", Integer.parseInt(Integer.toBinaryString(i).toString()));
	for (int j = 0; j < numbers.length; j++) {
		number += (s.charAt(j) == '1' ? numbers[j] : numbers[j] * (-1));
	}
	if (number == target) {
		count++;
	}
}

return count;
*/