package bookstore.controller;

import java.sql.ResultSet;
import java.util.Vector;

import bookstore.database.DatabaseMySql;
import bookstore.model.Transaction;

public class TransactionController {
	
	Vector<Transaction> trans = new Vector<Transaction>();
	Vector<Object> transResult;
	DatabaseMySql con;
	
	public TransactionController() {
		con = DatabaseMySql.getInstance();
	}
	
	public Vector<Object> getAllTransaction() {
		transResult = new Vector<Object>();
		ResultSet rs = con.executeQuery("SELECT * FROM transactions");
		try {
			while(rs.next()) {
				int productId = (int) rs.getObject(2);
				int transactionId = (int) rs.getObject(4);
				int transactionQty = (int) rs.getObject(6);
				String transactionType = (String) rs.getObject(7);
				Long transactionCardNumb = (Long) rs.getObject(8);
				
				Transaction ts = new Transaction(productId, transactionId, transactionQty, transactionType, transactionCardNumb);
				trans.add(ts);
				transResult.add(ts.toObjects());
			}
			return transResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
