// Polynomial.h
#ifndef POLYNOMIAL_H
#define POLYNOMIAL_H
#include <iostream>
using namespace std;

class Polynomial {
    private:
        /* data */
        int degree;
        double *factor;
    public:
        Polynomial(int degree = 0);
        Polynomial(const Polynomial& other);
        ~Polynomial();

        Polynomial operator+(const Polynomial& other);
        Polynomial operator-(const Polynomial& other);
        Polynomial operator=(const Polynomial& other);

        double &operator[](int x);
        double operator()(double x) const;

        friend istream &operator >> (istream &in, Polynomial &other);
        friend ostream &operator << (ostream &out, Polynomial &other);
};
#endif  
