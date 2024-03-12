// Minh họa cách dùng default
package Cac_tinh_chat_OOP;

package a111;
	class B2 {
		void method() { // Phương thức mặc định default
			System.out.println("Hello");
		}
	}

package a222;
import a111.*;

public class Text2 {
	public static void main(String arg[]) {
		B2 obj = new B2(); // Compile Time Error
		obj.method();	 // Compile Time Error
	}
}
