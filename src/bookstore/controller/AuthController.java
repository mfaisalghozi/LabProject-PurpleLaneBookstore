package bookstore.controller;

import java.sql.ResultSet;

import bookstore.database.DatabaseMySql;
import bookstore.model.User;

public class AuthController {
	
	DatabaseMySql con;
	
	public AuthController() {
		con = DatabaseMySql.getInstance();
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

	public int getUserId(String loginUsername, String loginPassword) {
		try {
			String sql = "SELECT * FROM `users` WHERE `userName` LIKE '"+loginUsername+"' AND `userPassword` LIKE '"+loginPassword+"'";		
			ResultSet rs = con.executeQuery(sql);
			if(rs.next()){
				int userId = (int) rs.getObject(1);
                if(loginUsername.equals(rs.getString("userName")) && loginPassword.equals(rs.getString("userPassword"))){             
                	return userId;
                }
            }else{  	
            		return 0;
                }
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}

	public int getRoleId(String loginUsername, String loginPassword) {
		try {
			String sql = "SELECT * FROM `users` WHERE `userName` LIKE '"+loginUsername+"' AND `userPassword` LIKE '"+loginPassword+"'";		
			ResultSet rs = con.executeQuery(sql);
			if(rs.next()){
				int roleId = (int) rs.getObject(4);
                if(loginUsername.equals(rs.getString("userName")) && loginPassword.equals(rs.getString("userPassword"))){             
                	return roleId;
                }
            }else{  	
            		return 0;
                }
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	
}
