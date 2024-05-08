// MultiThread class extends Thread class 
// and overrides run() method.
// Syn class has a method display() with synchronized block.
package Example_Thread;

class Syn {
	public void display() {
		for (int i=1; i<10; i+=2) {
			System.out.print(i + " ");
			try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
		}
	}
}

public class MultiThread extends Thread {
	static Syn a = new Syn();
	public void run() {
		synchronized (a) {
			a.display();
		}
	}
	public static void main(String[] args) {
		MultiThread t1 = new MultiThread();
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		
		MultiThread t2 = new MultiThread();
		t2.setPriority(Thread.MIN_PRIORITY);
		t2.start();
	}
}
