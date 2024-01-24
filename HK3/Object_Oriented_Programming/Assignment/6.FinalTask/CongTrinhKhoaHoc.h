#ifndef CongTrinhKhoaHoc_h
#define CongTrinhKhoaHoc_h
#include <iostream>
using namespace std;
class CongTrinhKhoaHoc 
{
    public:
        /* data */
        string ID;
        int PublisherYear; //1900 -> now
        bool Area;
    public:
        CongTrinhKhoaHoc();
        CongTrinhKhoaHoc(string , int , bool );
        virtual ~CongTrinhKhoaHoc();

        string getID() const;
        void setID(const string &);

        int getPublisherYear() const;
        void setPublisherYear(int );

        bool getArea() const;
        void setArea(bool );

        // Hàm đa năng hóa toán tử nhập xuất
        virtual void Show();
        virtual void Nhap();
};

#endif