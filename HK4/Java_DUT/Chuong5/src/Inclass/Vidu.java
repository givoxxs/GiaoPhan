package Inclass;

public class Vidu {
	public static void main(String args[]) {
		System.out.println("Hello World");
		int a = 5;
		System.out.println("a: " + a);
		int c = ++a + ++a;
		System.out.println("c2: " + c);
		System.out.println(23  +  02 + "ZendVN" + 89);
		
		int yourAge = 20;
		String yourName = "hailan";
		System.out.printf("Born: %d, name: %s", 2022 - yourAge,  yourName);
		System.out.println();
		System.out.println(yourAge++ + "-" + (++yourAge * 2));	    
	    
	    String[] colors = {"Red", "Green", "Blue"};
	    String result = String.join(", ", colors);
	    System.out.println(result); // Output: Red, Green, Blue

	    String str = "ZendVN.com";
	    String word = "ok";
	    System.out.print(str.substring(0, 2) + word + str.substring(3));
	}
}
