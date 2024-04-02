#include <iostream>
#include <winbgim.h>
//#include <graphics.h>

void MCircle(int a, int b, int r) ;

main() {

	initwindow(1000, 500);

    int a = 200, b = 200, r = 100;
    MCircle(a, b, r);

    getch();
    closegraph();
}

void MCircle(int a, int b, int r) {
    int x = 0, y = r;
//    int d = 3-2*r; 
	int d = 1-r;
    int c=getcolor();

    while (x <= y) {
        putpixel(a + x, b + y, c);
        putpixel(a - x, b + y, c);
        putpixel(a + x, b - y, c);
        putpixel(a - x, b - y, c);
        putpixel(a + y, b + x, c);
        putpixel(a - y, b + x, c);
        putpixel(a + y, b - x, c);
        putpixel(a - y, b - x, c);

        if (d <= 0) {
//            d = d + 4 * x + 6;
			d = d+ 2 * x + 3;
        } else {
//            d = d + 4 * (x - y) + 10;
			d=  d + 2*(x-y) + 5;
            y--;
        }
        x++;
    }
}
