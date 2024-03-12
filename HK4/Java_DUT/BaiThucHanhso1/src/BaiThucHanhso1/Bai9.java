// 	Viết chương trình tính :
// 	S=15-1+1/2-1/3!+....+(-1)n 1/n!
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = inp.nextInt();

        double sum = calcSeriesSum2(n);

        System.out.println("Tổng của dãy số là: " + sum);

        inp.close();
    }

    public static double calcSeriesSum2(int n) {
        double sum = 15.0;
        double factor = 1.0;
        for (int i = 1; i <= n; i++) {
        	factor *= i;
            sum += Math.pow(-1,i) * (1 / factor);
        }
        return sum;
    }
}

