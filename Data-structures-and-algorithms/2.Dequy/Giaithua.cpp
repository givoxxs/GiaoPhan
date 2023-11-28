#include <iostream>
using namespace std;

int Dequy(int n) {
    if (n<2) return 1;
    int sum = 1;
    for (int i=2; i<n; i++) {
      sum *= i;
    }
    return sum;
}

int main() {
    int n;

    cin >> n;
    cout << Dequy(n);
    
    return 0;
}