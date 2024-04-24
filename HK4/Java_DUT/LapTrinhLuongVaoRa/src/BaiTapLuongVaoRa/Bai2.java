package BaiTapLuongVaoRa;

import java.io.*;

public class Bai2 {
	// Read an integer
	public int ReadInt() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(input);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	// a. Sum of digits
	public int SumOfDigits(int n) {
		int sum = 0;
		while(n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
	// b. Reserve number
	public int SumOfDigitsReverse(int n) {
		int sum = 0;
		while (n > 0) {
			sum = sum * 10 + n % 10;
			n /= 10;
		}
		return sum;
	}
	// c. Check if number m belongs to the Fibonacci series
	public int BelongsToFibonacci(int m) {
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
}
