package GPPM.Entity;

public class Customer {
	private int customerid;
	private String password;
	private String customername;
	private String location;
	private String tel;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerid,String password, String customername, String location, String tel) {
		this.customerid = customerid;
		this.password = password;
		this.customername = customername;
		this.location = location;
		this.tel = tel;
	}

	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
