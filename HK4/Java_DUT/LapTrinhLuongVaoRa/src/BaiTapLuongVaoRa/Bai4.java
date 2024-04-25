package BaiTapLuongVaoRa;

import java.io.*;

public class Bai4 {
	// Read an integer
	public static int ReadInt() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	// a. Enter a Number matric
	public static int[][] EnterNumberMatric(int n, int m) throws IOException {
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print("Enter a[" + i + "][" + j + "]: ");
				a[i][j] = ReadInt();
			}
		}
		return a;
	}
	// b. The multiples of 3 on the first row of matrix a
	public static int MultiplesOf3OnFirstRow(int[][] a) {
		int count = 0;
		for (int i = 0; i < a[0].length; i++) {
			if (a[0][i] % 3 == 0) {
				count++;
			}
		}
		return count;
	}
	// c. Create a one-dimensional array X[i] is the maximum values on row i of the matrix
	public static int[] MaximumValuesOnRow(int[][] a) {
		int[] result = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int max = a[i][0];
			for (int j = 1; j < a[i].length; j++) {
				if (a[i][j] > max) {
					max = a[i][j];
				}
			}
			result[i] = max;
		}
		return result;
	}
	// d. Delete the first element of the array X[i], output the array X[i].
	public static int[] DeleteFirstElement(int[] a) {
		int[] result = new int[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			result[i - 1] = a[i];
		}
		return result;
	}
	// main
	public static void main(String[] args) throws IOException {
		int n, m;
		System.out.print("Enter n columns: ");
		n = ReadInt();
		System.out.print("Enter m rows: ");
		m = ReadInt();
		// a.
		int[][] a = EnterNumberMatric(n, m);
		// b.
		System.out.println("b. The multiples of 3 on the first row of matrix a: " + MultiplesOf3OnFirstRow(a));
		// c.
		int[] result = MaximumValuesOnRow(a);
		System.out.print("c. The maximum values on row i of the matrix: ");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		// d.
		System.out.println("\nd. Delete the first element of the array X[i]: ");
		result = DeleteFirstElement(result);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
