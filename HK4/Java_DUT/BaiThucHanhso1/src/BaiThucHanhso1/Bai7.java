// Nhập vào một tháng, một năm bất kỳ. Sau đó in ra số ngày tương ứng với
// tháng, năm đó (Ví dụ: tháng=2, năm=2000: songay=29,…)
package BaiThucHanhso1;

import 	java.util.Scanner;

public class Bai7 {
	
	public static boolean isLeapYear(int year) {
		 return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
	public static int getNumberOfDays(int month, int year) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 31;
        }
    }
	
	public static void main(String arg[]) {
		Scanner inp = new Scanner(System.in);
		int days, month, year;
		System.out.println("Nhập vào tháng năm:");
		System.out.print("Tháng (1-12): ");
		month = inp.nextInt();
		System.out.print("Năm: ");
		year = inp.nextInt();
		
		days = getNumberOfDays(month,year);
		
		System.out.println("Số ngày trong tháng " + month + ", năm " + year + " là: " + days);
		
		inp.close();
	}
}
