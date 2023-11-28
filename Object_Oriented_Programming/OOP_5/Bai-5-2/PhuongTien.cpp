#include "PhuongTien.h"

PhuongTien::PhuongTien() : m_fSoXang(0)  {}
void PhuongTien::doXang(float soXang) {
    m_fSoXang += soXang;
}
bool PhuongTien::hetXang() {
    return m_fSoXang <= 0;
}
float PhuongTien::layLuongXang() {
    return m_fSoXang;
}