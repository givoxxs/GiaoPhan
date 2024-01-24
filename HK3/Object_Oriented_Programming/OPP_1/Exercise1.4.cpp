#include <iostream>
using namespace std;

struct Date {
    int day,month,year;
};
// Ham nhap
istream &operator >> (istream &is, Date &d) {
    cout<<"Nhap ngay: ";
    is >> d.day;
    cout << "Nhap thang: ";
    is >> d.month;
    cout << "Nhap nam: ";
    is >> d.year;
    return is;
}
// Ham xuat
ostream &operator << (ostream &os,const Date &d) {
    cout << d.day << "/" << d.month << "/" << d.year << endl; 
    return os;
}
// 
Date operator++(Date &d) {
    d.day++;
    if (d.day > 28 && d.month == 2 && d.year % 4 == 0) {
        d.day = 1;
        d.month++;
    } else if (d.day > 30 && (d.month == 4 || d.month == 6 || d.month == 9 || d.month == 11)) {
        d.day = 1;
        d.month++;
    } else if (d.day > 31) {
        d.day = 1;
        d.month++;
    if (d.month == 12) {
        d.year++;
        d.month = 1;
    }}
  return d;
}
Date operator--(Date &d) {
  d.day--;
  if (d.day < 1) {
    if (d.month == 1) {
      d.year--;
      d.month = 12;
      d.day = 31;
    } else if (d.month == 2 && d.year % 4 == 0) {
      d.day = 28;
    } else if (d.month == 4 || d.month == 6 || d.month == 9 || d.month == 11) {
      d.day = 30;
    } else {
      d.day = 31;
    }
  }
  return d;
}
bool operator > (const Date &d1,const Date &d2) {
  return d1.year>d2.year || d1.year==d2.year && d1.month>d2.month || d1.year==d2.year && d1.month==d2.month && d1.day>d2.day;
}

bool operator < (const Date &d1,const Date &d2) {
  return d1.year<d2.year || d1.year==d2.year && d1.month<d2.month || d1.year==d2.year && d1.month==d2.month && d1.day<d2.day;
}

bool operator == (const Date &d1,const Date &d2) {
    return (d1.year==d2.year && d1.month==d2.month && d1.day==d2.day);
}
bool operator != (const Date &d1,const Date &d2) {
    return d1.year!=d2.year || d1.month!=d2.month || d1.day!=d2.day;
}
int main() {
    Date date1,date2;
    cout <<"nhap vao ngay thang nam: "<<endl;
    cin >> date1;
    cin >>date2;
    cout<<"ngay thu 1 la: "<<date1;
    cout<<"ngay thu 2 la: "<<date2;
    
    cout << "Ngay hom truoc cua ngay thu nhat la: " << --date1 << endl;
    ++date1;
   	cout << "Ngay hom sau cua ngay thu nhat la: " << ++date1 << endl;
   	cout << "Ngay hom truoc cua ngay thu hai la: " << --date2 << endl;
   	++date2;
   	cout << "Ngay hom sau cua ngay thu hai la: " << ++date2 << endl;
    
    if(date1>date2) {
        cout<<"ngay thu 1 lon hon ngay thu 2"<<endl;
    }
    if(date1<date2) {
        cout<<"ngay thu 1 nho hon ngay thu 2"<<endl;
    }
    if(date1==date2) {
        cout<<"ngay thu 1 trung ngay thu 2"<<endl;
    }
    if(date1!=date2) {
        cout<<"ngay thu 1 khac ngay thu 2"<<endl;
    }


    return 0;
}

