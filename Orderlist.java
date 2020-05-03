package GPPM.Entity;

public class Orderlist {
        
	private int orderlistid;
	private int goodid;
	private int businessid;
	 private String buytime;
	 private int  customerid;
	 private String situation ;//浜ゆ槗鐘舵��
	public Orderlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Orderlist(int goodid, int businessid, String buytime, int customerid, String situation) {
		super();
		this.goodid = goodid;
		this.businessid = businessid;
		this.buytime = buytime;
		this.customerid = customerid;
		this.situation = situation;
	}
	
	public Orderlist(int orderlistid,int goodid, int businessid, String buytime, int customerid, String situation) {
		super();
		this.orderlistid = orderlistid;
		this.goodid = goodid;
		this.businessid = businessid;
		this.buytime = buytime;
		this.customerid = customerid;
		this.situation = situation;
	}
	

	public int getOrderlistid() {
		return orderlistid;
	}

	public void setOrderlistid(int orderlistid) {
		this.orderlistid = orderlistid;
	}

	public int getGoodid() {
		return goodid;
	}
	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}
	public int getBusinessid() {
		return businessid;
	}
	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}
	public String getBuytime() {
		return buytime;
	}
	public void setBuytime(String buytime) {
		this.buytime = buytime;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}
	
}