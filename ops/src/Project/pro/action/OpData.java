package Project.pro.action;

import static comm.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Project.beans.Chatting;
import Project.beans.Member;
import Project.beans.ProjectBean;
import Project.beans.ProjectGroupBean;
import Project.beans.ProjectGroupProject;
import Project.beans.UploadFileBean;
public class OpData {
	Connection conn=null;
	private static OpData instance = new OpData();
	public static OpData getInstance() {
		return instance;
	}
	public void setConnection(Connection conn) {
		this.conn=conn;
	}
	
	//현재 프로젝트 검색
	public ArrayList<ProjectBean> opMainProject(String pj_no){
		ArrayList<ProjectBean> list=null;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			//sql="select pj.Pj_no,pj_admin,pj_title,pj_subTitle,pj_date,Pj_serviceDate, from project pj,pjparti pjp,pjGroup pjg where pj.pj_no=pjp.pjp_noFk AND pjg.pjp_noFK=pj.pj_no AND pj_no=?";
			//프로젝트 검색
			sql="select Pj_no,Pj_admin,Pj_title,Pj_subTitle,Pj_date,Pj_serviceDate,Pj_space from project where pj_no=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, pj_no);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<ProjectBean>();
				do {
					ProjectBean pjb=new ProjectBean();
					pjb.setPj_no(rs.getInt(1));
					pjb.setPj_admin(rs.getString(2));
					pjb.setPj_title(rs.getString(3));
					pjb.setPj_subTitle(rs.getString(4));
					pjb.setPj_date(rs.getTimestamp(5));
					pjb.setPj_serviceDate(rs.getString(6));
					pjb.setPj_space(rs.getString(7));
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
	//프로젝트 참여 권한 확인
	public ProjectBean opMainProjectRight(String pj_no,String myid){
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		ProjectBean pjb=null;
		try {
			sql="select pjp_userId,pjp_position,main_approval from pjparti pjp,MainPjSelect map where pjp.pjp_noFk= map.Pj_no AND pjp_noFk=? AND MainP_id=? AND pjp_userId=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, pj_no);
			psmt.setString(2, myid);
			psmt.setString(3, myid);
			rs=psmt.executeQuery();
			if(rs.next()) {
				pjb=new ProjectBean();
				pjb.setPjP_userId(rs.getString(1));
				pjb.setPjP_position(rs.getString(2));
				pjb.setMainP_Approval(rs.getString(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		return pjb;
	}
	
	
	//프로젝트 참여 인원검색
	public ArrayList<ProjectBean> opMainProjectPerson(String pj_no){
		ArrayList<ProjectBean> list=null;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			//sql="select pjp_userId,pjp_position from pjparti where pjp_noFk=?";
			sql="select pjp_userId,pjp_position,main_approval from pjparti pjp,MainPjSelect map where pjp.pjp_noFk= map.Pj_no AND pjp_noFk=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, pj_no);
			//psmt.setString(2, myid);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<ProjectBean>();
				do {
					ProjectBean pjb=new ProjectBean();
					pjb.setPjP_userId(rs.getString(1));
					pjb.setPjP_position(rs.getString(2));
					pjb.setMainP_Approval(rs.getString(3));
					
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
	
	//프로젝트 그룹 정보가져오기
	public ArrayList<ProjectBean> opMainProjectGroupPerson(String pj_no){
		ArrayList<ProjectBean> list=null;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			sql="select * from pjGroup where pjp_noFk=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, pj_no);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<ProjectBean>();
				do {
					ProjectBean pjb=new ProjectBean();
					pjb.setPjG_no(rs.getInt(1));
					pjb.setPjG_admin(rs.getString(2));
					pjb.setPjG_title(rs.getString(3));
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
	//프로젝트 그룹수
	public int projectGroupCount(String pj_no) {
		int state=0;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			sql="select count(*) from pjGroup where pjp_noFk=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, pj_no);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		return state;
	}
	//프로젝트 참여 인원
	public int projectPeCount(String pj_no) {
		int state=0;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			sql="select count(*) from pjparti where pjp_noFk=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, pj_no);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		return state;
	}
	
	//프로젝트 특정 그룹 참여 인원 정보가져오기
	public ArrayList<ProjectBean> projectGroupPeInfo(String pjg_no){
		ArrayList<ProjectBean> list=null;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			sql="select pjgroup.pjg_no,pjg_userId from pjgroup,pjgArti where pjgroup.pjg_no=pjgArti.pjg_noFk AND pjg_no=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, Integer.parseInt(pjg_no));
			rs=psmt.executeQuery();
			if(rs.next()) {
				list =new ArrayList<ProjectBean>();
				do {
					ProjectBean pjb =new ProjectBean();
					pjb.setPjG_no(rs.getInt(1));
					pjb.setPjg_userId(rs.getString(2));
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
	//프로젝트 특정 그룹 참여 인원 정보가져오기 (그룹번호 가 배열일경우) 오버로딩
		public ArrayList<ProjectGroupBean> projectGroupPeInfo(ArrayList<ProjectGroupBean> pjg_no){
			ArrayList<ProjectGroupBean> list=new ArrayList<ProjectGroupBean>();
			String sql="";
			PreparedStatement psmt=null;
			ResultSet rs=null;
			try {
				sql="select count(*) from pjgroup,pjgArti where pjgroup.pjg_no=pjgArti.pjg_noFk AND pjg_no=?";
				psmt=conn.prepareStatement(sql);
				for(int i=0; i< pjg_no.size();i++) {//그룹 반복 시켜서 배열에 답아서 각 그룹의 번호 추력 하려고함
					psmt.setInt(1, pjg_no.get(i).getPjG_no());
					rs=psmt.executeQuery();
					if(rs.next()) {
						do {
							ProjectGroupBean pjb =new ProjectGroupBean();
							pjb.setPeSize(rs.getInt(1));
							list.add(pjb);			
						}while(rs.next());
					}
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(psmt);
				
			}
			return list;
			
		}
	//프로젝트 그룹에 참여하지 않는 인원 조회
	public ArrayList<ProjectBean> ProjectGroupPreExc(int pj_no, int pjg_no){
		ArrayList<ProjectBean> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="";
		try {
			/*
			sql+="select * from pjparti where pjp_noFk=? AND pjp_userId != ALL"
			+ "(select pjga.pjg_userId from pjgarti pjga, pjgroup pjg, project pj, pjparti pjp "
			+ "where pjga.pjg_noFk=pjg.pjg_no AND pjg.pjp_noFk=pj.pj_no AND pj.pj_no=pjp.pjp_noFk AND pjp.pjp_no=pj.pj_no AND pj.pj_no=? AND pjg.pjg_no=?);";
			*/
			sql="select * from pjparti where pjp_noFk=? AND pjp_userId != ALL(select pjg_userId from pjgarti pjga, pjgroup pjg where pjga.pjg_noFK=pjg.pjg_no AND pjp_noFk=? AND pjg_no=?)";
			
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, pj_no);
			psmt.setInt(2, pj_no);
			psmt.setInt(3, pjg_no);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<ProjectBean>();
				do {
					ProjectBean pjb=new ProjectBean();
					pjb.setPjp_no(rs.getString("PjP_no"));
					pjb.setPjP_userId(rs.getString("PjP_userId"));
					list.add(pjb);
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
	
	
	//*******************추가**********************
	
	//프로젝트 그룹 참여인원 추가
	public int ProjectPreAdd(String []userId, int pj_no,int pjg_no) {
		int state=0;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		
		try {
			//해당 그룹 모든 사원 지우기
			sql="delete from pjgarti where pjg_noFk=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, pjg_no);
			state=psmt.executeUpdate();
			
			//추가
			for(int i=0; i<userId.length;i++) {
				if(userId[0].equals("")) {
					break;
				}
				sql="insert into pjgarti values(?,?)";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1, pjg_no);
				psmt.setString(2, userId[i]);
				state=psmt.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		
		return state;
	}
	
	//그룹 프로젝트 생성
	public int gorupProjectInsert(ProjectGroupProject pgp) {
		int state=0;
		String sql="";
		PreparedStatement psmt=null;
		try {
			sql="insert into pjgp values(null,?,?,?,?,?,?,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, pgp.getPjgp_title());
			psmt.setString(2, pgp.getPjgp_content());
			psmt.setString(3, pgp.getStartDate());
			psmt.setString(4, pgp.getEndDate());
			psmt.setTimestamp(5, pgp.getPjgp_date());
			psmt.setInt(6, pgp.getPjgp_division());
			psmt.setInt(7, pgp.getPjg_no());
			state=psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(psmt);
			
		}
		
		return state;
	}
	//그룹별 프로젝트 리스트 조회
	public ArrayList<ProjectGroupProject> ProjectGroupList(int pjg_no, String myId){
		ArrayList<ProjectGroupProject> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="";
		try {
			sql="select pjgp_no,pjgp_title,pjgp_content,startDate,endDate,pjgp_division from pjgp,pjgroup pjg,pjgarti pjga where pjg.pjg_no=pjga.pjg_noFk AND pjg.pjg_no=pjgp.pjg_no AND pjg.pjg_no=? AND pjga.pjg_userId=? ORDER BY pjgp_no DESC";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, pjg_no);
			psmt.setString(2, myId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<ProjectGroupProject>();
				do {
					ProjectGroupProject pjgp=new ProjectGroupProject();
					pjgp.setPjgp_no(rs.getInt("pjgp_no"));
					pjgp.setPjgp_title(rs.getString("pjgp_title"));
					pjgp.setPjgp_content(rs.getString("pjgp_content"));
					pjgp.setStartDate(rs.getString("startDate"));
					pjgp.setEndDate(rs.getString("endDate"));
					pjgp.setPjgp_division(rs.getInt("pjgp_division"));
					list.add(pjgp);
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
	
	//그룹별 프로젝트 조회
	public ProjectGroupProject ProjectGroup(int pjg_no, String myId,int pjgp_no){
		PreparedStatement psmt=null;
		ProjectGroupProject pjgp=null;
		ResultSet rs=null;
		String sql="";
		try {
			sql="select pjgp_no,pjgp_title,pjgp_content,startDate,endDate,pjgp_division from pjgp,pjgroup pjg,pjgarti pjga where pjg.pjg_no=pjga.pjg_noFk AND pjg.pjg_no=pjgp.pjg_no AND pjg.pjg_no=? AND pjga.pjg_userId=? AND pjgp_no=? ORDER BY pjgp_no DESC";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, pjg_no);
			psmt.setString(2, myId);
			psmt.setInt(3, pjgp_no);
			rs=psmt.executeQuery();
			if(rs.next()) {
				pjgp=new ProjectGroupProject();
				pjgp.setPjgp_no(rs.getInt("pjgp_no"));
				pjgp.setPjgp_title(rs.getString("pjgp_title"));
				pjgp.setPjgp_content(rs.getString("pjgp_content"));
				pjgp.setStartDate(rs.getString("startDate"));
				pjgp.setEndDate(rs.getString("endDate"));
				pjgp.setPjgp_division(rs.getInt("pjgp_division"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
			
		}
		
		
		return pjgp;
	}
	

	//그룹 파일 업로드
	public int uploadPro(String folder,String fileName,int pj_no,int pjgp_no , String exten,String myId) {
		int state=0;
		String sql="";
		PreparedStatement psmt=null;
		try {
			System.out.println(pj_no);
			sql="insert into FileUpload values(null,?,?,?,?,?,?,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, folder);
			psmt.setString(2, fileName);
			psmt.setString(3, exten); //확장자
			psmt.setString(4, myId);
			psmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			psmt.setInt(6, pjgp_no);
			psmt.setInt(7, pj_no);
			state=psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		return state;
	}
	//그룹별 업로드 파일 조회
	public ArrayList<UploadFileBean> uploadList(int pj_no,int pjg_no){
		ArrayList<UploadFileBean> list=null;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			
			sql="select * from fileupload where pjg_no=? AND pj_no=? ORDER BY file_no DESC";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, pjg_no);
			psmt.setInt(2, pj_no);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<UploadFileBean>(); 
				do {
					UploadFileBean uf=new UploadFileBean();
					uf.setFile_no(rs.getInt("file_no"));
					uf.setFile_fileName(rs.getString("file_fileName"));
					uf.setFile_folder(rs.getString("file_folder"));
					uf.setFile_exten(rs.getString("file_exten"));
					uf.setFile_admin(rs.getString("file_admin"));
					uf.setFile_date(rs.getString("file_date"));
					list.add(uf);
					
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
	// 파일 삭제
	public int deleteFile(int file_no, String myId) {
		int state=0;
		PreparedStatement psmt=null;
		String sql="";
		try {
			sql="delete from FileUpload where file_no=? AND file_admin=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, file_no);
			psmt.setString(2, myId);
			state=psmt.executeUpdate();			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		
		
		return state;
	}
	
	
	/*********************** 채팅 관련 ******************************/
	//친구 찾기
	public Member searchFriend(String userId,String myId) {
		Member mb=new Member();
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		int friendState=0;
		try {
			// 친구 찾기 (친구 목록에 추가 되어있다면 제외)
			sql="select * from chatting WHERE Cha_me=? AND Cha_opp=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myId);	//나를 기준으로 채팅방이 만들어져있는지 먼저 확인
			psmt.setString(2, userId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				friendState=1;
			}else {
				//만약 나를 기준으로 채팅방을 만들지 않았다면
				psmt.clearParameters();
				sql="select * from chatting WHERE Cha_me=? AND Cha_opp=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, userId);	//상대로 기준으로 한번더 검색
				psmt.setString(2, myId);
				rs=psmt.executeQuery();
				if(rs.next()) {
					friendState=1;
				}
			}
			if(friendState==0) {
				//채팅방 목록이 존재 하지 않는다면 친구 찾기 가능
				//나를 기준으로 채팅방을 만듬 
				psmt.clearParameters();
				//상대 아이디가 존재하는지 확인
				sql="select em_id,em_name from e_member where em_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, userId);
				rs=psmt.executeQuery();
				if(rs.next()) {
					mb.setEM_id(rs.getString("em_id"));
					mb.setEM_name(rs.getString("em_name"));
				}
			}else {
				//이미 친구 목록에 추가 되어있다면
				mb.setEM_uniqueCode("ok");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		
		return mb;
	}
	
	//친구 추가
	public int selectFriendAdd(String userId,String myId,String title) {
		int state=0;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		int friendState=0;
		try {
		// 친구 찾기 (친구 목록에 추가 되어있다면 제외)
		sql="select * from chatting WHERE Cha_me=? AND Cha_opp=?";
		psmt=conn.prepareStatement(sql);
		psmt.setString(1, myId);	//나를 기준으로 채팅방이 만들어져있는지 먼저 확인
		psmt.setString(2, userId);
		rs=psmt.executeQuery();
		if(rs.next()) {
			friendState=1;
		}else {
			//만약 나를 기준으로 채팅방을 만들지 않았다면
			psmt.clearParameters();
			sql="select * from chatting WHERE Cha_me=? AND Cha_opp=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userId);	//상대로 기준으로 한번더 검색
			psmt.setString(2, myId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				friendState=1;
			}
		}
		if(friendState==0) {
			//친구 찾기 후 친구 추가 할수 있다.
			//회원이 존재 한다면 고유 코드 번호 생성
			Date now =new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("YYY-MM-dd");
			String nowDate=sdf.format(now);
			String chatCode= nowDate+"-"+myId+"-"+userId;
			psmt.clearParameters();
			sql="insert into chatting values(?,?,?,?,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, chatCode);
			psmt.setString(2, myId);	//나를 기준으로 채팅방 생성
			psmt.setString(3, userId);
			psmt.setString(4, null);
			psmt.setString(5, "0");	//승인대기
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
	
	
	/*승인 대기중인 친구목록*/
	public ArrayList<Chatting> chattingAck(String myId){
		ArrayList<Chatting> list =null;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			sql="select * from chatting where Cha_opp=? AND Cha_appr=0";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myId);
			rs=psmt.executeQuery();
			
			if(rs.next()) {				
				list=new ArrayList<Chatting>();
				do {
					Chatting chat=new Chatting();
					chat.setCha_me(rs.getString("Cha_me")); 	//여기선 상대 아이디가 me가 됨
					chat.setCha_code(rs.getString("Cha_code"));
					chat.setCha_opp(rs.getString("cha_opp"));
					list.add(chat);
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
	
	/*친구 추가 한 목록 가져오기 (승인 대기중 제외)*/
	public ArrayList<Chatting> chatting(String myId){
		ArrayList<Chatting> list =null;
		String sql="";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			sql="select * from chatting where Cha_me=? OR Cha_opp=? AND Cha_appr=1";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myId);
			psmt.setString(2, myId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<Chatting>();
				do {
					Chatting ct=new Chatting();
					ct.setCha_me(rs.getString("Cha_me"));
					ct.setCha_code(rs.getString("cha_code"));
					ct.setCha_opp(rs.getString("cha_opp"));
					ct.setCha_appr(rs.getString("cha_appr"));
					list.add(ct);					
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
	//친구 승인 거절하기
	public int friendAcknoAdd(String id,String myId,String sta,String comp) {
		int state=0;
		PreparedStatement psmt=null;
		PreparedStatement psmt2=null;
		String sql="";
		try {
			//상대 방이 친구 추가 거절
			if(comp.equals("0")) {
				sql="update Chatting set Cha_appr=? where Cha_me=? AND Cha_opp=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, sta);
				psmt.setString(2, id);	//현재 값에서는 me 상대 id 임
				psmt.setString(3, myId);
				state=psmt.executeUpdate();
			}else{
				System.out.println(myId);

				System.out.println(id);
				
				//거절시 재용청 할수 있음
				sql="update Chatting set Cha_appr='0' where Cha_me=? AND Cha_opp=?";
				psmt2=conn.prepareStatement(sql);
				psmt2.setString(1, myId);	//현재 값에서는 me 본인
				psmt2.setString(2, id);
				state=psmt2.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(psmt);
			close(psmt2);
		}
		
		return state;
	}
}
