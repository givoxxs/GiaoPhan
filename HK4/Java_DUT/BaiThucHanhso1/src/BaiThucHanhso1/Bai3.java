// Giải phương trình bậc hai : ax2 + bx + c=0
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai3 {
	public static void ptbn(double a, double b) {
		if (a == 0) {
			if (b == 0) {
				System.out.println("Phương trình vô số nghiệm!");
			} else {
				System.out.println("Phương trình vô nghiệm!");
			}
		} else {
			System.out.println("Phương trình có 1 nghiệm duy nhất x: " + (-b/a));
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		double a,b,c;
		System.out.println("Nhập hệ số phương trình ax^2 + bx + c = 0: ");
		System.out.print(" a : ");
		a = sc.nextDouble();
		System.out.print(" b : ");
		b = sc.nextDouble();
		System.out.print(" c : ");
		c = sc.nextDouble();
		if (a == 0) {
			ptbn(b,c);
		} else {
			double delta = b*b - 4 * a * c;
			if (delta > 0) {
				double root1 = (-b + Math.sqrt(delta)) / (2 * a);
	            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
	            System.out.println("Phương trình có hai nghiệm phân biệt:");
	            System.out.println("Nghiệm thứ nhất x1: " + root1);
	            System.out.println("Nghiệm thứ hai x2: " + root2);
			} else if (delta == 0) {
				System.out.println("Phương trình có 1 nghiệm duy nhất x: " + -b/(2*a));
			} else {
				System.out.println("Phương trình vô nghiệm!");
			}	
		}
	}
}
