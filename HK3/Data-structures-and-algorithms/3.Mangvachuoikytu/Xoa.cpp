#include <iostream>
using namespace std;

int main() {
    int n,k,x,i;
    cin >> n;
    int *arr = new int [n];
    for (i = 0; i<n; i++) {
        cin >> arr[i];
    }
    cin >> k;
    for (i=k ; i<n ; i++) {
        arr[i] = arr[i+1];
    }
    n--;
    for (i=0 ; i<n; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}