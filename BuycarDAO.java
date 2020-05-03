package GPPM.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GPPM.Entity.BuyCar;

public class BuycarDAO extends BasicDAO{
		
	private PreparedStatement pstmt;
	private ResultSet rs;
	public void delBuycar(int goodid) {
		String sql = "delete from buycar where goodid = ?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1,goodid );
			pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	public ArrayList queryBuycar(int userid) {
		String sql = "select * from buycar where customerid=?";
		ArrayList blist = new ArrayList();
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			//处理结果集：把结果集中的数据导入到list集合中
			while(rs.next()) {
				int customerid = rs.getInt("customerid");
				int goodid = rs.getInt("goodid");
				int goodnum= rs.getInt("goodnum");
				int money = rs.getInt("money");
				BuyCar buyc= new BuyCar(customerid,goodid,goodnum,money);
				blist.add(buyc);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return blist;
	}

	
	
	public void addBuycar(int customerid,int goodid,int num,int money) {
		String sql = "insert into buycar (customerid,goodid,goodnum,money) value (?,?,?,?);";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, customerid);
			pstmt.setInt(2, goodid);
			pstmt.setInt(3, num);
			pstmt.setInt(4, money);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
}
