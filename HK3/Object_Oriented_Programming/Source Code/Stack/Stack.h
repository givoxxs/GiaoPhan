#ifndef STACK_H
#define STACK_H
class Stack {
    int *data;
    int top;
    int max;
    public:     
        Stack(int size = 10);
        Stack(const Stack &s);
        ~Stack();
        bool Push(int x);
        bool Pop (int &x);
        bool isFull();
        bool isEmpty(); 
        friend void Display(const Stack &s);
};

#endif