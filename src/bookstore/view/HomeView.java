package bookstore.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bookstore.controller.HomeController;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.TableModel;

public class HomeView extends JFrame {

	private JPanel bodyPanel;
	private JPanel mainPanel;
	private Panel homePanel;
	private Panel bookPanel;
	private Panel cartPanel;
	private DefaultTableModel dtm;
	private DefaultTableModel jtm;
	private DefaultTableModel ctm;
	private HomeController home = new HomeController();
	Vector<Object> tHeader;
	Vector<Object> tHeadCoupon;
	Vector<Object> product;
	Vector<Object> cart;
	Vector<Object> coupon;
	JTable productTable;
	private JTextField productNameTextField;
	private JTextField cartTextField;
	private JTable cartTable;
	private JTextField quantityTextField;
	private Panel couponPanel;
	private JTable couponTable;
	private Panel transHistoryPanel;
	private int idCartChoose;
	private JTextField couponTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView frame = new HomeView();
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
	void getProduct() {
		product = null;
		dtm = new DefaultTableModel(tHeader, 0);
		product = home.getAllProducts();
		Enumeration<Object> enu = product.elements();
		while(enu.hasMoreElements()) {
			dtm.addRow((Vector<?>) enu.nextElement());
		}
		productTable.setModel(dtm);
	}
	
	void getCart() {
		jtm = new DefaultTableModel(tHeader, 0);
		cart = home.getAllCart();
		Enumeration<Object> crt = cart.elements();
		while(crt.hasMoreElements()){
			jtm.addRow((Vector<?>) crt.nextElement());
		}
		cartTable.setModel(jtm);
	}
	
	void getCoupon() {
		ctm = new DefaultTableModel(tHeadCoupon, 0);
		coupon = home.getAllCoupon();
		Enumeration<Object> cp = coupon.elements();
		while(cp.hasMoreElements()) {
			ctm.addRow((Vector<?>) cp.nextElement());
		}
		couponTable.setModel(ctm);
	}
	
	public HomeView() {
		defaultView();
	}
	
	void mainPanelAdmin() {
		
	};
	void mainPanelPromotionTeam() {};
	void mainPanelManager() {};
	
	
	void fillData() {
		int idx = productTable.getSelectedRow();
		String productName = home.findIdx(idx);
		productNameTextField.setText(productName);
	}
	
	void fillCart() {
		int idx = cartTable.getSelectedRow();
		idCartChoose = idx;
		Vector<String> cartObj = (Vector<String>) cart.get(idx);
		cartTextField.setText(cartObj.get(1));
	}
	
