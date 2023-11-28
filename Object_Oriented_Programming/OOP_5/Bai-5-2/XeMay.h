// Set Class XeMay.h
#ifndef XEMAY_H
#define XEMAY_H
#include "PhuongTien.h"

class XeMay : public PhuongTien {
    private:
        /* data */
        float m_fTieuThuXangKm;
    public:
        XeMay(float tieuThuXangKm);

        void chay(float khoangCach);
        void chatHang(float trongLuong);
        void boHang(float trongLuong);
    };
#endif