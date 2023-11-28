#include <iostream>
#include "Point.h"

using namespace std;

Point::Point() {
    xVal = 0;
    yVal = 0;
};

Point::~Point() {};

Point::SetPt(int x, int y) {
    xVal = x;
    yVal = y;
};

Point::OffsetPt(int x, int y) {
    xVal += x;
    yVal += y;
};

Point::Show() {
    cout << "x = " << xVal << endl;
    cout << "y = " << yVal << endl;
};
