//Set.h
#ifndef SET_H
#define SET_H
#include <iostream>
using namespace std;

class Set {
    private:
        /* data */
        int size;
        int *data;
    public:
        Set();
        Set(const Set &other);
        ~Set();

        Set operator + (const Set &other); // Hợp
        Set operator - (const Set &other); // Trừ
        Set operator * (const Set &other); // Giao
        Set operator = (const Set &other); // Gán

        Set operator +=  (int ); // Thêm 1 phần tử
        Set operator -= (int ); // Bớt 1 phần tử

        friend istream &operator >> (istream& in,Set &other);
        friend ostream &operator << (ostream& out, const Set &other);

        int operator [] (int x);
        bool operator() (int x) const;
        
        int getSize() const;
        void Arrange();
};
#endif

