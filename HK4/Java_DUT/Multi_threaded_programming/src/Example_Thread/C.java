// Create a class A that extends Thread 
// and class B that extends Thread.
package Example_Thread;

class A extends Thread {
	public void run() {
		synchronized ("") {
			for (int i = 0; i < 10; i++) {
				System.out.print(i + " ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
	}
}

class B extends Thread {
	public void run() {
		synchronized ("") {
			for (int i=0; i<10; i++) {
				System.out.print((char)(i+65) + " ");
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
	}
}

public class C {
	public static void main(String[] args) {
		new A().start();
		new B().start();
	}
}
