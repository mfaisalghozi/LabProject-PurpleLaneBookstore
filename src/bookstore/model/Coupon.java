package bookstore.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Vector;

public class Coupon {
	
	int couponId;
	String couponCode;
	Long couponDiscount;
	String couponNote;
	
	public Coupon(int couponId, String couponCode, Long couponDiscount2, String couponNote) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.couponDiscount = couponDiscount2;
		this.couponNote = couponNote;
	}
	
	
	public Vector<Object> toObjects(){
		Vector<Object> ret = new Vector<Object>();
		
		ret.add(couponId);
		ret.add(couponCode);
		ret.add(couponDiscount);
		ret.add(couponNote);
		
		return ret;
	}
	

}
