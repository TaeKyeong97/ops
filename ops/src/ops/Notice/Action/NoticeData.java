package ops.Notice.Action;

import static common.ConUtilDAO.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ops.Notice.Beans.Notice;


public class NoticeData {
	Connection con;
	PreparedStatement ps = null;
	ResultSet rs = null;	
	private static NoticeData instance;
	
	public static NoticeData getInstance(){
		if(instance == null)
			instance = new NoticeData();
		return instance;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int insertNotice(Notice n) { //怨듦퀬�옉�꽦 26
		int x = 0;
		try {
			String sql0="select en_no from enmember where en_id=?";			
			ps = con.prepareStatement(sql0);
			ps.setString(1, n.getN_id());
			rs=ps.executeQuery();
			if(rs.next()) {				
				String sql = "insert into notice values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				ps.clearParameters();
				ps = con.prepareStatement(sql);
				ps.setString(1, n.getN_title());
				ps.setTimestamp(2, n.getN_date());
				ps.setString(3, n.getN_img());
				ps.setString(4, n.getN_comName());
				ps.setString(5, n.getN_ceoName());
				ps.setString(6, n.getN_address());
				ps.setString(7, n.getN_job());
				ps.setInt(8, n.getN_reCruit());
				ps.setString(9, n.getN_field());
				ps.setString(10, n.getN_gender());
				ps.setString(11, n.getN_age());
				ps.setString(12, n.getN_acadamiBg());
				ps.setString(13, n.getN_endDate());
				ps.setString(14, n.getN_sal());
				ps.setString(15, n.getN_workTerm());
				ps.setString(16, n.getN_workDay());
				ps.setString(17, n.getN_workTime());
				ps.setString(18, n.getN_workForm());
				ps.setString(19, n.getN_name());
				ps.setString(20, n.getN_email());
				ps.setString(21, n.getN_phone());
				ps.setString(22, n.getN_supportForm());
				ps.setString(23, n.getN_bigo());
				ps.setString(24, n.getN_content());
				ps.setInt(25, rs.getInt("en_no"));
				x = ps.executeUpdate();
				
			}			
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("공고작성오류:"+ e);
		}finally {
			if(ps!=null) {
				close(ps);
			}
		}
		return x;
	}
	
	public ArrayList<Notice> selectNoticeList(){ //怨듦퀬由ъ뒪�듃
		String sql="select n_no, n_title, n_date, n_comName, n_ceoName, n_address, n_job, n_reCruit, n_field, n_gender, n_age, n_acadamiBg, n_endDate, n_sal, n_workTerm, n_workDay, n_workTime, n_workForm, n_name, n_email, n_phone, n_supportForm, n_bigo, n_content from notice";
		ArrayList<Notice> noticeList = new ArrayList<Notice>();
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				do{
				Notice n = new Notice();
				n = new Notice();
				n.setN_no(rs.getInt("n_no"));
				n.setN_title(rs.getString("n_title"));
				n.setN_date(rs.getTimestamp("n_date"));
				n.setN_comName(rs.getString("n_comName"));
				n.setN_ceoName(rs.getString("n_ceoName"));
				n.setN_address(rs.getString("n_address"));
				n.setN_job(rs.getString("n_job"));
				n.setN_reCruit(rs.getInt("n_reCruit"));
				n.setN_field(rs.getString("n_field"));
				n.setN_gender(rs.getString("n_gender"));
				n.setN_age(rs.getString("n_age"));
				n.setN_acadamiBg(rs.getString("n_acadamiBg"));
				n.setN_endDate(rs.getString("n_endDate"));
				n.setN_sal(rs.getString("n_sal"));
				n.setN_workTerm(rs.getString("n_workTerm"));
				n.setN_workDay(rs.getString("n_workDay"));
				n.setN_workTime(rs.getString("n_workTime"));
				n.setN_workForm(rs.getString("n_workForm"));
				n.setN_name(rs.getString("n_name"));
				n.setN_email(rs.getString("n_email"));
				n.setN_phone(rs.getString("n_phone"));
				n.setN_supportForm(rs.getString("n_supportForm"));
				n.setN_bigo(rs.getString("n_bigo"));
				n.setN_content(rs.getString("n_content"));
				noticeList.add(n);
				}while(rs.next());
			
		}catch(Exception e){
			System.out.println("공고리스트오류 :" + e);			
		}finally{
			close(rs);
			close(ps);
		}
		return noticeList;
	}
	
