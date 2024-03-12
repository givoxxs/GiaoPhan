package BaiThucHanhso1;

import java.util.Scanner;

public class Bai19 {
	 public static void main(String arg[]) {
		 Scanner inp = new Scanner(System.in);

	     System.out.print("Nhập số nguyên dương n: ");
	     int n = inp.nextInt();

	     System.out.println(n + "số Fibonacci đầu tiên là:");
	     printAnswers(n);

	     inp.close();
	 }
	 
	 public static void printAnswers(int n) {
		 int a0 = 1;
		 int a1 = 1;
		 
		 for (int i = 0; i < n; i++) {
	            System.out.print(a0 + " ");
	            int a2 = a0 + a1;
	            a0 = a1;
	            a1 = a2;
	     }
	 }
}
