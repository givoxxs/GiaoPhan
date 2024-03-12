// 	Viết chương trình tính :
// 	S=1+1/2+1/3+....+1/n
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = inp.nextInt();

        double sum = calcSeriesSum(n);

        System.out.println("Tổng của dãy số là: " + sum);

        inp.close();
    }

    public static double calcSeriesSum(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }
}

