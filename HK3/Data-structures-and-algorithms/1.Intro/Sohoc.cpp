#include <iostream>
#include <cmath>
using namespace std;

bool check(int n) {
    if (n < 2)  return false;
    for (int i=2; i <= sqrt(n) ; i++) {
        if (n%i == 0) return false;
    }
    return true;
}

int Process(int n) {
    while (!check(n)) {
        int sum = 0;
        int i=2;
        int NA = n;
        while (i <= NA)  {
            if (check(i)) {
                if (n%i == 0) {sum+=i;n/=i;} else i++;
            } else {
                i++;
            }
        } 
        n = sum;
    }
    return n;
}

int main() {
    int n;

    cin >> n;
    cout << Process(n);
    
    return 0;
}