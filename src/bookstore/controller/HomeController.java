package bookstore.controller;

import java.sql.ResultSet;

import bookstore.database.DatabaseMySql;
import bookstore.model.User;
import bookstore.view.AuthView;
import bookstore.view.HomeView;

public class HomeController {
	
//	private User model;
	private HomeView view;
	DatabaseMySql con;
	
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
	
	
	
	
	

}
