// Set Class XeTai.h
#ifndef XETAI_H
#define XETAI_H
#include "PhuongTien.h"

class XeTai : public PhuongTien {
    private:
        /* data */
        float m_fTieuThuXangKm;
    public:
        XeTai(float tieuThuXangKm);

        void chay(float khoangCach);
        void chatHang(float trongLuong);
        void boHang(float trongLuong);
    };
#endif
