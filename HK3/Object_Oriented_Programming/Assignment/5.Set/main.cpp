#include "Set.h"
#include <iostream>
using namespace std;

int main()
{
    /* code */
    Set mySet;
    mySet += 1;
    mySet += 2;
    mySet += 3;

    // cout << "Nhập tập hợp: " << endl;
    // cin >> mySet;
    cout << "Tập hợp đã nhập: " << mySet << endl;
    mySet.Arrange();
    // cout << "Tập hợp đã nhập sau khi sắp xếp và loại bỏ trùng lặp: " << mySet << endl;
    return 0;
}
