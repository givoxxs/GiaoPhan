#include "Vecto.h"
#include <iostream>
#include <stdexcept>

using namespace std;

template <typename T>
Vecto<T>::Vecto(int size) {
    if (size <= 0) {
        throw invalid_argument("Kích thước của Vecto phải lớn hơn 0.");
        //throw string("Kích thước của Vecto phải lớn hơn 0.");
    } else {
        n = size;
        data = new T[n];
        for (int i = 0; i < n; i++) {
            data[i] = 0;
        }
    }

    // n = size;
    // data = new T[n];
    // for (int i = 0; i < n; i++) {
    //     data[i] = 0;
    // }
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
    if (n != other.n) {
            throw string("Kich thuoc cua 2 vecto khong khop!");
        }

    Vecto<T> result(n);
    for (int i = 0; i < n; i++) {
        result.data[i] = data[i] + other.data[i];
    }

    return result;
}
// Hiệu
template <typename T>
Vecto<T> Vecto<T>::operator-(const Vecto<T>& other) {
    if (n != other.n) {
            throw string("Kich thuoc cua 2 vecto khong khop!");
        }

    Vecto<T> result(n);
    for (int i = 0; i < n; i++) {
        result.data[i] = data[i] - other.data[i];
    }

    return result;
}
// Tich
template <typename T>
int Vecto<T>::operator*(const Vecto<T>& other) {
    if (n != other.n) {
            throw string("Kich thuoc cua 2 vecto khong khop!");
        }

    int result;
    for (int i = 0; i < n; i++) {
        result += data[i] * other.data[i];
    }
    return result;
    // invalid_argument
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
    cout << "(";
    for (int i = 0; i < other.n; i++) {
        cout << other.data[i];
        if (i < other.n - 1) cout << ", ";
    }
    cout << ")";

    return os;
}
// Đa năng hóa []
template <typename T>
T Vecto<T>::operator [] (int x) {
    if (x < 0 || x >= n) {
            throw string("Truy cap phan tu ngoai pham vi ");
        }
    return data[x];
}

template class Vecto<int>;
template class Vecto<float>;

