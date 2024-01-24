#ifndef List_h
#define List_h

#include <iostream>
using namespace std;

template <typename T>
class Node {
public:
    T data;
    Node* next;
    Node(T value) : data(value), next(nullptr) {}
};

template <typename T>
class List {
    private:
        Node<T>* head;
    public:
        List();
        ~List();
        void Insert(T value);
        void FirstOut();
        T LastOut();
        void displayAll();
};

#endif
