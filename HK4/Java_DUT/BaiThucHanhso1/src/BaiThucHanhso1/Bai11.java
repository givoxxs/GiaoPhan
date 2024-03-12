//.Viết chương trình tính:
//	n!! =1*3*5*…..*n (n lẽ)
// 		=2*4*6*….*n (n chẵn)
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai11 {
	public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = inp.nextInt();

        double result = calcSeriesSum4(n);

        System.out.println("Giai thừa đôi của " + n + ": " + result);

        inp.close();
    }
	
	public static double calcSeriesSum4(int n) {
		double result = 1.0;
		 if (n % 2 == 0) { 
	            for (int i = 2; i <= n; i += 2) {
	                result *= i;
	            }
	        } else { 
	            for (int i = 1; i <= n; i += 2) {
	                result *= i;
	            }
	        }
		
		return result;
	}
}
