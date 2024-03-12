//	Tìm ước chung lớn nhất và bội chung nhỏ nhất của 2 số a và b
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai13 {
	public static void main(String arg[]) {
		Scanner inp = new Scanner(System.in);

        System.out.print("Nhập a: ");
        int a = inp.nextInt();
        System.out.print("Nhập b: ");
        int b = inp.nextInt();
        
        int ucln = Find_UCLN(a,b);
        int bcnn = Find_BCNN(a,b);

        System.out.println("Ước chung lớn nhất : " + ucln);
        System.out.println("Bội chung nhỏ nhất : " + bcnn);

        inp.close();
	}
	
	public static int Find_UCLN(int a, int b) {
		while (b != 0) {
	            int temp = b;
	            b = a % b;
	            a = temp;
	        }
	    return a;
	}
	
	public static int Find_BCNN(int a, int b) {
		return (a*b)/Find_UCLN(a,b);
	}
}
