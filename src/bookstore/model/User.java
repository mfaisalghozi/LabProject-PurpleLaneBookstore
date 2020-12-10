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
	
	public Vector<Object> toObject() {
		Vector<Object> acc = new Vector<Object>();
		acc.add(username);
		acc.add(password);
		
		return acc;
	}

}
