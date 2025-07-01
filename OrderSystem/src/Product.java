
public class Product {
	private int id;
	private String name;
	private double price;
	//Constructor
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	//getter
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return id + " " + name + " - " + price + "USD";
	}
}
