package bookstore.controller;

import java.math.BigInteger;

import bookstore.database.DatabaseMySql;


public class BookController {
	
	DatabaseMySql con;
	
	
	
	public BookController() {
		con = DatabaseMySql.getInstance();
	}

	public void updateBook(int productId, String productName, String productAuthor, int productPrice, int productStock) {
		String query = String.format(""
				+ "UPDATE products "
				+ "SET productName = '%s',"
				+ "productAuthor = '%s',"
				+ "productStock = %d ,"
				+ "productPrice = %d "
				+ "WHERE productId = %d", productName, productAuthor, productStock, productPrice, productId);
		con.executeUpdate(query);
	}
	
	public void deleteBook(int productId) {
		String query = String.format("" 
				+ "DELETE FROM products "
				+ "WHERE ProductId = %d", productId);
		con.executeUpdate(query);
	}

	public void insertBook(int productId, String productName, String productAuthor, int productPrice, int productStock) {
		String query = String.format("" 
				+ "INSERT INTO products VALUES " 
				+ "(%d,'%s','%s',%d, %d)", productId, productName, productAuthor, productPrice, productStock);
		con.executeUpdate(query);
	}
	

}
