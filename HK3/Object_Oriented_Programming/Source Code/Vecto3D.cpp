#include <iostream>
using namespace std;
struct Vecto3D {
    int x, y, z;
};
istream &operator >>(istream &in, Vecto3D &a){
    cout<<"Nhập tọa độ x:"; in>>a.x;
    cout<<"Nhập tọa độ y:"; in>>a.y;
    cout<<"Nhập tọa độ z:"; in>>a.z;
    return in;
}
ostream &operator << (ostream &out,const Vecto3D &a){
    out<<"("<<a.x<<","<<a.y<<","<<a.z<<")"<<endl;
    return out;
}
Vecto3D operator + (const Vecto3D &a, const Vecto3D &b){
    Vecto3D t;
    t.x = a.x + b.x;
    t.y = a.y + b.y;
    t.z = a.z + b.z;
    return t;
}
int main(){
    Vecto3D a, b, c;
    cout<<"Nhập tọa độ vecto a:"<<endl;
    cin >> a;
    cout<<"Nhập tọa độ vecto b:"<<endl;
    cin >> b;
    cout<<"Tọa độ của vecto a:" << a;
    cout<<"Tọa độ của vecto b:" << b;
    c = a + b;
    cout<<"Tọa độ của vecto c = a + b = " << c;

}