#include <iostream>
#include <algorithm>
#include <functional>
#include <cmath>
using namespace std;

typedef void (*sort_func)(int[], int, bool);

typedef void (*search_func)(int[], int, bool);

// Nhap mang
void nhap_mang(int a[], int n) {
    cout << "Nhap " << n << " phan tu cua mang:\n";
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
}
// Xuat mang
void xuat_mang(int a[], int n) {
    cout << "Mang co " << n << " phan tu la:\n";
    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }
    cout << "\n";
}

int lay_kich_thuoc_mang(int a[]) {
    return sizeof(a) / sizeof(a[0]);
}
// Lay phan tu
int lay_phan_tu(int a[], int n, int i) {
    if (i >= 0 && i < n) {
        return a[i];
    }
    else {
        cout << "Vi tri khong hop le\n";
        return -1;
    }
}

// Ham sap xep chon truc tiep
void selection_sort(int a[], int n, bool tang) {
    for (int i = 0; i < n - 1; i++) {
        int min_or_max = i;
        for (int j = i + 1; j < n; j++) {
            if (tang) { // sapxep tang
                if (a[j] < a[min_or_max]) {
                    min_or_max = j;
                }
            }
            else { // sapxep giam
                if (a[j] > a[min_or_max]) {
                    min_or_max = j;
                }
            }
        }
        swap(a[i], a[min_or_max]);
    }
}

// Hàm sap xep chen truc tiep
void insertion_sort(int a[], int n, bool tang) {
    for (int i = 1; i < n; i++) {
        int key = a[i];
        int j = i - 1;
        if (tang) { // sapxep tang
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
        }
        else { // sapxep giam
            while (j >= 0 && a[j] < key) {
                a[j + 1] = a[j];
                j--;
            }
        }
        a[j + 1] = key;
    }
}

// ham BubbleSort
void bubble_sort(int a[], int n, bool tang) {
    for (int i = 0; i < n - 1; i++) {
        bool swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (tang) { // tang
                if (a[j] > a[j + 1]) {
                    swap(a[j], a[j + 1]);
                    swapped = true;
                }
            }
            else { // giam
                if (a[j] < a[j + 1]) {
                    swap(a[j], a[j + 1]);
                    swapped = true;
                }
            }
        }
        if (!swapped) break;
    }
}

// Ham hoan vi 
void swap(int &a, int &b) {
    int temp = a;
    a = b;
    b = temp;
}

// phan doan QuickSort
int partition(int a[], int low, int high, bool tang) {
    int pivot = a[high];
    int i = low - 1;
    for (int j = low; j <= high - 1; j++) {
        if (tang) { // tang
            if (a[j] <= pivot) {
                i++;
                swap(a[i], a[j]);
            }
        }
        else { // giam
            if (a[j] >= pivot) {
                i++;
                swap(a[i], a[j]);
            }
        }
    }
    swap(a[i + 1], a[high]);
    return i + 1;
}

// Ham QuickSort
void quick_sort(int a[], int low, int high, bool tang) {
    if (low < high) {
        int pi = partition(a, low, high, tang);
        quick_sort(a, low, pi - 1, tang);
        quick_sort(a, pi + 1, high, tang);
    }
}

//Ver 1 HeapSort
void heapify(int a[], int n, int i, bool tang) {
    int largest_or_smallest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (tang) { // tang
        if (left < n && a[left] > a[largest_or_smallest]) {
            largest_or_smallest = left;
        }
        if (right < n && a[right] > a[largest_or_smallest]) {
            largest_or_smallest = right;
        }
    }
    else { // giam
        if (left < n && a[left] < a[largest_or_smallest]) {
            largest_or_smallest = left;
        }
        if (right < n && a[right] < a[largest_or_smallest]) {
            largest_or_smallest = right;
        }
    }
    if (largest_or_smallest != i) {
        swap(a[i], a[largest_or_smallest]);
        heapify(a, n, largest_or_smallest, tang);
    }
}

// ham HeapSort
void heap_sort(int a[], int n, bool tang) {
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(a, n, i, tang);
    }
    for (int i = n - 1; i > 0; i--) {
        swap(a[0], a[i]);
        heapify(a, i, 0, tang);
    }
}

// ham ShellSort
void shell_sort(int a[], int n, bool tang) {
    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            int temp = a[i];
            int j;
            if (tang) { // tang
                for (j = i; j >= gap && a[j - gap] > temp; j -= gap) {
                    a[j] = a[j - gap];
                }
            }
            else { // giam
                for (j = i; j >= gap && a[j - gap] < temp; j -= gap) {
                    a[j] = a[j - gap];
                }
            }
            a[j] = temp;
        }
    }
}

// Lay so chu so
int lay_so_chu_so(int n) {
    int count = 0;
    while (n > 0) {
        count++;
        n /= 10;
    }
    return count;
}

// Hàm lay chu so tai vi tri exp 
int lay_chu_so(int n, int exp) {
    return (n / exp) % 10;
}

