#include "Stack.h"
#include <iostream>

using namespace std;
Stack::Stack(const Stack &s){
    this->max = s.max;
    this->data = new int [max];
    this->top = s.top;
    for(int i=0; i<=top; i++ )
        data[i] = s.data[i];
}
Stack::Stack(int size):max(size), top(-1), data(new int [size]){
    //max = size;
    // data = new int [size];
    // top = -1;
}
Stack::~Stack(){
    delete [] data;
}
bool Stack::Push(int x){
    if (!isFull()) {
        data [++top] = x;
        return true;
    }
    else return false;
}
bool Stack::Pop (int &x){
    if (!isEmpty()) {
        x = data[top--];
        return true;
    }
    else return false;
}
bool Stack::isFull(){
    return top==max-1;
}
bool Stack::isEmpty(){
    return top == -1;
}
void Display(const Stack &s){
    int i;
    for(int i=0; i<s.top; i++)
        cout<<s.data[i];
    }