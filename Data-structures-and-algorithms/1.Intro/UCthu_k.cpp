#include <iostream>
#include <cmath>
using namespace std;
// Tìm Ước chung thứ k
int UCthu_k(int x, int y, int k) {
    if (k <= 0) return -1;
    int i=1, count = 0;
    while (i <= min(x, y)) {
        if ((x % i == 0) && (y % i == 0)) {
            count ++;
            if (count == k) 
                return i;
        }
        i++;
    }          
    return -1;
}
// Main
int main() {
    int x,y,k;
    cin >> x;
    cin >> y;
    cin >> k;

    cout << UCthu_k(x,y,k);
    return 0;
}