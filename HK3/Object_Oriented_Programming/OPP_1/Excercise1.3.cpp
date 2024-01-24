#include <iostream>
#include <cmath>
using namespace std;

struct DonThuc {
    double heSo;
    int bac;
};

istream &operator>>(istream &is, DonThuc &dt) {
    cout << "Nhap he so: ";
    is >> dt.heSo;
    std::cout << "Nhap bac: ";
    is >> dt.bac;
    return is;
}

// Hàm in ra don thuc
ostream &operator<<(ostream &os, const DonThuc &dt) {
    os << dt.heSo;
    if (dt.bac != 0) {
        os << "x";
        if (dt.bac != 1) {
            os << "^" << dt.bac;
        }
    }
    return os;
}

// Hàm tính don thuc tai x
double TinhGiaTri(const DonThuc &dt, double x) {
    return dt.heSo * pow(x, dt.bac);
}

// Hàm tính dao ham
DonThuc DaoHam(const DonThuc &dt) {
    DonThuc result;
    result.heSo = dt.heSo * dt.bac;
    result.bac = dt.bac - 1;
    return result;
}

// Hàm tích phân don thuc
DonThuc NguyenHam(const DonThuc &dt) {
    DonThuc result;
    result.heSo = dt.heSo / (dt.bac + 1);
    result.bac = dt.bac + 1;
    return result;
}

// Hàm toán tu (+, -, *, /)
DonThuc operator+(const DonThuc &dt1, const DonThuc &dt2) {
    DonThuc result;
    if (dt1.bac == dt2.bac) {
        result.heSo = dt1.heSo + dt2.heSo;
        result.bac = dt1.bac;
    } else {
        cerr << "Khong the cong hai don thuc khac bac" << endl;
        exit(1);
    }
    return result;
}

DonThuc operator-(const DonThuc &dt1, const DonThuc &dt2) {
    DonThuc result;
    if (dt1.bac == dt2.bac) {
        result.heSo = dt1.heSo - dt2.heSo;
        result.bac = dt1.bac;
    } else {
        cerr << "Khong the tru hai don thuc khac bac" << endl;
        exit(1);
    }
    return result;
}

DonThuc operator*(const DonThuc &dt1, const DonThuc &dt2) {
    DonThuc result;
    result.heSo = dt1.heSo * dt2.heSo;
    result.bac = dt1.bac + dt2.bac;
    return result;
}

DonThuc operator/(const DonThuc &dt1, const DonThuc &dt2) {
    if (dt2.heSo == 0) {
        cerr << "Khong the chia cho don thuc co he so 0" << endl;
        exit(1);
    }
    DonThuc result;
    result.heSo = dt1.heSo / dt2.heSo;
    result.bac = dt1.bac - dt2.bac;
    return result;
}

// Hàm so sánh (<, >, ==, !=)
bool operator<(const DonThuc &dt1, const DonThuc &dt2) {
    return dt1.bac < dt2.bac;
}

bool operator>(const DonThuc &dt1, const DonThuc &dt2) {
    return dt1.bac > dt2.bac;
}

bool operator==(const DonThuc &dt1, const DonThuc &dt2) {
    return dt1.heSo == dt2.heSo && dt1.bac == dt2.bac;
}

bool operator!=(const DonThuc &dt1, const DonThuc &dt2) {
    return !(dt1 == dt2);
}

int main() {
    DonThuc dt1, dt2;
    cout << "Nhap don thuc thu nhat:\n";
    cin >> dt1;
    cout << "Nhap don thuc thu hai:\n";
    cin >> dt2;

    // Các phép toán và in KQ
    cout << "Don thuc thu nhat la: " << dt1 << endl;
    cout << "Don thuc thu hai la: " << dt2 << endl;

    double x;
    cout << "Nhap gia tri x: ";
    cin >> x;

   	cout << "Gia tri don thuc thu nhat tai x = " << x << " la: " << TinhGiaTri(dt1, x) << endl;
    cout << "Gia tri don thuc thu hai tai x = " << x << " la: " << TinhGiaTri(dt2, x) << endl;

    cout << "Dao ham cua don thuc thu nhat la: " << DaoHam(dt1) << endl;
    cout << "Dao ham cua don thuc thu hai la: " << DaoHam(dt2) << endl;

    cout << "Nguyen ham cua don thuc thu nhat la: " << NguyenHam(dt1) << endl;
    cout << "Nguyen ham cua don thuc thu hai la: " << NguyenHam(dt2) << endl;

    cout << "Tong cua hai don thuc la: " << dt1 + dt2 << endl;
    cout << "Hieu cua hai don thuc la: " << dt1 - dt2 << endl;
    cout << "Tich cua hai don thuc la: " << dt1 * dt2 << endl;
    cout << "Thuong cua hai don thuc la: " << dt1 / dt2 << endl;

    if (dt1 < dt2) cout << "Don thuc thu nhat nho hon don thuc thu hai\n";
    if (dt1 > dt2) cout << "Don thuc thu nhat lon hon don thuc thu hai\n";
    if (dt1 == dt2) cout << "Hai don thuc bang nhau\n";
    if (dt1 != dt2) cout << "Hai don thuc khong bang nhau\n";

    return 0;
}

