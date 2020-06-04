package dataCenter;

import static common.DataCenterDAO.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dataCenter.beans.DataCenterBeans;
import dataCenter.beans.applyCollectionBeans;
import dataCenter.beans.applySettingBeans;
import dataCenter.beans.collectionBeans;

public class CenterDAO {
	private static CenterDAO instance= new CenterDAO();
	public static CenterDAO getInstance() {
		if(instance==null) {
			instance=new CenterDAO();
		}
		return instance;
	}
	Connection conn=null;
	public void setConnection(Connection conn) {
		this.conn=conn;
	}
	
	//동의,거절 여부 확인
	public boolean ApprovalState(String userID) {
		boolean state=false;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select * from member where mem_userID=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userID);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		
		return state;		
	}
	//동의 여부 확인
	public boolean memberState(String userID) {
		boolean state=false;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select * from member where mem_userID=? AND mem_agree='Y'";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userID);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		
		return state;		
	}
	
	//첫 사용자 동의 값 저장
	public int acceptSave(DataCenterBeans dcb) {
		int state=0;
		PreparedStatement psmt=null;
		String sql="insert into member(mem_userID,in_interest,mem_agree,mem_date) values(?,?,?,?)";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dcb.getId());
			psmt.setString(2, dcb.getInterest());
			psmt.setString(3, dcb.getAgree());
			psmt.setTimestamp(4, dcb.getDate());
			state=psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		return state;
	}
	
	//수집정보 저장
	public boolean collectSave(String boardForm, String userID, Timestamp col_date) {
		boolean state=false;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String interest=null;
		String sql1="select in_interest from member where mem_userID=?";
		String sql="insert into collection(col_no,col_boardForm,col_click,col_date,mem_userID,co_in_interest) values(null,?,1,?,?,?) ";
		try {
			psmt=conn.prepareStatement(sql1);
			psmt.setString(1, userID);
			rs=psmt.executeQuery();
			if(rs.next()) {
				interest=rs.getString("in_interest");
			}
			psmt.clearParameters();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, boardForm);
			psmt.setTimestamp(2, col_date);
			psmt.setString(3, userID);
			psmt.setString(4, interest);
			
			int x=psmt.executeUpdate();
			if(x>0) {
				state=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		
		return state;
	}
	
	//현재 적용 정보 가져오기 (NULL 초기정보)
	public ArrayList<applySettingBeans> collectionInfoList(){
		ArrayList<applySettingBeans> applySettingBeans=null;
		ArrayList<String> sql=new ArrayList<String>();
		//ArrayList<settinginfomationBeans> settingBeans=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		int sett=0,settApp=0;
		//수집정보 검색 
		sql.add("select * from applyCollection");
		//초기 정보 검색
		sql.add("select * from settingInfomation");
		//적용정보에 없는 테이블 기본값 설정
		sql.add("select A.in_interest from settingInfomation A left outer join applyCollection B on A.in_interest=B.in_interest where B.in_interest is null");
		
		
		sql.add("select count(in_interest) as cnt from applyCollection");
		sql.add("select count(sett.sett_no) as cnt from (select sett_no from settingInfomation group by in_interest) as sett");
		//초기 값과 세팅값의 갯수가 동등할경우 apply 최대값 가져오기 (배열:5)
		sql.add("select appc_no,appc_boardForm,MAX(appc_click) as appc_click,appc_date,appc_saveDate,in_interest from applycollection group by in_interest");
		//초기값과 세팅값의 갯수가 동등하지 않을경우 초기값 세팅
		sql.add("select sett_no,in_interest,MAX(sett_click) as sett_click,sett_boardForm from settingInfomation group by in_interest");
		
		//
		sql.add("select appc_no,appc_boardForm,appc_click,appc_date,appc_saveDate,in_interest from (SELECT in_interest,appc_click,appc_saveDate,appc_date,appc_no,(SELECT appc_boardForm FROM applyCollection WHERE a1.in_interest=in_interest and a1.appc_click=appc_click limit 1) as appc_boardForm FROM (SELECT in_interest, max(appc_click) as appc_click,appc_saveDate,appc_date,appc_no FROM applyCollection GROUP BY in_interest) a1) as app");
		
		try {
			psmt=conn.prepareStatement(sql.get(0));
			rs=psmt.executeQuery();
			if(rs.next()) {
				//데이터가 존재 할때
				psmt.clearParameters();
				psmt=conn.prepareStatement(sql.get(3));
				rs=psmt.executeQuery();
				if(rs.next()) {
					settApp=rs.getInt(1);
				}
				psmt.clearParameters();
				psmt=conn.prepareStatement(sql.get(4));
				rs=psmt.executeQuery();
				if(rs.next()) {
					sett=rs.getInt("cnt");
				}
				if(sett==settApp) {
					//데이터가 존재 할경우					
					psmt.clearParameters();
					psmt=conn.prepareStatement(sql.get(5));
					rs=psmt.executeQuery();
					if(rs.next()) {
						applySettingBeans=new ArrayList<applySettingBeans>();
						do {
							applySettingBeans applyBean=new applySettingBeans();
							applyBean.setAppc_no(rs.getInt(1));
							applyBean.setAppc_boardForm(rs.getString(2));
							applyBean.setAppc_click(rs.getInt(3));
							applyBean.setAppc_date(rs.getTimestamp(4));
							applyBean.setAppc_saveDate(rs.getTimestamp(5));
							applyBean.setAppc_in_interest(rs.getString(6));
							applySettingBeans.add(applyBean);
						}while(rs.next());
					}
				}else if(settApp!=0){
					//데이터가 존재하지만 일치하지 않는경우 					
					psmt.clearParameters();
					psmt=conn.prepareStatement(sql.get(7));
					rs=psmt.executeQuery();
					if(rs.next()) {
						applySettingBeans=new ArrayList<applySettingBeans>();
						do {
							applySettingBeans applyBean=new applySettingBeans();
							applyBean.setAppc_no(rs.getInt(1));
							applyBean.setAppc_boardForm(rs.getString(2));
							applyBean.setAppc_click(rs.getInt(3));
							applyBean.setAppc_date(rs.getTimestamp(4));
							applyBean.setAppc_saveDate(rs.getTimestamp(5));
							applyBean.setAppc_in_interest(rs.getString(6));
							applySettingBeans.add(applyBean);
						}while(rs.next());
					}					
				}else{
					//존재하지않을경우 않을경우 초기값으로 세팅
					psmt.clearParameters();
					psmt=conn.prepareStatement(sql.get(6));
					rs=psmt.executeQuery();
					if(rs.next()) {
						applySettingBeans=new ArrayList<applySettingBeans>();
						do {
							applySettingBeans settingBean =new applySettingBeans();
							settingBean.setSett_no(rs.getInt(1));
							settingBean.setSett_in_interest(rs.getString(2));
							settingBean.setSett_click(rs.getInt(3));
							settingBean.setSett_boardForm(rs.getString(4));
							applySettingBeans.add(settingBean);
						}while(rs.next());
					}
					
					//수정 필요
					/*
					psmt.clearParameters();
					psmt=conn.prepareStatement(sql.get(2));
					rs=psmt.executeQuery();
					if(rs.next()) {
						applySettingBeans=new ArrayList<applySettingBeans>();
						do {
							applySettingBeans settingBean =new applySettingBeans();
							settingBean.setSett_no(rs.getInt(1));
							settingBean.setSett_in_interest(rs.getString(2));
							settingBean.setSett_click(rs.getInt(3));
							settingBean.setSett_boardForm(rs.getString(4));
							applySettingBeans.add(settingBean);					
						}while(rs.next());
					}
					psmt.clearParameters();
					psmt=conn.prepareStatement(sql.get(0));
					rs=psmt.executeQuery();
					if(rs.next()) {
						applySettingBeans=new ArrayList<applySettingBeans>();
						do {
							applySettingBeans applyBean=new applySettingBeans();
							applyBean.setAppc_no(rs.getInt(1));
							applyBean.setAppc_boardForm(rs.getString(1));
							applyBean.setAppc_click(rs.getInt(3));
							applyBean.setAppc_date(rs.getTimestamp(4));
							applyBean.setAppc_saveDate(rs.getTimestamp(5));
							applyBean.setAppc_in_interest(rs.getString(6));
							applySettingBeans.add(applyBean);
						}while(rs.next());
					}	
					*/				
				}
				
			}else {
				psmt.clearParameters();
				psmt=conn.prepareStatement(sql.get(1));
				rs=psmt.executeQuery();
				if(rs.next()) {
					applySettingBeans=new ArrayList<applySettingBeans>();
					do {
						applySettingBeans settingBean =new applySettingBeans();
						settingBean.setSett_no(rs.getInt(1));
						settingBean.setSett_in_interest(rs.getString(2));
						settingBean.setSett_click(rs.getInt(3));
						settingBean.setSett_boardForm(rs.getString(4));
						applySettingBeans.add(settingBean);					
					}while(rs.next());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return applySettingBeans;// 수정필요
	}
	
	//수집정보 List
	public ArrayList<collectionBeans> collectionList(){
		ArrayList<collectionBeans> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select col_no,col_boardForm,col_click,col_date,mem_userID,co_in_interest from collection where col_no limit 6";
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<collectionBeans>();
				do {
					collectionBeans cllb=new collectionBeans();
					cllb.setCol_no(rs.getInt("col_no"));
					cllb.setCol_boardForm(rs.getString("col_boardForm"));
					cllb.setCol_click(rs.getString("col_click"));
					cllb.setCol_date(rs.getTimestamp("col_date"));
					cllb.setUserID(rs.getString("mem_userID"));
					cllb.setIn_interest(rs.getString("co_in_interest"));
					list.add(cllb);
				}while(rs.next());
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//달별,레이아웃별 수집정보
	//SELECT CONCAT(YEAR(col_date), '-', MONTH(col_date)) ym, COUNT(*),col_boardForm FROM collection GROUP BY ym,col_boardForm;
	public ArrayList<collectionBeans> monthList(){
		ArrayList<collectionBeans> colbs=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		//String sql="SELECT col_no,col_boardForm,co_in_interest,CONCAT(YEAR(col_date), '-', MONTH(col_date)) ym, COUNT(*) cnt FROM collection GROUP BY ym,col_boardForm";
		String sql="SELECT col_no,col_boardForm,co_in_interest,DATE_FORMAT(col_date,'%Y-%m') ym, COUNT(*) cnt FROM collection GROUP BY ym,col_boardForm";
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next()) {
				colbs=new ArrayList<collectionBeans>();
				do {
					collectionBeans clb=new collectionBeans();
					clb.setCol_no(rs.getInt("col_no"));
					clb.setCol_boardForm(rs.getString("col_boardForm"));
					clb.setIn_interest(rs.getString("co_in_interest"));
					clb.setMonth_date(rs.getString("ym"));
					clb.setCol_click(rs.getString("cnt"));
					colbs.add(clb);
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return colbs;
	}
	
	/*
	 * 달별 수집 정보 적용
	 */
	
	//수집 정보 적용여부 조회
	public int selectAppCollection(String startDate, String interest, String boardForm) {
		int state=0;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select * from applycollection where in_interest=? AND appc_boardForm=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, interest);
			psmt.setString(2, boardForm);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(psmt);
		}
		return state;
	}
	
	// 달별 수집정보 적용
	public int saveCollectionInfo(int selectState,String interest,String appc_date,String boardForm,String click, applyCollectionBeans acb) {
		int state=0;
		PreparedStatement psmt=null;
		ArrayList<String> sql=new ArrayList<String>();
		//생성 날짜 정보 저장
		String nowDate=null;
		//UPDATE
		sql.add("update applycollection set appc_click=?+appc_click,appc_saveDate=? where in_interest=? AND appc_boardForm=?");
		//INSERT 
		sql.add("insert into applycollection(appc_no,appc_boardForm,appc_click,appc_date,appc_saveDate,in_interest) values(null,?,?,?,?,?)");
		try {
			if(selectState>0){
				//존재한다면 UPDATE
				psmt=conn.prepareStatement(sql.get(0));
				psmt.setString(1, click);
				psmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
				psmt.setString(3, interest);
				psmt.setString(4, boardForm);
				//psmt.setString(5, appc_date+"-%");
				state=psmt.executeUpdate();
			}else {
				psmt=conn.prepareStatement(sql.get(1));
				psmt.setString(1, acb.getAppc_boardForm());
				psmt.setInt(2, acb.getAppc_click());
				psmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
				psmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				psmt.setString(5, acb.getIn_interest());
				state=psmt.executeUpdate();
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return state;
	}
}
