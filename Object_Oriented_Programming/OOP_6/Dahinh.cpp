
#include <iostream>
#include <cmath>
using namespace std;
// Class Room
class Room {
    protected:
        float edge;
    public:
        virtual void Nhap();
        virtual float Dientich();
};
void Room::Nhap() {
    cin >> edge;
    cout << "=====================================" << endl;
}
float Room::Dientich() {
    return edge;
}
// Class Circle Room
class CircleRoom : public Room {

    public:
        void Nhap();
        void Xuat();
        float Dientich();
};
void CircleRoom::Nhap() {
    cout << "Do dai ban kinh R : ";
    Room::Nhap();
}
float CircleRoom::Dientich() {
    return M_PI*edge*edge;
}
// Class Square Room
class SquareRoom : public Room {

    public:
        void Nhap();
        void Xuat();
        float Dientich();
};
void SquareRoom::Nhap() {
    cout << "Do dai canh hinh vuong : ";
    Room::Nhap();
}
float SquareRoom::Dientich() {
    return edge*edge;
}
// Class Triangle Room
class TriangleRoom : public Room {

    public:
        void Nhap();
        void Xuat();
        float Dientich();
};
void TriangleRoom::Nhap() {
    cout << "Do dai canh hinh vuong : ";
    Room::Nhap();
}
float TriangleRoom::Dientich() {
    return edge*edge*sqrt(3)/4;
}
// Main
int main() {
    /*--Code--*/
    cout << "Ngoi nha cua ban co bao nhieu phong? " << endl;
    int n;
    cin >> n;
    cout << "=====================================" << endl;
    // Room *rooms = new Room[n];
    // Room** rooms = new Room*[n];
    Room *rooms[n];
    int i = 0;
    float sum = 0;
    char answer;
    do {
        cout << "Phong thu " << i+1 << " la phong hinh Tron(C) / hinh Vuong(S) / hinh Tam Giac(T)? " << endl;
        cin >> answer;
        answer =  toupper(answer);

        if (answer == 'C') rooms[i] = new CircleRoom; 
            else if (answer == 'S') rooms[i] = new SquareRoom;
                else if (answer == 'T') rooms[i] = new TriangleRoom;
                    else {
                        cout << "Khong the tinh dien tich phong nay!" << endl;
                        break;
                    }  
                 
        rooms[i]->Nhap();
        sum += rooms[i++]->Dientich();  
    } while (i<n);

    cout << "Dien tich NGOI NHA : " << sum << endl;

    for (int i = 0; i < n; i++) {
        delete rooms[i];
    }
    return 0;
}