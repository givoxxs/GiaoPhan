// Minh họa cách dùng protected
package Cac_tinh_chat_OOP;

package a111;
	public class B3 {
		protected void method() { // Phương thức mặc định default
			System.out.println("Hello");
		}
	}

package a222;
import a111.*;

public class Text2 extends B3 {
	public static void main(String arg[]) {
		B3 obj = new B3(); // Compile Time Error
		obj.method();	 // Compile Time Error
	}
}

// kết quả hiển thị: Hello
