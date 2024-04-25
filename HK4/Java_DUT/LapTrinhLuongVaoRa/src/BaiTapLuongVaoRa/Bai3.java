package BaiTapLuongVaoRa;

import java.io.*;

public class Bai3 {
	// Read an integer
	public static int ReadInt() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	// a. Enter a Number array
	public static int[] EnterNumberArray(int n) throws IOException {
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter a[" + i + "]: ");
			a[i] = ReadInt();
		}
		return a;
	}
	// b. Sum of old positive numbers
	public static int SumOfOldPositiveNumbers(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0 && a[i] > 0) {
				sum += a[i];
			}
		}
		return sum;
	}	
	// c. Find the index of k in the array
	public static int FindIndex(int[] a, int k) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == k) {
				return i;
			}
		}
		return -1;
	}
	// d. Sort the array in ascending order
	public static void SortArray(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	// e.  Insert p into array a so that array a still ensures increasing
	public static int[] InsertNumber(int[] a, int p) {
		int[] result = new int[a.length + 1];
		int i = 0;
		while (i<a.length && a[i] < p) {
			result[i] = a[i];
			i++;
		}
		result[i] = p;
		for (int j = i + 1; j < result.length; j++) {
			result[j] = a[i++];
		}
		return result;
	}
	// main
	public static void main(String args[]) throws IOException {
		int n;
		System.out.print("Enter the length: ");
		n = ReadInt();
		// a.
		int[] a = EnterNumberArray(n);
		// b.
		System.out.println("b. Sum of old positive numbers: " + SumOfOldPositiveNumbers(a));
		// c.
		int k;
		System.out.print("Enter k: ");
		k = ReadInt();
		if (FindIndex(a, k) == -1) {
			System.out.println("c. k " + k + " is not in the array");
		} else {
			System.out.println("c. k " + k + " is at index " + FindIndex(a, k));
		}
		// d.
		SortArray(a);
		System.out.print("d. Sort the array in ascending order: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// e.
		int p;
		System.out.print("\nEnter p: ");
		p = ReadInt();
		a = InsertNumber(a, p);
		System.out.print("e. Insert p into array a so that array a still ensures increasing: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
