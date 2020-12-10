package bookstore.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseMySql {
	private String USERNAME = "root";
	private String PASSWORD = "";
	private String HOST = "localhost:3306";
	private String DATABASE = "ooad_lab_project";
	private String CONNECT_ADDRESS = "jdbc:mysql://" + HOST + "/" + DATABASE;
	
	private Connection con;
	private Statement st;
	private static DatabaseMySql instance = null;
	
	
	//Singleton Design Pattern
	public static DatabaseMySql getInstance() {
		return instance = instance == null ? new DatabaseMySql() : instance;
	}
	
	public DatabaseMySql() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(CONNECT_ADDRESS,USERNAME,PASSWORD);
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("Connection Failed !");
		}
		System.out.println("Connection Success !");
	}
	
	public ResultSet executeQuery(String query) {
		try {
			return st.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void executeUpdate(String query) {
		try {
			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
