package Baithuchanh1;

public class OverloadingCalculation1 {
	void sum(int a, int b) {
		System.out.println(a + b);
	}
	
	void sum(double a, double b) {
		System.out.println(a + b);
	}
	
	void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}
	public static void main(String arg[]) {
		OverloadingCalculation1 obj = new OverloadingCalculation1();
		obj.sum(2, 2);
		obj.sum(5.0, 5.5);
		obj.sum(3, 3, 3);
	}
}
