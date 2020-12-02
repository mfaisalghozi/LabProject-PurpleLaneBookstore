package bookstore.model;

import java.util.Vector;

public class Transaction {
	
	int productId;
	int transactionId;
	int transactionQty;
	String transactionType;
	Long cardNumb;

	public Transaction(int productId, int transactionId, int transactionQty, String transactionType, Long cardNumb) {
		super();
		this.productId = productId;
		this.transactionId = transactionId;
		this.transactionQty = transactionQty;
		this.transactionType = transactionType;
		this.cardNumb = cardNumb;
	}
	
	public Vector<Object> toObjects(){
		Vector<Object> temp = new Vector<Object>();
		temp.add(productId);
		temp.add(transactionId);
		temp.add(transactionQty);
		temp.add(transactionType);
		temp.add(cardNumb);
		
		return temp;
	}


}
