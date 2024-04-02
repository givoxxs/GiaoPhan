//#include <iostream>
//#include <winbgim.h>
//
///* run this program using the console pauser or add your own getch, system("pause") or input loop */
//
//int main(int argc, char** argv) {
//	return 0;
//}

#include <winbgim.h>

main()
{
	int n=10,R=10,i;
	
	initwindow(1000,600); setbkcolor(15); cleardevice();
	setwindowtitle("Angten...");
	//setwritemode(XOR_PUT); khong tac dung voi hinh tron
	//setcolor(15); 
	while (!kbhit()){
		setcolor(0); 
		for (i=1;i<=n;i++){
			circle(500,300,i*R); delay(50);
		} 
		delay(500);
		setcolor(15); 
		for (i=n;i>0;i--){
			circle(500,300,i*R); delay(50);
		} 
		delay(500);
	}
}

