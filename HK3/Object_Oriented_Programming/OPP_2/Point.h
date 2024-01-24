//Point.h
#ifndef POINT_H
#define POINT_H

class Point {
    int xVal, yVal;
    public: 
        Point();
        ~Point();
        void SetPt(int , int);
        void OffsetPt(int, int);
        void Show();
};

#endif