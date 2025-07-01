import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class OrderSystemGUI extends JFrame {
	private ArrayList<Product> menu;
	private ArrayList<OrderItem> orders;
	private JTextArea orderArea;
	private JLabel totalTag;
	
	public OrderSystemGUI() {
		setTitle("Order System");
		setSize(500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		menu = new ArrayList<>();
		orders = new ArrayList<>();
		
		//The list holding the products in the menu
		menu.add(new Product(1, "Spicy McCrispy", 5.49));
		menu.add(new Product(2, "Big Mac", 5.29));
		menu.add(new Product(3, "Chicken McNuggets", 2.99));
		menu.add(new Product(4, "Chicken Big Mac", 5.99));
		menu.add(new Product(5, "Iced Coffee", 2.19));
		
		//GUI Panels
		JPanel menuPanel = new JPanel(new GridLayout(0, 2, 10, 10));
		menuPanel.setBorder(BorderFactory.createTitledBorder("MENU"));
		menuPanel.setPreferredSize(new Dimension(400, 200));
		
		for (Product item : menu) {
			JButton button = new JButton(item.getName() + " (" + item.getPrice() + " USD) ");
			button.addActionListener(e -> addOrder(item));
			menuPanel.add(button);
		}
		
		orderArea = new JTextArea(10, 40);
		orderArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(orderArea);
		
		totalTag = new JLabel("Total: 0 USD");
		
		JButton paymentButton = new JButton("PAYMENT");
		paymentButton.addActionListener(e -> payment());
		
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(totalTag, BorderLayout.WEST);
		bottomPanel.add(paymentButton, BorderLayout.EAST);
		
		//Main panel
		setLayout(new BorderLayout());
		add(menuPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	private void addOrder(Product selected) {
		boolean finded = false;
		
		for (OrderItem item : orders) {
			if (item.getProduct().getID() == selected.getID()) {
				item.setQuantity(item.getQuantity() + 1);
				finded = true;
				break;
			}
		}
		
		if (!finded) {
			orders.add(new OrderItem(selected, 1));
		}
		
		orderUpdate();
	}
	
	private void orderUpdate() {
		StringBuilder sb = new StringBuilder();
		double total = 0;
		
		for (OrderItem item : orders) {
			sb.append(item.toString()).append("\n");
			total += item.getTotalPrice();
		}
		
		orderArea .setText(sb.toString());
		totalTag.setText("Total: " + total + "USD");
	}
	
	private void payment() {
		if (orders.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Order list is empty!");
			return;
		}
		
		double total = 0;
		for (OrderItem item : orders) {
			total += item.getTotalPrice();
		}
		
		JOptionPane.showMessageDialog(this, "Payment has been received! Total: " + total + " USD");
		orders.clear();
		orderUpdate();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new OrderSystemGUI());
	}
}
