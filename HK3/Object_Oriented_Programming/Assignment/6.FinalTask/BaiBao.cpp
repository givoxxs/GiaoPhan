#include"BaiBao.h"
#include <iostream>
using namespace std;

BaiBao::BaiBao() {}
BaiBao::BaiBao(string tenCongTrinh, int soTacGia) : tenCongTrinh(tenCongTrinh), soTacGia(soTacGia) {}
BaiBao::~BaiBao()
{}
void BaiBao::Show()
{
    cout<<"Ma bai bao: "<<this->ID<<endl;
    cout<<"Ten bai bao: "<<this->tenCongTrinh<<endl;
    cout<<"So luong tac gia: "<<this->soTacGia<<endl;
    cout<<"Nam xuat ban: "<<this->PublisherYear<<endl;
    cout<<"Khu vuc xuat ban: ";
    if(this->Area==1)  cout<<"quoc te";
        else    cout<<"trong nuoc";
    cout<<endl;
}

void BaiBao::Nhap()
{
    cout<<"\nNhap ma bai bao: ";
    cin.ignore();
    getline(cin,this->ID);
    
    cout<<endl<<"Nhap ten bai bao: ";
	getline(cin, this->tenCongTrinh);
    this->PublisherYear=1800;
    while(this->PublisherYear<1900)
    {
        while(cout<<endl<<"Nhap nam xuat ban, tu 1900 den nay: " && !(cin>>this->PublisherYear))
        {
            cin.clear();
            cin.ignore();
            cout<<"Dau vao sai nhap lai!";
        }
    }
    

    while(cout<<endl<<"Nhap khu vuc xuat ban:(0): trong nuoc  (1): quoc te " && !(cin>> this->Area || this->Area<0 || this->Area>1))
    {
        cin.clear();
        cin.ignore();
        cout<<"Dau vao sai nhap lai!";
    }
    while(cout<<endl<<"Nhap so tac gia: " && !(cin>> this->soTacGia))
    {
        cin.clear();
        cin.ignore();
        cout<<"Dau vao sai moi nhap lai!";
    }
}
void BaiBao::setTenCongTrinh(string _tenCT)
{
    this->tenCongTrinh= _tenCT;
}
void BaiBao::setSoTacGia(int _soTG)
{
    this->soTacGia= _soTG;
}