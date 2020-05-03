package GPPM.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import GPPM.Entity.Business;


public class BusinessDAO extends BasicDAO{
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/**
	 * @author huawei 商家登陆
	 *
	 */	
	
	public boolean login(int  userid,String password) {
		String sql = "select * from business where businessid = ? and password = ?";
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
	/**
	 * @author huawei 商家注册
	 *
	 */	
	
	public void addBusiness (Business bussin) {
		String sql = "insert into business (password,businessname,businesstel,businessaddress,businessid) values(?,?,?,?,?)";
		try {
			pstmt = getConn().prepareStatement(sql);
			
			
		 pstmt.setString(1, bussin.getPassword());
		 pstmt.setString(2, bussin.getBusinessname());	
		 pstmt.setInt(3, bussin.getBusinesstel());
		 pstmt.setString(4, bussin.getBusinessaddress());
		 pstmt.setInt(5, bussin.getBusinessid());
		
		 pstmt.executeUpdate();
			
		// System.out.println("shangjiazhuce");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	/**
	 * 王雪0704
	 * 查询部门信息方法
	 * @return
	 */
	public Business SelectBusinessByBusinessid(int Business) {
		String sql = "select * from Business where businessid = ?";
		Business business = null;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1,Business );
			rs = pstmt.executeQuery();
			//处理结果集：把结果集中的数据导入到list集合中
			if(rs.next()) {
				int businessid = rs.getInt("businessid");
				String password = rs.getString("password");
				String businessname = rs.getString("businessname");
				int businesstel = rs.getInt("businesstel");
				String businessaddress = rs.getString("businessaddress");
				business = new Business(businessid,password,businessname,businesstel,businessaddress);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return business;
	}
	
	/**
	 * 王雪0705
	 * @param did
	 * @param dname
	 * @param dloc
	 */
	public void UpdateBusiness(int businessid,String businessname,String businessaddress,int businesstel) {
		String sql = "update Business set businessname= ?,businesstel = ?,businessaddress = ? where businessid = ?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, businessname);
			pstmt.setInt(2, businesstel);
			pstmt.setString(3, businessaddress);
			pstmt.setInt(4,businessid );
			pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	
	
}
