package bookstore.controller;

import bookstore.database.DatabaseMySql;

public class CouponController {
	
	DatabaseMySql con;
	
	public CouponController() {
		con = DatabaseMySql.getInstance();
	}
	
	public void insertCoupon(int couponId, String couponCode, Long couponDiscount, String couponNote) {
		String query = String.format("" 
				+ "INSERT INTO coupons VALUES " 
				+ "(%d,'%s',%d,'%s')", couponId, couponCode, couponDiscount, couponNote);
		con.executeUpdate(query);
	}
	
	public void updateCoupon(int couponId, String couponCode, Long couponDiscount, String couponNote) {
		String query = String.format(""
				+ "UPDATE coupons "
				+ "SET couponNote = '%s',"
				+ "couponCode = '%s',"
				+ "couponDiscount = %d "
				+ "WHERE couponId = %d", couponNote, couponCode, couponDiscount, couponId);
		con.executeUpdate(query);
	}

	public void deleteCoupon(int couponId) {
		String query = String.format("" 
				+ "DELETE FROM coupons "
				+ "WHERE couponId = %d", couponId);
		con.executeUpdate(query);
	}
}
