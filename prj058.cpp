#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;



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
