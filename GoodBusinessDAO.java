package GPPM.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GoodBusinessDAO extends BasicDAO{

	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/**
	 * 添加商品商家信息功能
	 * @param did
	 * @param dname
	 * @param dloc
	 */
	public void addGoodBusiness(int businessid,int goodid) {
		String sql = "insert into Good_Business(businessid,goodid) values(?,?)";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1,businessid );
			pstmt.setInt(2,goodid );
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	
}
