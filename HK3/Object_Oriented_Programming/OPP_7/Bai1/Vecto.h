// Vecto.h khai báo
#ifndef VECTO_H 
#define VECTO_H 

#include <iostream>

using namespace std;
template <typename T>
class Vecto;

template <typename T>
istream &operator >> (istream &is, Vecto<T> &other);
template <typename T>
ostream &operator << (ostream &os, const Vecto<T> &other);

template <typename T>
class Vecto {
    int n;
    T *data;
    
    public:
        Vecto(int size);
        Vecto(const Vecto<T>& other);
        ~Vecto(); 

        Vecto<T> operator + (const Vecto<T>& ); // Tổng
        Vecto<T> operator - (const Vecto<T>& ); // Hiệu
        int operator * (const Vecto<T>& ); // Tích
        Vecto<T>& operator = (const Vecto<T>& ); // " = "
        T operator [] (int x);

        friend istream &operator >> <T>(istream &is, Vecto<T> &other);
        friend ostream &operator << <T>(ostream &os, const Vecto<T> &other);
        
};

#endif


