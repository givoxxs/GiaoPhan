#include <iostream>
#include <winbgim.h>

using namespace std;

void BLine(int xA,int yA,int xB,int yB);

int main() {
	int xA, yA, xB, yB;
	
	// Nhap toa do diem A
	cout << "Nhap toa do diem A (xA, yA): ";
	cin >> xA >> yA;
	
	// Nhap toa do diem B
	cout << "Nhap toa do diem B (xB, yB): ";
	cin >> xB >> yB;
	
	initwindow(1300, 1000);
	setwindowtitle("Thuat toan Bresenham ke doan thang..."); 
	setbkcolor(15); setcolor(1); cleardevice();
	BLine(xA, yA, xB, yB);
	getch();
	closegraph();
	return 0;
}

void BLine(int x1, int y1, int x2, int y2)
{
	int x, y, dx, dy, e, eg, ekg;
	
	int c=getcolor();
	dx=x2-x1; 
	dy=y2-y1;
	e=-2*dy-dx; ekg=-2*dy;  eg=-2*dy-2*dx;
	for (x=x1, y=y1; x<=x2; x++){
		putpixel(x, y, c); 
		delay(10);
		if (e<0) e+=ekg;
		else {
			e+=eg;
			y--;
		}
	} 
}

