package StartUp;

import java.io.*;

public class ChangeString {
	public String nhapchuoi() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return s;
	}
	//To Upper Case
	public void UpperCase(String s) {
		int length = s.length();
		String result = "";
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z') {
				c = (char) (c - 32);
			}
			result += c;
		}
		System.out.println("To UpperCase: " + result);
	}	
	//To Lower Case
	public void LowerCase(String s) {
		int length = s.length();
		String result = "";
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				c = (char) (c + 32);
			}
			result += c;
		}
		System.out.println("To LowerCase: " + result);
	}
	//To Upper and Lower Case
	public void UpLowCase(String s) {
		int length = s.length();
		String result = "";
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z') {
				c = (char) (c - 32);
			} else if (c >= 'A' && c <= 'Z') {
				c = (char) (c + 32);
			}
			result += c;
		}
		System.out.println("To Upper and Lower Case: " + result);
	}
	public static void main(String arg[]) {
		ChangeString dt = new ChangeString();
		String st = "";
		try {
			System.out.print("Nhap chuoi s: ");
			st = dt.nhapchuoi();
		} catch (Exception e) {
			System.out.println("Loi nhap xuat du lieu");
		}
		System.out.println("Chuoi vua nhap: " + st);
		if (st.length() > 0) {
			dt.UpperCase(st);
			dt.LowerCase(st);
			dt.UpLowCase(st);
		}
	}
}
