#include   <iostream>
using namespace std;
// Tìm chữ số cuối cùng khác 0 của 1 số
int Find(int x) {
    while (x % 10 == 0) {
            x /= 10;
        }
    return x;
}
// Tìm chữ số cuối cùng khác 0 của n!
int Try(int n) {
    if (n < 2) return 1;
    int result = 1;
    for (int i=2; i<=n; i++) {
        int c = Find(i);
        c = c % 100;
        result *= c;
        result = Find(result);
        result = result % 100;
    }
    return result % 10;
}
// Main
int main() {
    int n;

    cin >> n;
    cout << Try(n);

    return 0;
}