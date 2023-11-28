#include"Sach.h"
Sach::Sach() {}
Sach::Sach(string loaiSach) : loaiSach(loaiSach) {}
Sach::~Sach() {}
void Sach::Show()
{
    cout<<"\nMa sach: "<<this->ID<<endl;
    cout<<"Nam xuat ban: "<<this->PublisherYear<<endl;
    cout<<"Khu vuc xuat ban: ";
    if(this->Area==1)  cout<<"quoc te";
        else    cout<<"trong nuoc";
    cout<<endl;
    cout<<"Loai sach: "<<this->loaiSach<<endl;
}
void Sach::Nhap()
{
    cout<<"Nhap ma sach: ";
    cin.ignore();
    getline(cin,this->ID);
    this->PublisherYear=1800;
    while(this->PublisherYear<1900)
    {
        while(cout<<endl<<"Nhap nam xuat ban, tu 1900 den nay: " && !(cin>> this->PublisherYear))
        {
            cin.clear();
            cin.ignore();
            cout<<"Dau vao sai moi nhap lai!";
        }
    }
    while (this->Area<0 || this->Area>1)
    {
        while(cout<<endl<<"Khu vuc xuat ban: (0): trong nuoc  (1): quoc te " && !(cin>> this->Area))
        {
            cin.clear();
            cin.ignore();
            cout<<"Dau vao sai moi nhap lai!";
        }
    }
    
    cout<<"Nhap loai sach: ";
    cin.ignore();
    getline(cin,this->loaiSach);
}
void Sach::setLoaiSach(string _LS)
{
    this->loaiSach=_LS;
}