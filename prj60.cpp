#include <iostream>
#include <vector>
#include <set>

using namespace std;
set<int> numSet;
int tangSize = 2147483647;

void Combination(vector<int> tangerine, vector<int> choose, int r, int index, int depth)
{
    if (r == 0)
    {
        for(int i = 0; i < choose.size(); i++)
        {
            numSet.insert(choose[i]);
        }
        
        if(numSet.size() < tangSize)
        {
            tangSize = numSet.size();
        }
        numSet.clear();
    }
    else if (depth == tangerine.size()) 
    {
        return;
    }
    else
    {
        choose[index] = tangerine[depth];
        Combination(tangerine, choose, r - 1, index + 1, depth + 1);
        Combination(tangerine, choose, r, index, depth + 1);
    }
}


int main()
{
    vector<int> tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
    int k = 4;
    vector<int> choose(k);
    
    Combination(tangerine, choose, k, 0, 0);

    cout << tangSize;
    return 0;
}
