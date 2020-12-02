package bookstore.model;

import java.math.BigInteger;
import java.util.Vector;

public class Product {
	
	public int productId;
	public String productName;
	public String productAuthor;
	public BigInteger productPrice;
	public int productStock;
	
	public Product(int productId, String productName, String productAuthor, BigInteger productPrice, int productStock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productAuthor = productAuthor;
		this.productPrice = productPrice;
		this.productStock = productStock;
	}
	
	public Vector<Object> toObjects(){
		Vector<Object> ret = new Vector<Object>();
		
		ret.add(productId);
		ret.add(productName);
		ret.add(productAuthor);
		ret.add(productPrice);
		ret.add(productStock);
		
		return ret;
	}

}
