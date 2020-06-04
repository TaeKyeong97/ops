package ops.search;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import ops.MemberCareer.Beans.Career;
import ops.portfolio.beans.PortfolioBeans;
/*
 * 검색 엔진
 */
public class SearchService {
	//검색어 추출
	public ArrayList<ArrayList<String>> search(String query) {
		SearchDAO sd=SearchDAO.getInstance();
		ArrayList<ArrayList<String>> q= sd.searchQueryProcessing(query);
		return q;
	}
	//포트폴리오 검색 엔진
	public ArrayList<PortfolioBeans> searchPortfolioList(ArrayList<ArrayList<String>> q){
		Connection conn=getConnection();
		SearchDAO sd=SearchDAO.getInstance();
		sd.setConnection(conn);
		ArrayList<PortfolioBeans> list=sd.searchPortfolio(q);
		
		close(conn);
		return list;
	}
	//이력서 검색엔진 (필터 없음)
	public ArrayList<Career> searchCareerList(ArrayList<ArrayList<String>> q){
		Connection conn=getConnection();
		SearchDAO sd=SearchDAO.getInstance();
		sd.setConnection(conn);
		ArrayList<Career> list=sd.searchCareer(q);
		
		close(conn);
		return list;
	}
	
	//포트폴리오 검색 결과 및 필터검색결과 (필터 사용 또는 미 사용)
	public ArrayList<PortfolioBeans> searchPortfolioLists(ArrayList<PortfolioBeans> pb,FilterABeans fb){
		ArrayList<PortfolioBeans> list=null;
		if(fb!=null) {
			Connection conn=getConnection();
			SearchDAO sd=SearchDAO.getInstance();
			sd.setConnection(conn);
			list=sd.searchRealPortfolio(pb,fb);
			
			close(conn);			
		}
		return list;
	}
	//공고 검색 (필터 미 사용)
	public ArrayList<NoticBeans> searchNoticList(ArrayList<ArrayList<String>> query,FilterABeans fb){
		ArrayList<NoticBeans> list=null;
		if(fb!=null) {
			Connection conn=getConnection();
			SearchDAO sd=SearchDAO.getInstance();
			sd.setConnection(conn);
			list=sd.searchNoticListNopt(query, fb);
			
			close(conn);
		}
		return list;	
	}
	
	//이력서 검색 결과 (필터 사용)
	public ArrayList<Career> searchCareerLists(ArrayList<Career> pb,FilterABeans fb){
		ArrayList<Career> list=null;
		if(fb!=null) {
			Connection conn=getConnection();
			SearchDAO sd=SearchDAO.getInstance();
			sd.setConnection(conn);
			list=sd.searchRealCareer(pb,fb);
			
			close(conn);
		}
		return list;
	}
	//공고 검색 결과 (필터 사용)
	public ArrayList<NoticBeans> searchNoticeLists(ArrayList<ArrayList<String>> q,FilterABeans fb){
		ArrayList<NoticBeans> list=null;
		if(fb!=null) {
			Connection conn=getConnection();
			SearchDAO sd=SearchDAO.getInstance();
			sd.setConnection(conn);
			list=sd.searchNoticList(q,fb);
			
			close(conn);
		}
		return list;
	}
		
}
