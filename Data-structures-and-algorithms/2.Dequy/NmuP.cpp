#include <iostream>
using namespace std;

long long Try(int n, int p) {
    if (p < 1) return 1;
    return n*Try(n, p-1);
}

int main() {
    int n,p;
    
    cin >> n;
    cin >> p;
    cout << Try(n,p);

    return 0;
}