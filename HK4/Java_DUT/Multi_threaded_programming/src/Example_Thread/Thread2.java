// Tao thread bang cach su dung interface Runnable
package Example_Thread;

class Thongbao3 implements Runnable {
	public void run() {
        for (int i = 1; i <= 500; i++) {
            System.out.println("Chao cac ban den voi toi!");
        }
    }
}

class Thongbao4 implements Runnable {
	public void run() {
		for (int i = 1; i <= 500; i++) {
			System.out.println("Welcome to my world!");
		}
	}
}

public class Thread2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Thongbao3());
		t1.start();
		Thread t2 = new Thread(new Thongbao4());
		t2.start();
	}
}
