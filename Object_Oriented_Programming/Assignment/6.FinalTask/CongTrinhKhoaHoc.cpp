#include "CongTrinhKhoaHoc.h" 
#include <iostream>
using namespace std;
// Constructor function
CongTrinhKhoaHoc::CongTrinhKhoaHoc() {
  ID = "";
  PublisherYear = 0;
  Area = false;
}
// Constructor function
CongTrinhKhoaHoc::CongTrinhKhoaHoc(string ID, int PublisherYear, bool Area) : ID(ID), PublisherYear(PublisherYear), Area(Area) {}
// Destructor function
CongTrinhKhoaHoc::~CongTrinhKhoaHoc() {}

string CongTrinhKhoaHoc::getID() const {
  return ID;
}

void CongTrinhKhoaHoc::setID(const string &ID) {
  this->ID = ID;
}

int CongTrinhKhoaHoc::getPublisherYear() const {
  return PublisherYear;
}

void CongTrinhKhoaHoc::setPublisherYear(int PublisherYear) {
  this->PublisherYear = PublisherYear;
}

bool CongTrinhKhoaHoc::getArea() const {
  return Area;
}

void CongTrinhKhoaHoc::setArea(bool Area) {
  this->Area = Area;
}

void CongTrinhKhoaHoc::Show()
{
    cout<<"ma xong trinh CTKH: "<<this->ID<<endl;
    cout<<"nam xuat ban CTKH: "<<this->PublisherYear<<endl;
    cout<<"Khu vuc xuat ban CTKH: ";
    if(this->Area==1)   cout<<"quoc te";
        else cout<<"trong nuoc";
    cout<<endl;
}

void CongTrinhKhoaHoc::Nhap()
{
    //cout<<"nhap loai cong trinh: (1) : bai bao | (2) : sach";
    cout<<"Nhap ma cong trinh CTKH: ";
    cin.ignore();
    getline(cin, this->ID);
    this->PublisherYear=1800;
    while(this->PublisherYear<1900)
    {
        cout<<"Nhap nam xuat ban, tu 1900 den nay CTKH: ";
        cin>>this->PublisherYear;
    }
    while (this->Area<0 || this->Area>1)
    {
        cout<<endl<<"Nhap khu vuc xuat ban CTKH:(0): trong nuoc  (1): quoc te ";
        cin>>this->Area;
    }
}