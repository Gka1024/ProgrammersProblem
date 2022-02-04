package prj21;

import java.util.Arrays;

public class prj021 {
	public static boolean isKept;

	public static int[] distance_check1(String[][] places) {
		int[] answer = new int[5];
		for (int i = 0; i < 5; i++) {
			isKept = true;
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (places[i][j].charAt(k) == 'P' && isKept) {
						manhattan1(places, i, j, k);
					}
				}
			}

			if (isKept) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
		}
		return answer;
	}

	public static void manhattan1(String[][] places, int i, int j, int k) {
		if (!isKept) {
			return;
		}
		int[] moveY = { 1, -1, 0, 0 };
		int[] moveX = { 0, 0, -1, 1 };

		for (int firstMove = 0; firstMove < 4; firstMove++) { // 상, 하, 좌, 우 순으로 움직임
			if (0 > j + moveY[firstMove] || 4 < j + moveY[firstMove] || 0 > k + moveX[firstMove]
					|| 4 < k + moveX[firstMove]) { // OutOfBound의 경우에 반복문을 실행하지 않음
				continue;
			}
			switch (places[i][j + moveY[firstMove]].charAt(k + moveX[firstMove])) {
			case 'P': { // 바로 옆에 사람이 있는 경우
				isKept = false;
				return;
			}
			case 'O': {
				int Pcount = 0;

				for (int secondMove = 0; secondMove < 4; secondMove++) {
					if (0 > j + moveY[firstMove] + moveY[secondMove] || 4 < j + moveY[firstMove] + moveY[secondMove]
							|| 0 > k + moveX[firstMove] + moveX[secondMove]
							|| 4 < k + moveX[firstMove] + moveX[secondMove]) {// OutOfBound의 경우에 반복문을 실행하지 않음
						continue;
					}
					if (places[i][j + moveY[firstMove] + moveY[secondMove]]
							.charAt(k + moveX[firstMove] + moveX[secondMove]) == 'P') {
						Pcount++;
					}
				}
				if (Pcount > 1) {
					isKept = false;
					return;
				}

				break;
			}
			case 'X': {
				break;
			}
			default:
				break;
			}
		}
	}
	//====================================================================================================//
	public static int[] distance_check2(String[][] places)
	{
		int [] answer = new int[5];
		
		for (int i = 0; i < 5; i++) 
		{
			isKept = true;
			for (int j = 0; j < 5; j++) 
			{
				for (int k = 0; k < 5; k++) 
				{
					manhattan2(places, places[i][j].charAt(k), i, j, k);
				}
			}
			if (isKept) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
		}
		return answer;
	}
	
	public static void manhattan2(String [][] places, char checkChar,int i, int j, int k)
	{
		if(checkChar == 'X')
			return;
		
		int[] moveY = { 1, -1, 0, 0 };
		int[] moveX = { 0, 0, -1, 1 };
		int Pcount = 0, numberOfP = 0;
		
		switch(checkChar)
		{
			case 'O':
			{
				numberOfP = 1;
				break;
			}
			case 'P':
			{
				numberOfP = 0;
				break;
			}
			default : break;
		}
		
		for (int firstMove = 0; firstMove < 4; firstMove++) 
		{ // 상, 하, 좌, 우 순으로 움직임
			if (0 > j + moveY[firstMove] || 4 < j + moveY[firstMove] || 0 > k + moveX[firstMove] || 4 < k + moveX[firstMove]) 
			{ // OutOfBound의 경우에 반복문을 실행하지 않음
				continue;
			}
			if(places[i][j + moveY[firstMove]].charAt(k + moveX[firstMove]) == 'P')
			{
				Pcount++;
			}
		}
		
		if(Pcount > numberOfP)
		{
			isKept = false;
		}
		return;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		System.out.println(Arrays.toString(distance_check2(places)));
	}

}
