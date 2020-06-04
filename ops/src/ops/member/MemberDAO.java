package ops.member;

import static common.ConUtilDAO.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Random;

import ops.business.Business;
import ops.member.beans.EmemberBean;
import ops.member.beans.MemberBean;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		if(instance==null)
			instance=new MemberDAO();
		return instance;
	}
	Connection conn=null;
	public void setConnection(Connection conn) {
		this.conn=conn;
	}
	
	//회원가입 (일반)
	public int joinPro(MemberBean mb){
		int state=0;
		PreparedStatement psmt=null;
		String sql=null;		
		String password=SHA.passSHA512(mb.getPw());
		
		try {
		sql="insert into member(id,pw,name,phone,email,sex,joinData,zipNo,roadAddr,jibunAddr,realAddr,profile,birthday) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		psmt=conn.prepareStatement(sql);
		psmt.setString(1, mb.getId());
		psmt.setString(2, password);
		psmt.setString(3, mb.getName());
		psmt.setString(4, mb.getPhone());
		psmt.setString(5, mb.getEmail());
		psmt.setString(6, mb.getSex());
		psmt.setTimestamp(7, mb.getJoinData());
		psmt.setString(8, mb.getZipNo());
		psmt.setString(9, mb.getRoadAddr());
		psmt.setString(10, mb.getJibunAddr());
		psmt.setString(11, mb.getRealAddr());
		psmt.setString(12, mb.getProfile());
		psmt.setString(13, mb.getBirthday());
		state=psmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(psmt!=null) {
				close(psmt);
			}
		}
		
		return state;
	}
	//사업자 등록번호 조회
	public HashMap<String, String> EmBusinessLicence(String liceName,String liceNum) throws Exception {
		Business bs=new Business();
		HashMap<String, String> licence=bs.businessOk(liceName, liceNum);
		return licence;		
	}
	
	//회원가입 (기업)
	public int joinEmPro(EmemberBean mb,String uni_uniqueName, String uni_uniqueCodeNo){
		int state=0;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;		
		String password=SHA.passSHA512(mb.getEn_pw());
		try {
			sql="select * from uniques where uni_uniqueCodeNo=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, uni_uniqueCodeNo);
			rs=psmt.executeQuery();
			if(!rs.next()) {
				sql="insert into uniques(uni_uniqueCodeNo,uni_uniqueName,uni_confirmNum,uni_img) values(?,?,?,?)";//사업자등록
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, uni_uniqueName);
				psmt.setString(2, uni_uniqueCodeNo);
				psmt.setInt(3, 0);
				psmt.setString(4, "no");
				state=psmt.executeUpdate();
			}else {
				state=1;
			}
			if(state>0) {
				//OPS DB
				sql="insert into enmember(en_no,en_id,en_pw,en_name,en_phone,en_Email,en_sex,en_joinData,en_confirmNum,en_img,un_uniqueCodeFk,repName,typeOfBusiness,joinNumber,repNum) values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				psmt.clearParameters();
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, mb.getEn_id());
				psmt.setString(2, password);
				psmt.setString(3, mb.getEn_name());
				psmt.setString(4, mb.getEn_phone());
				psmt.setString(5, mb.getEn_Email());
				psmt.setString(6, mb.getEn_sex());
				psmt.setTimestamp(7, mb.getEn_joinData());
				psmt.setInt(8, mb.getEn_confirmNum());
				psmt.setString(9, mb.getEn_img());
				psmt.setString(10, uni_uniqueCodeNo);
				psmt.setString(11, mb.getRepName());
				psmt.setString(12, mb.getTypeOfBusiness());
				psmt.setString(13, mb.getJoinNumber());
				psmt.setString(14, mb.getRepNum());
				state=psmt.executeUpdate();
				
				//PJ DB
				sql="insert into project.e_member(EM_id,EM_pw,EM_name,EM_bir,EM_phon,EM_email,EM_document,EM_appCode,EM_date,EM_uniqueCode) values(?,?,?,?,?,?,?,?,?,?)";
				psmt.clearParameters();
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, mb.getEn_id());
				psmt.setString(2, password);
				psmt.setString(3, mb.getEn_name());
				psmt.setString(4, "");
				psmt.setString(5, mb.getEn_phone());
				psmt.setString(6, mb.getEn_Email());
				psmt.setString(7, mb.getEn_img());
				psmt.setInt(8, 0);
				psmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
				psmt.setString(10, "1");
				state=psmt.executeUpdate();
				
				
			}
			
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(psmt!=null) {
				close(psmt);
			}
		}
		
		return state;
	}
	
	//아이디 중복 체크
	public int overCk(String id) {
		int state=0;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		try {
			sql="select * from member where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=1;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return state;		
	}
	//아이디 중복 체크(기업)
	public int overCk2(String id) {
		int state=0;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		try {
			sql="select * from enmember where en_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=1;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return state;		
	}
	//일반 로그인
	public int loginUserPro(String userID,String userPW) {
		int state=0;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="";
		userPW=SHA.passSHA512(userPW);
		try {
			sql="select * from member where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userID);
			rs=psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pw").equals(userPW)) {
					state=1;
				}else {
					state=-1;
				}
			}else {
				state=0;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	//기업 로그인
	public int loginCorpPro(String userID,String userPW) {
		int state=0;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="";
		userPW=SHA.passSHA512(userPW);
		try {
			sql="select * from enmember where en_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userID);
			rs=psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("en_pw").equals(userPW)) {
					state=1;
				}else {
					state=-1;
				}
			}else {
				state=0;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	//일반 회원 비밀번호 찾기
	public String searchPassword(String myId, String phone) {
		String password=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="";
		try {
			sql="select * from member where id=? AND phone=?";
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
				String buf1=SHA.passSHA512(buf.toString());
				psmt.clearParameters();
				sql="update member set pw=? where id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, buf1);
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
	
	//회원 개인페이지 조회
	public MemberBean memberPage(String memberId) {
		MemberBean mb=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		try {
			//회원 이름가져오기
			sql="select * from member where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, memberId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				mb=new MemberBean();
				mb.setId(rs.getString("id"));
				mb.setName(rs.getString("name"));
				mb.setPhone(rs.getString("phone"));
				mb.setEmail(rs.getString("email"));
				mb.setProfile(rs.getString("profile"));
				mb.setSex(rs.getString("sex"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mb;
	}
	//일반 회원 정보 가져오기
	public MemberBean MyInfo(String id) {
		PreparedStatement psmt=null;
		ResultSet rs=null;
		MemberBean mb=null;
		String sql=null;
		try {
			sql="select * from member where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				mb=new MemberBean();
				mb.setId(rs.getString("id"));
				mb.setEmail(rs.getString("email"));
				mb.setPhone(rs.getString("phone"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mb;
	}
	//회원 정보 가져오기
	public MemberBean getUserInfo(String myID) {
		MemberBean mb=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select * from member where id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, myID);
			rs=psmt.executeQuery();
			if(rs.next()) {
				mb=new MemberBean();
				mb.setId(rs.getString("id"));
				mb.setName(rs.getString("name"));
				mb.setEmail(rs.getString("email"));
				mb.setPhone(rs.getString("phone"));
				mb.setSex(rs.getString("sex"));
				mb.setJibunAddr(rs.getString("jibunAddr"));
				mb.setProfile(rs.getString("profile"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mb;
	}
	//사용자 이름 조회
	public String userName(String userID) {
		String userName=null;
		String sql="select * from member where id=?";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userID);
			rs=psmt.executeQuery();
			if(rs.next()) {
				userName=rs.getString("name");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userName;
	}
	//사용자 프로필가져오기
	public String userProfile(String userID) {
		String profile=null;
		String sql="select * from member where id=?";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userID);
			rs=psmt.executeQuery();
			if(rs.next()) {
				profile=rs.getString("profile");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return profile;
	}
	//회원정보 수정
	public int userChange(String pw, String userID) {
		int state=0;
		String sql="update member set pw=? where id=?";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String password=SHA.passSHA512(pw);
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, password);
			psmt.setString(2, userID);
			state=psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return state;
	}
}
