
#include <iostream>
#include <cmath>
using namespace std;

int demSoChuSo(int x);
bool laSoTuMan(int x);

int main()
{
    int n,i;
    cin >> n;
    int *arr = new int [n];
    for (i = 0; i<n; i++) {
        cin >> arr[i];
    }
    int count = 0;
    for (i = 0; i<n; i++) {
        if(laSoTuMan(arr[i])) {
            cout << arr[i] << " ";
            count++;
        }
    }
    if (count == 0) cout << "NO";
    delete arr;
    return 0;
}

int demSoChuSo(int x)
{
	int count = 0;
	while (x != 0)
	{
		x = x / 10;
		count++;
	}
	return count;
}
bool laSoTuMan(int x)
{
	int nNumOfDigits = demSoChuSo(x);
	int nRem, sum = 0;

	int temp = x;
	while (temp != 0)
	{
		nRem = temp % 10;

		sum = sum + pow(nRem, nNumOfDigits);

		temp = temp / 10;
	}
	return (sum == x);
}
