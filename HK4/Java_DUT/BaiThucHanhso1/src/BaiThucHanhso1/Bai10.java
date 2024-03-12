// 	Viết chương trình tính :
// 	S=1+1/3!+1/5!+…..+1/(2n-1)!
package BaiThucHanhso1;

import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = inp.nextInt();

        double sum = calcSeriesSum3(n);

        System.out.println("Tổng của dãy số là: " + sum);

        inp.close();
    }

    public static double calcSeriesSum3(int n) {
        double sum = 1.0;
        double factor = 1.0;
        for (int i = 2; i <= n; i++) {
            factor *= (2 * i - 1) * (2 * i - 2);
            sum += 1.0 / factor;
        }
        return sum;
    }
}

