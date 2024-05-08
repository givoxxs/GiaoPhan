// Tao thread bang cach ke thua lop Thread
package Example_Thread;

class Thongbao1 extends Thread {
	public void run() {
		for (int i = 1; i <= 500 ; i++) {
			System.out.println("Chao cac ban den voi toi!");			}
	}
}

class Thongbao2 extends Thread {
	public void run() {
		for (int i = 1; i <= 500; i++) {
			System.out.println("Welcome to my world!");
		}
	}
}

public class Thread1 {
	public static void main(String[] args) {
		Thongbao1 dt1 = new Thongbao1();
		dt1.start();
		Thongbao2 dt2 = new Thongbao2();
		dt2.start();
	}
}
