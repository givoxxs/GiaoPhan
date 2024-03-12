package BaiThucHanhso1;

public class Bai18 {
	public static void main(String arg[]) {
		System.out.println("Các số hoàn hảo nhỏ hơn 1000 là:");
        for (int i = 1; i < 1000; i++) {
            if (Hoanhao(i)) {
                System.out.print(i + " ");
            }
        }
	}
	public static boolean Hoanhao(int m) {
		int sum = 0;
		for (int i = 1; i <= m / 2; i++) {
            if (m % i == 0) {
                sum += i;
            }
        }
		return sum == m;
	}
}
