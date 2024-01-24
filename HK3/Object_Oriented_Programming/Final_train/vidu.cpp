// #include <stdio.h>
// #include <math.h>

// void input(int *a, int n) {
// 	int i;
// 	for ( i = 0; i < n; i++){
// 		printf("Nhap phan tu thu %d:", i);
// 		scanf("%d", &a[i]);}
// }
// void reverse(int *arr, int n) {
// 	 int i, temp;
// 	 for (i=0; i < n / 2; i++) {
// 	 	temp = arr[i];
// 	 	arr[i] = arr[n - i - 1];
// 	    arr[n - i - 1] = temp;
// 	 }
// }
// void output(int *a, int n) {
// 	for (int i = 0; i < n; i++)
// 	printf("%d", a[i]);
// }
// void giam(int *a, int n)
// {
// 	int tg;
// 	for (int i = 0; i < n - 1; i++){
// 		for (int j = i + 1; j < n; j++)
// 			if (a[i] < a[j]) {
// 				tg = a[i];
// 				a[i] = a[j];
// 	        	a[j] = tg;
//         	}
// 	}
// 	output(a,n);
// }

// int main() {
// 	int n, i, count = 0;
// 	printf("Nhap vao so phan tu cho day: ");
// 	scanf("%d", &n);
// 	int arr[n];
// 	input(arr,n);
// 	for (i = 0; i < n; i++) {
// 		//scanf("%d", &arr[i]);
// 		if (arr[i]%5 != 0) {
// 			count++;
// 		}
// 	}
// 	printf("So phan tu khong chia het cho 5 la: %d\n", count);
// 	reverse(arr, n);
// 	printf("Day sau khi dao nguoc la: ");
// 	for (i = 0; i < n; i++) {
// 		printf("%d ", arr[i]);
// 	}
// 	return 0;
// }

#include <stdio.h>
#include <math.h>

void input(int a[], int n) {
	int i;
	for ( i = 0; i < n; i++){
		printf("Nhap phan tu thu %d:", i);
		scanf("%d", &a[i]);}
}
void reverse(int arr[], int n) {
	 int i, temp;
	 for (i=0; i < n / 2; i++) {
	 	temp = arr[i];
	 	arr[i] = arr[n - i - 1];
	    arr[n - i - 1] = temp;
	 }
}
void output(int a[], int n) {
	for (int i = 0; i < n; i++)
	printf("%d", a[i]);
}
void giam(int a[], int n)
{
	int tg;
	for (int i = 0; i < n - 1; i++){
		for (int j = i + 1; j < n; j++)
			if (a[i] < a[j]) {
				tg = a[i];
				a[i] = a[j];
	        	a[j] = tg;
        	}
	}
	output(a,n);
}

int main() {
	int n, i, count = 0;
	printf("Nhap vao so phan tu cho day: ");
	scanf("%d", &n);
	int arr[n];
	input(arr,n);
	for (i = 0; i < n; i++) {
		if (arr[i]%5 != 0) {
			count++;
		}
	}
	printf("So phan tu khong chia het cho 5 la: %d\n", count);
	reverse (arr, n);
	printf("Day sau khi dao nguoc la: ");
	for (i = 0; i < n; i++) {
		printf("%d ", arr[i]);
	}
	return 0;
}