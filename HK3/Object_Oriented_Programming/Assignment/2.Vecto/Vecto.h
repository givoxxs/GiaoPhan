
#include <iostream>

using namespace std;
// Vecto.h khai báo
#ifndef VECTO_H 
#define VECTO_H 

class Vecto {
    int n;
    int *data;
    
    public:
        Vecto(int size);
        Vecto(const Vecto& other);
        ~Vecto(); 

        void input();
        void output();

        Vecto add(const Vecto& other);
        Vecto subtract(const Vecto& other);
        int dotProduct(const Vecto& other);

        friend istream &operator >> (istream &is, Vecto &other);
        friend ostream &operator << (istream &os, Vecto &other);
        
};

#endif


