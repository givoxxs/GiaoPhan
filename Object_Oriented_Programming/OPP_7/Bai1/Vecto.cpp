#include "Vecto.h"
#include <iostream>

using namespace std;

template <typename T>
Vecto<T>::Vecto(int size) {
    n = size;
    data = new T[n];
    for (int i = 0; i < n; i++) {
        data[i] = 0;
    }
}

template <typename T>
Vecto<T>::Vecto(const Vecto<T>& other) {
    n = other.n;
    data = new T[n];
    for (int i=0; i<n;i++) {
        data[i] = other.data[i];
    }
}
template <typename T>
Vecto<T>::~Vecto() {
    delete[] data;
}

// Tổng
template <typename T>
Vecto<T> Vecto<T>::operator+(const Vecto<T>& other) {
    Vecto<T> result(n);
    for (int i = 0; i < n; i++) {
        result.data[i] = data[i] + other.data[i];
    }

    return result;
}
// Hiệu
template <typename T>
Vecto<T> Vecto<T>::operator-(const Vecto<T>& other) {
    Vecto<T> result(n);
    for (int i = 0; i < n; i++) {
        result.data[i] = data[i] - other.data[i];
    }

    return result;
}
// Tich
template <typename T>
int Vecto<T>::operator*(const Vecto<T>& other) {
    int result;
    for (int i = 0; i < n; i++) {
        result += data[i] * other.data[i];
    }
    return result;
}
// Dau =
template <typename T>
Vecto<T>& Vecto<T>::operator = (const Vecto<T>& other) {
    if (this != &other) {
        delete[] data;
        n = other.n;
        data = new T[n];
        for (int i=0; i<n;i++) {
            data[i] = other.data[i];
        }
    }
    return *this;

}
// đa năng hóa  >>
template <typename T>
istream &operator >> (istream &is, Vecto<T> &other) {

    for (int i = 0; i < other.n;i++) {
        is >> other.data[i];
    }

    return is;
}
// Đa năng hóa <<
template <typename T>
ostream &operator << (ostream &os,const Vecto<T> &other) {
    // cout << "Vecto " << other.n << " chieu la:  (";

    for (int i = 0; i < other.n; i++) {
        cout << other.data[i];
    }

    return os;
}
// Đa năng hóa []
template <typename T>
T Vecto<T>::operator [] (int x) {
    if (x < 0 || x > n) {
        cout << "Nằm ngoài phạm vi!!!" << endl;
    }
    return data[x];
}

template class Vecto<int>;
template class Vecto<float>;

