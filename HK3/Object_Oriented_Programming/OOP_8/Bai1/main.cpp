#include "Vecto.h"
#include "Vecto.cpp"
#include <iostream>
#include <stdexcept>

using namespace std;

int main() {
    int n1, n2;
    cout << "Nhap so chieu cua vec to thu 1: ";
    cin >> n1;
    try {
        if (n1 <= 0) throw string("Kích thước của Vecto phải lớn hơn 0.");
    } catch (string& s) {
        cout << s;
        return 0;
    }
    Vecto<int> vecto1(n1);
    cout << "\tNhap vecto thu 1: ";
    cin >> vecto1;

    cout << "===========================" << endl;

    cout << "Nhap so chieu cua vec to thu 2: ";
    cin >> n2;
    try {
        if (n2 <= 0) throw string("Kích thước của Vecto phải lớn hơn 0.");
    } catch (string& s) {
        cout << s;
        return 0;
    }
    Vecto<int> vecto2(n2);
    cout << "\tNhap vecto thu 2: ";
    cin >> vecto2;

    cout << "=========================" << endl;

    cout << "\n\tVecto thu 1 la" << vecto1 << endl;

    cout << "\tVecto thu 2 la" << vecto2 << endl; 

    try {
        Vecto<int> sum = vecto1 + vecto2;
        Vecto<int> hieu = vecto1 - vecto2;
        int tich  = vecto1*vecto2;

        cout << "=========================" << endl;

        cout << "\tTong hai vec to la :" << sum << endl;

        cout << "\tHieu hai vec to la :" << hieu << endl;

        cout << "\tTich vo huong hai vec to la :" << tich << endl;

    cout << "=========================" << endl;
    } 
    catch (string& s) {
        cout << s << endl;
        cout << "Khong the tinh toan 2 Vecto" << endl;
        
    }

    int x;
    cout << "\t Nhap x = "; cin >> x;
    try {
        vecto1[x];
        cout << "\tvecto1 [" << x << "] = " << vecto1[x] << endl; 
    } catch (string& s) {
        cout << s << " vecto1." << endl;       
    }

    try {
        vecto2[x];
        cout << "\tvecto2 [" << x << "] = " << vecto2[x] << endl; 
    } catch (string& s) {
        cout << s << " vecto2." << endl;       
    }

    return 0;
}