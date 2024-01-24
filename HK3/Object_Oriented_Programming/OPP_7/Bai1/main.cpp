#include "Vecto.h"
#include "Vecto.cpp"
#include <iostream>

using namespace std;

int main() {
    int n;
    cout << "Nhap so chieu cua vec to: ";
    cin >> n;
    Vecto<int> vecto1(n);
    Vecto<int> vecto2(n);

    cout << "\tNhap vecto thu 1:" << endl;
    cin >> vecto1;

    cout << "\tNhap vecto thu 2" << endl;
    cin >> vecto2;

    cout << "Vecto thu 1 la" << vecto1;

    cout << "Vecto thu 2 la" << vecto2;

    Vecto<int> sum = vecto1 + vecto2;
    Vecto<int> hieu = vecto1 - vecto2;
    int tich  = vecto1*vecto2;

    cout << "tong hai vec to la :" << sum << endl;

    cout << "hieu hai vec to la :" << hieu << endl;

    cout << "Tich vo huong hai vec to la :" << tich << endl;

    int x;
    cout << "Nhap x = "; cin>>x;
    cout << "vecto1 [" << x << "] = " << vecto1[x] << endl; 

    return 0;
}