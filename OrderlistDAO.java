package GPPM.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GPPM.Entity.Orderlist;




public class OrderlistDAO extends BasicDAO{

	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Orderlist queryByidOrder(int customerid,int goodid) {
		String sql = "select * from orderlist where customerid = ? and goodid = ?";
		Orderlist order = null;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, customerid);
			pstmt.setInt(2, goodid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int businessid = rs.getInt("businessid");
				String buytime = rs.getString("buytime");
				String situation = rs.getString("situation");
				order = new Orderlist(goodid,businessid,buytime,customerid,situation);
			}
			else {
				order = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return order;
	}
	
	

	/**
	 * 王雪0705
	 * 根据商家编号查询商家订单信息
	 * @param Businessid
	 * @return
	 */
	public ArrayList SelectOrderlistByBusinessid(int Businessid) {
		String sql = "select * from orderlist where businessid = ?";
		ArrayList list = new ArrayList();
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1,Businessid );
			rs = pstmt.executeQuery();
			//处理结果集：把结果集中的数据导入到list集合中
			while(rs.next()) {
				int businessid = rs.getInt("businessid");
				int goodid = rs.getInt("goodid");
				String buytime = rs.getString("buytime");
				int customerid= rs.getInt("customerid");
				String situation = rs.getString("situation");
				Orderlist orderlist = new Orderlist(goodid,businessid,buytime,customerid,situation);
				list.add(orderlist);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return list;
	}
	
	
	public ArrayList SelectOrderlistByBusinessid() {
		String sql = "select * from orderlist";
		ArrayList list = new ArrayList();
		try {
			pstmt = getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			//处理结果集：把结果集中的数据导入到list集合中
			while(rs.next()) {
				int businessid = rs.getInt("businessid");
				int goodid = rs.getInt("goodid");
				String buytime = rs.getString("buytime");
				int customerid= rs.getInt("customerid");
				String situation = rs.getString("situation");
				Orderlist orderlist = new Orderlist(goodid,businessid,buytime,customerid,situation);
				list.add(orderlist);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return list;
	}
	
	/**
	 * 王雪0705
	 * 删除订单信息功能
	 * @param did
	 */
	public void delOrderlist(int customerid,int goodid,int businessid) {
		String sql = "delete from orderlist where customerid = ? and goodid = ? and businessid = ?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1,customerid );
			pstmt.setInt(2,goodid );
			pstmt.setInt(3,businessid );
			pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	
	/**
	 * 王雪0705
	 * 修改配送信息功能
	 * @param did
	 * @param dname
	 * @param dloc
	 */
	public void UpdateOrderByCidGidServlet(int businessid,int customerid,int goodid,String situation) {
		String sql = "update Orderlist set situation = ? where businessid = ? and customerid = ? and goodid = ?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, situation);
			pstmt.setInt(2, businessid);
			pstmt.setInt(3, customerid);
			pstmt.setInt(4, goodid);
			pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
}
