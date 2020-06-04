package Buy.action;

import static comm.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Project.beans.BuyBean;
import Project.beans.RatingBean;

public class BuyData {
	private static BuyData instance=new BuyData();
	public static BuyData getInstance() {
		return instance;
	}
	Connection conn=null;
	public void setConnection(Connection conn) {
		this.conn=conn;
	}
	
	//구매 목록 보기
	public ArrayList<BuyBean> buyList(String myId){
		ArrayList<BuyBean> list= null;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			sql="select substring(buy_date,1,10) buy_date, buy_no,buy_price,buy_dayNumber,pj_title,buy_useDate from Buy,Project pj where pj.Pj_no=buy.Pj_no AND pj_admin=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<BuyBean>();
				do {
					BuyBean bb=new BuyBean();
					bb.setBuy_no(rs.getInt("buy_no"));
					bb.setBuy_price(rs.getString("buy_price"));
					bb.setBuy_dayNumber(rs.getString("buy_dayNumber"));
					bb.setBuy_useDate(rs.getString("buy_useDate"));
					bb.setPj_title(rs.getString("pj_title"));
					bb.setBuy_date(rs.getString("buy_date"));
					list.add(bb);
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		return list;
	}
	
	//등급 조회 ( VIP, 프리미엄, 일반 )
	public ArrayList<RatingBean> myRating(String myId) {
		PreparedStatement psmt=null;
		ArrayList<RatingBean> rbc=null;
		RatingBean rb=null;
		ResultSet rs=null;
		String sql="";
		try {
			sql="select * from Buy where buy_date between '2019-01-01' AND '2019-12-31' AND EM_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myId);
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				rbc=new ArrayList<RatingBean>();
				do {
					rb=new RatingBean();
					rb.setBuy_no(rs.getInt("buy_no"));
					rb.setBuy_date(rs.getString("buy_date"));
					rb.setBuy_useDate(rs.getString("buy_useDate"));
					rb.setBuy_price(rs.getString("buy_price"));
					rbc.add(rb);
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rbc;
	}
	
}
