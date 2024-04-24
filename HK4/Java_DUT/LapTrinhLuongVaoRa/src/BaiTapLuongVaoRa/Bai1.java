package BaiTapLuongVaoRa;

import java.io.*;
import java.util.ArrayList;

public class Bai1 {
	//Read String
	public String ReadString() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return s;
	}
	// a. ReverseString
	public void ReverseString(String s) {
		String result = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			result += s.charAt(i);
		}
		System.out.println("a. Reverse String: " + result);
	}
	// b. To UpperCase
	public void ToUpperCase(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z') {
				c = (char) (c - 32);
			}
			result += c;
		}
		System.out.println("b. To UpperCase: " + result);
	}
	// c. To LowerCase
	public void ToLowerCase(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				c = (char) (c + 32);
			}
			result += c;
		}
		System.out.println("c. To LowerCase: " + result);
	}
	// d. To Upper and Lower Case
	public void ToUpperLowerCase(String s) {
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
		System.out.println("d. To Upper and Lower Case: " + result);
	}
	// Split String
	public String[] SplitString(String s) {
		ArrayList<String> parts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    parts.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        if (sb.length() > 0) {
            parts.add(sb.toString());
        }

        return parts.toArray(new String[0]);
	}
	// e. Count Number of Words
	public void CountNumberWords(String s) {
		System.out.println("e. Number of Words: " + SplitString(s).length);
	}
	// f. Đưa ra bảng tần số xuất hiện của các từ.
	public void TableFrequency(String s) {
		String[] words = SplitString(s);
		int[] count = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			count[i] = 1;
			for (int j = i + 1; j < words.length; j++) {
				if (words[i] == null) {
					continue;
				} else if (words[i].equals(words[j])) {
					count[i]++;
					words[j] = null;
				}
			}
		}
		System.out.println("f. Table Frequency: ");
		for (int i = 0; i < words.length; i++) {
			if (words[i] != null) {
				System.out.println(words[i] + " is " + count[i] + " times");		
			}
		}
	}
	// Main
	public static void main(String arg[]) {
		Bai1 dt = new Bai1();
		String s = "";

		try {
			System.out.print("Nhập chuỗi s: ");
			s = dt.ReadString();
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		if (s.length() > 0) {
			System.out.println("Chuỗi vừa nhập: " + s);
			dt.ReverseString(s);
			dt.ToUpperCase(s);
			dt.ToLowerCase(s);
			dt.ToUpperLowerCase(s);
			dt.CountNumberWords(s);
			dt.TableFrequency(s);
		} else {
			System.out.println("Chuỗi rỗng");
		}
	}
}
