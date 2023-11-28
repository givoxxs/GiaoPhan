#include "Date.h"
#include <iostream>

using namespace std;

int main()
{
    Date day;

    cin >> day;

    cout << "Day la ngay ban vua nhap: " << day;

    cout << "Ngay hom truoc la ngay: " << --day;

    cout << "Ngay hom sau la ngay: " << ++day;

    return 0;
}

