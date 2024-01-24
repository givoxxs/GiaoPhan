#include "XeMay.h"
#include <iostream>

using namespace std;

XeMay::XeMay(float tieuThuXangKm) : m_fTieuThuXangKm(tieuThuXangKm) {}
void XeMay::chay(float khoangCach) {
    float xangCan = khoangCach / 100 * m_fTieuThuXangKm;
    if (xangCan <= m_fSoXang)
    {
        m_fSoXang -= xangCan;
        cout << "Xe May da chay " << khoangCach << " km." << endl;
    } else {
        cout << "Xe May HET xang!" << endl;
    }
}
void XeMay::chatHang(float trongLuong) {
    float themXang = trongLuong/10 * 0.1;
    if (themXang <= m_fSoXang) {
        m_fSoXang -= themXang;
        cout << "Xe May da them " << trongLuong << " kg hang." << endl;
    } else {
        cout << "Xe May khong du xang de cho THEM hang!" << endl;
    }
}
void XeMay::boHang(float trongLuong) {
    float themXang = trongLuong / 10 * 0.1;
    if (themXang <= m_fSoXang)
    {
        m_fSoXang -= themXang;
        std::cout << "Xe May da giam " << trongLuong << " kg hang." << std::endl;
    }
    else
    {
        std::cout << "Xe May khong du xang de cho GIAM hang!" << std::endl;
    }
}