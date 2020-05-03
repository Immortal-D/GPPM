package GPPM.Entity;

public class Business {
	
	private int businessid;
	private String password;
	private String Businessname;
	private String businesstel;
	private String businessaddress;
	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Business(int businessid, String password, String businessname, String businesstel, String businessaddress) {
		this.businessid = businessid;
		this.password = password;
		Businessname = businessname;
		this.businesstel = businesstel;
		this.businessaddress = businessaddress;
	}
	public int getBusinessid() {
		return businessid;
	}
	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBusinessname() {
		return Businessname;
	}
	public void setBusinessname(String businessname) {
		Businessname = businessname;
	}
	public String getBusinesstel() {
		return businesstel;
	}
	public void setBusinesstel(String businesstel) {
		this.businesstel = businesstel;
	}
	public String getBusinessaddress() {
		return businessaddress;
	}
	public void setBusinessaddress(String businessaddress) {
		this.businessaddress = businessaddress;
	}
	

}
