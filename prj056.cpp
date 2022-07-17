#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    vector<int> student(n,1);
    int all = 0;

    for(int i = 0; i < lost.size(); i++)
    {
        student[lost[i]-1]--;
    }

    for(int i = 0; i < reserve.size(); i++)
    {
        student[reserve[i]-1]++;
    }

    for(int i = 0; i < student.size(); i++)
    {
        if(student[i] == 0)
        {
            if(student[i-1] == 2 && i != 0)
            {
                student[i] = 1;
                student[i-1] = 1;
            }
            else if(student[i+1] == 2 && i != student.size()-1)
            {
                student[i] = 1;
                student[i+1] = 1;
            }
        }
    }

    for(int i = 0; i < student.size(); i++)
    {
        if(student[i] != 0)
        {
            all++;
        }
    }

    return all;
}
