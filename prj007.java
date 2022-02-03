package prj7;

public class main7 {

	public static String bracket_reculsive(String s) {
		if (s.isEmpty()) { // 1�� ���ǹ�.
			return "";
		}

		int leftBracket = 0, rightBracket = 0;
		for (int i = 0; i < s.length(); i++) { // 2�� ���ǹ�. u�� 0���� leftBracket+rightBracket -1 ������ ���ڿ��̴�.
			if (s.charAt(i) == '(') {
				leftBracket++;
			} 
			else {
				rightBracket++;
			}
			if (leftBracket == rightBracket) {
				break;
			}
		}

		String u = s.substring(0, rightBracket + leftBracket);
		String v = s.substring(rightBracket + leftBracket);

		if (u.charAt(0) == '(') { // 3�� ���ǹ�
			return u + bracket_reculsive(v); // 3-1
		} 
		else { // 4�� ���ǹ�
			String w = "("; // 4-1 
			w = w + bracket_reculsive(v); // 4-2
			w = w + ")"; // 4-3
			for (int i = 1; i < u.length() - 1; i++) { // 4-4
				w = w + (u.charAt(i) == ')' ? '(' : ')');
			}
			return w; // 4-5
		}
	}

	public static void main(String[] args) {

		String s = "()))((()";
		System.out.println(bracket_reculsive(s));

	}

}
