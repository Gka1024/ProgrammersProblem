#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;


bool cmpsize(int a, int b)
{
    string astring = to_string(a);
    string bstring = to_string(b);

    return astring + bstring > bstring + astring;
}

int main()
{
    vector<int> v = {70, 0, 0, 1};
    sort(v.begin(), v.end(), cmpsize);
    string str = "";
    
    for(auto i : v)
    {
        str.append(to_string(i));
    }
    
    if(str[0] == '0')
    {
        str = "0";
    }
    
    cout << str;

    return 0;
}

bool cmpsize_old(int a, int b)
{
    string astring = to_string(a);
    string bstring = to_string(b);
    
    if(astring[0] != bstring[0])
    {
        return astring[0] > bstring[0];
    }
    else
    {
        if(astring.size() != bstring.size())
        {
            if(astring.size() < bstring.size())
            {
                astring.append(bstring.size() - astring.size(), a % 10 + 48);
            }
            else
            {
                bstring.append(astring.size() - bstring.size(), b % 10 + 48);
            }
            
        }
        
        for(int i = 1; i < astring.size(); i++)
        {
            if(astring[i] == bstring[i])
            {
                continue;
            }
            return astring[i] > bstring[i];
        }
    }
    
    return false;
}

