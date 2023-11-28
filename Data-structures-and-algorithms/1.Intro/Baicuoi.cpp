#include   <iostream>
using namespace std;
// Tìm chữ số cuối cùng khác 0 của 1 số

int dig[] = {1, 1, 2, 6, 4, 2, 2, 4, 2, 8};
// Tìm chữ số cuối cùng khác 0 của n!
int Try(int n)
{
     if (n < 10)
        return dig[n];

    if (((n/10)%10)%2 == 0)
        return (6*Try(n/5)*dig[n%10]) % 10;
    else
        return (4*Try(n/5)*dig[n%10]) % 10;
}
 
// Main
int main() {
    int n;

    cin >> n;
    cout << Try(n);

    return 0;
}