#include <iostream>
using namespace std;

int Fibonacci(int n) {
    int F[n];
    F[1] = F[2] = 1;
    for (int i=3; i<=n; i++) {
      F[i] = F[i-1] + F[i-2];
    }
    return F[n];
}

int main() {
    int n;
    cin >> n;
    cout << Fibonacci(n);
    return 0;
}