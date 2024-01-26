// Tìm max của 3 biến a,b,c (Dùng if, if…else, ?:)
package Bailam;

import java.util.Scanner;

public class Bai1 {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int a,b,c, max;
		System.out.println("Nhap 3 so a, b, c: ");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		max = a > b ? a : b;
		max = c > max ? c : max;
		System.out.println("So lon nhat la: " + max); 
	}
}
