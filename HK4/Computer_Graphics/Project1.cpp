#include <iostream>
#include <winbgim.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void BresLine(int xA , int yA, int xB, int yB)
{
	int dx = xB – xA; 
	int dy = yB – yA;
	int e_noinc = dy + dy; 
	int e = e_noinc – dx;
	int e_inc = e – dx; 
	int c = getcolor() ;
	for (int x = xA, y = yA; x <= xB; x++){
		putpixel(x, y, c);
		if (e<0) e+=e_noinc;
		else { y++ ; e+=e_inc;}
	}
}

int main(int argc, char** argv) {
	BresLine(0,0,10,4);
	return 0;
}
