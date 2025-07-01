
public class OrderItem {
	private Product product;
	private int quantity;
	
	//Constructor
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	//Getter
	public Product getProduct() {
		return product;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	
	//Price calculating
	public double getTotalPrice() {
		return product.getPrice() * quantity;
	}
	
	//Order details
	@Override
	public String toString() {
		return product.getName() + " x " + quantity + " = " + getTotalPrice() + "USD";
	}
}
