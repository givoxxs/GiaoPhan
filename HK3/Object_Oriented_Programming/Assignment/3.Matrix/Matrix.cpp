#include    "Matrix.h"
#include    <iostream>

using namespace std;
// Hàm dựng
Matrix::Matrix(int n) : size(n) {
    data = new int*[size];
    for (int i=0; i<size; i++) {
        data[i] = new int[size];
        for (int j=0; j<size; j++) {
            data[i][j] = 0;
        }
    }
}
// Hàm sao chép
Matrix::Matrix(const Matrix &other) {
    size = other.size;
    data = new int*[size];
    for (int i=0; i<size; i++) {
        data[i] = new int[size];
        for (int j=0; j<size; j++) {
            data[i][j] = other.data[i][j];
        }
    }
}
// Hàm hủy
Matrix::~Matrix() {
    for (int i=0; i<size; i++) {
        delete [] data[i];
    }
    delete[] data;
}
// Hàm lấy giá trị theo chỉ số
int &Matrix::operator() (int row, int col) {
    if (row<0 || row>= size || col<0 || col>=size) {
        cout << "Chi so khong hop le!!!" << endl;
        return data[0][0];
    } else return data[row][col];
}
// Hàm cộng 2 ma trận
Matrix Matrix::operator + (const Matrix &other) {
    if (size != other.size) {
        cout << "Khong the cong hai ma tran!!!" << endl;
        return *this;
    } else {
        Matrix result(size);
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                result.data[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return result;
    }   
}
// Hàm trừ 2 ma trận
Matrix Matrix::operator - (const Matrix &other) {
    if (size != other.size) {
        cout << "Khong the tru hai ma tran!!!" << endl;
        return *this;
    } else {
        Matrix result(size);
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                result.data[i][j] = data[i][j] - other.data[i][j];
            }
        }
    return result;
    }
}
// Hàm nhân 2 ma trận 
Matrix Matrix::operator * (const Matrix &other) {
    if (size != other.size) {
        cout << "Khong the tru hai ma tran!!!" << endl;
        return *this;
    } else {
        Matrix result(size);
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                result.data[i][j] = data[i][j] * other.data[i][j];
            }
        }
        return result;
    }
}
// Hàm gán ma trận
Matrix &Matrix::operator = (const Matrix &other) {
    if (size == other.size) {
        return *this;
    } else {
        for (int i=0; i<size; i++) {
            delete [] data[i];
        }
        delete data;

        size = other.size;
        data = new int *[size];
        for (int i=0; i<size; i++) {
            data[i] = new int [size];
            for (int j=0; j<size; j++)  {
                data[i][j] = other.data[i][j];
            }
        }
    }
    return *this;
}
// Hàm nhập
istream &operator>>(istream& in, Matrix& other) {
    cout << "Nhap cac thanh phan cua ma tran  vuong " << other.size << " bac!" << endl;
    for (int i=0; i<other.size; i++) {
        for (int j=0; j<other.size; j++) {
            cin >> other.data[i][j]; 
            cout << " ";
        }
        cout << endl;
    }
    return in;
}
// Hàm xuất 
ostream &operator<<(ostream& out, const Matrix& other) {
    for (int i=0; i<other.size; i++) {
        cout << "(";
        for (int j=0; j<other.size; j++) {
            cout << other.data[i][j] << " ";
        }
        cout << ")" << endl;
    }
    return out;
}
