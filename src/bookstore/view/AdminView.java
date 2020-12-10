package bookstore.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.CardLayout;

public class AdminView extends JFrame {

	private JPanel bodyPanel;
	private JPanel mainPanel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Panel bookPanel;
	private Panel searchPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminView() {
		setTitle("Admin BookStore PurpleLane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 537);
		bodyPanel = new JPanel();
		bodyPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(bodyPanel);
		bodyPanel.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.GREEN);
		menuPanel.setBounds(10, 11, 879, 61);
		bodyPanel.add(menuPanel);
		menuPanel.setLayout(null);
		
		JLabel logo1Lbl = new JLabel("PurpleLane");
		logo1Lbl.setBounds(10, 5, 107, 25);
		logo1Lbl.setFont(new Font("Century", Font.ITALIC, 20));
		menuPanel.add(logo1Lbl);
		
		JLabel logo2Lbl = new JLabel("Bookstore");
		logo2Lbl.setBounds(49, 25, 92, 25);
		logo2Lbl.setFont(new Font("Century", Font.ITALIC, 20));
		menuPanel.add(logo2Lbl);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//remove Panel
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.revalidate();
				
				//add panel
				mainPanel.add(bookPanel);
				mainPanel.repaint();
				mainPanel.revalidate();
			}
		});
		btnMainMenu.setBounds(282, 11, 154, 39);
		menuPanel.add(btnMainMenu);
		
		JButton btnSearchMenu = new JButton("Search Book");
		btnSearchMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.revalidate();
				
				//add panel
				mainPanel.add(searchPanel);
				mainPanel.repaint();
				mainPanel.revalidate();
			}
		});
		btnSearchMenu.setBounds(477, 10, 154, 39);
		menuPanel.add(btnSearchMenu);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(10, 83, 879, 404);
		bodyPanel.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		searchPanel = new Panel();
		searchPanel.setLayout(null);
		searchPanel.setFont(new Font("Arial Black", Font.BOLD, 14));
		searchPanel.setBackground(new Color(60, 179, 113));
		mainPanel.add(searchPanel, "name_334905963095100");
		
		Label searchLabel = new Label("Search Menu");
		searchLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		searchLabel.setBounds(10, 10, 95, 45);
		searchPanel.add(searchLabel);
		
		Button btnSearch = new Button("Search");
		btnSearch.setBounds(707, 63, 143, 36);
		searchPanel.add(btnSearch);
		
		bookPanel = new Panel();
		bookPanel.setLayout(null);
		bookPanel.setBackground(new Color(255, 192, 203));
		mainPanel.add(bookPanel, "name_334925453067700");
		
		Label bookLabel = new Label("Books Menu");
		bookLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		bookLabel.setBounds(10, 10, 125, 24);
		bookPanel.add(bookLabel);
		
		Panel bookListPanel = new Panel();
		bookListPanel.setLayout(null);
		bookListPanel.setBackground(Color.WHITE);
		bookListPanel.setBounds(10, 40, 859, 354);
		bookPanel.add(bookListPanel);
		
		JScrollPane sp = new JScrollPane((Component) null);
		sp.setBounds(0, 0, 859, 195);
		bookListPanel.add(sp);
		
		Panel addToCartPanel = new Panel();
		addToCartPanel.setLayout(null);
		addToCartPanel.setBackground(Color.GRAY);
		addToCartPanel.setBounds(0, 195, 859, 159);
		bookListPanel.add(addToCartPanel);
		
		Button btnAddBook = new Button("Add New Book");
		btnAddBook.setActionCommand("Add New Book");
		btnAddBook.setBounds(191, 98, 125, 33);
		addToCartPanel.add(btnAddBook);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(114, 11, 167, 20);
		addToCartPanel.add(textField);
		
		JLabel productNameLbl = new JLabel("Product Name");
		productNameLbl.setForeground(Color.WHITE);
		productNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		productNameLbl.setBounds(10, 14, 94, 17);
		addToCartPanel.add(productNameLbl);
		
		JLabel productQtyLbl = new JLabel("Quantity");
		productQtyLbl.setForeground(Color.WHITE);
		productQtyLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		productQtyLbl.setBounds(10, 42, 72, 17);
		addToCartPanel.add(productQtyLbl);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(114, 42, 167, 20);
		addToCartPanel.add(textField_1);
		
		Button btnUpdateBook = new Button("Update Book");
		btnUpdateBook.setBounds(377, 98, 125, 33);
		addToCartPanel.add(btnUpdateBook);
		
		Button btnDeleteBook = new Button("Delete Book");
		btnDeleteBook.setBounds(570, 98, 125, 33);
		addToCartPanel.add(btnDeleteBook);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(405, 11, 167, 20);
		addToCartPanel.add(textField_2);
		
		JLabel lblProductAuthor = new JLabel("Product Author");
		lblProductAuthor.setForeground(Color.WHITE);
		lblProductAuthor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProductAuthor.setBounds(301, 14, 94, 17);
		addToCartPanel.add(lblProductAuthor);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(405, 42, 167, 20);
		addToCartPanel.add(textField_3);
		
		JLabel lblProductPrice = new JLabel("Product Price");
		lblProductPrice.setForeground(Color.WHITE);
		lblProductPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProductPrice.setBounds(301, 45, 94, 17);
		addToCartPanel.add(lblProductPrice);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(686, 11, 167, 20);
		addToCartPanel.add(textField_4);
		
		JLabel lblProductStock = new JLabel("Product Stock");
		lblProductStock.setForeground(Color.WHITE);
		lblProductStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProductStock.setBounds(582, 14, 94, 17);
		addToCartPanel.add(lblProductStock);
	}
}
