package Project.action;

import static comm.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import Project.beans.Member;
import Project.beans.MemberAll;
import Project.beans.MemberImg;
import Project.beans.ProjectBean;
import Project.beans.ProjectGroupBean;
import Project.beans.Work;

public class ProjectData {
	private static ProjectData instance=new ProjectData();
	public static ProjectData getInstance() {
		return instance;
	}
	Connection conn=null;
	public void setConnection(Connection conn) {
		this.conn=conn;
	}
	
	//회원가입
	public int insertMember(Member mb,String userImg,String folder) {
		int state=0;
		String sql=null;
		PreparedStatement psmt=null;
		try {
			sql="insert into E_Member values(?,?,?,?,?,?,?,?,?,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, mb.getEM_id());
			psmt.setString(2, mb.getEM_pw());
			psmt.setString(3, mb.getEM_name());
			psmt.setString(4, mb.getEM_bir());
			psmt.setString(5, mb.getEM_phon());
			psmt.setString(6, mb.getEM_email());
			psmt.setString(7, mb.getEM_document());
			psmt.setInt(8, mb.getEM_appCode());
			psmt.setTimestamp(9, mb.getEM_date());
			psmt.setString(10, mb.getEM_uniqueCode());
			state=psmt.executeUpdate();	
			
			//회원 이미지 저장
			sql="insert into EM_Image values(null,?,?,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userImg);
			psmt.setString(2, folder);
			psmt.setString(3,mb.getEM_id());
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
			} catch (SQLException e) {
			}
		}
		
