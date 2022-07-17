class Solution {
    public static int PE(int[] lost, int[] reserve, int n)
    {
        int[] student = new int[n];
        int all = 0;

        for(int i = 0; i < lost.length; i++)
        {
            student[lost[i]-1]--;
        }

        for(int i = 0; i < reserve.length; i++)
        {
            student[reserve[i]-1]++;
        }

        for(int i = 0; i < student.length; i++)
        {   
            student[i] ++;
        }  

        for(int i = 0; i < student.length; i++)
        {
            if(student[i] == 0)
            {
                if(i == 0)
                {
                    if(student[i+1] == 2)
                    {
                        student[i] = 1;
                        student[i+1] = 1; 
                    }

                    continue;
                }

                if(i == student.length - 1)
                {
                    if(student[i-1] == 2)
                    {
                        student[i] = 1;
                        student[i-1] = 1; 
                    }
                    continue;
                }

                if(student[i-1] == 2)
                {
                    student[i] = 1;
                    student[i-1] = 1;
                }
                else if(student[i+1] == 2)
                {
                    student[i] = 1;
                    student[i+1] = 1;
                }
            }
        }

        for(int i = 0; i < student.length; i++)
        {   
            if(student[i] != 0)
            {
                all++;
            }
        }

        return all;
    }

    public int solution(int n, int[] lost, int[] reserve) {
        return PE(lost, reserve, n);
    }
}
