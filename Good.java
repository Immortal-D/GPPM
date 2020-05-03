package GPPM.Entity;

public class Good {
	private int goodid;
	private String goodname;
	private int goodprice;
	private int number;
	private String type;
	private String adaptsex;
	
	
	public Good() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Good(int goodid, String goodname, int goodprice, int number, String type, String adaptsex) {
		this.goodid = goodid;
		this.goodname = goodname;
		this.goodprice = goodprice;
		this.number = number;
		this.type = type;
		this.adaptsex = adaptsex;
	}

	public int getGoodid() {
		return goodid;
	}

	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}

	public String getGoodname() {
		return goodname;
	}

	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}

	public int getGoodprice() {
		return goodprice;
	}

	public void setGoodprice(int goodprice) {
		this.goodprice = goodprice;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAdaptsex() {
		return adaptsex;
	}

	public void setAdaptsex(String adaptsex) {
		this.adaptsex = adaptsex;
	}

    

}
