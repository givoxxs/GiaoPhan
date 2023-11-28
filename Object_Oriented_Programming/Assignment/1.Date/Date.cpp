// Date.cpp
#include "Date.h" 
#include <iostream>
using namespace std;

Date::Date() : day(1), month(1), year(2000) {}

Date::Date(int d, int m, int y) :  day(d), month(m), year(y) {}

bool Date::NamNhuan() {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
}

int Date::travengay() {
    switch (month) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            return 31;
        case 4: case 6: case 9: case 11:
            return 30;
        case 2:
            if (NamNhuan()) return 29;
                else return 28;
        default:
            return -1; // Th�ng kh�ng h?p l?
      }
}

Date Date::operator -- () {
    Date prev = *this; 
    prev.day--;
    if (prev.day == 0) { 
        prev.month--; 
        if (prev.month == 0) {
            prev.month = 12; 
            prev.year--; 
        }
        prev.day = prev.travengay(); 
    } 

    return prev; 
}
Date Date::operator ++ () {
    Date next = *this;
        next.day++; 
        if (next.day > next.travengay()) { 
            next.month++; 
            if (next.month > 12) { 
                next.month = 1;
                next.year++;
            }
            next.day = 1;
        }

        return next; 
}

istream &operator >> (istream &is, Date &other) {
    cout << "Nhap ngay: ";
    cin >> other.day;
    cout << "Nhap thang: ";
    cin >> other.month;
    cout << "Nhap nam: ";
    cin >> other.year;
    return is;
}

ostream &operator << (ostream &os,const Date &other) {
    cout << other.day << "/" << other.month << "/" << other.year << endl;
    return os;
}

