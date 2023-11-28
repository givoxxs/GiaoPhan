#include "Vecto3D.h"
#include <iostream>
using namespace std;

Vecto3D(int xx=1, int yy = 1, int zz = 1){}
~Vecto3D   (){}

void Nhap(){

}
void Xuat (){

}

Vecto3D Tong(const Vecto3D &v){

}
operator + ()
friend istream &operator >> (istream &in, Vecto3D &v){
    cout << "Nhap x: "; in >> v.x;
    cout << "Nhap y: "; in >> v.y;
    cout << "Nhap z: "; in >> v.z;
    return in;
}
friend ostream &operator << (istream &in, Vecto3D &v){
    
}