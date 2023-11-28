#include <iostream>
using namespace std;

int main() {
    int n,k,x,i;
    cin >> n;
    int *arr = new int [n];
    for (i = 0; i<n; i++) {
        cin >> arr[i];
    }
    cin >> k >> x;
    for (i=n ; i>k ; i--) {
        arr[i] = arr[i-1];
    }
    arr[k] = x;
    for (i=0 ; i<=n; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}