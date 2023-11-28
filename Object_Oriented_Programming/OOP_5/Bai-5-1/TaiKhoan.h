// Set class TaiKhoan.h
#ifndef CLASS_H
#define CLASS_H
class TaiKhoan {
    private:
        /* data */
        float m_fSoDu = 0;
    public:
        float baoSoDu() { return m_fSoDu; }
        void napTien(float fSoTien) { m_fSoDu += fSoTien; }
        void rutTien(float fSoTien) {
            if (fSoTien <= m_fSoDu)
            m_fSoDu -= fSoTien;
        }
};
#endif 