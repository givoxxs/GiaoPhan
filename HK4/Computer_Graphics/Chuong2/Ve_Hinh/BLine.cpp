//Ke doan thang AB bang thuat toan Bresenham
//Nhap diem A bang nut phai chuot
//Nhap diem B bang nut trai chuot

#include <winbgim.h>
#include <stdio.h>


void BLine1(int x1, int y1, int x2, int y2),
	 BLine2(int x1, int y1, int x2, int y2),
	 BLine3(int x1, int y1, int x2, int y2),
	 BLine4(int x1, int y1, int x2, int y2); 

int c=1;

main()
{
      int mx=700, my=700,x1,y1,x2,y2,x,y,a=0,b=0,tam;
      float m;
      
      initwindow(mx,my);
      setwindowtitle("Thuat toan Bresenham ke doan thang..."); 
      setbkcolor(15); setcolor(1); cleardevice();
      
      while (!kbhit()){
		if (ismouseclick(WM_LBUTTONDOWN)){
			a=1;
			getmouseclick (WM_LBUTTONDOWN,x1,y1);
			setcolor(1);circle(x1,y1,3);
			printf("\nA(%d,%d)",x1,y1);
		}
		if (ismouseclick(WM_RBUTTONDOWN)){
			b=1;
			getmouseclick (WM_RBUTTONDOWN,x2,y2);
			setcolor(4);circle(x2,y2,3);
			printf("\nB(%d,%d)",x2,y2);
		}
		if (a && b){
			if (x1>x2){
				tam=x1; x1=x2; x2=tam;
				tam=y1; y1=y2; y2=tam;
			}
		 	if (y1==y2){
		 		y=y1;
		 		for (x=x1; x<=x2;x++) putpixel(x,y,c); 
			}
			else if (x1==x2){
		 		x=x1;
		 		if (y1<y2) for (y=y1; y<=y2;y++) putpixel(x,y,c); 
		 		else for (y=y2; y<=y1;y++) putpixel(x,y,c); 
			 }
			else {
				m=float(y2-y1)/float(x2-x1);
				if (m==1) for (x=x1; x<=x2;x++,y++) putpixel(x,y,c); 
				if (m==-1) for (x=x1; x<=x2;x++,y--) putpixel(x,y,c); 
				if (m!=1 && m!=-1){
				  if (m>0 && m<1) BLine1(x1,y1,x2,y2);
				  if (m>1) BLine2(x1,y1,x2,y2);
				  if (m<0 && m>-1) BLine3(x1,y1,x2,y2);
				  if (m<-1) BLine4(x1,y1,x2,y2);
				}
			}
			a=0; b=0;
		}
	}
	
}
// 0 < m < 1
void BLine1(int x1, int y1, int x2, int y2)
{
	int x, y, dx, dy, e, et, ekt;
	
	dx=x2-x1; dy=y2-y1;
	ekt=dy+dy; e=ekt-dx; et=e-dx;
	for (x=x1, y=y1; x<=x2; x++){
		putpixel(x, y, c); 
		delay(5);
		if (e<0) e+=ekt;
		else {
			e+=et;
			y++;
		}
	} 
}
// m > 1
void BLine2(int x1, int y1, int x2, int y2)
{
	int x, y, dx, dy, e, et, ekt;
	
	dx=x2-x1; dy=y2-y1; 
	e=2*dx-dy; ekt=2*dx;  et=2*dx-2*dy;
	for (x=x1, y=y1; y<=y2; y++){
		putpixel(x, y, c); 
		delay(10);
		if (e<0) e+=ekt;
		else {
			e+=et;
			x++;
		}
	} 
}
// -1 < m < 0
void BLine3(int x1, int y1, int x2, int y2)
{
	int x, y, dx, dy, e, eg, ekg;
	
	dx=x2-x1; dy=y2-y1;
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
// m < -1
void BLine4(int x1, int y1, int x2, int y2)
{
	int x, y, dx, dy, e, et, ekt;
	
	dx=x2-x1; dy=y2-y1;
	e=2*dx+dy; ekt=2*dx; et=2*dx+2*dy;
	for (x=x1, y=y1; y>=y2; y--){
		putpixel(x, y, c); 
		delay(10);
		if (e<0) e+=ekt;
		else {
			e+=et;
			x++;
		}
	} 
}

