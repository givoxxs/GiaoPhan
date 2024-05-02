package me.hitoan.model;

public class Cart extends Product{
	private int quantity;

	public Cart() {}

//	public Cart(int id, String name, String category, String price, String image, int quantity) {
//		super(id, name, category, price, image);
//		this.quantity = quantity;
//	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
