package bookstore.controller;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.Vector;

import bookstore.database.DatabaseMySql;
import bookstore.model.Product;
import bookstore.model.User;
import bookstore.view.AuthView;
import bookstore.view.HomeView;

public class HomeController {
	
//	private User model;
	private HomeView view;
	DatabaseMySql con;
	Vector<Product> products = new Vector<Product>();
	Vector<Object> result = new Vector<Object>();
	Product currentSelected;
	
	public Vector<Object> getAllProducts(){
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
				System.out.println(pd.productId);
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
	
	
	
	
	

}
