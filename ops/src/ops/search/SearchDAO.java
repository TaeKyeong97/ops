package ops.search;

import static common.ConUtilDAO.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ops.MemberCareer.Beans.Career;
import ops.portfolio.beans.PortfolioBeans;

/*
 * DB 검색
 */
public class SearchDAO {
	private static SearchDAO instance = new SearchDAO();
	public static SearchDAO getInstance() {
		if(instance==null) {
			instance = new SearchDAO();
		}
		return instance;		
	}
	Connection conn=null;
	public void setConnection(Connection conn) {
		this.conn=conn;
	}
	
	/*
	 * 검색어 가공
	 */
	public ArrayList<ArrayList<String>> searchQueryProcessing(String query) {
		ArrayList<ArrayList<String>> q=new ArrayList<ArrayList<String>>();
		ArrayList<String> q1=new ArrayList<String>();
		ArrayList<String> q2=new ArrayList<String>();
		List<String> matchListen=new ArrayList<String>();
		List<String> matchListkr=new ArrayList<String>();
		HashSet<String> q0=new HashSet<String>();
		String[] qa=query.split(" ");
		Pattern enregex = Pattern.compile("([a-zA-Z\\s]+)"); 
		Pattern krregex = Pattern.compile("([가-힣\\s]+)"); 
		Matcher regexMatcherEn = enregex.matcher(query);
		Matcher regexMatcherKr = krregex.matcher(query);
		
		for(int i=0;i<qa.length;i++) {
			q1.add(qa[i].trim());
		}		
		qa=query.split(",");
		for(int i=0;i<qa.length;i++) {
			q2.add(qa[i].trim());
		}		
		while(regexMatcherEn.find()) {
			matchListen.add(regexMatcherEn.group().trim());
		}
		while(regexMatcherKr.find()) {
			matchListkr.add(regexMatcherKr.group().trim());
		}
		q0.addAll(q1);
		q0.addAll(q2);
		
		int mc=0;
		while(mc<matchListkr.size()) {
			if(matchListkr.get(mc)==null||matchListkr.get(mc).equals("")||matchListkr.get(mc).equals(" ")) {
				matchListkr.remove(mc);
	       }
			mc++;
		}
		mc=0;
		while(mc<matchListen.size()) {
			if(matchListen.get(mc)==null||matchListen.get(mc).equals("")||matchListen.get(mc).equals(" ")) {
				matchListen.remove(mc);
	       }
			mc++;
		}
		matchListkr.addAll(q0);
		if(matchListkr.size()>0) {
			q.add((ArrayList<String>) matchListkr);
		}
		if(matchListen.size()>0&&matchListen.get(0).trim().length()>0) {
			q.add((ArrayList<String>) matchListen);
		}
		return q;
	}
	
