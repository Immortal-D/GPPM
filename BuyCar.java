package GPPM.Entity;

public class BuyCar {

	private int customerid;
	private int goodid;
	private int goodnum;//购物车中商品数量
	private int money;//待付款金额
	public BuyCar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyCar(int customerid, int goodid, int goodnum, int money) {
		super();
		this.customerid = customerid;
		this.goodid = goodid;
		this.goodnum = goodnum;
		this.money = money;
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
	public int getGoodnum() {
		return goodnum;
	}
	public void setGoodnum(int goodnum) {
		this.goodnum = goodnum;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
