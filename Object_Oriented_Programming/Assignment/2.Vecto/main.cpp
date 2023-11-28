#include "Vecto.h"
#include <iostream>

using namespace std;

int main() {
    int n;
    cout << "Nhap so chieu cua vec to: ";
    cin >> n;
    Vecto vecto1(n);
    Vecto vecto2(n);
    cout << "Nhap vecto thu 1" << endl;
    vecto1.input();

    cout << "Nhap vecto thu 2" << endl;
    vecto2.input();

    cout << "Vecto thu 1 la";
    vecto1.output();
    cout << "Vecto thu 2 la";
    vecto2.output();

    Vecto sum = vecto1.add(vecto2);
    Vecto hieu = vecto1.subtract(vecto2);
    int tich  = vecto1.dotProduct(vecto2);

    cout << "tong hai vec to la ";
    sum.output();

    cout << "hieu hai vec to la ";
    hieu.output();

    cout << "Tich vo huong hai vec to la " << tich << endl;

    return 0;
}