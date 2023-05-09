package product;

import java.sql.Date;

/*
  		create table product (
  			idx			number,
  			name		varchar2(100),
  			price		number,
  			expiryDate	date,
  			memo		varchar2(2000)
  		);
 */
public class ProductDTO {

	// java.util.Date : 자바에서 사용하는 기본 날짜 타입 (super)
	// java.sql.Date : 오라클 및 다른 DB에서 불러오는 날짜 타입 (sub)
	// java.sql.Date extends java.util.Date
	private int idx;
	private String name;
	private int price;
	private Date expiryDate;
	private String memo;
	
	@Override
	public String toString() {
		return String.format("%s) %s \t%,d원 \t%s \t%s", idx, name, price, expiryDate, memo) ;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
}