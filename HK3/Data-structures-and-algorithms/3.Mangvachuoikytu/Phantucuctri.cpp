#include <iostream>
using namespace std;

int main() {
    int n,i;
    cin >> n;
    int *arr = new int [n];
    for (i = 0; i<n; i++) {
        cin >> arr[i];
    }
    if (n==1) {
        cout << 0;
        return 0;
    } else {
        if (arr[0] >= arr[1]) cout << 0 << " ";
        
        for (i = 1; i<n-1; i++) {
            if ((arr[i] >= arr[i-1]) && (arr[i] >= arr[i+1])) {
                cout << i << " ";
            }
        }

        if (arr[n - 1] >= arr[n - 2]) cout << n-1;
    }
    
    delete arr;
    return 0;
}