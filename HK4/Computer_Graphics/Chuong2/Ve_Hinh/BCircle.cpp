//Ve duong tron bang thuat toan Michener con goi la thuat toan Bresenham

#include <winbgim.h>

void MCircle(int R);
	
main()
{
	initwindow(1000,500);
	setwindowtitle("Thuat toan Bresenham ve duong tron...");
	setviewport(500,250,1000,500,0);
	setbkcolor(15); cleardevice();
	setcolor(1); MCircle(200);
//	delay(2000); cleardevice();	setcolor(4); circle(0,0,200);
	getch();
	closegraph();
}

void MCircle(int R){
		int x, y, c, d; 
		x = 0; y = R; d = 3 - 2*R ;
		c = getcolor() ;
		while (x <= y){
			putpixel(x, y, c); putpixel(-x, y, c); delay(1);
			putpixel(x, -y, c); putpixel(-x, -y, c); delay(1);
			putpixel(y, x, c); putpixel(y, -x, c);delay(1);
			putpixel(-y, x, c); putpixel(-y, -x, c);delay(1);
			if (d<0) d += 4*x + 6;
			else { d += 4*(x - y) + 10; y-- ;}
			x++ ;
	}
}

