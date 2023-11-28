#include <iostream>
#include "Point.h"

using namespace std;

int main()
{
    /* code */
    Point p1;
    
    p1.SetPt(2, 3);
    p1.OffsetPt(1, 1);
    p1.Show();

    return 0;
}
