#include "XeTai.h"
#include <iostream>

using namespace std;

XeTai::XeTai(float tieuThuXangKm) : m_fTieuThuXangKm(tieuThuXangKm) {}
void XeTai::chay(float khoangCach) {
    float xangCan = khoangCach / 100 * m_fTieuThuXangKm;
    if (xangCan <= m_fSoXang)
    {
        m_fSoXang -= xangCan;
        cout << "Xe Tai da chay " << khoangCach << " km." << endl;
    } else {
        cout << "Xe Tai HET xang!" << endl;
    }
}
void XeTai::chatHang(float trongLuong) {
    float themXang = trongLuong/1000 * 1;
    if (themXang <= m_fSoXang) {
        m_fSoXang -= themXang;
        cout << "Xe Tai da them " << trongLuong << " kg hang." << endl;
    } else {
        cout << "Xe Tai khong du xang de cho THEM hang!" << endl;
    }
}
void XeTai::boHang(float trongLuong) {
    float themXang = trongLuong / 1000 * 1;
    if (themXang <= m_fSoXang)
    {
        m_fSoXang -= themXang;
        std::cout << "Xe Tai da giam " << trongLuong << " kg hang." << std::endl;
    }
    else
    {
        std::cout << "Xe Tai khong du xang de cho GIAM hang!" << std::endl;
    }
}