import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int iMinMatch = 0; 
        int iMaxMatch = 0;
        
        for(int i = 0; i < 6; i++)
        { // lottos 배열과 win_nums 배열을 비교합니다. 0은 비교하지 않습니다.
            for(int j = 0; j < 6; j++)
            {
                 if(lottos[i] == win_nums[j])
                 {
                     iMinMatch++;
                 }
            }
        }
        
        iMaxMatch = iMinMatch;
        //맞는 숫자의 최소개수는 항상 맞는 최대개수보단 커야 합니다.
        
        for(int i = 0; i < 6; i++)
        { // lottos 배열에 0이 몇개 있는지 파악합니다. 0은 어떤 숫자도 될 수 있기 때문에 0의 개수는 맞는 숫자의 개수를 의미합니다.
            if(lottos[i] == 0)
            {
                iMaxMatch++;
            }
        }
        
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        answer[0] = rank[iMaxMatch];
        answer[1] = rank[iMinMatch];
        //등수를 설정합니다. 각각 맞은 숫자가 0개, 1개, 2개 ... 6개일때를 의미합니다.
        
        return answer;
    }
}