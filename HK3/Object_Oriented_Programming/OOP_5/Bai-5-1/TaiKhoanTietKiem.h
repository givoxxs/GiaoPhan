// Set class TaiKhoanTietKiem.h
#ifndef TAIKHOANTIETKIEM_H
#define TAIKHOANTIETKIEM_H
#include "TaiKhoan.h"

class TaiKhoanTietKiem : public TaiKhoan {
    private:
    /* data */
        float m_fLaiSuat;
        int m_iKyHanGui;
        int m_iSoThangDaGui;

    public:
        TaiKhoanTietKiem(float laiSuat, int kyHanGui);
        void napTien(float fSoTien);
        void rutTien(float fSoTien);
        void tangSoThangDaGui(int soThang);
        float tinhSoDu();
};
#endif