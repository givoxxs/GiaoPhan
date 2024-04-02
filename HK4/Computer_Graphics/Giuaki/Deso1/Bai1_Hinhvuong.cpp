#include <iostream>
//#include <graphics.h>
#include "winbgim.h"

using namespace std;

main() {
	int x, y, d;
	cout << "Nhap toa do diem A (x, y): ";
	cin >> x >> y;
	cout << "Nhap do dai canh hinh vuong d: ";
	cin >> d;
	
	// Tao cua so do hoa
	initwindow(1000, 500);
	
	// Ve hinh vuong ABCD
	rectangle(x, y, x + d, y + d);
	
	// Ve cac canh cua hinh vuong
	//  line(x, y, x + d, y);
	//  line(x + d, y, x + d, y + d);
	//  line(x + d, y + d, x, y + d);
	//  line(x, y + d, x, y);
	
	getch();
	closegraph();
}

