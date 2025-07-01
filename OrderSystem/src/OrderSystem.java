import java.awt.Menu;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderSystem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//The list holding the products in the menu
		ArrayList<Product> menu = new ArrayList<>();
		menu.add(new Product(1, "Spicy McCrispy", 5.49));
		menu.add(new Product(2, "Big Mac", 5.29));
		menu.add(new Product(3, "Chicken McNuggets", 2.99));
		menu.add(new Product(4, "Chicken Big Mac", 5.99));
		menu.add(new Product(5, "Iced Coffee", 2.19));
		
		//List holding orders
		ArrayList<OrderItem> orders = new ArrayList<>();
		
		while(true) {
			System.out.println("\n=== Order System ===");
			System.out.println("1. Show Menu");
			System.out.println("2. Order");
			System.out.println("3. Show Orders");
			System.out.println("4. Make Payment");
			System.out.println("5. Exit");
			
			String selection = scanner.nextLine();
			
			switch (selection) {
				case "1": {
					System.out.println("\n--- Menu ---");
					for (Product product : menu) {
						System.out.println(product);
					}
				}
				case "2": {
					System.out.print("Please enter a product ID: ");
					int id = Integer.parseInt(scanner.nextLine());
					Product selected = null;
					
					//Find Products According to ID
					for (Product item : menu) {
						if (item.getID() == id) {
							selected = item;
							break;
						}
					}
					
					if (selected == null) {
						System.out.println("Wrong product ID...");
						break;
					}
					
					System.out.print("How many quantity do you want? ");
					int quantity = Integer.parseInt(scanner.nextLine());
					
					orders.add(new OrderItem(selected, quantity));
					System.out.println("Order added: " + selected.getName() + " x " + quantity);
					break;
				}
				case "3": {
					if (orders.isEmpty()) {
						System.out.println("Orders is empty...");
					} else {
						System.out.println("\n--- Orders ---");
						double total = 0;
						
						for (OrderItem item : orders) {
							System.out.println(item);
							total += item.getTotalPrice();
						}
						System.out.println("Total: " + total + " USD");
					}
					break;
				}
				case "4": {
					if (orders.isEmpty()) {
						System.out.println("Orders is empty...");
					} else {
						double total = 0;
						for (OrderItem item : orders) {
							total += item.getTotalPrice();
						}
						System.out.println("Total price: " + total + "USD");
						System.out.println("Payment was received. Thank you!");
						orders.clear();
					}
					break;
				}
				case "5": {
					System.out.println("Exit...");
					return;
				}
				default:
					System.out.println("Invalid transaction...");
				}
		}
	}

}
