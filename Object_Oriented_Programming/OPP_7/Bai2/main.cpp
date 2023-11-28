#include "List.h"
#include <iostream>
using namespace std;

int main() {
    List<int> myList;

    myList.Insert(1);
    myList.Insert(2);
    myList.Insert(3);

    cout << "Initial List: ";
    myList.displayAll();

    myList.FirstOut();
    cout << "After Remove(Firt out): ";
    myList.displayAll();

    cout << "Pop last: " << myList.LastOut() << endl;
    cout << "After Remove(Last out):";
    myList.displayAll();

    myList.Insert(4);
    cout << "After Insert(4)(FIFO): ";
    myList.displayAll();

    return 0;
}