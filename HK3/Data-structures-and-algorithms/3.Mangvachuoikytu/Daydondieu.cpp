#include <iostream>
using namespace std;

int main() {
    int n,i;
    cin >> n;
    int *arr = new int [n];
    for (i = 0; i<n; i++) {
        cin >> arr[i];
    }
    int check = arr[1] - arr[0];
    for (i = 2; i<n; i++) {
        if (check*(arr[i]- arr[i-1]) <= 0) {
            cout << "NO";
            return 0;
        }
    } 
    cout << "YES";
    return 0;
}