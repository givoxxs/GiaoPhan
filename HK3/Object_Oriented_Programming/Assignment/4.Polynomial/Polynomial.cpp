#include "Polynomial.h"
#include <iostream>
#include <math.h>

using namespace std;
// Hàm dựng
Polynomial::Polynomial(int n) : degree(n) {
    factor = new double [degree + 1];
    for (int i=0; i<=degree; i++) {
        factor[i] = 0;
    }
}
// Hàm dựng sao chép
Polynomial::Polynomial(const Polynomial& other) : degree(other.degree) {
    factor = new double [degree + 1];
    for (int i=0; i<=degree; i++) {
        factor[i] = other.factor[i];
    }
}
// Hàm hủy
Polynomial::~Polynomial() {
    delete [] factor;
}
// cộng 2 đa thức
Polynomial Polynomial::operator + (const Polynomial& other) {
    int maxDegree = (degree > other.degree) ? degree : other.degree;
    Polynomial result(maxDegree);

    for (int i=0; i<=maxDegree; i++) {
        result.factor[i] = (i <= degree ? factor[i] : 0.0) + (i <= other.degree ? other.factor[i] : 0.0) ;
    }

    return result;
} 
// trừ 2 đa thức
Polynomial Polynomial::operator - (const Polynomial& other) {
    int maxDegree = (degree > other.degree) ? degree : other.degree;
    Polynomial result(maxDegree);

    for (int i=0; i<=maxDegree; i++) {
        result.factor[i] = (i <= degree ? factor[i] : 0.0) - (i <= other.degree ? other.factor[i] : 0.0); 
    }

    return result;
} 
// gán đa thức
Polynomial Polynomial::operator = (const Polynomial& other) {
    if (this == &other) {
        return *this;
    }
    if (degree != other.degree) {
        delete [] factor;
        degree = other.degree;
        factor = new double [degree + 1];
    }
    for (int i=0; i<=degree; i++) {
        factor[i] = other.factor[i];
    }
    return *this;
} 
// Truy xuất 1 hệ số của đa thức;
double &Polynomial::operator[](int x) {
    if (x < 0; x > degree + 1) {
        cout << "Lỗi hệ số!!!" << endl;
    }
    return factor[x];
}
// Tính giá trị đa thức tại x
double Polynomial::operator()(double x) const {
    double result = 0;
    for (int i=degree; i>=0; i--) {
        result += factor[i] * pow(x, i);
    }
    return result;
}
// Hàm nhập
istream &operator >> (istream &in, Polynomial &other) {
    cout << "Nhập đa thức " << other.degree << " :" << endl;
    for (int i=other.degree; i>=0; i--) {
        cout << "Hệ số x^" << i << " = ";
        in >> other.factor[i];
    }
    return in;
}
// Hàm xuất
ostream &operator << (ostream &out, Polynomial &other) {
    for (int i=other.degree; i>0; i--) {
        out << other.factor[i] << "x^" << i << " + ";
    }
    out << other.factor[0] << endl;
    return out;
}
