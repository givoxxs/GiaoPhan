// Set Class PhuongTien.h
#ifndef PHUONGTIEN_H
#define PHUONGTIEN_H
class PhuongTien {
    protected:
        /* data */
        float m_fSoXang;
    public:
        PhuongTien(/* args */);

        void doXang(float soXang);
        bool hetXang();
        float layLuongXang();

        virtual void chay(float khoangcach) = 0;
        virtual void chatHang(float khoiluong) = 0;
        virtual void boHang(float khoiluong) = 0;
    };
#endif