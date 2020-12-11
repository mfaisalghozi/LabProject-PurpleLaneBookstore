package bookstore.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bookstore.controller.BookController;
import bookstore.controller.HomeController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;

public class AdminView extends JFrame {

	private JPanel bodyPanel;
	private JPanel mainPanel;
	private JTextField productNameTxtField;
	private JTextField productIdTxtField;
	private JTextField productAuthorTxtField;
	private JTextField productPriceTxtField;
	private JTextField productStockTxtField;
	private Panel bookPanel;
	private Panel searchPanel;
	Vector<Object> foundBook;
	Vector<Object> tHeader;
	Vector<Object> book;
	Vector<String> bookFound;
	private DefaultTableModel dtm;
	JTable bookTable;
	private HomeController home;
	private static int userId;
	private static String username;
	private static String password;
	private BookController bc;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView(userId, username, password);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void getBook() {
		book = null;
		dtm = new DefaultTableModel(tHeader, 0);
		book = home.getAllProducts();
		Enumeration<Object> enu = book.elements();
		while(enu.hasMoreElements()) {
			dtm.addRow((Vector<?>) enu.nextElement());
		}
		bookTable.setModel(dtm);
	}
	
	void fillBook() {
		int idx = bookTable.getSelectedRow();
		foundBook = home.findIdx(idx);
		int productId = (int) foundBook.get(1);
		String productName = (String) foundBook.get(0);
		String productAuthor = (String) foundBook.get(4);
		BigInteger productPrice = (BigInteger) foundBook.get(3);
		int productStock = (int) foundBook.get(2);
		
		productNameTxtField.setText(productName);
		productIdTxtField.setText("" + productId);
		productAuthorTxtField.setText(productAuthor);
		productPriceTxtField.setText("" + productPrice);
		productStockTxtField.setText("" + productStock);
	}
	
	
	/**
	 * Create the frame.
	 */
	public AdminView(int userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		home = new HomeController(userId, username, password);
		bc = new BookController();
		defaultView();
	}
	
	void defaultView() {
		setTitle("Admin BookStore PurpleLane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 539);
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
		
		tHeader = new Vector<>();
		tHeader.add("ProductId");
		tHeader.add("ProductName");
		tHeader.add("ProductAuthor");
		tHeader.add("ProductPrice");
		tHeader.add("ProductStock");
		dtm = new DefaultTableModel(tHeader, 0);
		bookListPanel.setLayout(null);
		bookTable = new JTable(dtm);
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getSource() == bookTable) fillBook();
			}
		});
		
		JScrollPane sp = new JScrollPane(bookTable);
		sp.setBounds(0, 0, 859, 195);
		bookListPanel.add(sp);
		
		Panel addToCartPanel = new Panel();
		addToCartPanel.setLayout(null);
		addToCartPanel.setBackground(Color.GRAY);
		addToCartPanel.setBounds(0, 195, 859, 159);
		bookListPanel.add(addToCartPanel);
		
		Button btnAddBook = new Button("Add New Book");
		btnAddBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int productId = Integer.parseInt(productIdTxtField.getText());
				String productName = productNameTxtField.getText();
				String productAuthor = productAuthorTxtField.getText();
				int productPrice = Integer.parseInt(productPriceTxtField.getText());
				int productStock = Integer.parseInt(productStockTxtField.getText());
				
				bc.insertBook(productId, productName, productAuthor, productPrice, productStock);
				getBook();
			}
		});
		btnAddBook.setActionCommand("Add New Book");
		btnAddBook.setBounds(191, 98, 125, 33);
		addToCartPanel.add(btnAddBook);
		
		productNameTxtField = new JTextField();
		productNameTxtField.setColumns(10);
		productNameTxtField.setBounds(114, 11, 167, 20);
		addToCartPanel.add(productNameTxtField);
		
		JLabel productNameLbl = new JLabel("Product Name");
		productNameLbl.setForeground(Color.WHITE);
		productNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		productNameLbl.setBounds(10, 14, 94, 17);
		addToCartPanel.add(productNameLbl);
		
		JLabel productIdLbl = new JLabel("Product ID");
		productIdLbl.setForeground(Color.WHITE);
		productIdLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		productIdLbl.setBounds(10, 42, 72, 17);
		addToCartPanel.add(productIdLbl);
		
		productIdTxtField = new JTextField();
		productIdTxtField.setColumns(10);
		productIdTxtField.setBounds(114, 42, 167, 20);
		addToCartPanel.add(productIdTxtField);
		
		Button btnUpdateBook = new Button("Update Book");
		btnUpdateBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int productId = Integer.parseInt(productIdTxtField.getText());
				String productName = productNameTxtField.getText();
				String productAuthor = productAuthorTxtField.getText();
				int productPrice = Integer.parseInt(productPriceTxtField.getText());
				int productStock = Integer.parseInt(productStockTxtField.getText());
								
				bc.updateBook(productId, productName, productAuthor, productPrice, productStock);
				getBook();
			}
		});
		btnUpdateBook.setBounds(377, 98, 125, 33);
		addToCartPanel.add(btnUpdateBook);
		
		Button btnDeleteBook = new Button("Delete Book");
		btnDeleteBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int productId = Integer.parseInt(productIdTxtField.getText());
								
				bc.deleteBook(productId);
				getBook();
			}
		});
		btnDeleteBook.setBounds(570, 98, 125, 33);
		addToCartPanel.add(btnDeleteBook);
		
		productAuthorTxtField = new JTextField();
		productAuthorTxtField.setColumns(10);
		productAuthorTxtField.setBounds(405, 11, 167, 20);
		addToCartPanel.add(productAuthorTxtField);
		
		JLabel lblProductAuthor = new JLabel("Product Author");
		lblProductAuthor.setForeground(Color.WHITE);
		lblProductAuthor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProductAuthor.setBounds(301, 14, 94, 17);
		addToCartPanel.add(lblProductAuthor);
		
		productPriceTxtField = new JTextField();
		productPriceTxtField.setColumns(10);
		productPriceTxtField.setBounds(405, 42, 167, 20);
		addToCartPanel.add(productPriceTxtField);
		
		JLabel lblProductPrice = new JLabel("Product Price");
		lblProductPrice.setForeground(Color.WHITE);
		lblProductPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProductPrice.setBounds(301, 45, 94, 17);
		addToCartPanel.add(lblProductPrice);
		
		productStockTxtField = new JTextField();
		productStockTxtField.setColumns(10);
		productStockTxtField.setBounds(686, 11, 167, 20);
		addToCartPanel.add(productStockTxtField);
		
		JLabel lblProductStock = new JLabel("Product Stock");
		lblProductStock.setForeground(Color.WHITE);
		lblProductStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProductStock.setBounds(582, 14, 94, 17);
		addToCartPanel.add(lblProductStock);
		
		getBook();
	}
	
}
