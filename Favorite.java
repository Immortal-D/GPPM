package GPPM.Entity;

public class Favorite {
	
	private int customerid;
	private int goodid;
	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Favorite(int customerid, int goodid) {
		this.customerid = customerid;
		this.goodid = goodid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getGoodid() {
		return goodid;
	}
	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}
	
	

}