		return state;
	}
	//비밀번호 찾기
	public String searchPassword(String myId, String phone) {
		String password=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="";
		try {
			sql="select * from e_member where EM_id=? AND EM_phon=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myId);
			psmt.setString(2, phone);
			rs=psmt.executeQuery();
			if(rs.next()) {
				Random rd=new Random();
				StringBuffer buf=new StringBuffer();
				for(int i=0;i<15;i++) {
					rd.nextBoolean();
					if(rd.nextBoolean()) {
						 buf.append((char)((int)(rd.nextInt(26))+97));
					}else {
						 buf.append((rd.nextInt(10)));
					}
				}
				System.out.println(buf);
				psmt.clearParameters();
				sql="update e_member set EM_pw=? where EM_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, buf.toString());
				psmt.setString(2, myId);
				int state=psmt.executeUpdate();	
				if(state>0) {
					password=buf.toString();
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return password;
	}
	
	
	//로그인
	public int loginEMember(String id, String pw) {
		int state=0;
		String sql=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			sql="select EM_pw,EM_appCode from e_member where EM_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("EM_appCode").equals("-1")) {
					state=-3;
				}else if(rs.getString("EM_pw").equals(pw)) {
					state=1;
				}else {
					state=0;
				}
			}else{
				state=-1;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				psmt.close();
			} catch (SQLException e) {
			}
		}
		
		return state;
	}
	//이름 가져오기
	public String loginName(String id) {
		String myName=null;
		String sql="";
		ResultSet rs=null;
		PreparedStatement psmt=null;
		try {
			sql="select * from e_member where em_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				myName=rs.getString("em_name");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		
		
		return myName;
	}
	//로그인한 사용자 기본정보가져오기
	public Member userInfo(String id){
		String sql=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Member mb=new Member();
		sql="select EM_id,EM_name,EM_bir,EM_email from e_member where EM_id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				mb.setEM_id(rs.getString("EM_id"));
				mb.setEM_name(rs.getString("EM_name"));
				mb.setEM_email(rs.getString("EM_email"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				psmt.close();
			} catch (SQLException e) {
			}
		}
		return mb;
	}
	 	
	
	public MemberImg userInfoImg(String id) {
		String sql=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		MemberImg mb=null;
		//로그인 사용자 이미지 정보 가져오기
		try {
			sql="select EM_id,EMImg_folder,EMImg_name from EM_Image where EM_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				mb=new MemberImg();
				mb.setEMImg_folder(rs.getString("EMImg_folder"));
				mb.setEMImg_name(rs.getString("EMImg_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		return mb;
	}
	
	//회원정보 수정
	public int MemberInfoChange(String id,String Email,String andChange,String pw,String sortation) throws Exception{
		int state=0;
		String sql=null;
		PreparedStatement psmt=null;
		try {
			if(sortation.equals("emailChange")) {
				sql="update e_member set EM_email=? where EM_id=?&&EM_pw=?&&EM_email=? ";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, andChange);
				psmt.setString(2, id);
				psmt.setString(3, pw);
				psmt.setString(4, Email);
				state=psmt.executeUpdate();
				
			}else if(sortation.equals("pwChange")) {
				sql="update e_member set EM_pw=? where EM_id=?&&EM_pw=? ";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, andChange);
				psmt.setString(2, id);
				psmt.setString(3, pw);
				state=psmt.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		
		return state;
	}
	//가장 최근에 생성한 프로젝트
	public int createNoProject(ProjectBean pb) {
		int pj_no=0;
		String sql=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			//생성된 프로젝트 id 가져오기
			sql="select MAX(Pj_no) from Project where Pj_admin=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, pb.getPj_admin());
			rs=psmt.executeQuery();
			if(rs.next()) {
				pj_no=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return pj_no;
	}
	
	//프로젝트 생성
	public int createProject(ProjectBean pb,String buy_price) {
		int state=0;
		String sql=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			//project 생성
			sql="insert into Project values(null,?,?,?,?,?,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, pb.getPj_admin());
			psmt.setString(2, pb.getPj_title());
			psmt.setString(3, pb.getPj_subTitle());
			psmt.setTimestamp(4, pb.getPj_date());
			psmt.setString(5, pb.getPj_serviceDate());
			psmt.setString(6, pb.getPj_space());
			state=psmt.executeUpdate();
			
			
			
			if(state>0) {
				//생성된 프로젝트 id 가져오기
				int pj_no=0;
				psmt.clearParameters();
				sql="select MAX(Pj_no) from Project where Pj_admin=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, pb.getPj_admin());
				rs=psmt.executeQuery();
				if(rs.next()) {
					pj_no=rs.getInt(1);
				}
				
				//project 인원 넣기
				psmt.clearParameters();
				sql="insert into PjParti values(null,?,?,?)";
				psmt=conn.prepareStatement(sql);
				
				String userIdSplit[]=pb.getPjP_userId().split(",");
				for(int i=0;i<userIdSplit.length;i++) {
					psmt.setString(1, userIdSplit[i]);
					psmt.setInt(2, pj_no);
					psmt.setString(3, pb.getPjP_position());
					state=psmt.executeUpdate();
				}
				
				//그룹 별 프로젝트 생성
				psmt.clearParameters();
				sql="insert into PjGroup values(null,?,?,?)";
				psmt=conn.prepareStatement(sql);
				
				String g_title[]=pb.getPjG_title().split(",");
				for(int i=0;i<g_title.length;i++) {
					psmt.setString(1, null);//그룹 팀장 프로젝트 생성후 지정....
					psmt.setString(2, g_title[i]);
					psmt.setInt(3, pj_no);
					state=psmt.executeUpdate();
				}
				//MY프로젝트 현황 생성
				psmt.clearParameters();
				sql="insert into MainPjSelect values(null,?,'0','0',?)";
				psmt=conn.prepareStatement(sql);
				for(int i=0;i<userIdSplit.length;i++) {
					psmt.setString(1, userIdSplit[i]);
					psmt.setInt(2, pj_no);
					state=psmt.executeUpdate();
				}
				
				//구매내역에 추가
				psmt.clearParameters();
				sql="insert into Buy values(null,?,?,?,?,?,?)";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, pb.getPj_serviceDate());
				psmt.setTimestamp(2, pb.getPj_date());
				psmt.setString(3, buy_price); //구매가격 0
				psmt.setString(4, "30");
				psmt.setString(5, pb.getPj_admin());
				psmt.setInt(6, pj_no);
				state=psmt.executeUpdate();
		
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//close(rs);
			close(psmt);
			
		}
		
		return state;
	}
	
	
	//알림생성 work
	public int Work(Work work, int pj_no,String myId) throws Exception {
		int state=0;
		PreparedStatement psmt=null;
		PreparedStatement psmt2=null;
		ResultSet rs=null;
		String sql="";
		int pjpno=0;
		try {
			//작성자 번호 
			sql="select pjp.pjp_no from project pj, pjparti pjp where pj.pj_no=pjp.pjp_noFk AND pj.pj_no=? AND pjp.pjp_userId=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, pj_no);
			psmt.setString(2, myId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				pjpno=rs.getInt(1);
			}
			
			psmt.clearParameters();
			//알림생성
			sql="insert into work values(null,?,?,?,?,?,?,?,?,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, work.getWo_write());
			psmt.setString(2, work.getWo_title());
			psmt.setString(3, work.getWo_content());
			psmt.setTimestamp(4, work.getWo_date());
			psmt.setString(5, work.getWo_StratDate());
			psmt.setString(6, work.getWo_EndDate());
			psmt.setInt(7, work.getWo_status());	//확인여부
			psmt.setString(8, "0");
			psmt.setInt(9, pjpno);//프로젝트 번호
			psmt.executeUpdate();
			
			psmt.clearParameters();
			//생성한 업무 열람
			sql="select Max(wo_no) from work";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=rs.getInt(1);
			}
			
			psmt.clearParameters();
			//프로젝트 참가 팀원 검색(모든 팀원)
			sql="select pjp_userId from project pj, pjparti pjp where pj.pj_no=pjp.pjp_noFk AND pj.pj_no=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, pj_no);
			rs=psmt.executeQuery();
			int i=0;
			if(rs.next()) {
				do {
					System.out.println("실행");
					//받는 사람
					sql="insert into worksend values(null,?,?,?,?,?)";
					psmt2=conn.prepareStatement(sql);
					psmt2.setString(1, myId);
					psmt2.setString(2, rs.getString("pjp_userId"));
					psmt2.setString(3, "0");
					psmt2.setInt(4, 0);
					psmt2.setInt(5, state);
					psmt2.addBatch();
					if(i%1000==0) {
						psmt2.executeBatch();
					}
					i++;
				}while(rs.next());
			}
			psmt2.executeBatch();

			//이미지 파일
			sql="";
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
			close(psmt2);
		}
		
		return state;
	}
	//기간 내 모든 업무리스트 조회 (신규업무)
	public ArrayList<Work> workList(int pj_no, String myId) {
		ArrayList<Work> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="";
		try {
			sql="select * from project pj,pjparti pjpa, work wo, WorkSend wos where pj.pj_no=pjpa.pjp_noFk AND pjpa.pjp_no = wo.pjp_noFk AND wo.wo_no=wos.wo_noFk AND pj.pj_no=? AND wos.ws_sending=? AND WS_work=0 ORDER BY ws_no DESC";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, pj_no);
			psmt.setString(2, myId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<Work>();
				do {
					Work work=new Work();
					work.setWs_no(rs.getInt("WS_no"));
					work.setWo_no(rs.getInt("wo_no"));
					work.setWo_title(rs.getString("wo_title"));
					work.setWo_content(rs.getString("wo_content"));
					work.setWo_date(rs.getTimestamp("wo_date"));
					list.add(work);
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//기간 내 모든 업무리스트 조회 (내업무에서 조회)
	public ArrayList<Work> workMyList(int pj_no, String myId) {
		ArrayList<Work> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="";
		try {
			sql="select * from project pj,pjparti pjpa, work wo, WorkSend wos where pj.pj_no=pjpa.pjp_noFk AND pjpa.pjp_no = wo.pjp_noFk AND wo.wo_no=wos.wo_noFk AND pj.pj_no=? AND wos.ws_sending=? AND WS_work=1 ORDER BY ws_no DESC";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, pj_no);
			psmt.setString(2, myId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<Work>();
				do {
					Work work=new Work();
					work.setWs_no(rs.getInt("WS_no"));
					work.setWo_no(rs.getInt("wo_no"));
					work.setWo_title(rs.getString("wo_title"));
					work.setWo_content(rs.getString("wo_content"));
					work.setWo_date(rs.getTimestamp("wo_date"));
					list.add(work);
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//업무 구분 변경(신규 업무 내업무 위치)
	public int workSortChange(String myId, int pj_no,String []myWorkArray, String []noWorkArray) {
		int state=0;
		PreparedStatement psmt=null;
		String sql="";
		try {
			if(myWorkArray!=null) {
				sql="update worksend set WS_work=1 where WS_sending=? AND ws_no=?";
				psmt=conn.prepareStatement(sql);
				System.out.println(myWorkArray.length);
				for(int i=0; i<myWorkArray.length;i++) {
					psmt.setString(1,myId);
					psmt.setString(2, myWorkArray[i]);
					psmt.addBatch();
					if(i%1000==0) {
						psmt.executeBatch();
					}
				}
				psmt.executeBatch();
				psmt.clearParameters();
				state=1;
			}
			
			if(noWorkArray!=null) {
				sql="update worksend set WS_work=0 where WS_sending=? AND ws_no=?";
				psmt=conn.prepareStatement(sql);
				for(int i=0; i<noWorkArray.length;i++) {
					psmt.setString(1,myId);
					psmt.setString(2, noWorkArray[i]);
					psmt.addBatch();
					if(i%1000==0) {
						psmt.executeBatch();
					}
				}
				psmt.executeBatch();
				psmt.clearParameters();
				state=1;
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		
		return state;
	}
	// 업무 상세 보기
	public Work workView(int ws_no) {
		Work work=null;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			sql="select * from worksend ws,work wo where wo.wo_no=ws.wo_noFk AND ws_no=? ";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, ws_no);
			rs=psmt.executeQuery();
			if(rs.next()) {
				work=new Work();
				work.setWs_no(rs.getInt("ws_no"));
				work.setWs_receive(rs.getString("ws_receive"));
				work.setWo_title(rs.getString("wo_title"));
				work.setWo_content(rs.getString("wo_content"));
				work.setWo_StratDate(rs.getString("Wo_StartDate"));
				work.setWo_EndDate(rs.getString("Wo_EndDate"));
				
			}
			
		}catch(Exception e) {
			System.out.println("업무상세보기 오류");
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		
		return work;
	}
	
	// 내가 작성한 업무 리스트
	public ArrayList<Work> myWorkList(String myId) {
		Work work=null;
		ArrayList<Work> list=null;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			//sql="select Wo_no,ws_no,wo_title,wo_content,Wo_StartDate,Wo_EndDate from worksend ws,work wo group by Wo_no ORDER BY WS_receive=?";
			sql="select * from work where Wo_write=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list =new ArrayList<Work>();
				do {
					work=new Work();
					work.setWo_no(rs.getInt("wo_no"));
					//work.setWs_no(rs.getInt("ws_no"));
					work.setWo_title(rs.getString("wo_title"));
					work.setWo_content(rs.getString("wo_content"));
					work.setWo_StratDate(rs.getString("Wo_StartDate"));
					work.setWo_EndDate(rs.getString("Wo_EndDate"));
					list.add(work);
				}while(rs.next());
			}
			
		}catch(Exception e) {
			System.out.println("내가 작성한 업무 리스트 오류");
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		return list;
	}
	// 내가 작성한 업무 조회
		public Work myWorkView(int wo_no,String myId) {
			Work work=null;
			String sql="";
			PreparedStatement psmt=null;
			ResultSet rs=null;
			try {
				sql="select * from worksend ws,work wo where wo.wo_no=ws.wo_noFk AND wo_no=? AND Wo_write=? ";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1, wo_no);
				psmt.setString(2, myId);
				rs=psmt.executeQuery();
				if(rs.next()) {
					work=new Work();
					work.setWo_no(rs.getInt("wo_no"));
					work.setWs_no(rs.getInt("ws_no"));
					work.setWo_title(rs.getString("wo_title"));
					work.setWo_content(rs.getString("wo_content"));
					work.setWo_StratDate(rs.getString("Wo_StartDate"));
					work.setWo_EndDate(rs.getString("Wo_EndDate"));
					work.setWs_receive(rs.getString("ws_receive"));
					
				}
				
			}catch(Exception e) {
				System.out.println("내가 작성한 업무 리스트 오류");
				e.printStackTrace();
			}finally {				;
				close(psmt);
			}
			return work;
		}
	// 내알림 수정 하기
	public int myWorkChange(int wo_no, String myId,Work work) {
		int state=0;
		String sql="";
		PreparedStatement psmt=null;
		try {
	
			sql="update work set Wo_title=?,Wo_content=?,Wo_StartDate=?,Wo_EndDate=? where Wo_no=? AND Wo_write=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, work.getWo_title());
			psmt.setString(2, work.getWo_content());
			psmt.setString(3, work.getWo_StratDate());
			psmt.setString(4, work.getWo_EndDate());
			psmt.setInt(5, wo_no);
			psmt.setString(6, myId);
			state=psmt.executeUpdate();
		
		}catch(SQLException e) {
			System.out.println("내알림 수정 하기 오류");
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		return state;
		
	}
	// 내 알림 삭제
	public int MyworkDelete(int wo_no, String myId) {
		int state=0;
		String sql="";
		PreparedStatement psmt=null;
		try {
	
			sql=" delete from worksend where wo_nofk=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, wo_no);
			state=psmt.executeUpdate();
			
			psmt.clearParameters();
			sql=" delete from work where wo_no=? AND Wo_write=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, wo_no);
			psmt.setString(2, myId);
			state=psmt.executeUpdate();
		
		}catch(SQLException e) {
			System.out.println("내알림 삭제 오류");
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		return state;
	}
	
	//모든 회원 아이디 가져오기 (추후 친구 목록 아이디로 변경 예정)
	public ArrayList<MemberAll> memberInfoSelect(String myId) throws SQLException {
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		ArrayList<MemberAll> list= null;
		try {
			sql="select EM_id,EM_name from e_member where EM_id!=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myId);
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				list=new ArrayList<MemberAll>();
				do {
					MemberAll mba=new MemberAll();
					mba.setEM_id(rs.getString(1));
					mba.setEM_name(rs.getString(2));
					list.add(mba);
				}while(rs.next());
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(psmt);
		}
		
		return list;
	
	}
	
	//대표 프로젝트 조회
	public ArrayList<ProjectBean> projectSelectMain(String pj_admin) throws ParseException{
		ArrayList<ProjectBean> list=null;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		int pj_no=-1;
		String endDate=null;
		try {
			//1.프로젝트가 존재하는지 검색
			sql="select Pj_no from MainPjSelect where MainP_id=? AND MainP_status!='0'";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, pj_admin);
			rs=psmt.executeQuery();
			if(rs.next()) {
				//현재일 구하기 (프로젝트 만료 기간 제외하기위해 만듬)
				SimpleDateFormat smd=new SimpleDateFormat("yyy-MM-dd");
				Date now =new Date();
				String nowFormat=smd.format(now);
				
				//존재하고 메인 프로젝트로 지정이 되어있다면
				psmt.clearParameters();
				sql="select Pj_no from project where Pj_no=? AND DATEDIFF(Pj_serviceDate,?)";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, rs.getString("Pj_no"));
				psmt.setString(2, nowFormat);
				rs=psmt.executeQuery();
				if(rs.next()) {
					pj_no=rs.getInt(1);
				}
				
				psmt.clearParameters();
				sql="select * from project where Pj_no=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1, pj_no);
				rs=psmt.executeQuery();
				if(rs.next()) {
					list=new ArrayList<ProjectBean>();
					do {
						ProjectBean pjb=new ProjectBean();
						pjb.setPj_no(rs.getInt("Pj_no"));
						pjb.setPj_admin(rs.getString("Pj_admin"));
						pjb.setPj_title(rs.getString("Pj_title"));
						pjb.setPj_subTitle(rs.getString("Pj_subTitle"));
						pjb.setPj_date(rs.getTimestamp("Pj_date"));
						pjb.setPj_serviceDate(rs.getString("Pj_serviceDate"));
						pjb.setPj_space(rs.getString("Pj_space"));
						list.add(pjb);
					}while(rs.next());
				}
			}else {
				//존재 할수도 있고 안할 수 도있지만 존재한다면 그중 첫번째 값을 메인에 뿌려줌
			
				//현재일 구하기 (프로젝트 만료 기간 제외하기위해 만듬)
				SimpleDateFormat smd=new SimpleDateFormat("yyy-MM-dd");
				Date now =new Date();
				String nowFormat=smd.format(now);
				psmt.clearParameters();
				//초기 생성 프로젝트를 기본 메인 프로젝트로 지정(진행중인 프로젝트 오랜된프로젝트 메인으로 검색)
				sql="select MIN(Pj_no) from project where Pj_admin=? AND  DATEDIFF(Pj_serviceDate,?)";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, pj_admin);
				psmt.setString(2, nowFormat);
				rs=psmt.executeQuery();
				if(rs.next()) {
					pj_no=rs.getInt(1);
				}
				psmt.clearParameters();
				sql="select * from project where Pj_no=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1, pj_no);
				rs=psmt.executeQuery();
				if(rs.next()) {
					list=new ArrayList<ProjectBean>();
					do {
						ProjectBean pjb=new ProjectBean();
						pjb.setPj_no(rs.getInt("Pj_no"));
						pjb.setPj_admin(rs.getString("Pj_admin"));
						pjb.setPj_title(rs.getString("Pj_title"));
						pjb.setPj_subTitle(rs.getString("Pj_subTitle"));
						pjb.setPj_date(rs.getTimestamp("Pj_date"));
						pjb.setPj_serviceDate(rs.getString("Pj_serviceDate"));
						pjb.setPj_space(rs.getString("Pj_space"));
						list.add(pjb);
					}while(rs.next());
				}
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(psmt);
		}
		
		return list;
	}
	
	// 참여중인 프로젝트 현황 조회 (그룹별 프로젝트로 변경중 그룹별 프로젝트 생성뒤 변경 예정)
	public ArrayList<ProjectBean> selectMyProject(String myid){
		ArrayList<ProjectBean> list=null;
		String sql="";
		ResultSet rs=null;
		PreparedStatement psmt=null;
		try {
			sql="select p.pj_no,pj_admin,pj_title,MainP_status from Project p,MainPjSelect m where m.pj_no=p.pj_no AND MainP_id=? AND Main_Approval!=0 AND Main_Approval!=-1 ";
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myid);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<ProjectBean>();
				do {
					ProjectBean pjb=new ProjectBean();
					pjb.setPj_no(rs.getInt(1));
					pjb.setPj_admin(rs.getString(2));
					pjb.setPj_title(rs.getString(3));
					pjb.setMainP_status(rs.getString(4));
					list.add(pjb);
				}while(rs.next());
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		
		
		return list;
	}
	// 승인 대기중인 프로젝트
	public ArrayList<ProjectBean> selectMyProjectApproval(String myid){
		ArrayList<ProjectBean> lista=null;
		String sql="";
		ResultSet rs=null;
		PreparedStatement psmt=null;
		try {
			sql="select p.pj_no,pj_admin,pj_title,MainP_status,MainP_no from Project p,MainPjSelect m where m.pj_no=p.pj_no AND MainP_id=? AND Main_Approval=0 AND Pj_space!='-1'";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myid);
			rs=psmt.executeQuery();
			if(rs.next()) {
				lista=new ArrayList<ProjectBean>();
				do {
					ProjectBean pjb=new ProjectBean();
					pjb.setPj_no(rs.getInt(1));
					pjb.setPj_admin(rs.getString(2));
					pjb.setPj_title(rs.getString(3));
					pjb.setMainP_status(rs.getString(4));
					pjb.setMainP_no(rs.getString(5));
					lista.add(pjb);
				}while(rs.next());
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		
		
		return lista;
	}
	
	
	//프로젝트 메인 페이지 노출 하기
	public int projectMainSetting(String myid,String no ){
		int state=0;
		ArrayList<ProjectBean> list=null;
		String sql="";
		ResultSet rs=null;
		PreparedStatement psmt=null;
		
		//사용자 모든 프로젝트 노출 제외 0으로 초기화
		try {
			sql="update MainPjSelect set MainP_status='0' where MainP_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myid);
			state=psmt.executeUpdate();
			if(state>0) {
				psmt.clearParameters();
				sql="update MainPjSelect set MainP_status='1' where MainP_id=? AND Pj_no=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, myid);
				psmt.setString(2, no);
				state=psmt.executeUpdate();
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		
		
		return state;
	}
	//프로젝트 승인하기
	public int projectApplSetting(String myid,String no,String Applno ){
		int state=0;
		ArrayList<ProjectBean> list=null;
		String sql="";
		PreparedStatement psmt=null;
		
		//사용자 모든 프로젝트 노출 제외 0으로 초기화
		try {
			sql="update MainPjSelect set Main_Approval=? where MainP_id=? AND MainP_no=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, Applno);
			psmt.setString(2, myid);
			psmt.setString(3, no);
			state=psmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		
		
		return state;
	}
	
	
	//내가 생성한 프로젝트 목록
	public ArrayList<ProjectBean> myProjectList(String myid){
		ArrayList<ProjectBean> list=null;
		String sql=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			sql="select pj_no,pj_admin,pj_title,pj_date,pj_serviceDate,pj_space,DATE_FORMAT(Pj_date, '%Y-%m-%d') DATEONLY, TO_DAYS(Pj_serviceDate) - TO_DAYS(NOW()) AS CHA from project where Pj_admin=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myid);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<ProjectBean>();
				do {
					ProjectBean pjb=new ProjectBean();
					pjb.setPj_no(rs.getInt("pj_no"));
					pjb.setPj_admin(rs.getString("pj_admin"));
					pjb.setPj_title(rs.getString("pj_title"));
					pjb.setPj_date(rs.getTimestamp("pj_date"));
					pjb.setPj_serviceDate(rs.getString("pj_serviceDate"));
					pjb.setPj_space(rs.getString("pj_space"));
					pjb.setPj_dateSlice(rs.getString("DATEONLY"));
					pjb.setPj_dateRemain(rs.getInt("CHA"));
					list.add(pjb);					
				}while(rs.next());
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	//회원 중복 체크
	public int joinOverCk(String id) {
		int state=0;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="";
		try {
			sql="select * from e_member where EM_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return state;
	}
	
	//회원 탈퇴
	public int withdrawal(String myId, String pw) {
		int state=0;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="";
		
		try {
			sql="select * from e_member where em_id=? AND em_pw=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myId);
			psmt.setString(2, pw);
			rs=psmt.executeQuery();
			if(rs.next()) {
				
				//프로젝트 번호 -1 은 삭제된 프로젝트로 칭함
				sql="update project set pj_space='-1' where pj_admin=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, myId);
				state=psmt.executeUpdate();
				
				//회원정보 삭제 된것 처럼
				sql="update e_member set em_appcode='-1' where em_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, myId);
				state=psmt.executeUpdate();
				
				/*
				state=1;
				psmt.clearParameters();
				//알림 지우기
				sql="delete from WorkSend where ws_receive=? OR ws_sending=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, myId);
				psmt.setString(2, myId);
				psmt.executeUpdate();
				
				//Work Wimg 제거
				psmt.clearParameters();
				sql="delete work,wimg from work,Wimg where work.wo_no=wimg.wimg_noFk AND wo_write=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, myId);
				psmt.executeUpdate();
				
				//프로젝트 삭제
				psmt.clearParameters();
				sql="delete pjgparti,pjgp,pjgarti,pjgroup,mainPjselect,pjparti, project from project,pjparti,pjgroup,mainPjselect,pjgarti,pjgp,pjgparti WHERE project.pj_no=pjparti.pjp_noFk AND MainpjSelect.pj_no=project.pj_no AND pjgroup.pjp_noFk=project.pj_no AND pjgroup.pjg_no=pjgarti.pjg_noFk AND pjgp.pjg_no=pjgroup.pjg_no AND pjgp.pjgp_no=pjgpArti.pjgp_no AND pj_admin=?";
				"select * from project,pjparti,mainPjSelect,pjgroup WHERE project.pj_no=pjparti.pjp_noFk AND project.pj_no=mainPjselect.pj_no AND pjgroup.pjp_noFk=project.pj_no AND pj_admin='test';"
				"select pjg_no,project.pj_no,pjp_no,pjg_no,mainp_no from project,pjparti,mainPjSelect,pjgroup WHERE project.pj_no=pjparti.pjp_noFk AND project.pj_no=mainPjselect.pj_no AND pjgroup.pjp_noFk=project.pj_no AND pj_admin='test';"
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, myId);
				psmt.executeUpdate();
				*/
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	
	
	/*
	 * 조직도 검색을 위한 쿼리
	 * 
	 */
	//프로젝트 관리자 가져오기
	public String searchProjectAdmin(int pjNo) {
		String admin=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		String adminName=null;
		String sql="select * from Project where Pj_no=?";
		String sql2="select EM_name from e_member where EM_id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, pjNo);
			rs=psmt.executeQuery();
			if(rs.next()) {
				psmt.clearParameters();
				psmt=conn.prepareStatement(sql2);
				psmt.setString(1, rs.getString("Pj_admin"));
				rs2=psmt.executeQuery();
				if(rs2.next()) {
					adminName=rs2.getString("EM_name");
				}
				admin=adminName;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	//프로젝트 그룹별 팀장 가져오기
	public ArrayList<ProjectGroupBean> searchProjectGAdmin(int pjNo){
		ArrayList<ProjectGroupBean> list=null;
		PreparedStatement psmt=null;
		String adminName=null;
		String img=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		String joinDate=null;
		String sql="select * from PjGroup where PjP_noFk=?";
		String sql2="select EM_name,EM_document,EM_date from e_member where EM_id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, pjNo);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<ProjectGroupBean>();
				do {
					psmt.clearParameters();
					psmt=conn.prepareStatement(sql2);
					psmt.setString(1, rs.getString("PjG_admin"));
					rs2=psmt.executeQuery();
					if(rs2.next()) {
						adminName=rs2.getString("EM_name");
						img=rs2.getString("EM_document");
						joinDate=rs2.getString("EM_date");
						
					}
					
					ProjectGroupBean pgb=new ProjectGroupBean();
					pgb.setPjp_noFk(rs.getInt("PjP_noFk"));
					pgb.setPjG_no(rs.getInt("PjG_no"));
					pgb.setPjg_title(rs.getString("PjG_title"));
					pgb.setMyfrofile(img);
					pgb.setJoinDate(joinDate);
					pgb.setPjg_admin(adminName);
					list.add(pgb);
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//프로젝트 그룹별 참여 인원 가져오기
	public ArrayList<ProjectGroupBean> searchProjectGUser(int pjNo){
		ArrayList<ProjectGroupBean> list=null;
		PreparedStatement psmt=null;
		String adminName=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		int pjgNo=0;
		String sql="select DISTINCT PjG_userId,PjG_no from PjGArti,PjGroup where PjGArti.PjG_noFk=PjGroup.PjG_no AND PjGroup.PjP_noFk=?";
		String sql2="select EM_name from e_member where EM_id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, pjNo);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<ProjectGroupBean>();
				do {
					psmt.clearParameters();
					psmt=conn.prepareStatement(sql2);
					psmt.setString(1, rs.getString("PjG_userId"));
					rs2=psmt.executeQuery();
					if(rs2.next()) {
						adminName=rs2.getString("EM_name");
					}
					ProjectGroupBean pgb=new ProjectGroupBean();
					pgb.setPjg_admin(adminName);
					pgb.setPjp_noFk(rs.getInt("PjG_no"));
					list.add(pgb);
					
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//프로젝트 그룹별 팀장 설정
	public int pgAdminSetting(int pjpNoFk,String pjg_admin) {
		int state=0;
		ArrayList<ProjectGroupBean> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="update PjGroup set PjG_admin=? where PjP_noFk=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, pjg_admin);
			psmt.setInt(2, pjpNoFk);
			state=psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	
	
}
