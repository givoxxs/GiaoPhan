//	.In ra các số nguyên tố nhỏ hơn hoặc bằng số nguyên dương n cho trước
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai17 {
	public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương n: ");
        int n = inp.nextInt();

        System.out.println("Các số nguyên tố nhỏ hơn hoặc bằng " + n + " là:");
        printAnswers(n);

        inp.close();
    }
	
	public static boolean Nguyento(int m) {
		if (m <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(m); i++) {
            if (m % i == 0) {
                return false;
            }
        }
		
		return true;
	}
	
	public static void printAnswers(int n) {
		for (int i = 2; i <= n; i++) {
            if (Nguyento(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
