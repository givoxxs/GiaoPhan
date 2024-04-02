//Ve duong tron tam (x0,y0) bang thuat toan Midpoint
#include <winbgim.h>

void MPCircle(int x0, int y0, int R);
	
main()
{
	initwindow(1000,500);
	setwindowtitle("Thuat toan Midpoint ve duong tron...");
	setbkcolor(15); cleardevice();
	setcolor(1); MPCircle(500,250,100);
	setcolor(15); //circle(500,250,100);
	getch();
	closegraph();
}

void MPCircle(int x0, int y0, int R){
		int x, y, c, p; 
		x = 0; y = R; p = 1 - R ;
		c = getcolor() ;
		while (x <= y){
			putpixel(x0+x,y0+y,c); putpixel(x0-x,y0+y,c); delay(1);
			putpixel(x0+x,y0-y,c); putpixel(x0-x,y0-y,c); delay(1);
			putpixel(x0+y,y0+x,c); putpixel(x0+y,y0-x,c); delay(1);
			putpixel(x0-y,y0+x,c); putpixel(x0-y,y0-x,c); delay(1);
			if (p<0) p += 2*x + 3;
			else { p += 2*(x - y) + 5; y-- ;}
			x++ ;
	}
}

