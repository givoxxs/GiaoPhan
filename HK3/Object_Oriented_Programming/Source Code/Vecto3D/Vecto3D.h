#ifndef VECTO3D_H
#define VECTO3D_H
#include <iostream>
using namespace std;

class Vecto3D  {
    private:
        int x,y,z;
    public:
        Vecto3D(int xx=1, int yy = 1, int zz = 1);
        ~Vecto3D();

        void Nhap();
        void Xuat();

        Vecto3D Tong(const Vecto3D &v);
        operator + ()
        friend istream &operator >> (istream &in, Vecto3D &v);
        friend ostream &operator << (istream &in, Vecto3D &v);
};
#endif



