#include "List.h"
#include <iostream>

using namespace std;

template <typename T>
List<T>::List() : head(nullptr) {}

template <typename T>
List<T>::~List() {
    while (head) {
        Node<T>* temp = head;
        head = head->next;
        delete temp;
    }
}

template <typename T>
void List<T>::Insert(T value) {
    Node<T>* newNode = new Node<T>(value);
    newNode->next = head;
    head = newNode;
}

template <typename T>
void List<T>::FirstOut() {
    if (!head) {
        cout << "The list is empty." << endl;
        return;
    }
    Node<T>* temp = head;
    head = head->next;
    delete temp;
}
template <typename T>
T List<T>::LastOut() {
    if (!head) {
        cout << "The list is empty." << endl;
        return -999;
    }

    if (!(head->next)) {
        delete head;
        head = nullptr;
        return head->data;
    }

    Node<T>* previous = nullptr;
    Node<T>* current = head;
    while (current->next) {
        previous = current;
        current = current->next;
    }
    T output = current->data;
    delete current;
    previous->next = nullptr;
    return output;
}


template <typename T>
void List<T>::displayAll() {
    Node<T>* current = head;
    while (current) {
        cout << current->data << " ";
        current = current->next;
    }
    cout << endl;
}


template class List<int>;
template class List<float>;