	void fillCoupon() {
		int idx = couponTable.getSelectedRow();
		Vector<String> couponObj = (Vector<String>) coupon.get(idx);
		couponTextField.setText(couponObj.get(1));
	}
	
	
	void defaultView() {
		setTitle("Aplikasi Bookstore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 516);
		bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(0, 206, 209));
		bodyPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		setContentPane(bodyPanel);
		bodyPanel.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		menuPanel.setBackground(new Color(186, 85, 211));
		menuPanel.setBounds(10, 11, 163, 459);
		bodyPanel.add(menuPanel);
		menuPanel.setLayout(null);
		
		Button btnHome = new Button("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//remove Panel
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.revalidate();
				
				//add panel
				mainPanel.add(homePanel);
				mainPanel.repaint();
				mainPanel.revalidate();
				
			}
		});
		btnHome.setBounds(10, 111, 143, 36);
		menuPanel.add(btnHome);
		
		Button btnBook = new Button("Books");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		btnBook.setBounds(10, 165, 143, 36);
		menuPanel.add(btnBook);
		
		Button btnCart = new Button("Cart");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove Panel
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.revalidate();
				
				//add panel
				mainPanel.add(cartPanel);
				mainPanel.repaint();
				mainPanel.revalidate();
			}
		});
		btnCart.setBounds(10, 216, 143, 36);
		menuPanel.add(btnCart);
		
		Button btnLogout = new Button("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogBtn = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah yakin ingin logged out ?", "Peringatan", dialogBtn);
				
				if(dialogResult==0) {
					//True balik ke auth view
					dispose();
					AuthView a = new AuthView();
					a.setVisible(true);
				}else {
					//False tidak ingin keluar				
				}
			}
		});
		btnLogout.setBounds(10, 377, 143, 36);
		menuPanel.add(btnLogout);
		
		JLabel logo1Lbl = new JLabel("PurpleLane");
		logo1Lbl.setFont(new Font("Century", Font.ITALIC, 20));
		logo1Lbl.setBounds(10, 0, 115, 50);
		menuPanel.add(logo1Lbl);
		
		JLabel logo2Lbl = new JLabel("Bookstore");
		logo2Lbl.setFont(new Font("Century", Font.ITALIC, 20));
		logo2Lbl.setBounds(58, 36, 95, 25);
		menuPanel.add(logo2Lbl);
		
		Button btnCoupon = new Button("Coupon");
		btnCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove Panel
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.revalidate();
				
				//add panel
				mainPanel.add(couponPanel);
				mainPanel.repaint();
				mainPanel.revalidate();
			}
		});
		btnCoupon.setBounds(10, 270, 143, 36);
		menuPanel.add(btnCoupon);
		
		Button btnTransactionHistory = new Button("Transaction History");
		btnTransactionHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove Panel
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.revalidate();
				
				//add panel
				mainPanel.add(transHistoryPanel);
				mainPanel.repaint();
				mainPanel.revalidate();
			}
		});
		btnTransactionHistory.setBounds(10, 323, 143, 36);
		menuPanel.add(btnTransactionHistory);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0, 255, 255));
		mainPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		mainPanel.setBounds(183, 11, 644, 459);
		bodyPanel.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		homePanel = new Panel();
		homePanel.setFont(new Font("Arial Black", Font.BOLD, 14));
		homePanel.setBackground(new Color(60, 179, 113));
		mainPanel.add(homePanel, "name_880672469796400");
		homePanel.setLayout(null);
		
		Label menuLabel = new Label("MENU HOME");
		menuLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuLabel.setBounds(10, 10, 95, 45);
		homePanel.add(menuLabel);
		
		Button btnAbout = new Button("About");
		btnAbout.setBounds(242, 369, 143, 36);
		homePanel.add(btnAbout);
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutView n = new AboutView();
				n.setVisible(true);
			}
		});
		
		bookPanel = new Panel();
		bookPanel.setBackground(new Color(255, 192, 203));
		mainPanel.add(bookPanel, "name_881002896137600");
		bookPanel.setLayout(null);
		
		Label bookLabel = new Label("Books Menu");
		bookLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		bookLabel.setBounds(10, 10, 125, 38);
		bookPanel.add(bookLabel);
		
		Panel bookListPanel = new Panel();
		bookListPanel.setBackground(Color.WHITE);
		bookListPanel.setBounds(10, 50, 620, 395);
		bookPanel.add(bookListPanel);
		
		tHeader = new Vector<>();
		tHeader.add("ProductId");
		tHeader.add("ProductName");
		tHeader.add("ProductAuthor");
		tHeader.add("ProductPrice");
		tHeader.add("ProductStock");
		dtm = new DefaultTableModel(tHeader, 0);
		bookListPanel.setLayout(null);
		productTable = new JTable(dtm);
		productTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getSource() == productTable) fillData();
			}
		});
		JScrollPane sp = new JScrollPane(productTable);
		sp.setBounds(0, 0, 620, 298);
		
		bookListPanel.add(sp);
		
		
		Panel addToCartPanel = new Panel();
		addToCartPanel.setBackground(Color.GRAY);
		addToCartPanel.setBounds(0, 304, 620, 91);
		bookListPanel.add(addToCartPanel);
		addToCartPanel.setLayout(null);
		
		Button btnAddToCart = new Button("Add To Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productName = productNameTextField.getText();
				String qty = quantityTextField.getText();
				if(qty.equals("")) qty = "0";  
					int productQty = Integer.parseInt(qty);
				// if productQty < productQty di list jalan
		
					if(home.checkQty(productName,productQty)) {
						home.addToCart(productName, productQty);
						productNameTextField.setText("");
						quantityTextField.setText("");
						getCart();
						getProduct();
					}else if(productQty == 0) {
						JOptionPane.showMessageDialog(btnAddToCart, "Jumlah tidak bisa kosong atau nol :(");
					}else {
						JOptionPane.showMessageDialog(btnAddToCart, "Jumlah stock tidak bisa lebih banyak :(");
					}
			}
		});
		btnAddToCart.setBounds(236, 48, 125, 33);
		addToCartPanel.add(btnAddToCart);
		
		productNameTextField = new JTextField();
		productNameTextField.setBounds(114, 11, 167, 20);
		addToCartPanel.add(productNameTextField);
		productNameTextField.setColumns(10);
		
		JLabel productNameLbl = new JLabel("Product Name");
		productNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		productNameLbl.setForeground(Color.WHITE);
		productNameLbl.setBounds(10, 14, 94, 17);
		addToCartPanel.add(productNameLbl);
		
		JLabel productQtyLbl = new JLabel("Quantity");
		productQtyLbl.setForeground(Color.WHITE);
		productQtyLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		productQtyLbl.setBounds(331, 12, 72, 17);
		addToCartPanel.add(productQtyLbl);
		
		quantityTextField = new JTextField();
		quantityTextField.setColumns(10);
		quantityTextField.setBounds(413, 11, 167, 20);
		addToCartPanel.add(quantityTextField);
		
		cartPanel = new Panel();
		cartPanel.setBackground(new Color(119, 136, 153));
		mainPanel.add(cartPanel, "name_881133832908100");
		cartPanel.setLayout(null);
		
		Label cartLabel = new Label("List of your cart");
		cartLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		cartLabel.setBounds(10, 10, 183, 50);
		cartPanel.add(cartLabel);
		
		Panel cartListPanel = new Panel();
		cartListPanel.setLayout(null);
		cartListPanel.setBackground(Color.WHITE);
		cartListPanel.setBounds(10, 59, 620, 386);
		cartPanel.add(cartListPanel);
		
		Panel deleteItemPanel = new Panel();
		deleteItemPanel.setLayout(null);
		deleteItemPanel.setBackground(Color.GRAY);
		deleteItemPanel.setBounds(0, 297, 620, 98);
		cartListPanel.add(deleteItemPanel);
		
		Button btnDeleteItem = new Button("Delete Item");
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean delete = home.deleteCart(idCartChoose);
				if(delete == true) {
					JOptionPane.showMessageDialog(btnDeleteItem, "Delete item from cart success !");
					cartTextField.setText("");
					getCart();
				}else {
					JOptionPane.showMessageDialog(btnDeleteItem, "No Item right there :(");
				}
				
			}
		});
		btnDeleteItem.setBounds(325, 37, 125, 33);
		deleteItemPanel.add(btnDeleteItem);
		
		cartTextField = new JTextField();
		cartTextField.setColumns(10);
		cartTextField.setBounds(215, 11, 192, 20);
		deleteItemPanel.add(cartTextField);
		
		Button btnCheckout = new Button("Checkout");
		btnCheckout.setBounds(174, 37, 125, 33);
		deleteItemPanel.add(btnCheckout);
		
		jtm = new DefaultTableModel(tHeader, 0);
		cartTable = new JTable(dtm);
		cartTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getSource() == cartTable) fillCart();
			}
		});
		
		
		JScrollPane sp_cart = new JScrollPane(cartTable);
		sp_cart.setBounds(0, 0, 620, 298);
		cartListPanel.add(sp_cart);
		
		tHeadCoupon = new Vector<>();
		tHeadCoupon.add("Coupon ID");
		tHeadCoupon.add("Coupon Code");
		tHeadCoupon.add("Coupon Discount");
		tHeadCoupon.add("Coupon Note");
		ctm = new DefaultTableModel(tHeadCoupon, 0);
		couponTable = new JTable(ctm);
		couponTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getSource() == couponTable) fillCoupon();
			}
		});
		
		couponPanel = new Panel();
		couponPanel.setLayout(null);
		couponPanel.setBackground(Color.ORANGE);
		mainPanel.add(couponPanel, "name_97394224460200");
		
		Label couponLabel = new Label("Available Coupon");
		couponLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		couponLabel.setBounds(10, 10, 183, 50);
		couponPanel.add(couponLabel);
		
		Panel couponListPanel = new Panel();
		couponListPanel.setLayout(null);
		couponListPanel.setBackground(Color.WHITE);
		couponListPanel.setBounds(10, 59, 620, 386);
		couponPanel.add(couponListPanel);
		
		Panel couponSettingPanel = new Panel();
		couponSettingPanel.setLayout(null);
		couponSettingPanel.setBackground(Color.GRAY);
		couponSettingPanel.setBounds(0, 297, 620, 98);
		couponListPanel.add(couponSettingPanel);
		
		Button btnUseCoupon = new Button("Use Coupon");
		btnUseCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String couponCode = couponTextField.getText();
				boolean useCoupon = home.useCoupon(couponCode);
				if(useCoupon == true) {
					JOptionPane.showMessageDialog(btnUseCoupon, "Use coupon successfull !");
					couponTextField.setText("");
				}else {
					JOptionPane.showMessageDialog(btnUseCoupon, "Use coupon failed !");
				}
			}
		});
		btnUseCoupon.setBounds(230, 46, 140, 28);
		couponSettingPanel.add(btnUseCoupon);
		
		couponTextField = new JTextField();
		couponTextField.setBounds(230, 11, 140, 20);
		couponSettingPanel.add(couponTextField);
		couponTextField.setColumns(10);
		
		JScrollPane sp_coupon = new JScrollPane(couponTable);
		sp_coupon.setBounds(0, 0, 620, 301);
		couponListPanel.add(sp_coupon);
		
		transHistoryPanel = new Panel();
		transHistoryPanel.setLayout(null);
		transHistoryPanel.setBackground(Color.CYAN);
		mainPanel.add(transHistoryPanel, "name_133508683103399");
		
		Label transLabel = new Label("Transaction History");
		transLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		transLabel.setBounds(10, 10, 183, 50);
		transHistoryPanel.add(transLabel);
		
		Panel historyListPanel = new Panel();
		historyListPanel.setLayout(null);
		historyListPanel.setBackground(Color.WHITE);
		historyListPanel.setBounds(10, 59, 620, 386);
		transHistoryPanel.add(historyListPanel);
		
		Panel historySettingPanel = new Panel();
		historySettingPanel.setLayout(null);
		historySettingPanel.setBackground(Color.PINK);
		historySettingPanel.setBounds(0, 297, 620, 98);
		historyListPanel.add(historySettingPanel);
		
		JScrollPane sp_transactionHistory = new JScrollPane((Component) null);
		sp_transactionHistory.setBounds(0, 0, 620, 301);
		historyListPanel.add(sp_transactionHistory);
		
		getCoupon();
		getProduct();
	}
}
