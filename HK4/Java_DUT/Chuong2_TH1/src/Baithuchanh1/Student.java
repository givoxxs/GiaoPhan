package Baithuchanh1;

public class Student {
	int 	id;
	String 	name;
	
	public void chen(int id, String name) {
		this.id = id; 		this.name = name;
	}
	
	public void thaydoi(int id, String name) {
		this.name = name;
	}
	
	public void hienthi() {
		System.out.println(id + "" + name);
	}
	
	public static void main(String []tui) {
		Student		sv1 = new Student();
		Student		sv2 = new Student();
		sv1.chen(1,"TueNhi"); sv2.chen(2, "Minh");
		sv2.thaydoi(2,"TueNghi");		sv1.hienthi();	  sv2.hienthi();
	}
}
