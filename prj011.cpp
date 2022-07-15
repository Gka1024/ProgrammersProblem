// Online C++ compiler to run C++ program online
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    priority_queue<int, vector<int>, greater<int>> que; // 오름차순
    vector<int> scoville = {1, 2, 3, 9, 10, 12};
    int k = 7;
    int cnt = 0;

    for(int i = 0; i < scoville.size(); i++)
    {
        que.push(scoville.at(i));
    }
    
    while(que.top() < k && que.size() != 1)
    {
        int leshot = que.top();
        que.pop();
        int morehot = que.top();
        que.pop();
        int hotmix = leshot + (2 * morehot);
        que.push(hotmix);
        cnt++;
    }
    
    cout << cnt;
    
    if(que.top() < k)
    {
        return -1;
    }
    
    cout << cnt;
    return cnt;
}
