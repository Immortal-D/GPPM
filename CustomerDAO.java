package GPPM.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import GPPM.Entity.Customer;





/**
 * @author huawei �˿͵�ע��
 *
 */
public class CustomerDAO extends BasicDAO{
	private PreparedStatement pstmt;
	private ResultSet rs;
	

	
	public void addCustomer (Customer cust) {
		String sql = "insert into customer(customerid,password,location,tel,customername) values(?,?,?,?,?)";
		try {
			pstmt = getConn().prepareStatement(sql);
			
			pstmt.setInt(1,cust.getCustomerid() );
			pstmt.setString(2,cust.getPassword() );
			pstmt.setString(3,cust.getLocation());
			pstmt.setInt(4,cust.getTel());
			pstmt.setString(5,cust.getCustomername());
					
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * @author �˿͵Ĳ�ѯ
	 *
	 */

	public Customer queryCust(int userid) {
		String sql = "select * from customer where customerid= ?";
		Customer cust =null;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1,userid);
			rs = pstmt.executeQuery();
			//�����������ѽ�����е����ݵ��뵽list������
			if(rs.next())
			{
				int customerid = rs.getInt("customerid");
				String password = rs.getString("password");
				String location = rs.getString("location");
				String customername = rs.getString("customername");
				int tel = rs.getInt("tel");
			 cust = new Customer (customerid, password, customername,location,tel);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return cust;
		}
	/**
	 * @author �˿͵ĸ���
	 *
	 */
 public void UpdateCustomer(int customerid,String password,String customername,int tel,String location) {
		String sql = "update customer set password=?,customername=?,tel=?,location=? where customerid=?";
		//System.out.println("sqlsqlsql");
		try {
			
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1,password);
			pstmt.setString(2,customername);
			pstmt.setInt(3,tel);
			pstmt.setString(4,location);
			pstmt.setInt(5,customerid);
			
			pstmt.executeUpdate();
		
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}



/**
 * @author huawei �˿͵ĵ�½���
 */


public boolean login(int  userid,String password) {
		String sql = "select * from customer where customerid = ? and password = ?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1,userid );
			pstmt.setString(2,password );
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs, pstmt, null);
		}
		return false;
	}
}

 
