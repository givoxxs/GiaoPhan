#include <iostream>
#include "PhuongTien.h"
#include "XeMay.h"
#include "XeTai.h"

using namespace std;

int main()
{
    XeMay xeMay(2);
    XeTai xeTai(20);

    xeMay.doXang(5);
    xeTai.doXang(50);

    xeMay.chay(50);
    xeTai.chay(50);

    xeMay.chatHang(20);
    xeTai.chatHang(2000);

    xeMay.boHang(10);
    xeTai.boHang(1000);

    cout << "Xe May con " << xeMay.layLuongXang() << " lit xang." << endl;
    cout << "Xe Tai con " << xeTai.layLuongXang() << " lit xang." << endl;

    return 0;
}
