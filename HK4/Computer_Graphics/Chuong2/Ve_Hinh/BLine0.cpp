#include <winbgim.h>
#include <stdio.h>

//xA<xB & 0<m<1
void BLine(int x1, int y1, int x2, int y2);

main()
{
      int mx=1000, my=500, x1, y1, x2, y2;
      
      printf("A(x1, y1): "); scanf("%d %d", &x1, &y1);
      printf("B(x2, y2): "); scanf("%d %d", &x2, &y2);

	  initwindow(mx,my);
      setbkcolor(15); setcolor(0); cleardevice();
	  BLine(x1, y1, x2, y2);
	  delay(5000);//getch();
	  setcolor(15); line(x1, y1, x2, y2);
	  getch(); //delay(2000);
      closegraph();
}

void BLine(int x1, int y1, int x2, int y2)
{
	int x, y, dx, dy, e, et, ekt, c;
	
	dx=x2-x1; dy=y2-y1; c=getcolor();
	ekt=dy+dy; e=ekt-dx; et=e-dx;
	for (x=x1, y=y1; x<=x2; x++){
		putpixel(x, y, c); 
		delay(1000);
		if (e<=0) e+=ekt;
		else {
			e+=et;
			y++;
		}
	} 
}

