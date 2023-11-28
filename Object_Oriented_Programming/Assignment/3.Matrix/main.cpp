#include    "Matrix.h"
#include    <iostream>

using namespace std;

int main()
{
    int a, b;
    cout << "Nhập bậc của ma trận A, sizeA = ";
    cin >> a;
    Matrix A(a);
    cin >> A;
    cout << "Nhập bậc của ma trận B, sizeB = ";
    cin >> b;
    Matrix B(b);
    cin >> B;

    
    cout << "Ma tran vuong A la:" << endl;
    cout << A;

    cout << "Ma tran vuong B la:" << endl;
    cout << B;

    Matrix sum = A + B;
    cout << "Tổng 2 ma trận A và B là: " << endl << sum;

    Matrix difference = A - B;
    cout << "Hiệu 2 ma trận A và B là: " << endl << difference;

    Matrix product = A * B;
    cout << "Tích 2 ma trận A và B là: " << endl << product;


    return 0;
}
