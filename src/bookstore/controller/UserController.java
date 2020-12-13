package bookstore.controller;

import java.sql.ResultSet;
import java.util.Vector;

import bookstore.database.DatabaseMySql;
import bookstore.model.Transaction;
import bookstore.model.User;

public class UserController {
	
	Vector<User> users = new Vector<User>();
	Vector<Object> userResult;
	DatabaseMySql con;
	
	public UserController() {
		con = DatabaseMySql.getInstance();
	}
	
	public Vector<Object> getAllUser(){
		userResult = new Vector<Object>();
		ResultSet rs = con.executeQuery("SELECT * FROM users");
		try {
			while(rs.next()) {
				int userId = (int) rs.getObject(1);
				String userName = (String) rs.getObject(2);
				String userPassword = (String) rs.getObject(3);
				int userRoleId = (int) rs.getObject(4);
				User u = new User(userId, userName, userPassword, userRoleId);
				users.add(u);
				userResult.add(u.toObject());
			}
			return userResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
