#include <iostream>
#include <cmath>
using namespace std;

struct SoPhuc {
    double phanThuc;
    double phanAo;
};
// Ham nhap so phuc
istream &operator>>(istream &is, SoPhuc &sp) {
    cout << "Nhap phan thuc: ";
    is >> sp.phanThuc;
   	cout << "Nhap phan ao: ";
    is >> sp.phanAo;
    return is;
}
// Ham xuat so phuc
ostream &operator<<(ostream &os, const SoPhuc &sp) {
    os << sp.phanThuc << " + " << sp.phanAo << "i";
    return os;
}
// Ham tính module so phuc
double Module(const SoPhuc &sp) {
    return sqrt(sp.phanThuc * sp.phanThuc + sp.phanAo * sp.phanAo);
}
// Hàm toan tu arithmetric (+, -, *, /)
// Hàm tính "+"
SoPhuc operator+(const SoPhuc &sp1, const SoPhuc &sp2) {
    SoPhuc result;
    result.phanThuc = sp1.phanThuc + sp2.phanThuc;
    result.phanAo = sp1.phanAo + sp2.phanAo;
    return result;
}
// Hàm tính "-"
SoPhuc operator-(const SoPhuc &sp1, const SoPhuc &sp2) {
    SoPhuc result;
    result.phanThuc = sp1.phanThuc - sp2.phanThuc;
    result.phanAo = sp1.phanAo - sp2.phanAo;
    return result;
}
// Hàm tính "*"
SoPhuc operator*(const SoPhuc &sp1, const SoPhuc &sp2) {
    SoPhuc result;
    result.phanThuc = sp1.phanThuc * sp2.phanThuc - sp1.phanAo * sp2.phanAo;
    result.phanAo = sp1.phanThuc * sp2.phanAo + sp1.phanAo * sp2.phanThuc;
    return result;
}
// Hàm tính "/"
SoPhuc operator/(const SoPhuc &sp1, const SoPhuc &sp2) {
    SoPhuc result;
    double denominator = sp2.phanThuc * sp2.phanThuc + sp2.phanAo * sp2.phanAo;
    result.phanThuc = (sp1.phanThuc * sp2.phanThuc + sp1.phanAo * sp2.phanAo) / denominator;
    result.phanAo = (sp1.phanAo * sp2.phanThuc - sp1.phanThuc * sp2.phanAo) / denominator;
    return result;
}
// Hàm so sánh (<, >, ==, !=)
// Hàm so sanh >
bool operator<(const SoPhuc &sp1, const SoPhuc &sp2) {
    return Module(sp1) < Module(sp2);
}
// Hàm so sanh <
bool operator>(const SoPhuc &sp1, const SoPhuc &sp2) {
    return Module(sp1) > Module(sp2);
}
// Hàm so sanh ==
bool operator==(const SoPhuc &sp1, const SoPhuc &sp2) {
    return (sp1.phanThuc == sp2.phanThuc) && (sp1.phanAo == sp2.phanAo);
}
// Hàm so sanh !=
bool operator!=(const SoPhuc &sp1, const SoPhuc &sp2) {
    return !(sp1 == sp2);
}
//Ham MAIN
int main() {
    SoPhuc sp1, sp2;
    cout << "Nhap so phuc thu nhat:\n";
    cin >> sp1;
    cout << "Nhap so phuc thu hai:\n";
    cin >> sp2;

    cout << "So phuc thu nhat la: " << sp1 << endl;
    cout << "So phuc thu hai la: " << sp2 << endl;

    cout << "Tong cua hai so phuc la: " << sp1 + sp2 << endl;
    cout << "Hieu cua hai so phuc la: " << sp1 - sp2 << endl;
    cout << "Tich cua hai so phuc la: " << sp1 * sp2 << endl;
    cout << "Thuong cua hai so phuc la: " << sp1 / sp2 << endl;

    if (sp1 < sp2) cout << "So phuc thu nhat nho hon so phuc thu hai\n";
    if (sp1 > sp2) cout << "So phuc thu nhat lon hon so phuc thu hai\n";
    if (sp1 == sp2) cout << "Hai so phuc bang nhau\n";
    if (sp1 != sp2) cout << "Hai so phuc khong bang nhau\n";

    return 0;
}

