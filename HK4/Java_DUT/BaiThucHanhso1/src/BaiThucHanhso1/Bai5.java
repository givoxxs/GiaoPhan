// Tìm số trung gian của 3 số a,b,c (a=1, b=2, c=3 => stg=2)
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai5 {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		double a,b,c, max;
		System.out.println("Nhập 3 số a, b, c: ");
		System.out.print("Nhập a: ");
		a = sc.nextDouble();
		System.out.print("Nhập b: ");
		b = sc.nextDouble();
		System.out.print("Nhập c : ");
		c = sc.nextDouble();
		if (a == b || b == c || a == c) {
			System.out.println("Không có số trung gian");
		} else if (a > b && b > c) System.out.println("Số trung gian là: " + b);
		else if (a > c && c > b) System.out.println("Số trung gian là: " + c);
		else {
			System.out.println("Số trung gian là: " + a);
		}
	}
}
