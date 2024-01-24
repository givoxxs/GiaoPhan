#include <iostream>
using namespace std;

struct PhanSo{
	int tu;
	int mau;
};
// Ham nhap phan so tu ban phim
istream &operator >> (istream &is, PhanSo &ps) {
	cout << "Nhap tu so: ";
	is >> ps.tu;
	cout << "Nhap mau so: ";
	is >> ps.mau;
	return is;
}
// Ham xuat phan so ra man hinh
ostream &operator << (ostream &os,const PhanSo ps){
	os << ps.tu << "/" << ps.mau;
	return os;
}
// Ham tim UCLN 
int UCLN(int a, int b){
	while (b != 0) {
		int temp = b;
		b = a % b;
		a = temp;
	}
	return a;
}
// Ham rut gon phan so
void RutGon(PhanSo &ps){
	int ucln = UCLN(ps.tu, ps.mau);
	ps.tu /= ucln;
	ps.mau /= ucln;
}
// Ham nghich dao phan so
void NghichDao(PhanSo &ps){
	swap(ps.tu, ps.mau);
}
// Ham cong hai phan so
PhanSo operator + (const PhanSo a,const PhanSo b) {
	PhanSo kq;
	kq.tu = a.tu * b.mau + a.mau * b.tu;
	kq.mau = a.mau * b.mau;
	RutGon(kq);
	return kq;
}
// Ham tru hai phan so
PhanSo operator - (const PhanSo &a,const PhanSo &b) {
	PhanSo kq;
	kq.tu = a.tu * b.mau - a.mau * b.tu;
	kq.mau = a.mau * b.mau;
	RutGon(kq);
	return kq;
}
// Ham nhan hai phan so
PhanSo operator * (const PhanSo &a, const PhanSo &b) {
	PhanSo kq;
	kq.tu = a.tu * b.tu;
	kq.mau = a.mau * b.mau;
	RutGon(kq);
	return kq;
}
// Ham chia hai phan so
PhanSo operator / (const PhanSo &a, const PhanSo &b) {
	PhanSo kq;
	kq.tu = a.tu * b.mau;
	kq.mau = a.mau * b.tu;
	RutGon(kq);
	return kq;
}
// Ham so sanh 2 phan so co nho hon khong < 
bool operator < (const PhanSo &a, const PhanSo &b) {
	return a.tu * b.mau < a.mau * b.tu;
}
// Ham so sanh 2 phan so co lon hon khong >
bool operator > (const PhanSo &a, const PhanSo &b) {
	return a.tu * b.mau > a.mau * b.tu;
}
// Ham so sanh 2 phan so co bang nhau khong =
bool operator == (const PhanSo &a, const PhanSo &b) {
	return a.tu * b.mau == a.mau * b.tu;
}
// Ham so sanh 2 phan so co # nhau khong
bool operator != (const PhanSo &a, const PhanSo &b) {
	return a.tu * b.mau != a.mau * b.tu;
}

int main() {
	PhanSo ps1, ps2;
	cout << "Nhap phan so thu nhat:\n";
	cin >> ps1;
	cout << "Nhap phan so thu hai:\n";
	cin >> ps2;
	
	cout << "Phan so thu nhat la: " << ps1 << endl; 
    cout << "Phan so thu hai la: " << ps2 << endl; 
    
    cout << "Tong cua hai phan so la: " << ps1 + ps2 << endl;
    cout << "Hieu cua hai phan so la: " << ps1 - ps2 << endl; 
    cout << "Tich cua hai phan so la: " << ps1 * ps2 << endl;
    cout << "Thuong cua hai phan so la: " << ps1 / ps2 << endl; 
    
    if (ps1 < ps2) cout << "Phan so thu nhat nho hon phan so thu hai\n";
    if (ps1 > ps2) cout << "Phan so thu nhat lon hon phan so thu hai\n"; 
    if (ps1 == ps2) cout << "Hai phan so bang nhau\n"; 
    if (ps1 != ps2) cout << "Hai phan so khong bang nhau\n";
    return 0;
}
