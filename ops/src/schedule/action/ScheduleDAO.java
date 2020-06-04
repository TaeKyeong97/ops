package schedule.action;

import static comm.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import schedule.beans.ScheduleBeans;

public class ScheduleDAO {
	private static ScheduleDAO instance=new ScheduleDAO();
	public static ScheduleDAO getInstance() {
		if(instance==null) {
			instance=new ScheduleDAO();
		}		
		return instance;
	}
	Connection conn=null;
	public void setConnection(Connection conn) {
		this.conn=conn;
	}
	
	//스케줄 등록
	public int scheduleAdd(ScheduleBeans sb) {
		int state=0;
		System.out.println(sb.getStartMonth());
		PreparedStatement psmt=null;
		String sql="insert into schedule(no,startDate,endDate,ampm,startMonth,endMonth,Pj_no,content) values(null,?,?,?,?,?,?,?)";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, sb.getStartDate());
			psmt.setString(2, sb.getEndDate());
			psmt.setString(3, sb.getAmpm());
			psmt.setString(4, sb.getStartMonth());
			psmt.setString(5, sb.getEndMonth());
			psmt.setInt(6, sb.getPj_no());
			psmt.setString(7, sb.getContent());
			state=psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(psmt!=null) {
				close(psmt);
			}
		}
		
		return state;
	}
	
	//스케줄 조회
	public ArrayList<ScheduleBeans> scheduleList(int no) {
		ArrayList<ScheduleBeans> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select * from schedule where Pj_no=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<ScheduleBeans>();
				do {
					ScheduleBeans sb=new ScheduleBeans();
					sb.setNo(rs.getInt("no"));
					sb.setStartDate(rs.getString("startDate"));
					sb.setEndDate(rs.getString("endDate"));
					sb.setAmpm(rs.getString("ampm"));
					sb.setStartMonth(rs.getString("startMonth"));
					sb.setEndMonth(rs.getString("endMonth"));
					sb.setContent(rs.getString("content"));
					list.add(sb);					
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				close(rs);
			}
			if(psmt!=null) {
				close(psmt);
			}			
		}
		
		return list;
	}
	//스케줄 수정
	public int scheduleModify(ScheduleBeans sb) {
		int state=0;
		PreparedStatement psmt=null;
		String sql="update schedule set startDate=?,endDate=?,ampm=?,startMonth=?,endMonth=? where Pj_no=? AND no=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,sb.getStartDate());
			psmt.setString(2, sb.getEndDate());
			psmt.setString(3, sb.getAmpm());
			psmt.setString(4, sb.getStartMonth());
			psmt.setString(5, sb.getEndMonth());
			psmt.setInt(6, sb.getPj_no());
			psmt.setInt(7, sb.getNo());
			state=psmt.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(psmt!=null) {
				close(psmt);
			}
		}
		
		return state;		
		
	}
}
