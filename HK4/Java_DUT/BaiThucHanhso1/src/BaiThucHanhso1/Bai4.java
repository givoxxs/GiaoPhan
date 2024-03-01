//  Giải hệ phương trình bậc nhất:
//				ax+by=c
//				dx+ey=f
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai4 {
	
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		double a,b,c,d,e,f;
		System.out.println("Nhập hệ số hệ phương trình : ");
		System.out.println("		ax + by = c");
		System.out.println("		dx + ey = f");
		System.out.print("	a: ");
		a = sc.nextDouble();
		System.out.print("	b: ");
		b = sc.nextDouble();
		System.out.print("	c: ");
		c = sc.nextDouble();
		System.out.print("	d: ");
		d = sc.nextDouble();
		System.out.print("	e: ");
		e = sc.nextDouble();
		System.out.print("	f: ");
		f = sc.nextDouble();
		
		double key = a * e - b * d;
		
		 if (key == 0) {
	            if (a * f - c * d == 0 && b * f - c * e == 0) {
	                System.out.println("Hệ phương trình có vô số nghiệm!");
	            } else {
	                System.out.println("Hệ phương trình không có nghiệm!");
	            }
	        } else {
	            double x = (c * e - b * f) / key;
	            double y = (a * f - c * d) / key;
	            System.out.println("Nghiệm của hệ phương trình là:");
	            System.out.println("x = " + x);
	            System.out.println("y = " + y);
	        }
	}
}
