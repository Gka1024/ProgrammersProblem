#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int qsum(vector<int> queue1, vector<int> queue2)
{
    queue<int> q1, q2;
    long sum1 = 0, sum2 = 0;
    int count = 0;
    
    for(int i : queue1)
    {
        sum1 += i;
        q1.push(i);
    }
    for(int i : queue2)
    {
        sum2 += i;
        q2.push(i);
    }
    
    if((sum1 + sum2) % 2 == 1)
    {
        return -1;
    }
    
    while(sum1 != sum2)
    {
        if(sum1 < sum2)
        {
            sum1 += q2.front();
            sum2 -= q2.front();
            q1.push(q2.front());
            q2.pop();
        }
        else if(sum1 > sum2)
        {
            sum1 -= q1.front();
            sum2 += q1.front();
            q2.push(q1.front());
            q1.pop();
        }
        count++;
        
        if(count > 2 * (queue1.size() + queue2.size()))
        {
            return -1;
        }
    }
    return count;
}

int main() {
    
    vector<int> queue1 = {3, 2, 7, 2};
    vector<int> queue2 = {4, 6, 5, 1};
    
    qsum(queue1, queue2);
    
}
    