	public Notice selectNoticeDetail(int n_no) { //怨듦퀬 議고쉶
		Notice n = null;
		try {
			String sql = "select * from notice where n_no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, n_no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				n = new Notice();
				n.setN_no(rs.getInt("n_no"));
				n.setN_title(rs.getString("n_title"));
				n.setN_content(rs.getString("n_content"));
				n.setN_date(rs.getTimestamp("n_date"));
				n.setN_img(rs.getString("n_img"));
				n.setN_comName(rs.getString("n_comName"));
				n.setN_ceoName(rs.getString("n_ceoName"));
				n.setN_address(rs.getString("n_address"));
				n.setN_job(rs.getString("n_job"));
				n.setN_reCruit(rs.getInt("n_reCruit"));
				n.setN_field(rs.getString("n_field"));
				n.setN_gender(rs.getString("n_gender"));
				n.setN_age(rs.getString("n_age"));
				n.setN_acadamiBg(rs.getString("n_acadamiBg"));
				n.setN_sal(rs.getString("n_sal"));
				n.setN_endDate(rs.getString("n_endDate"));
				n.setN_workTerm(rs.getString("n_workTerm"));
				n.setN_workDay(rs.getString("n_workDay"));
				n.setN_workTime(rs.getString("n_workTime"));
				n.setN_workForm(rs.getString("n_workForm"));
				n.setN_name(rs.getString("n_name"));
				n.setN_email(rs.getString("n_email"));
				n.setN_phone(rs.getString("n_phone"));
				n.setN_supportForm(rs.getString("n_supportForm"));
				n.setN_bigo(rs.getString("n_bigo"));
				n.setEn_no(rs.getInt("en_no"));	
			}
		}catch(Exception e) {
			System.out.println("공고조회:" + e);
		}finally {
			close(rs);
			close(ps);
		}
		return n;
	}
	
	public boolean isNoticeNo(int n_no){ //怨듦퀬 踰덊샇 �솗�씤

		String sql="select * from Notice where n_no=?";
		boolean isNo = false;
			
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, n_no);
			rs = ps.executeQuery();
			if(rs.next()) {
				isNo = true;
			}
		}catch(Exception e){
			System.out.println("공고번호오류: "+ e);
		}
		finally{
			close(ps);
		}
		return isNo;
	}
	
	public int updateNotice(Notice detail){ //怨듦퀬�닔�젙

		int x = 0;
		String sql="update Notice set n_title=?, n_content=?, n_img=?, n_comName=?, n_ceoName=?, n_address=?, n_job=?, n_reCruit=?, n_field=?, n_gender=?, n_age=?, n_acadamiBg=?, n_sal=?, n_endDate=?, n_workTerm=?, n_workDay=?, n_workTime=?, n_workForm=?, n_name=?, n_email=?, n_phone=?, n_supportForm=?, n_bigo=? where n_no=?";

		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, detail.getN_title());
			ps.setString(2, detail.getN_content());
			ps.setString(3, detail.getN_img());
			ps.setString(4, detail.getN_comName());
			ps.setString(5, detail.getN_ceoName());
			ps.setString(6, detail.getN_address());
			ps.setString(7, detail.getN_job());
			ps.setInt(8, detail.getN_reCruit());
			ps.setString(9, detail.getN_field());
			ps.setString(10, detail.getN_gender());
			ps.setString(11, detail.getN_age());
			ps.setString(12, detail.getN_acadamiBg());
			ps.setString(13, detail.getN_sal());
			ps.setString(14, detail.getN_endDate());
			ps.setString(15, detail.getN_workTerm());
			ps.setString(16, detail.getN_workDay());
			ps.setString(17, detail.getN_workTime());
			ps.setString(18, detail.getN_workForm());
			ps.setString(19, detail.getN_name());
			ps.setString(20, detail.getN_email());
			ps.setString(21, detail.getN_phone());
			ps.setString(22, detail.getN_supportForm());
			ps.setString(23, detail.getN_bigo());
			ps.setInt(24, detail.getN_no());
			x = ps.executeUpdate();
		}catch(Exception e){
			System.out.println("공고수정오류 : " + e);
		}finally{
			close(ps);
		}
		return x;
	}
	
	public int deleteNotice(int n_no){ //怨듦퀬�궘�젣
		String sql="delete from Notice where n_no=?";
		int x = 0;

		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, n_no);
			x = ps.executeUpdate();
		}catch(Exception e){
			System.out.println("공고삭제오류: "+ e);
		}finally{
			close(ps);
		}
		return x;
	}
}


	


