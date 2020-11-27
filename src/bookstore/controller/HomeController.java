package bookstore.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import bookstore.database.DatabaseMySql;
import bookstore.model.Coupon;
import bookstore.model.Product;
import bookstore.model.User;
import bookstore.view.AuthView;
import bookstore.view.HomeView;

public class HomeController {
	
//	private User model;
	private HomeView view;
	DatabaseMySql con;
	Vector<Product> products = new Vector<Product>();
	Vector<Object> result;
	Vector<Object> coupon;
	Vector<Object> cart = new Vector<Object>();
	User currentUser;
	Product currentSelected;
	
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
	
	public HomeController() {
		con = DatabaseMySql.getInstance();
	}
		
	public void viewAuthPage() {
		AuthView auth = new AuthView();
		auth.setVisible(true);
	}
	
	public void viewHomePage() {
		HomeView home = new HomeView();
		home.setVisible(true);
	}

	public boolean Login(String loginUsername, String loginPassword) {
		currentUser = new User(loginUsername, loginPassword);
		try {
			String sql = "SELECT * FROM `users` WHERE `userName` LIKE '"+loginUsername+"' AND `userPassword` LIKE '"+loginPassword+"'";		
			ResultSet rs = con.executeQuery(sql);
			if(rs.next()){
                if(loginUsername.equals(rs.getString("userName")) && loginPassword.equals(rs.getString("userPassword"))){             
                    return true;
                }
            }else{  	
            		return false;
                }
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public boolean Register(String regUsername, String regPassword, String regEmail) {
		try {
			String query = String.format("" 
					+ "INSERT INTO `users` (`userId`, `userName`, `userPassword`, `userRoleId`) "
					+ "VALUES (NULL, '%s', '%s', '4');", regUsername, regPassword);
			con.executeUpdate(query);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String findIdx(int idx) {
		currentSelected = products.get(idx);
		return currentSelected.productName;
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
				cart.add(pd.toObjects());
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
		return cart;
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

	
	
	
	
	

}
