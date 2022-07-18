#include <iostream>
#include <vector>
using namespace std;

int count = 0;

long fibo(int n)
{
    long num1 = 1;
    long num2 = 2;
    long temp;
    
    if(n == 1)
    {
        return num1;
    }
    if(n == 2)
    {
        return num2;
    }
    
    for(int i = 0 ; i< n-2; i++)
    {
        temp = (num1 + num2) % 1000000007;
        num1 = num2;
        num2 = temp;
    }
    
    return num2;
}

int main()
{
    int n = 4;
    
    for(int i = 1; i < 100; i++)
    {
        cout << fibo(i) << endl;
    }
    
    return 0;
}
