//	Kiểm tra số M có phải là số đối xứng không?
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai16 {
	public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương M: ");
        int M = inp.nextInt();

        if (Doixung(M)) {
            System.out.println(M + " là số đối xứng.");
        } else {
            System.out.println(M + " không phải là số đối xứng.");
        }

        inp.close();
    }
	
	public static boolean Doixung(int m) {
		
		int end_number = 0;
        int begin_number = m;
		
        while (m > 0) {
            int digit = m % 10;
            end_number = end_number * 10 + digit;
            m /= 10;
        }
		return end_number == begin_number;
    }
}
