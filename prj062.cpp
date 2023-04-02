#include <iostream>
#include <queue>
#include <string>
#include <vector>

using namespace std;

pair<int, int> charLocate(vector<string> maps, char t)
{
    int xCo, yCo;
    for(int i = 0 ; i < maps.size(); i++)
    {
        if(maps[i].find(t) != string::npos)
        {
            xCo = maps[i].find(t);
            yCo = i;
            break;
        }
    }
    return make_pair(xCo, yCo);
}

bool indexOutOfBound(vector<string> maps, int x, int y)
{
    return x < 0 || maps.size() < x || y < 0 || maps[0].size() < y;
}

int bfs(vector<string> maps, char starts, char ends)
{
    queue<pair<int, int>> q;
    vector<vector<int>> isVisitedNum(maps.size(), vector<int>(maps[0].size(),-1));
    
    q.push(charLocate(maps, starts));
    
    isVisitedNum[q.front().first][q.front().second] = 0;
    
    int dx[4] = {0, 0, 1, -1};
    int dy[4] = {1, -1, 0, 0};
    
    while(!q.empty())
    {
        int firX = q.front().first;
        int firY = q.front().second;
        q.pop();
        
        if(maps[firX][firY] == ends)
        {
            return isVisitedNum[firX][firY];
        }
        
        for(int i = 0; i < 4; i++)
        {
            int moveX = firX + dx[i];
            int moveY = firY + dy[i];
            
            if(indexOutOfBound(maps, moveX, moveY))
            {
                continue;
            }
            
            if(isVisitedNum[moveX][moveY] == -1 && maps[moveX][moveY] != 'X')
            {
                q.push(make_pair(moveX, moveY));
                isVisitedNum[moveX][moveY] = isVisitedNum[firX][firY] + 1;
            }
        }
    }
    return 0;
}



int main()
{
    vector<string> maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
    
    int a = bfs(maps, 'S','L');
    cout << a << endl;
    int b = bfs(maps, 'L','E');
    cout << b << endl;
    
    return 0;
}

