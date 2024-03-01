// Tìm max của 3 biến a,b,c (Dùng if, if…else, ?:)
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai1 {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int a,b,c, max;
		System.out.println("Nhập 3 so a, b, c: ");
		System.out.print("Nhập a: ");
		a = sc.nextInt();
		System.out.print("Nhập b: ");
		b = sc.nextInt();
		System.out.print("Nhập c : ");
		c = sc.nextInt();
		max = a > b ? a : b;
		max = c > max ? c : max;
		System.out.println("Số lớn nhất là: " + max); 
	}
}
