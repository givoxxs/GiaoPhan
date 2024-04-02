#include <math.h>
#include <winbgim.h>

void Dr4Point(int, int), MEllipse(int , int);
	
main()
{
	initwindow(1300,700);
	setviewport(650,350,1300,700,0);
	setbkcolor(15); cleardevice();
	setcolor(1); 
	line(-650,0, 650,0);
	line(0, -350, 0, 350);
	MEllipse(200, 100);
	getch();
	closegraph();
}

void Dr4Point(int x, int y)
{
	int c=getcolor();

	putpixel(x, y, c); putpixel(-x, y, c); delay(2);
	putpixel(x, -y, c); putpixel(-x, -y, c); delay(2);
}

void MEllipse(int a, int b)
{
	float p, a2, b2;
	int x, y;
	
	a2=a*a; b2=b*b;
	x=0; y=b;
	Dr4Point(x,y);
	p=b2-a2*b + a2*0.25;
	while ((b2/a2)*(x/y)<1){
		x++;
		if (p<=0) p+=b2+2*b2*x;
		else {
			y--;
			p+=b2+2*b2*x-2*a2*y;
		}
		Dr4Point(x,y);
	}
	delay(500);
	p=b2*(x+0.5)*(x+.5)+a2*(y-1)*(y-1)-a2*b2;
	while (y>0){
		y--;
		if (p>=0) p+=a2-2*a2*y;
		else {
			x++;
			p+=a2+2*b2*x-2*a2*y;
		}
		Dr4Point(x,y);
	}
}

