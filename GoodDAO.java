package GPPM.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GPPM.Entity.Good;

public class GoodDAO extends BasicDAO{
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		public ArrayList queryGood(int min,int max,String type,String sex) {
			String sql;
			ArrayList list = new ArrayList();
			String n = "null1";
			
			try {
				//娉ㄦ剰浼犲洖绌哄�间細瀵艰嚧null.equals绌烘寚閽堥棶棰橈紝灏介噺涓嶈浼犲洖绌哄��
				if(sex.equals(n)&&type.equals("null1")) {
					sql = "select * from good where goodprice between ? and ?";
					pstmt = getConn().prepareStatement(sql);
					pstmt.setInt(1,min);
					pstmt.setInt(2,max);
					rs = pstmt.executeQuery();}
				else if(type.equals(n)) {
					sql = "select * from good where goodprice between ? and ? and adaptsex = ?";
					pstmt = getConn().prepareStatement(sql);
					pstmt.setInt(1,min);
					pstmt.setInt(2,max);
					pstmt.setString(3,sex);
					rs = pstmt.executeQuery();}
				else if(sex.equals(n)) {
					sql = "select * from good where goodprice between ? and ? and type = ?";
					pstmt = getConn().prepareStatement(sql);
					pstmt.setInt(1,min);
					pstmt.setInt(2,max);
					pstmt.setString(3,type);
					rs = pstmt.executeQuery();}
				else 
					{
					sql = "select * from good where goodprice between ? and ? and type = ? and adaptsex = ?";
					pstmt = getConn().prepareStatement(sql);
					pstmt.setInt(1,min);
					pstmt.setInt(2,max);
					pstmt.setString(3,type);
					pstmt.setString(4,sex);
					rs = pstmt.executeQuery();
				}
			
				//缁撴灉闆�
				while(rs.next()) {
					int id = rs.getInt("goodid");
					String name = rs.getString("goodname");
					int price = rs.getInt("goodprice");
					int number = rs.getInt("number");
					String type1 = rs.getString("type");
					String sex1 = rs.getString("adaptsex");
					Good good = new Good(id,name,price,number,type1,sex1);
					list.add(good);
				}
				
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close(null, pstmt, null);
			}
			return list;
		}
		/**
		 * 王雪0706
		 * 添加商品信息功能
		 * @param did
		 * @param dname
		 * @param dloc
		 */
		public void addGood(int goodid,String goodname ,int goodprice,int number,String type,String adaptsex) {
			String sql = "insert into Good (goodid,goodname ,goodprice,number,type,adaptsex) values(?,?,?,?,?,?)";
			try {
				pstmt = getConn().prepareStatement(sql);
				pstmt.setInt(1,goodid );
				pstmt.setString(2,goodname );
				pstmt.setInt(3,goodprice );
				pstmt.setInt(4,number );
				pstmt.setString(5,type );
				pstmt.setString(6,adaptsex );
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close(null, pstmt, null);
			}
		}
		
		/**
		 * 王雪0706
		 * 查询商品信息方法
		 * @return
		 */
		public ArrayList SelectGoodByBusinessid(int Businessid) {
			String sql = "select * from Good,Good_Business where Good.goodid = Good_Business.goodid and businessid = ?";
			Good good = null;
			ArrayList list = new ArrayList();
			try {
				pstmt = getConn().prepareStatement(sql);
				pstmt.setInt(1,Businessid );
				rs = pstmt.executeQuery();
				//处理结果集：把结果集中的数据导入到list集合中
				while(rs.next()) {
					int goodid = rs.getInt("goodid");
					String goodname = rs.getString("goodname");
					int goodprice = rs.getInt("goodprice");
					int number = rs.getInt("number");
					String type = rs.getString("type");
					String adaptsex = rs.getString("adaptsex");
					good = new Good(goodid,goodname,goodprice,number,type,adaptsex);
					list.add(good);
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
		 * 王雪0706
		 * 修改商品信息
		 * @param did
		 * @param dname
		 * @param dloc
		 */
		public void UpdateGood(int goodid,String goodname,int goodprice,int number,String type,String adaptsex) {
			String sql = "update Good set goodname= ?,goodprice = ?,number = ?,type = ?,adaptsex = ? where goodid = ?";
			try {
				pstmt = getConn().prepareStatement(sql);
				pstmt.setString(1, goodname);
				pstmt.setInt(2, goodprice);
				pstmt.setInt(3, number);
				pstmt.setString(4,type );
				pstmt.setString(5,adaptsex );
				pstmt.setInt(6, goodid);
				pstmt.executeUpdate();	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close(null, pstmt, null);
			}
		}
		
		/**
		 * 王雪0706
		 * 删除商品信息功能
		 * @param did
		 */
		public void delGood(int goodid) {
			String sql = "delete from Good where goodid = ?";
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
		
		/**
		 * 王雪0706
		 * 通过goodid查询商品信息方法
		 * @return
		 */
		public Good SelectGoodByGoodid(int Goodid) {
			String sql = "select * from Good where goodid = ?";
			Good good = null;
			try {
				pstmt = getConn().prepareStatement(sql);
				pstmt.setInt(1,Goodid );
				rs = pstmt.executeQuery();
				//处理结果集：把结果集中的数据导入到list集合中
				if(rs.next()) {
					int goodid = rs.getInt("goodid");
					String goodname = rs.getString("goodname");
					int goodprice = rs.getInt("goodprice");
					int number = rs.getInt("number");
					String type = rs.getString("type");
					String adaptsex = rs.getString("adaptsex");
					good = new Good(goodid,goodname,goodprice,number,type,adaptsex);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close(null, pstmt, null);
			}
			return good;
		}

	}


