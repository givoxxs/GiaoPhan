// Nhập một số nguyên m và kiểm tra m có phải là số nguyên tố không?
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai14 {
	public static void main(String arg[]) {
		Scanner inp = new Scanner(System.in);

        System.out.print("Nhập m: ");
        int m = inp.nextInt();
        
        if (Nguyento(m)) {
            System.out.println(m + " là số nguyên tố.");
        } else {
            System.out.println(m + " không phải là số nguyên tố.");
        }

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
}
