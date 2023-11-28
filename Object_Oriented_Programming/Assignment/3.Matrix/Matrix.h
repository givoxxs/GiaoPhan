//Matrix.h
#ifndef MATRIX_H
#define MATRIX_H
#include <iostream>
using namespace std;

class Matrix {
    private:
        /* data */
        int size;
        int** data;
    public:
        Matrix(int n);
        Matrix(const Matrix &other);
        ~Matrix();

        Matrix &operator = (const Matrix &other);
        Matrix operator + (const Matrix &other);
        Matrix operator - (const Matrix &other);
        Matrix operator * (const Matrix &other); 
        int &operator() (int row, int col);

        friend istream &operator>>(istream& in, Matrix& m);
        friend ostream &operator<<(ostream& out, const Matrix& m);
};
#endif
