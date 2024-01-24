// Date.h khai bao
#ifndef DATE_H 
#define DATE_H 
#include <iostream>
using namespace std;

class Date {
    int day, month, year;
    
    public:
        Date();
        Date(int d, int m, int y);

        bool NamNhuan(); // Nam nhuan
        int travengay(); //

        Date operator -- ();
        Date operator ++ ();

        friend istream &operator >> (istream &is, Date &other);
        friend ostream &operator << (ostream &os,const Date &other);
};

#endif

