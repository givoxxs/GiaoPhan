#include "Polynomial.h"
#include <iostream>

using namespace std;

int main()
{
    /* code */
    int degree1, degree2;
   
    cout << "Bậc của đa thức F1(x) là: ";
    cin >> degree1;
    Polynomial poly1(degree1);
    cin >> poly1;
    cout << "Đa thức F1(x): " << poly1 << endl;

    cout << "Bậc của đa thức F2(x) là : ";
    cin >> degree2;
    Polynomial poly2(degree2);
    cin >> poly2;
    cout << "Đa thức F2(x): " << poly2 << endl;

    Polynomial sum = poly1 + poly2;
    Polynomial diff = poly1 - poly2;

    cout << "Sum: F1(x) + F2(x) = " << sum << endl;
    cout << "Difference: F1(x) - F2(x) = " << diff << endl;

    double x;
    cout << "Nhập giá trị x: ";
    cin >> x;

    cout << "F1(" << x << ") = " << poly1(x) << endl;
    cout << "F2(" << x << ") = " << poly2(x) << endl;

    return 0;
}

