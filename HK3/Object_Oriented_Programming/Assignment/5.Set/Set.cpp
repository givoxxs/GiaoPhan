#include "Set.h"
#include <iostream>
#include <algorithm>
using namespace std;


Set::Set() : data(nullptr), size(0) {
}
Set::Set(const Set &other) : size(other.size) {
    for (int i=0; i<size;i++) {
        data[i] = other.data[i];
    }
}
Set::~Set() {
    delete [] data;
}
// Lấy giá trị tại x
int Set::operator [] (int x) {
    if (x < 0 || x > size) {
        cout << "Nằm ngoài phạm vi!!!" << endl;
    }
    return data[x];
}
// Kiểm tra có trong Tập hợp k
bool Set::operator() (int x) const {
    for (int i = 0; i < size; ++i) {
        if (data[i] == x) {
            return true;
        }
    }
    return false;
}

// Hợp
Set Set::operator + (const Set &other) {
    Set result;
    int i = 0, j = 0;
    while (i < size && j < other.size) {
        if (data[i] < other.data[j]) {
            result += data[i];
            i++;
        } else if (other.data[j] < data[i]) {
            result += other.data[j];
            j++;
        } else {
            result += data[i];
            ++i;
            ++j;
        }
    }

    while (i < size) {
        result += data[i];
        i++;
    }

    while (j < other.size) {
        result += other.data[j];
        ++j;
    }

    return result;
}
// Trừ
Set Set::operator - (const Set &other) {
    Set result;
    int i = 0, j = 0;
    while (i < size && j < other.size) {
        if (data[i] < other.data[j]) {     
            result += data[i];      
            ++i;
        } else if (other.data[j] < data[i]) {
            ++j;
        } else {
            ++i;
            ++j;
        }
    }

    while (i < size) {
        result += data[i];
        ++i;
    }

    return result;
}
// Giao
Set Set::operator * (const Set &other) {
    Set result;
    int i = 0, j = 0;
    while (i < size && j < other.size) {
        if (data[i] < other.data[j]) {
            ++i;
        } else if (other.data[j] < data[i]) {
            ++j;
        } else {
            result += data[i];
            ++i;
            ++j;
        }
    }

    return result;
}

Set Set::operator = (const Set &other) {
    if (this != &other) {
        delete[] data;
        size = other.size;
        data = new int [size];
        for (int i=0; i<size; i++) {
            data[i] = other.data[i];
        }
    }
    return *this;
}

// Thêm 1 phần tử
Set Set::operator += (int x) {
    //   if (!(*this)(x)) {
    //     int* newdata = new int[size + 1];
    //     int i = 0;
    //     while (i < size && data[i] < x) {
    //         newdata[i] = data[i];
    //         ++i;
    //     }
    //     newdata[i] = x;
    //     while (i < size) {
    //         newdata[i + 1] = data[i];
    //         ++i;
    //     }
    //     delete[] data;
    //     data = newdata;
    //     ++size;
    // }
    bool check = false; 
    for (int i=0; i < size; i++) {
        if (x==data[i]) {
            check = true;
            break;
        }
    }
    if (!check) {
        int* temp = new int [size];
        for (int i=0; i<size; i++) {
            temp[i] = data[i];
        }
        temp[size] = x;
        delete [] data;
        data = temp;
        size++;
    }
    Arrange();
    return *this;
}
// Bớt 1 phần tử
Set Set::operator -= (int x) {
    if ((*this)(x)) {
        int* newdata = new int[size - 1];
        int i = 0, j = 0;
        while (i < size) {
            if (data[i] != x) {
                newdata[j] = data[i];
                ++j;
            }
            ++i;
        }
        delete[] data;
        data = newdata;
        --size;
    }
    return *this;
}



// Sắp xếp lại và loại bỏ các phần tử trùng lặp
void Set::Arrange() {
    if (size<=1) {
        return;
    }

    sort(data, data + size);
    int newSize = 1;
    for (int i = 1; i < size; i++) {
        if (data[i] != data[i - 1]) {
            data[newSize] = data[i];
            ++newSize;
        }
    }
    size = newSize;
    return;
}
// Hàm nhập
istream &operator >> (istream& in,Set &other) {
    int x,num;
    // char comma;
    // in >> comma; // Đọc dấu { đầu tiên
    // while (true) {
    //     in >> x;
    //     other += x; // Thêm phần tử vào tập hợpƠ{}
    //     in >> comma; // Đọc dấu phẩy hoặc }
    //     if (comma == '}') {
    //         break; // Kết thúc khi đọc dấu }
    //     }
    // }c
    cout << "Tập hợp có số phần tử là: ";
    cin >> num;
    while (num>0) {
        cin >> x;
        other += x;
        num--;
    }
    return in;
}
// Hàm xuất
ostream &operator << (ostream& out, const Set &other) {
    out << "{";
    for (int i = 0; i < other.size; ++i) {
        out << other.data[i];
        if (i < other.size - 1) {
            out << ", ";
        }
    }
    out << "}";
    return out;
}
int Set::getSize() const {
    return size;
}

