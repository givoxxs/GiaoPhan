#include <iostream>
using namespace std;
// MAX HEAPIFY
void max_heapify(int *a, int i, int n) {
    int largest = 0;
    int l = 2*i;
    int r = 2*i + 1;
    if (l <= n && a[l] > a[i])  largest = l;    else    largest = i;
    if (r <= n && a[r] > a[i])  largest = r;    else    largest = r;
    if (largest != i) {
        int t = a[i];
        a[i] = a[largest];
        a[largest] = t;
        max_heapify(a, largest, n);
    }
}
// BUILD MAX HEAP (A)
void build_maxheap(int *a, int n) {
    int i;
    for (i = n/2; i >= 1; i--)  max_heapify(a, i, n);
}
// HEAPSORT
void heapsort(int *a, int n) {
    int i, temp;
    for (i = n; i >= 2; i--) {
        temp = a[i];
        a[i] = a[1];
        a[1] = temp;
        max_heapify(a,1,i-1);
    }
}
// MAIN
int main() {
    int n, i, x;
    cout << "enter no of elements of array\n";
    cin >> n;
    int a[20];
    for (i = 1; i <= n; i++) {
        cout << "enter element" << i << endl;
        cin >> a[i];
    }
    //build_maxheap(a,n);
    //heapsort(a,n);
    cout << "sorted output\n";
    for (i = 1; i <= n; i++) {
        cout << a[i] << endl;
    }
    getchar();
    return 0;
}