	/*
	 * 검색엔진 v_01
	 */
	//포트폴리오 검색 엔진
	public ArrayList<PortfolioBeans> searchPortfolio(ArrayList<ArrayList<String>> query){
		ArrayList<PortfolioBeans> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			//select po_id , po_title , REGEXP_REPLACE(po_title, '<(/)?(img|label|table|thead|tbody|tfoot|tr|td|p|div|span|font|strong|b)(.|\s|\t|\n|\r\n)*?>', '') as po_title from portfolio;
			//select po_title1 from (select po_title , REGEXP_REPLACE(po_title, '<(/)?(img|label|table|thead|tbody|tfoot|tr|td|p|div|span|font|strong|b)(.|\s|\t|\n|\r\n)*?>', '') as po_title1 from portfolio) as po where po.po_title1 like'% 모%';
			
			//--String view="create view search AS  select  convert(REGEXP_REPLACE(po_title, '<(/)?(img|label|table|thead|tbody|tfoot|tr|td|p|div|span|font|strong|b)(.|\\s|\\t|\\n|\\r\\n)*?>', '') ,char) from portfolio";
			
			//String sql="select Name_exp_1 from (select po_title , REGEXP_REPLACE(po_title, '<(/)?(img|label|table|thead|tbody|tfoot|tr|td|p|div|span|font|strong|b)(.|\\s|\\t|\\n|\\r\\n)*?>', '') as po_title1 from portfolio) as po where po.po_title like ";
			String sql="select * from portfolio where po_reTitle like ";
			for(int queryI=0;queryI<query.size();queryI++) {
				for(int queryK=0;queryK<query.get(queryI).size();queryK++) {
					if(queryK!=0) {
						sql+=" OR po_reTitle like ?";
					}else if(queryI==1&&queryK==0){
						sql+=" OR po_reTitle like ?";
					}else{
						sql+="?";
					}
				}
				
			}
			psmt=conn.prepareStatement(sql);
			int queryG=0;
			for(int queryI=0;queryI<query.size();queryI++) {
				for(int queryK=0;queryK<query.get(queryI).size();queryK++) {
					queryG++;
					psmt.setString(queryG, "%"+query.get(queryI).get(queryK)+"%");
				}
			}
			rs=psmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<PortfolioBeans>();
				do {
					PortfolioBeans pb=new PortfolioBeans();
					pb.setNo(rs.getInt("po_no"));
					list.add(pb);
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
	//이력서 검색 엔진
	public ArrayList<Career> searchCareer(ArrayList<ArrayList<String>> query){
		
		ArrayList<Career> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			String sql="select ca_no,ca_title,ca_subTitle,member.id,profile from career,member where career.id=member.id AND ca_title like ";
			for(int queryI=0;queryI<query.size();queryI++) {
				for(int queryK=0;queryK<query.get(queryI).size();queryK++) {
					if(queryK!=0) {
						sql+=" OR ca_title like ?";
					}else if(queryI==1&&queryK==0){
						sql+=" OR ca_title like ?";
					}else{
						sql+="?";
					}
				}				
			}
			psmt=conn.prepareStatement(sql);
			int queryG=0;
			for(int queryI=0;queryI<query.size();queryI++) {
				for(int queryK=0;queryK<query.get(queryI).size();queryK++) {
					queryG++;
					psmt.setString(queryG, "%"+query.get(queryI).get(queryK)+"%");
				}
			}
			rs=psmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<Career>();
				do {
					Career pb=new Career();
					pb.setCa_no(rs.getInt("ca_no"));
					pb.setCa_title(rs.getString("ca_title"));
					pb.setCa_subTitle(rs.getString("ca_subTitle"));
					pb.setId(rs.getString("member.id"));
					pb.setCa_name(userNameSearch(rs.getString("member.id")));
					pb.setProfile(rs.getString("profile"));
					list.add(pb);
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
	//공고 검색 (필터 미사용)
	public ArrayList<NoticBeans> searchNoticListNopt(ArrayList<ArrayList<String>> query,FilterABeans fb){
		ArrayList<NoticBeans> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from notice where n_title like ";
			if(query!=null) {
				for(int queryI=0;queryI<query.size();queryI++) {
					for(int queryK=0;queryK<query.get(queryI).size();queryK++) {
						if(queryK!=0) {
							sql+=" OR n_title like ?";
						}else if(queryI==1&&queryK==0){
							sql+=" OR n_title like ?";
						}else{
							sql+="?";
						}
					}
				}
				psmt=conn.prepareStatement(sql);
				int queryG=0;
				for(int queryIs=0;queryIs<query.size();queryIs++) {
					for(int queryK=0;queryK<query.get(queryIs).size();queryK++) {
						queryG++;
						psmt.setString(queryG, "%"+query.get(queryIs).get(queryK)+"%");
					}
				}
				sql+=" ORDER BY n_no DESC limit 4";
				rs=psmt.executeQuery();
				if(rs.next()) {
					list=new ArrayList<NoticBeans>();
					do {
						NoticBeans nb=new NoticBeans();
						nb.setN_no(rs.getInt("n_no"));
						nb.setN_title(rs.getString("n_title"));
						nb.setN_date(rs.getTimestamp("n_date"));
						nb.setN_img(rs.getString("n_img"));
						list.add(nb);
					}while(rs.next());
				}
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
	
	/*
	 * 필터 검색
	 */
	
	//실제 검색 내용 가져오기(포트폴리오) 및 필터 검색	//지역제외 검색
	public ArrayList<PortfolioBeans> searchRealPortfolio(ArrayList<PortfolioBeans> pb,FilterABeans fb) {//검색 결과 번호 를 받아 필터
		ArrayList<PortfolioBeans> list=new ArrayList<PortfolioBeans>();;		
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			String sql="select po_no,po_id,convert(REGEXP_REPLACE(po_title, '<(/)?(img|label|table|thead|tbody|tfoot|tr|td|p|div|span|font|strong|b)(.|\\s|\\t|\\n|\\r\\n)*?>', '') ,char) as po_title,po_layout,po_date,po_img from portfolio where po_no=?";
			psmt=conn.prepareStatement(sql);
			
			if(pb!=null) {
				for(int i=0;i<pb.size();i++) {
					psmt.setInt(1, pb.get(i).getNo());
					rs=psmt.executeQuery();
					if(rs.next()) {
						PortfolioBeans pfb=new PortfolioBeans();
						pfb.setNo(rs.getInt("po_no"));
						pfb.setId(rs.getString("po_id"));
						pfb.setTitle(rs.getString("po_title"));
						pfb.setLayout(rs.getString("po_layout"));
						pfb.setDate(rs.getTimestamp("po_date"));
						pfb.setImg(rs.getString("po_img"));
						list.add(pfb);
					}
				}
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

	//상세 검색 가져오기(이력서 검색) 필터검색
	public ArrayList<Career> searchRealCareer(ArrayList<Career> pb,FilterABeans fb) {//검색 결과 번호 를 받아 필터3
		ArrayList<Career> list=new ArrayList<Career>();;		
		PreparedStatement psmt=null;
		ResultSet rs=null;		
		try {
			String sql="select * from career,member where career.id=member.id AND ca_no=? ";
			if(fb.getAcbg()!=null&&fb.getAcbg()!="") {
				sql+="AND ca_acadamiBg=? ";			//학력 (상세 학력 정보를 이걸로)
			}
			if(fb.getAcbgState()!=null) {
				//sql+="AND ca_acadamiBgState=? ";	//상세 학력 추가하기
			}
			if(fb.getIndustry()!=null) {
				//sql+="AND ca_industry=? ";		//업종 추가하기
			}
			if(fb.getDetailIndustry()!=null) {
				//sql+="AND ca_detailIndustry=? ";	//상세업종추가하기
			}
			if(fb.getLocal()!=null&&fb.getLocal()!="") {
				sql+="AND ca_realAddr like ? ";			//시도
			}
			if(fb.getDetailLocal()!=null&&fb.getDetailLocal()!="") {		
				sql+="AND ca_realAddr like ? ";			//상세 주소
			}
			if(fb.getMoney()!=null&&fb.getMoney()!="") {
				sql+="AND ca_sal=? ";				//연봉
			}
			if(fb.getSex()!=null) {
				//sql+="AND ca_sex=? ";				//나이,성별 받기
			}
			psmt=conn.prepareStatement(sql);
			if(pb!=null) {
				for(int i=0;i<pb.size();i++) {
					int indexFilter=1;
					psmt.setInt(1, pb.get(i).getCa_no());
					if(fb.getAcbg()!=null&&fb.getAcbg()!="") {
						indexFilter++;
						psmt.setString(indexFilter, fb.getAcbg());
					}
					if(fb.getLocal()!=null&&fb.getLocal()!="") {
						indexFilter++;
						psmt.setString(indexFilter, "%"+fb.getLocal()+"%");
					}
					if(fb.getDetailLocal()!=null&&fb.getDetailLocal()!="") {
						indexFilter++;
						psmt.setString(indexFilter, "%"+fb.getDetailLocal()+"%");
					}
					if(fb.getMoney()!=null&&fb.getMoney()!="") {
						indexFilter++;
						psmt.setString(indexFilter, fb.getMoney());
					}
					rs=psmt.executeQuery();
					if(rs.next()) {
						Career pfb=new Career();
						pfb.setCa_no(rs.getInt("ca_no"));
						pfb.setCa_title(rs.getString("ca_title"));
						pfb.setCa_talk(rs.getString("ca_talk"));
						pfb.setId(rs.getString("career.id"));
						pfb.setCa_name(userNameSearch(rs.getString("id")));
						pfb.setProfile(rs.getString("profile"));
						list.add(pfb);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		
		return list;
	}
	//이력서 사용자 이름검색
	public String userNameSearch(String userId) {
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String userName=null;
		String sql="select name from member where id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				userName=rs.getString("name");
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
		
		return userName;
	}
	
	//공고 검색 (필터사용)
	public ArrayList<NoticBeans> searchNoticList(ArrayList<ArrayList<String>> query,FilterABeans fb){
		ArrayList<NoticBeans> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from notice where n_title like ";
			if(query!=null) {
				for(int queryI=0;queryI<query.size();queryI++) {
					for(int queryK=0;queryK<query.get(queryI).size();queryK++) {
						if(queryK!=0) {
							sql+=" OR n_title like ?";
						}else if(queryI==1&&queryK==0){
							sql+=" OR n_title like ?";
						}else{
							sql+="?";
						}
					}
				}
				
				if(fb.getAcbg()!=null&&fb.getAcbg()!="") {
					sql+=" AND n_acadamiBg=? ";			//학력 (상세 학력 정보를 이걸로)
				}
				if(fb.getLocal()!=null&&fb.getLocal()!="") {
					sql+=" AND n_address like ? ";			//시도
				}
				if(fb.getDetailLocal()!=null&&fb.getDetailLocal()!="") {		
					sql+=" AND n_address like ? ";	//상세 주소
				}
				if(fb.getMoney()!=null&&fb.getMoney()!="") {
					sql+=" AND n_sal=? ";				//연봉
				}
				sql+=" ORDER BY n_no DESC limit 4";
				
				psmt=conn.prepareStatement(sql);
				int queryG=0;
				for(int queryIs=0;queryIs<query.size();queryIs++) {
					for(int queryK=0;queryK<query.get(queryIs).size();queryK++) {
						queryG++;
						psmt.setString(queryG, "%"+query.get(queryIs).get(queryK)+"%");
						
					}
				}
				if(fb.getAcbg()!=null&&fb.getAcbg()!="") {
					queryG++;
					psmt.setString(queryG, fb.getAcbg());						
				}
				if(fb.getLocal()!=null&&fb.getLocal()!="") {
					queryG++;
					psmt.setString(queryG, "%"+fb.getLocal()+"%");						
				}
				if(fb.getMoney()!=null&&fb.getMoney()!="") {
					queryG++;
					psmt.setString(queryG, fb.getMoney());						
				}
				if(fb.getDetailLocal()!=null&&fb.getDetailLocal()!="") {
					queryG++;
					psmt.setString(queryG, "%"+fb.getDetailLocal()+"%");						
				}
				
				rs=psmt.executeQuery();
				if(rs.next()) {
					list=new ArrayList<NoticBeans>();
					do {
						NoticBeans nb=new NoticBeans();
						nb.setN_no(rs.getInt("n_no"));
						nb.setN_title(rs.getString("n_title"));
						nb.setN_date(rs.getTimestamp("n_date"));
						nb.setN_img(rs.getString("n_img"));
						list.add(nb);
					}while(rs.next());
				}
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
	
	
	//공고 제목 가져오기
	public ArrayList<NoticBeans> noticSearch() {
		ArrayList<NoticBeans> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select n_no,n_title,n_img,n_comName from notice ORDER BY n_no DESC limit 3";
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<NoticBeans>();
				do {
					NoticBeans nb=new NoticBeans();
					nb.setN_no(rs.getInt("n_no"));
					nb.setN_title(rs.getString("n_title"));
					nb.setN_img(rs.getString("n_img"));
					nb.setN_comName(rs.getString("n_comName"));
					list.add(nb);
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}				
		return list;
	}
}
