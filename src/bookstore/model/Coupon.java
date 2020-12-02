package bookstore.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Vector;

public class Coupon {
	
	public int couponId;
	public String couponCode;
	public Long couponDiscount;
	public String couponNote;
	
	public Coupon(int couponId, String couponCode, Long couponDiscount, String couponNote) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.couponDiscount = couponDiscount;
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
