#include <winbgim.h>

void Fill(int , int , int , int);

main()
{
      int mx=1800, my=700;
    
      initwindow(mx,my);
      setwindowtitle("Thuat toan to tran...");
      setcolor(1);
      circle(mx/2,my/2,170); 
	  floodfill(mx/2,my/2,1); // ham chuan
      delay(1000);
      Fill(mx/2,my/2,1,2); //RMAX = 167
      delay(1000);
      getch();
      closegraph();
}

void Fill(int x, int y, int BC, int C)
{
	int CC=getpixel(x,y);
	if((CC!=BC) &&(CC!=C)){
		putpixel(x,y,C);
		Fill(x-1,y,BC,C);
		Fill(x+1,y,BC,C);// delay(1);
		Fill(x,y-1,BC,C); 
		Fill(x,y+1,BC,C);
	}
}

