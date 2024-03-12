// Minh họa cách sử dụng PRIVATE
package Cac_tinh_chat_OOP;

class B {
	private int attrribute = 70;
	private void method() {
		System.out.println("Hello you!");
	}
}

public class Text1 {
	public static void main(String args[]) {
		B obj = new B();
		System.out.println(obj.attribute); // Compile Time Error
		obj.method(); // Compile Time Error
	}
}
