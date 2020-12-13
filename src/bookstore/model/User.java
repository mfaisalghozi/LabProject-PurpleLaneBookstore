package bookstore.model;

import java.util.Vector;

public class User {
	
	public int userId;
	private int roleId;
	public String username;
	public String password;
	
	public User(int userId, String loginUsername, String loginPassword) {
		this.userId = userId;
		this.username = loginUsername;
		this.password = loginPassword;
	}
	
	
	public User(int userId, String userName, String userPassword, int userRoleId) {
		this.userId = userId;
		this.username = userName;
		this.password = userPassword;
		this.roleId = userRoleId;
	}

	public Vector<Object> toObject() {
		Vector<Object> acc = new Vector<Object>();
		acc.add(userId);
		acc.add(username);
		acc.add(password);
		acc.add(roleId);
		
		return acc;
	}

}
