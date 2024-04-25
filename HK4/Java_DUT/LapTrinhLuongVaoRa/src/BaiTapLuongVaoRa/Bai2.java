package BaiTapLuongVaoRa;

import java.io.*;

public class Bai2 {
	// Read an integer
	public static int ReadInt() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(input);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	// a. Sum of digits
	public static int SumOfDigits(int n) {
		int sum = 0;
		while(n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
	// b. Reserve number
	public static int SumOfDigitsReverse(int n) {
		int sum = 0;
		while (n > 0) {
			sum = sum * 10 + n % 10;
			n /= 10;
		}
		return sum;
	}
	// c. Check if number m belongs to the Fibonacci series
	public static int BelongsToFibonacci(int m) {
		int a = 0, b = 1, c = 1;
		while (c < m) {
			c = a + b;
			a = b;
			b = c;
		}
		if (c == m) {
			return 1;
		}
		return 0;
	}
	// d. Check if the reverse of m is a symmetric number
	public static int IsSymmetric(int m) {
		int n = SumOfDigitsReverse(m);
		if (n == m) {
			return 1;
		}
		return 0;
	}
	public static void main(String[] args) throws IOException {
		int num;
		do {
			System.out.print("Enter m (m>0): ");
			num = ReadInt();
		} while (num <= 0);
		// a. Sum of digits
		System.out.println("a. Sum of digits: " + SumOfDigits(num));
		// b. Reserve number
		System.out.println("b. Reserve number: " + SumOfDigitsReverse(num));
		// c. Check if number m belongs to the Fibonacci series
		if (BelongsToFibonacci(num) == 1) {
            System.out.println("c. " + num + " belongs to the Fibonacci series");
        } else {
            System.out.println("c. " + num + " does not belong to the Fibonacci series");
        }
		// d. Check if the reverse of m is a symmetric number
		if (IsSymmetric(num) == 1) {
			System.out.println("d. " + num + " is a symmetric number");
		} else {
			System.out.println("d. " + num + " is not a symmetric number");
		}
		
	}
}
