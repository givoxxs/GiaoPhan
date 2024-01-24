#include "Vecto.h"
#include <iostream>

using namespace std;

Vecto::Vecto(int size) {
    n = size;
    data = new int[n];
    for (int i = 0; i < n; i++) {
        data[i] = 0;
    }
}

Vecto::Vecto(const Vecto& other) {
    n = other.n;
    data = new int[n];
    for (int i=0; i<n;i++) {
        data[i] = other.data[i];
    }
}

Vecto::~Vecto() {
    delete[] data;
}

void Vecto::input() {
    cout << "Nhap cac thanh phan cua vec to co " << n << "chieu!" << endl;
    for (int i=0;i<n;i++) {
        cout << "Thanh phan thu "<< i + 1 << " la: ";
        cin >> data[i];
    }
}

void Vecto::output() {
    cout << "Vecto " << n << " chieu la:  (";
    for (int i = 0; i < n; i++) {
        cout << data[i];
        if (i < n - 1) {
            cout << ", ";
        }
    }
    cout << ")" << endl;
}

Vecto Vecto::add(const Vecto& other) {
    Vecto result(n);
    for (int i = 0; i < n; i++) {
        result.data[i] = data[i] + other.data[i];
    }

    return result;
}

Vecto Vecto::subtract(const Vecto& other) {
    Vecto result(n);
    for (int i = 0; i < n; i++) {
        result.data[i] = data[i] - other.data[i];
    }

    return result;
}

int Vecto::dotProduct(const Vecto& other) {
    int result;
    for (int i = 0; i < n; i++) {
        result += data[i] * other.data[i];
    }
    return result;
}

istream &operator >> (istream &is, Vecto &other) {
    cout << "Nhap cac thanh phan cua vec to co " << other.n << "chieu!" << endl;
    for (int i=0;i< other.n;i++) {
        cout << "Thanh phan thu "<< i + 1 << " la: ";
        cin >> other.data[i];
    }
    return is;
}

ostream &operator << (istream &os, Vecto &other) {
    cout << "Vecto " << other.n << " chieu la:  (";
    for (int i = 0; i < other.n; i++) {
        cout << other.data[i];
        if (i < 3 - 1) {
            cout << ", ";
        }
    }
    cout << ")" << endl;
}
