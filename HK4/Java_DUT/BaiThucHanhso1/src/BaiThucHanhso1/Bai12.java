//	Tính tổng và tích các chữ số của một số nguyên dương m cho trước
//	(Ví dụ : m=234=> S=2+3+4=9, P=2*3*4=24)
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai12 {
	public static void main(String arg[]) {
		Scanner inp = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = inp.nextInt();

        int s = calc_sum(n);
        int p =calc_multi(n);

        System.out.println("Tổng các chữ số của : " + s);
        System.out.println("Tích các chữ số của : " + p);

        inp.close();
	}
	
	public static int calc_sum(int n) {
		int result = 0;
		while (n > 0) {
			result += n%10;
			n /= 10;
		}
		return result;
	}
	
	public static int calc_multi(int n) {
		int result = 1;
		while (n > 0) {
			result *= n%10;
			n /= 10;
		}
		return result;
	}
}
