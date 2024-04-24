package StartUp;

import java.io.*;

public class ReadInt {
	// Read an integer
	public int nhapso() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	// Tổng và tích các chữ số
	public void TongTichcacchuso(int m) {
		int s=0, p=1;
		while (m > 0) {
			s += m % 10;
			p *= m % 10;
			m /= 10;
		}
		System.out.println("Tong cac chu so: " + s);
		System.out.println("Tich cac chu so: " + p);
	}
	// Main
	public static void main(String arg[]) {
		ReadInt dt = new ReadInt();
		int m=0;
		try {
			do {
				System.out.print("Nhap so nguyen duong m: ");
				m = dt.nhapso();
			} while (m <= 0);
		} catch (Exception e) {
			System.out.println("Loi nhap xuat du lieu");
		}
		System.out.println("So vua nhap: " + m);
		dt.TongTichcacchuso(m);
	}
}
