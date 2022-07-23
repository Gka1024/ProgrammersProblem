#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <string>

using namespace std;

int main()
{
    int n = 8;
    int number = 53;
    set<int> setNo;
    vector<vector<int>> v(8);
    v[0].push_back(n);
    
    if(n == number)
    {
        return 1;
    }
    
    for(int i = 1; i < 8; i++) // 연산 횟수
    { // 1 2 3 4 5 6 7;
        for(int j = 0; j <= i; j++) // (연산 횟수 -1) 까지 나누는 변수 
        { // ex) 5일경우 0/5, 1/4, 2/3, 3/2, 4/1
            for(int k = 0; k < v[j].size(); k++)
            {
                for(int l = 0; l < v[i-j-1].size(); l++)
                {
                    string tempstr;
                    int temp;
                    
                    tempstr.append(i+1, n + 48);
                    temp = stoi(tempstr);
                    if(setNo.insert(temp).second && temp >= 1)
                    {
                        v[i].push_back(temp);
                    }
                   
                    temp = v[j][k] + v[i-j-1][l];
                    if(setNo.insert(temp).second && temp >= 1)
                    {
                        v[i].push_back(temp);
                    }
                    
                    temp = v[j][k] - v[i-j-1][l];
                    if(setNo.insert(temp).second && temp >= 1)
                    {
                        v[i].push_back(temp);
                    }
                    
                    temp = v[j][k] * v[i-j-1][l];
                    if(setNo.insert(temp).second && temp >= 1)
                    {
                        v[i].push_back(temp);
                    }
                    
                    if(v[i-j-1][l] != 0)
                    {
                        temp = v[j][k] / v[i-j-1][l];
                        if(setNo.insert(temp).second && temp > 1)
                        {
                           v[i].push_back(temp);
                        }
                    }
                    
                }
            }
        }
        
        if(setNo.find(number) != setNo.end())
        {
            //return i+1;
            cout << i + 1 << endl;
            break;
        }
    }
    
    
    
    for(int i = 0; i < 8; i++)
    {
        cout << i << " : ";
        for(auto a : v[i])
        {
            cout << a << " ";
        }
        cout << endl;
    }
    
    return 0;
}



/* 이전 코드입니다. 작동하지 않습니다.
int main()
{
    int n = 5;
    int number = 31168;
    
    vector<int> numvec = {n};
    
    for(int i = 0; i < 8; i++)
    {
        for(auto a : numvec)
        {
            numvec.push_back(a + n);
            numvec.push_back(a - n);
            numvec.push_back(a * n);
            numvec.push_back(a / n);
        }
        
        auto it = find(numvec.begin(), numvec.end(), number);
        if(it != numvec.end())
        {
            cout << i;
            break;
        }
        
    }
    
    
    
    return 0;
}
*/
