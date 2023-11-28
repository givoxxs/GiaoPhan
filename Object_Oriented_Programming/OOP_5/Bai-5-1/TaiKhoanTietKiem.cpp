#include "Taikhoantietkiem.h"
#include <iostream>
using namespace std;

TaiKhoanTietKiem::TaiKhoanTietKiem(float laiSuat, int kyHanGui) : m_fLaiSuat(laiSuat), m_iKyHanGui(kyHanGui), m_iSoThangDaGui(0) { }
void TaiKhoanTietKiem::napTien(float fSoTien) {
    m_iSoThangDaGui = 0;
    TaiKhoan::napTien(fSoTien);
}
void TaiKhoanTietKiem::rutTien(float fSoTien) {
    if (m_iSoThangDaGui >= m_iKyHanGui) {
        TaiKhoan::rutTien(fSoTien);
    } else {
        cout << "Khong the rut tien truoc khi den ky han." << endl;
    }
}
void TaiKhoanTietKiem::tangSoThangDaGui(int soThang) {
    m_iSoThangDaGui += soThang;
}
float TaiKhoanTietKiem::tinhSoDu() {
    float laiSuatThang = m_fLaiSuat / 12;
    float soDu = TaiKhoan::baoSoDu();
    for (int i = 1;i <= m_iSoThangDaGui; i++) {
        soDu += soDu * laiSuatThang;
    }
    return soDu;
}
