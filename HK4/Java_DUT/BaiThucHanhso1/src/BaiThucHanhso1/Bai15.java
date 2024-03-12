// .Kiểm tra số P có phải là số chính phương không?
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai15 {
	public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương P: ");
        int P = inp.nextInt();

        if (ChinhPhuong(P)) {
            System.out.println(P + " là số chính phương.");
        } else {
            System.out.println(P + " không phải là số chính phương.");
        }

        inp.close();
    }
	
	public static boolean ChinhPhuong(int p) {
        if (p < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(p);
        return sqrt * sqrt == p;
    }
}
