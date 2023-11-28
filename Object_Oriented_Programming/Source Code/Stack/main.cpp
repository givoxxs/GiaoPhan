#include "Stack.h"
#include <iostream>

using namespace std;
int main(){
    int n;
    cout<<"nhập n:";
    cin>>n;
    Stack S(8);
    do {
        S.Push(n%16);
        n = n/16;
    } while (n);
    cout<<"Dãy số thập lục phân:";
    int x;
    Stack S1 = S;
    //S1.data[2] = 3;
    char Hex[] = "0123456789ABCDEF";
    while (!S.isEmpty()) {
        S.Pop(x);
        cout<<Hex[x];
    }
}