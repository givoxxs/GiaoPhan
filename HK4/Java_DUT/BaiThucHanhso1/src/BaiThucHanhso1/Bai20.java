package BaiThucHanhso1;

import java.util.Scanner;

public class Bai20 {
	public static void main(String arg[]) {
		 Scanner inp = new Scanner(System.in);

	     System.out.print("Nhập số nguyên dương K: ");
	     int K = inp.nextInt();
	     
	     int check = findFibo(K);

	     if (check != -1) {
	            System.out.println(K + " thuộc dãy Fibonacci và là phần tử ở vị trí thứ " + check);
	        } else {
	            System.out.println(K + " không thuộc dãy Fibonacci.");
	        }

	     inp.close();
	 }
	
	public static int findFibo(int K) {
		int a0 = 0;
        int a1 = 1;
        int check = 1;

        while (a1 < K) {
            int a2 = a0 + a1;
            a0 = a1;
            a1 = a2;
            check++;
        }

        if (a1 == K) {
            return check;
        } else {
            return -1;
        }
	}
}
