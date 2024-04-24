package StartUp;

import java.io.*;

public class ChangeString {
	// Read a string
	public String nhapchuoi() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return s;
	}
	//To Upper Case
	public void UpperCase(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
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
		String result = "";
		for (int i = 0; i < s.length(); i++) {
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
		String result = "";
		for (int i = 0; i < s.length(); i++) {
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
	// Chuỗi đảo ngược
	public void ReverseString(String s) {
		String result = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			result += s.charAt(i);
		}
		System.out.println("Chuỗi đảo ngược: " + result);
	}
	// Main
	public static void main(String arg[]) {
		ChangeString dt = new ChangeString();
		String st = "";
		
		try {
			System.out.print("Nhập chuỗi st: ");
			st = dt.nhapchuoi();
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		// Check if the input string is empty
		if (st.length() > 0) {
			System.out.println("Chuỗi vừa nhập: " + st);
			dt.UpperCase(st);
			dt.LowerCase(st);
			dt.UpLowCase(st);
			dt.ReverseString(st);
		} else if (st.length() == 0) {
			System.out.println("Chuỗi rỗng");
		}
	}
}
