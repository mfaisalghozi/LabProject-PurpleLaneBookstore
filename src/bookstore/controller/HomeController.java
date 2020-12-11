package bookstore.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import java.sql.Date;

import bookstore.database.DatabaseMySql;
import bookstore.model.Coupon;
import bookstore.model.Product;
import bookstore.model.Transaction;
import bookstore.model.User;
import bookstore.view.AuthView;
import bookstore.view.HomeView;


public class HomeController {
	
//	private User model;
	private HomeView view;
	DatabaseMySql con;
	Vector<Product> products = new Vector<Product>();
	Vector<Object> result;
	Vector<Transaction> trans = new Vector<Transaction>();
	Vector<Object> transResult;
	Vector<Object> coupon;
	Vector<Product> cartCheckout = new Vector<Product>();
	Vector<Object> carts = new Vector<Object>();
	Product currentSelected;
	Product currentCart;
	Coupon currentCoupon;
	User currentUser;
	Vector<Object> found;
	
	public Vector<Object> getAllTransaction(int userId) {
		transResult = new Vector<Object>();
		ResultSet rs = con.executeQuery("SELECT * FROM transactions WHERE userId = " + userId);
		try {
			while(rs.next()) {
				int productId = (int) rs.getObject(2);
				int transactionId = (int) rs.getObject(4);
				int transactionQty = (int) rs.getObject(6);
				String transactionType = (String) rs.getObject(7);
				Long transactionCardNumb = (Long) rs.getObject(8);
				
				Transaction ts = new Transaction(productId, transactionId, transactionQty, transactionType, transactionCardNumb);
				trans.add(ts);
				transResult.add(ts.toObjects());
			}
			return transResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Vector<Object> getAllProducts(){
		result = new Vector<Object>();
		ResultSet rs = con.executeQuery("SELECT * FROM products");
		try {
			while(rs.next()) {
				int productId = (int) rs.getObject(1);
				String productName = (String) rs.getObject(2);
				String productAuthor = (String) rs.getObject(3);
				BigInteger productPrice = (BigInteger) rs.getObject(4);
				int productStock = (int) rs.getObject(5);
				
				Product pd = new Product(productId, productName, productAuthor, productPrice, productStock);
				products.add(pd);
				result.add(pd.toObjects());
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HomeController(int userId, String username, String password) {
		currentUser = new User(userId, username, password);
		con = DatabaseMySql.getInstance();
	}
		
	public void viewAuthPage() {
		AuthView auth = new AuthView();
		auth.setVisible(true);
	}
	
//	public void viewHomePage() {
//		HomeView home = new HomeView();
//		home.setVisible(true);
//	}
	
	public Vector<Object> findIdx(int idx) {
		found = new Vector<Object>();
		currentSelected = products.get(idx);
		found.add(currentSelected.productName);
		found.add(currentSelected.productId);
		found.add(currentSelected.productStock);
		found.add(currentSelected.productPrice);
		found.add(currentSelected.productAuthor);
		
		return found;
	}

	public void addToCart(String productNameField, int productQty) {
		ResultSet rs = con.executeQuery("SELECT * FROM `products` WHERE `productName` LIKE '"+productNameField+"'");
		try {
			if(rs.next()) {
				int productId = (int) rs.getObject(1);
				String productName = (String) rs.getObject(2);
				String productAuthor = (String) rs.getObject(3);
				BigInteger productPrice = (BigInteger) rs.getObject(4);
				int productStock = (int) rs.getObject(5);
				productStock = productStock - productQty;
				if(productStock == 0) {
					deleteItem(productId);
				}else {
					updateItem(productId, productStock);
				}
				Product pd = new Product(productId, productName, productAuthor, productPrice, productQty);
				cartCheckout.add(pd);
				carts.add(pd.toObjects());
				System.out.println("Add a product success !");
			}else {
				System.out.println("Product incorrect or out of stock !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void updateItem(int productId,int productStock) {
		String query = String.format(""
				+ "UPDATE products "
				+ "SET productStock = %d "
				+ "WHERE productId = %d", productStock, productId);
		con.executeUpdate(query);
	}
	
	public void deleteItem(int productId) {
		String query = String.format("" 
				+ "DELETE FROM products "
				+ "WHERE productId = '%s'", productId);
		con.executeUpdate(query);
	}
	
	public Vector<Object> getAllCart() {
		return carts;
	}

	public boolean checkQty(String productNameField,int productQty) {
		ResultSet rs = con.executeQuery("SELECT * FROM `products` WHERE `productName` LIKE '"+productNameField+"'");
		try {
			if(rs.next()) {
				int productStock = (int) rs.getObject(5);
				if(productQty == 0) {
					return false;
				}else if(productQty <= productStock) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Vector<Object> getAllCoupon() {
		coupon = new Vector<Object>();
		ResultSet rs = con.executeQuery("SELECT * FROM coupons");
		try {
			while(rs.next()) {
				int couponId = (int) rs.getObject(1);
				String couponCode = (String) rs.getObject(2);
				Long couponDiscount = (Long) rs.getObject(3);
				String couponNote = (String) rs.getObject(4);
				
				Coupon cp = new Coupon(couponId, couponCode, couponDiscount, couponNote); 
				coupon.add(cp.toObjects());
			}
			return coupon;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteCart(int idx) {
		try {
			//remove in cartCheckout too bro !
			cartCheckout.remove(idx);
			carts.remove(idx);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean useCoupon(String couponCodeText) {
		if(currentCoupon == null) {
			ResultSet rs = con.executeQuery("SELECT * FROM `coupons` WHERE `couponCode` LIKE '"+couponCodeText+"'");
			try {
				if(rs.next()) {
					int couponId = (int) rs.getObject(1);
					String couponCode = (String) rs.getObject(2);
					Long couponDiscount = (Long) rs.getObject(3);
					String couponNote = (String) rs.getObject(4);
		
					currentCoupon = new Coupon(couponId, couponCode, couponDiscount, couponNote);
					System.out.println("Use Coupon Success !");
					return true;
				}else {
					System.out.println("Coupon is invalide");
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}	
		}
		else {
			return false;
		}
		
	}

	public boolean createTransaction(int idx, String paymentType) {
		
		//FLOW
		//0. check if there is a product in cart, if no reject it
		//1. User Checkout (Only Selected Product WIll Be CheckOut)
		//2. Create transaction by inserting to db all product in cart and create per collumn
		//3. Deleting cart list, and refresh the page
		//4. send success notification
		
		
		if(carts.isEmpty() == false) {			
			currentCart = cartCheckout.get(idx);
			
			int userId = currentUser.userId;
			int productId = currentCart.productId;
			int transactionQty = currentCart.productStock;
			int couponId = 1;
			String transactionType = paymentType; //CHOOSE DEBIT OR CREDIT
			Long transactionCardNumb = (long) 491673512; //INPUT CARD NUMBER
			
			if(currentCoupon != null) {
				couponId = currentCoupon.couponId;
			}
			
			String query = String.format(""
					+"INSERT INTO transactions(userId, productId, couponId, transactionQty, transactionType, transactionCardNumber) VALUES "
					+"(%d, %d, %d, %d, '%s', %d)", userId, productId, couponId, transactionQty, transactionType, transactionCardNumb);
			con.executeUpdate(query);
			return true;
		}else {
			System.out.println("cartnya kosong");
			return false;
		}
		
	}

	
	
	
	
	

}
