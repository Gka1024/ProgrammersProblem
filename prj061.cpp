#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

int GCD(int a, int b) // a와 b의 최대 공약수를 구하는 함수
{
    if(a % b == 0)
    {
        return b;
    }
    else
    {
        return GCD(b, a%b);
    }

}

int divCard(int num,vector<int> arr) // num의 약수로 arr의 각 요소를 나누었을 때,
{ //  나누어 떨어지지 않는 가장 큰 약수를 구하는 함수
    vector<int> Divisor; // num의 약수를 담을 벡터
    int root = (int) sqrt(num);

    for(int i = 1; i <= root; i++)
    { // num의 약수를 구하는 반복문
        if(num % i == 0)
        {
            Divisor.push_back(i);
            if(i != num/i)
            { // i가 num의 제곱근이면 한번만 넣어야 하므로
                Divisor.push_back(num/i);
            }
        }
    }

    sort(Divisor.rbegin(), Divisor.rend());
     // 내림차순 정렬
    int finNum; // 나누어 떨어지지 않는 가장 큰 약수
    bool flag;

    for(int i = 0; i < Divisor.size(); i++)
    {
        flag = true;

        if(Divisor[i] == 1)
        { // 모든 수로 나누어 떨어지거나 1인 경우에
            finNum = 0; 
            break;
        }

        for(int j = 0; j < arr.size(); j++)
        {
            if(arr[j] % Divisor[i] == 0)
            { // 나누어 떨어진다면 다음 수로 넘어가야 하므로
                flag = false;
                break;
            }
        }

        if(flag)
        {
          finNum = Divisor[i];
          break;
        }
    }

    return finNum;
}

int getGCD(vector<int> arr) //벡터 arr이 주어졌을 때, arr의 최대 공약수를 구하는 함수 
{
    int num = arr[0];
    for(int i = 1; i < arr.size(); i++)
    {
        num = GCD(arr[i], num);
    }
    return num;
}

int solution(vector<int> arrayA, vector<int> arrayB) {

    int a = divCard(getGCD(arrayA), arrayB);
    int b = divCard(getGCD(arrayB), arrayA);

    return ((a>b)?a:b);
}
