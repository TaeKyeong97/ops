package ops.MemberCareer.Action;

import static common.ConUtilDAO.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import ops.MemberCareer.Beans.Career;
import ops.MemberCareer.Beans.Careerfile;
import ops.MemberCareer.Beans.Loc;
import ops.MemberCareer.Beans.Work;

public class CareerData {
	Connection con;
	PreparedStatement ps = null;
	ResultSet rs = null;
	private String cityName;	
	private static CareerData instance;
	
	public static CareerData getInstance(){
		if(instance == null)
			instance = new CareerData();
		return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int insertArticle(Career c) { //이력서작성
		int x = 0;
		try {
			String sql = "insert into career values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, c.getCa_title());
			ps.setString(2, c.getCa_subTitle());
			ps.setString(3, c.getCa_selfText());
			ps.setString(4, c.getCa_talk());
			ps.setString(5, c.getCa_job());
			ps.setString(6, c.getZipNo());
			ps.setString(7, c.getRoadAddr());
			ps.setString(8, c.getJibunAddr());
			ps.setString(9, c.getRealAddr());
			//ps.setString(6, c.getCa_address());			
			ps.setString(10, c.getCa_workTerm());
			ps.setString(11, c.getCa_workDay());
			ps.setString(12, c.getCa_workTime());
			ps.setTimestamp(13, c.getCa_date());
			ps.setString(14, c.getCa_sal());
			ps.setString(15, c.getCa_acadamiBg());
			ps.setString(16, c.getCa_startPublic());
			ps.setString(17, c.getCa_endPublic());
			ps.setString(18, c.getCa_publicTerm());
			ps.setString(19, c.getCa_phone());
			ps.setString(20, c.getCa_addPhone());
			ps.setInt(21, c.getCa_private());
			ps.setInt(22, c.getWorkFormNo());
			ps.setString(23, c.getId());
			ps.setString(24, c.getCa_schoolName());
			ps.setString(25, c.getCa_attendTerm());
			ps.setString(26, c.getCa_credit());
			ps.setString(27, c.getCa_certificateKind());
			ps.setString(28, c.getCa_grade());
			ps.setString(29, c.getCa_obtainDate());
			ps.setString(30, c.getCa_publisher());
			x = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("이력서작성오류:"+ e);
		}finally {
			close(ps);
		}
		return x;
	}
	
	public ArrayList<Career> selectCareerList(String myId){ //이력서리스트
		String sql="select c.ca_no, c.ca_title, c.ca_subTitle, c.ca_selfText, c.ca_talk, c.ca_job, c.ca_jibunAddr, c.ca_workTerm, c.ca_workDay, c.ca_workTime, c.ca_date, c.ca_sal, c.ca_acadamiBg, c.ca_startPublic, c.ca_endPublic, c.ca_publicTerm, c.ca_phone, c.ca_addPhone, c.ca_private, w.workName, m.id from career c, work w, member m where c.workFormNo = w.workFormNo and m.id = c.id AND c.id=?";
		ArrayList<Career> careerList = new ArrayList<Career>();		
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, myId);
			rs = ps.executeQuery();
			
			if(rs.next()){
				do{
				Career c = new Career();
				c.setCa_no(rs.getInt("ca_no"));
				c.setCa_title(rs.getString("ca_title"));
				c.setCa_subTitle(rs.getString("ca_subTitle"));
				c.setCa_selfText(rs.getString("ca_selfText"));
				c.setCa_talk(rs.getString("ca_talk"));
				c.setCa_job(rs.getString("ca_job"));
				c.setRoadAddr(rs.getString("ca_jibunAddr"));
				c.setCa_workTerm(rs.getString("ca_workTerm"));
				c.setCa_workDay(rs.getString("ca_workDay"));
				c.setCa_workTime(rs.getString("ca_workTime"));
				c.setCa_date(rs.getTimestamp("ca_date"));
				c.setCa_sal(rs.getString("ca_sal"));
				c.setCa_acadamiBg(rs.getString("ca_acadamiBg"));
				c.setCa_startPublic(rs.getString("ca_startPublic"));
				c.setCa_endPublic(rs.getString("ca_endPublic"));
				c.setCa_publicTerm(rs.getString("ca_publicTerm"));
				c.setCa_phone(rs.getString("ca_phone"));
				c.setCa_addPhone(rs.getString("ca_addPhone"));
				c.setCa_private(rs.getInt("ca_private"));
				c.setWorkName(rs.getString("workName"));
				c.setId(rs.getString("id"));
				careerList.add(c);
				}while(rs.next());
			}
		}catch(Exception ex){
			System.out.println("이력서 리스트 에러: " + ex);			
		}finally{
			if(rs!=null) {
				close(rs);
			}else if(ps!=null){
				close(ps);
			}
		}
		return careerList;
	}
	
	public Career selectDetail(int ca_no) { //이력서 조회
		Career c = null;
		try {
			String sql = "select * from career where ca_no=?";
		
			ps = con.prepareStatement(sql);
			ps.setInt(1, ca_no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				c = new Career();
				c.setCa_no(rs.getInt("ca_no"));
				c.setCa_title(rs.getString("ca_title"));
				c.setCa_subTitle(rs.getString("ca_subTitle"));
				c.setCa_selfText(rs.getString("ca_selfText"));
				c.setCa_talk(rs.getString("ca_talk"));
				c.setCa_job(rs.getString("ca_job"));
				c.setRoadAddr(rs.getString("ca_realAddr"));
				c.setCa_workTerm(rs.getString("ca_workTerm"));
				c.setCa_workDay(rs.getString("ca_workDay"));
				c.setCa_workTime(rs.getString("ca_workTime"));
				c.setCa_date(rs.getTimestamp("ca_date"));
				c.setCa_sal(rs.getString("ca_sal"));
				c.setCa_acadamiBg(rs.getString("ca_acadamiBg"));
				c.setCa_startPublic(rs.getString("ca_startPublic"));
				c.setCa_endPublic(rs.getString("ca_endPublic"));
				c.setCa_publicTerm(rs.getString("ca_publicTerm"));
				c.setCa_phone(rs.getString("ca_phone"));
				c.setCa_addPhone(rs.getString("ca_addPhone"));
				c.setCa_private(rs.getInt("ca_private"));
				c.setWorkFormNo(rs.getInt("workFormNo"));
				c.setId(rs.getString("id"));
				c.setCa_schoolName(rs.getString("ca_schoolName"));
			}
		}catch(Exception e) {
			System.out.println("이력서조회오류 : " + e);
		}finally {
			close(rs);
			close(ps);
		}
		return c;
	}
	
	public int updateArticle(Career article){ //이력서 수정

		int updateCount = 0;
		String sql="update career set ca_title=?, ca_subTitle=?, ca_selfText=?, ca_talk=?, ca_job=?, ca_address=?, ca_workTerm=?, ca_workDay=?, ca_workTime=?, ca_sal=?, ca_acadamiBg=?, ca_startPublic=?, ca_endPublic=?, ca_publicTerm=?, ca_phone=?, ca_addPhone=? where ca_no=?";

		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, article.getCa_title());
			ps.setString(2, article.getCa_subTitle());
			ps.setString(3, article.getCa_selfText());
			ps.setString(4, article.getCa_talk());
			ps.setString(5, article.getCa_job());
			ps.setString(6, article.getCa_address());
			ps.setString(7, article.getCa_workTerm());
			ps.setString(8, article.getCa_workDay());
			ps.setString(9, article.getCa_workTime());
			ps.setString(10, article.getCa_sal());
			ps.setString(11, article.getCa_acadamiBg());
			ps.setString(12, article.getCa_startPublic());
			ps.setString(13, article.getCa_endPublic());
			ps.setString(14, article.getCa_publicTerm());
			ps.setString(15, article.getCa_phone());
			ps.setString(16, article.getCa_addPhone());
			ps.setInt(17, article.getCa_no());
			updateCount = ps.executeUpdate();
		}catch(Exception ex){
			System.out.println("이력서수정 에러 : " + ex);
		}finally{
			close(ps);
		}

		return updateCount;
	}
	
	public ArrayList<Work> selectWorkList(){ //업무형태 리스트
		String sql="select * from work";
		ArrayList<Work> workList = new ArrayList<Work>();
		
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()){
				do{
				Work w = new Work();
				w.setWorkFormNo(rs.getInt("workFormNo"));
				w.setWorkName(rs.getString("workName"));
				workList.add(w);
				}while(rs.next());
			}
		}catch(Exception ex){
			System.out.println("업종 리스트 에러: " + ex);			
		}finally{
			close(rs);
			close(ps);
		}
		return workList;
	}
	
	public ArrayList<Loc> selectAddressList() { //주소...ㅠㅠ
		ArrayList<Loc> list = new ArrayList<Loc>();
		
		try {
		String sql = "select * from loc where cityName LIKE '%' || ? || '%'";
		ps = con.prepareStatement(sql);
		ps.setString(1, cityName);
		rs = ps.executeQuery();
		if(rs.next()){
			do{
			Loc l = new Loc();
			l.setCityName(rs.getString("cityName"));
			l.setCountyName(rs.getString("countyName"));
			l.setRoadName(rs.getString("roadName"));
			list.add(l);
			}while(rs.next());
		}
		}catch(Exception ex){
			System.out.println("주소 에러: " + ex);			
		}finally{
			close(rs);
			close(ps);
		}
		return list;
	}
	
	public boolean isArticleCareerWriter(int ca_no){ //이력서번호확인

		String sql="select * from career where ca_no=?";
		boolean isWriter = false;
			
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, ca_no);
			rs = ps.executeQuery();
			if(rs.next()) {
				isWriter = true;
			}
		}catch(Exception e){
			System.out.println("isCareerWriter 에러 : "+ e);
		}
		finally{
			close(ps);
		}
		return isWriter;
	}
	
	public int deleteArticle(int ca_no){ //이력서삭제		
		String sql="delete from career where ca_no=?";
		//추가 사항
		String careerFile="delete from careerFile where ca_no=?";
		String cp_includ="delete from cp_include where ca_no=?";
		int deleteCount=0;
		try{
			ps=con.prepareStatement(careerFile);
			ps.setInt(1, ca_no);
			ps.executeUpdate();
			
			ps.clearParameters();
			ps=con.prepareStatement(cp_includ);
			ps.setInt(1, ca_no);
			ps.executeUpdate();	
			
			ps.clearParameters();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ca_no);
			deleteCount = ps.executeUpdate();//현재 공고 지원 중이라 에러
		}catch(Exception ex){
			ex.printStackTrace();
		}	finally{
			close(ps);
		}

		return deleteCount;

	}
	//생성한 이력서 번호
	public int careerNextNumber(String userId) {
		int state=0;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select MAX(ca_no) as caNo from career where id=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, userId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=rs.getInt("caNo");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
		return state;
	}
	
	
	//파일 업로드
	public int uploadFile(Careerfile cf) {
		int state=0;
		PreparedStatement psmt=null;
		String fileNames[]=cf.getFileName().replace("[", "").replace("]", "").split(",");
		String sql="insert into careerfile(fileNo,fileName,fileDate,fileType,ca_no) values(null,?,?,?,?)";
		try {
			for(int fileSize=0;fileSize<fileNames.length;fileSize++) {				
				psmt=con.prepareStatement(sql);
				psmt.setString(1, fileNames[fileSize]);
				psmt.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
				psmt.setString(3, cf.getFileType());
				psmt.setInt(4, cf.getCa_no());
				state=psmt.executeUpdate();
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
		
		return state;
	}
	//파일 조회
	public ArrayList<Careerfile> selectFile(int ca_no){
		ArrayList<Careerfile> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select fileNo,fileName,fileDate,fileType from careerfile where ca_no=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, ca_no);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<Careerfile>();
				do {
					Careerfile caf=new Careerfile();
					caf.setFileNo(rs.getInt("fileNo"));
					caf.setFileName(rs.getString("fileName"));
					caf.setFileDate(rs.getTimestamp("fileDate"));
					caf.setFileType(rs.getString("fileType"));
					list.add(caf);
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
	
}

