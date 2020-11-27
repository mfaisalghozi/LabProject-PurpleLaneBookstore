package bookstore.model;

import java.util.Vector;

public class User {
	
	private String username;
	private String password;
	
	public User(String loginUsername, String loginPassword) {
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
