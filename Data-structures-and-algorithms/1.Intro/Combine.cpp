#include   <iostream>
using namespace std;
// Combine
long long Combine(int n, int k) {
    if ((k==0) || (k==n)) return 1;
    long long A[k+1];
    int i, j;

    for (i=1; i<=k; i++)     A[i] = 0;
    A[0] = 1;

    for (i=1; i<=n; i++) {
        for (j=k; j>0; j--) {
            A[j] = A[j] + A[j-1];
        }
    }

    return A[k];
}
//Main
int main() {
    int k, n;

    cin >> k;
    cin >> n;
    cout << Combine(n,k);

    return 0;
}