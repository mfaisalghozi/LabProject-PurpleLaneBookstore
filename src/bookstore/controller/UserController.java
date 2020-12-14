package bookstore.controller;

import java.sql.ResultSet;
import java.util.Vector;

import bookstore.database.DatabaseMySql;
import bookstore.model.Transaction;
import bookstore.model.User;

public class UserController {
	
	Vector<User> users;
	User findUser;
	Vector<Object> userResult;
	Vector<Object> foundUser;
	DatabaseMySql con;
	
	public UserController() {
		con = DatabaseMySql.getInstance();
	}
	
	public Vector<Object> getAllUser(){
		userResult = new Vector<Object>();
		users = new Vector<User>();
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
	
	public Vector<Object> foundUser(int idx){
		foundUser = new Vector<Object>();
		findUser = users.get(idx);
		foundUser.add(findUser.userId);
		foundUser.add(findUser.username);
		foundUser.add(findUser.password);
		foundUser.add(findUser.roleId);
		
		return foundUser;
	}
	
	
	public void addStaff(int userId, int roleId, String username, String password) {
		String query = String.format(""
				+ "INSERT INTO users VALUES "
				+ "(%d,'%s','%s',%d)", userId, username, password, roleId);
		con.executeUpdate(query);
	}
	
	public void updateStaff(int userId, int roleId, String username, String password) {
		String query = String.format(""
				+ "UPDATE users "
				+ "SET userRoleId = %d,"
				+ "userName = '%s',"
				+ "userPassword = '%s' "
				+ "WHERE userId = %d", roleId, username, password, userId);
		con.executeUpdate(query);
	}
	
	public void deleteStaff(int userId) {
		String query = String.format(""
				+ "DELETE FROM users "
				+ "WHERE userId = %d", userId);
		con.executeUpdate(query);
	}
}
