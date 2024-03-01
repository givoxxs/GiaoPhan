// Giải phương trình bậc nhất : ax+b=0
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai2 {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int a,b, ans;
		System.out.println("Nhập hệ số phương trình sau ax + b = 0: ");
		System.out.print("Nhập a : ");
		a = sc.nextInt();
		System.out.print("Nhập b : ");
		b = sc.nextInt();
		if (a == 0) {
			if (b == 0) {
				System.out.println("Phương trình vô số nghiệm!");
			} else {
				System.out.println("VPhương trình vô nghiệm!");
			}
		} else {
			System.out.println("Nghiệm của phương trình là: " + (-b/a));
		}
	}
}
