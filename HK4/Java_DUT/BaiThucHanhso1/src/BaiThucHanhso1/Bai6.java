// Viết chương trình tính tiền cho bài toán KaraOke
//	+ Giờ bắt đầu : a (int)
// 	+ Giờ kết thúc : b (int)
// 	+ Nếu b<18h : 45000đ/1h, nếu b>=18h : 60000đ/1h
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai6 {
	
	public static void main(String arg[]) {
		Scanner inp = new Scanner(System.in);
		int a,b, ans;
		do {
			System.out.print("Giờ bắt đầu: ");
			a = inp.nextInt();
			System.out.print("Giờ kết thúc: ");
			b = inp.nextInt();
			if (a >= b || a < 0 || b > 24) System.out.println("Vui lòng nhập lại!");
		} while (a >= b || a < 0 || b > 24);
        
        if (a > 18) {
        	ans = (b-a)*60000;
        } else if (b < 18) {
        	ans = (b-a)*45000;
        } else {
        	ans = (18 - a)*45000 + (b - 18)*60000;
        }
        
        System.out.println("Tổng tiền phải trả: " + ans + "đ");
        
        inp.close();
	}
}
