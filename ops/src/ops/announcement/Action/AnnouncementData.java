package ops.announcement.Action;

import static common.ConUtilDAO.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ops.Notice.Beans.Notice;
import ops.announcement.Beans.Announcement;


public class AnnouncementData {
	Connection con;
	PreparedStatement ps = null;
	ResultSet rs = null;	
	private static AnnouncementData instance;
	
	public static AnnouncementData getInstance(){
		if(instance == null)
			instance = new AnnouncementData();
		return instance;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int insertAnnouncement(Announcement a) { //공지사항작성 
		int x = 0;
		try {
			String sql = "insert into announcement values(null,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, a.getA_id());
			ps.setString(2, a.getA_title());
			ps.setString(3, a.getA_content());
			ps.setTimestamp(4, a.getA_date());
			ps.setString(5, a.getA_img());
			x = ps.executeUpdate();
		
		}catch(Exception e) {
			System.out.println("공지사항작성오류:"+ e);
		}finally {
			close(ps);
		}
		return x;
	}
	
	/*
	 * 추가 사항
	 */
	//공고 지원하기
	public int NotiCareerSupport(String myId,int ca_no, int n_no) {
		int state=0;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		int maxSize=0;
		String sql="insert into management(m_no,m_id,ca_no,n_no) values(null,?,?,?)";
		String sql1="select max(m_no) as coun from management where m_id=?";
		String sql2="insert into hire(hi_no,hi_confirmNum,m_no) values(null,?,?)";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, myId);
			psmt.setInt(2, ca_no);
			psmt.setInt(3, n_no);
			state=psmt.executeUpdate();
			if(state>0) {
				state=0;
				psmt.clearParameters();
				psmt=con.prepareStatement(sql1);
				psmt.setString(1, myId);
				rs=psmt.executeQuery();
				con.commit();
				if(rs.next()) {					
					maxSize=rs.getInt("coun");
					psmt.clearParameters();
					psmt=con.prepareStatement(sql2);
					psmt.setString(1, "N");
					psmt.setInt(2, maxSize);
					state=psmt.executeUpdate();
				}				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return state;
	}
	//공고 지원 여부 확인 true OR flase
	public boolean NoticCareerState(int n_no, String myId) {
		boolean state=false;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select * from management where n_no=? AND m_id=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, n_no);
			psmt.setString(2, myId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return state;
	}
	//공고 지원자 조회전 공고리스트
	public ArrayList<Notice> noticCareerLists(String emId) {
		ArrayList<Notice> notice=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select n_title,n_no,n_date,n_img from notice nt,enMember mb where mb.en_no=nt.en_no AND mb.en_id=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, emId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				notice=new ArrayList<Notice>();
				do {
					Notice nt=new Notice();
					nt.setN_title(rs.getString("n_title"));
					nt.setN_no(rs.getInt("n_no"));
					nt.setN_date(rs.getTimestamp("n_date"));
					nt.setN_img(rs.getString("n_img"));
					notice.add(nt);
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return notice;
	}
	
	//공고 지원 현황 조회 (공고서 제목 , 공고 번호,이력서 번호 반환)(사용자 입장)
	public ArrayList<Notice> NoticCareerList(String myId){
		ArrayList<Notice> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select ma.n_no,ma.ca_no,nt.n_title,ca.ca_no,n_img from management ma,notice nt,career ca where ma.n_no=nt.n_no AND ma.ca_no=ca.ca_no AND ma.m_id=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, myId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<Notice>();
				do {
					Notice ntc=new Notice();
					ntc.setN_title(rs.getString("nt.n_title"));
					ntc.setN_no(rs.getInt("ma.n_no"));
					ntc.setCa_no(rs.getInt("ca.ca_no"));
					ntc.setN_img(rs.getString("n_img"));
					list.add(ntc);
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//공고 지원 현황 조회 (공고서 제목 , 공고 번호,이력서 번호 반환)(기업 입장)
		public ArrayList<Notice> NoticCorpCareerList(String myId,int n_no){
			ArrayList<Notice> list=null;
			PreparedStatement psmt=null;
			ResultSet rs=null;
			String sql="select ma.n_no,ma.ca_no,nt.n_title,ca.ca_no,hire.hi_confirmNum,hire.hi_no,ma.m_id,mb.name,mb.birthday,mb.profile from management ma,notice nt,career ca,hire,member mb,enMember en where ma.n_no=nt.n_no AND ma.ca_no=ca.ca_no AND hire.m_no=ma.m_no AND mb.id=ma.m_id AND en.en_no=nt.en_no AND en_id=?";
			sql="select ma.n_no,ma.ca_no,nt.n_title,ca.ca_no,hire.hi_confirmNum,hire.hi_no,ma.m_id,mb.name,mb.birthday,mb.profile from management ma,notice nt,career ca,hire,member mb,enMember en where ma.n_no=nt.n_no AND ma.ca_no=ca.ca_no AND hire.m_no=ma.m_no AND mb.id=ma.m_id AND en.en_no=nt.en_no AND en_id=? AND nt.n_no=?";
//sql="select * from notice nt,management ma,hire where ma.n_no= nt.n_no AND hire.m_no=ma.m_no AND m_id=?";
			
			try {
				psmt=con.prepareStatement(sql);
				psmt.setString(1, myId);
				psmt.setInt(2, n_no);
				rs=psmt.executeQuery();
				if(rs.next()) {
					list=new ArrayList<Notice>();
					do {
						Notice ntc=new Notice();
						ntc.setN_title(rs.getString("nt.n_title"));
						ntc.setN_no(rs.getInt("ma.n_no"));
						ntc.setCa_no(rs.getInt("ca.ca_no"));
						ntc.setHi_confirmNum(rs.getString("hire.hi_confirmNum"));
						ntc.setHi_no(rs.getInt("hire.hi_no"));
						ntc.setM_id(rs.getString("ma.m_id"));
						ntc.setName(rs.getString("mb.name"));
						ntc.setBirthday(rs.getString("mb.birthday"));
						ntc.setProfile(rs.getString("mb.profile"));
						
						list.add(ntc);
					}while(rs.next());
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
	//공고 지원 별 포트폴리오 수
	public int NoticPortfolioSize(int ca_no){
		int state=0;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select count(ca.ca_no) as cnt from career ca,cp_include cp, portfolio po where ca.ca_no=cp.ca_no AND cp.po_no=po.po_no AND ca.ca_no=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, ca_no);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=rs.getInt("cnt");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(psmt!=null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return state;
	}
	//지원 공고 승인
	public int NoticCareerSuccess(int hi_no) {
		int state=0;
		PreparedStatement psmt=null;
		String sql="update hire set hi_confirmNum=? where hi_no=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, "Y");
			psmt.setInt(2, hi_no);
			state=psmt.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(psmt!=null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}
	//지원자 승인 취소
	public int NoticCareerCance(int hi_no) {
		int state=0;
		PreparedStatement psmt=null;
		String sql="update hire set hi_confirmNum=? where hi_no=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, "N");
			psmt.setInt(2, hi_no);
			state=psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(psmt!=null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return state;
	}
	//지원자 거절
	public int NoticCareerRefusal(int hi_no, int n_no) {
		int state=0;
		PreparedStatement psmt=null;
		String sql="update hire set hi_confirmNum=? where hi_no=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, "R");
			psmt.setInt(2, hi_no);
			state=psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(psmt!=null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return state;
	}
	
	/*추가 사황*/

	public ArrayList<Announcement> selectAnnouncementList(){ //공지사항리스트
		String sql="select * from announcement";
		ArrayList<Announcement> announcementList = new ArrayList<Announcement>();
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				do{
				Announcement a = new Announcement();
				a = new Announcement();
				a.setA_no(rs.getInt("a_no"));
				a.setA_id(rs.getString("a_id"));
				a.setA_title(rs.getString("a_title"));
				a.setA_content(rs.getString("a_content"));
				a.setA_date(rs.getTimestamp("a_date"));
				a.setA_img(rs.getString("a_img"));
				announcementList.add(a);
				}while(rs.next());
		}catch(Exception e){
			System.out.println("공지사항리스트오류 :" + e);			
		}finally{
			close(rs);
			close(ps);
		}
		return announcementList;
	}
	
	public Announcement selectAnnouncementDetail(int a_no) {
		Announcement a = null;
		try {
			String sql = "select * from announcement where a_no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, a_no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				a = new Announcement();
				a.setA_no(rs.getInt("a_no"));
				a.setA_id(rs.getString("a_id"));
				a.setA_title(rs.getString("a_title"));
				a.setA_content(rs.getString("a_content"));
				a.setA_date(rs.getTimestamp("a_date"));
				a.setA_img(rs.getString("a_img"));
				}
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(ps);
			}
			return a;
		}
	
	public boolean isAnnouncementNo(int a_no){ //공지사항번호조회
		String sql="select * from announcement where a_no=?";
		boolean isNo = false;
			
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, a_no);
			rs = ps.executeQuery();
			if(rs.next()) {
				isNo = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(ps);
		}
		return isNo;
	}
	
	public int updateAnnouncement(Announcement a){ //공지업데이트
		String sql="update announcement set a_title=?, a_content=?, a_img=? where a_no=?";
		int x = 0;
		
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, a.getA_title());
			ps.setString(2, a.getA_content());
			ps.setString(3, a.getA_img());
			ps.setInt(4, a.getA_no());
			x = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(ps);
		}
		return x;
	}
	
	public int deleteAnnouncement(int a_no) { //공지삭제
		String sql = "delete from announcement where a_no=?";
		int x = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, a_no);
			x = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return x;
	}
	
}