// Ham sap xep RadixSort theo chi so vi tri exp
void radix_sort_by_exp(int a[], int n, int exp, bool tang) {
    int output[n];
    int count[10] = {0};
    
    for (int i = 0; i < n; i++) {
        count[lay_chu_so(a[i], exp)]++;
    }

    if (tang) { // tang
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[lay_chu_so(a[i], exp)] - 1] = a[i];
            count[lay_chu_so(a[i], exp)]--;
        }
    }
    else { // giam 
        for (int i = 8; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        for (int i = 0; i < n; i++) {
            output[count[lay_chu_so(a[i], exp)] - 1] = a[i];
            count[lay_chu_so(a[i], exp)]--;
        }
    }

    for (int i = 0; i < n; i++) {
        a[i] = output[i];
    }
}

            
// ham RadixSort
void radix_sort(int a[], int n, bool tang) {
//    int max = *max_element(a, a + n);
//    int min = *min_element(a, a + n);
//    int max_abs = max(abs(max), abs(min));
    
    int max_val = *max_element(a, a + n);
	int min_val = *min_element(a, a + n);
	int max_abs = max(abs(max_val), abs(min_val)); 

    
    int exp = 1;
    while (max_abs / exp > 0) {
        radix_sort_by_exp(a, n, exp, tang);
        exp *= 10;
    }
}

// ham tim kiem tuan tu
int sequential_search(int a[], int n, int x) {
    for (int i = 0; i < n; i++) {
        if (a[i] == x) {
            return i;
        }
    }
    return -1;
}

// Hàm tim kiem nhi phan
int binary_search(int a[], int n, int x, bool tang) {
    int left = 0;
    int right = n - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (a[mid] == x) {
            return mid;
        }
        if (tang) { //mang da sap xep  tang
            if (a[mid] < x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        else { //mang da sap xep giam
            if (a[mid] > x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
    }
    return -1;
}

// ham tim kiem noi suy 
int interpolation_search(int a[], int n, int x, bool tang) {
    int low = 0;
    int high = n - 1;
    while (low <= high && x >= a[low] && x <= a[high]) {
        if (low == high) {
            if (a[low] == x) return low;
            return -1;
        }
        int pos = low + (x - a[low]) * (high - low) / (a[high] - a[low]);
        if (a[pos] == x) {
            return pos;
        }
        if (tang) { // mang da sap xep  tang
            if (a[pos] < x) {
                low = pos + 1;
            }
            else {
                high = pos - 1;
            }
        }
        else { // mang da sap xep giam
            if (a[pos] > x) {
                low = pos + 1;
            }
            else {
                high = pos - 1;
            }
        }
    }
    return -1;
}

// Con tro ham sap xep
typedef void (*sort_func)(int[], int, bool);

// SAP XEP
sort_func sort_methods[] = {selection_sort, insertion_sort, bubble_sort, quick_sort, heap_sort, shell_sort, radix_sort};

// Ten cac pp sap xep
	string sort_names[] = {"Chon truc tiep", "Chen truc tiep", "Noi bot BubbleSort", "QuickSort", "HeapSort", "ShellSort", "RadixSort"};

// Con tro ham tim kiem
typedef int (*search_func)(int[], int, int, bool);

// TIM KIEM
	search_func search_methods[] = {sequential_search, binary_search, interpolation_search};

// Ten cac pp tim kiem
	string search_names[] = {"Tuan tu", "Nhi phan", "Noi suy"};

// MAIN 
int main() {

    int n;
    cout << "Nhap kich thuoc mang: ";
    cin >> n;
    int *a = new int[n];

    nhap_mang(a, n);

    xuat_mang(a, n);

    int i;
    cout << "Nhap vi tri can lay phan tu: ";
    cin >> i;
    cout << "Phan tu tai vi tri " << i << " la: " << lay_phan_tu(a, n, i) << "\n";


    int method;
    bool order;
    cout << "Chon phuong phap sap xep:\n";
    for (int i = 0; i < 7; i++) {
        cout << i + 1 << ". " << sort_names[i] << "\n";
    }
    cin >> method;
    cout << "Chon thu tu sap xep:\n";
    cout << "1. Tang dan\n";
    cout << "2. Giam dan\n";
    cin >> order;
    sort_methodsmethod - 1;
    cout << "Mang sau khi sap xep la:\n";
    xuat_mang(a, n);


    int x;
    int result;
    cout << "Nhap phan tu can tim kiem: ";
    cin >> x;
    cout << "Chon phuong phap tim kiem:\n";
    for (int i = 0; i < 3; i++) {
        cout << i + 1 << ". " << search_names[i] << "\n";
    }
    cin >> method;
    result = search_methodsmethod - 1;
    if (result == -1) {
        cout << "Khong tim thay phan tu " << x << " trong mang\n";
    }
    else {
        cout << "Tim thay phan tu " << x << " tai vi tri " << result << "\n";
    }

	delete[] a;
    return 0;
}

