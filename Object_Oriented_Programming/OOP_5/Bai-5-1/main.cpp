#include "TaiKhoanTietKiem.h"
#include <iostream>

using namespace std;

int main()
{
    TaiKhoanTietKiem taiKhoanTietKiem(0.05, 12);

    taiKhoanTietKiem.napTien(1000);
    taiKhoanTietKiem.tangSoThangDaGui(6);
    taiKhoanTietKiem.tangSoThangDaGui(6);
    taiKhoanTietKiem.rutTien(200);

    cout << "So du hien tai: " << taiKhoanTietKiem.tinhSoDu() << endl;

    return 0;
}

