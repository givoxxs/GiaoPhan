package Baithuchanh1;

class Animal {
	public void eat() {
		System.out.println("You are eating...");
	}
}

public class OverridingExample extends Animal{
	public void eat() {
		System.out.println("I am eating bread...");
	}
	
	public static void main(String a[]) {
		OverridingExample obj = new OverridingExample();
		obj.eat();
	}
}
