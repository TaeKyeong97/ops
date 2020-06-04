package ops.announcement.Action;

import java.sql.Connection;
import java.util.ArrayList;
import static common.ConUtilDAO.*;

import ops.Notice.Beans.Notice;
//공고 지원 현황조회
public class NoticCareerListService {
	//공고 제목 번호 반환 (사용자 입장)
	public ArrayList<Notice> noticCareerList(String myId) {
		Connection conn=getConnection();
		AnnouncementData ann=new AnnouncementData();
		ann.setConnection(conn);
		ArrayList<Notice> ntb=ann.NoticCareerList(myId);	
		close(conn);
		return ntb;
	}
	//공고 제목 번호 반환 (기업 입장)
	public ArrayList<Notice> noticCorpCareerList(String myId,int n_no) {
		Connection conn=getConnection();
		AnnouncementData ann=new AnnouncementData();
		ann.setConnection(conn);
		ArrayList<Notice> ntb=ann.NoticCorpCareerList(myId,n_no);	
		close(conn);
		return ntb;
	}
	//지원 공고 포트폴리오 갯수 반환
	public int noticPortfolioSize(int ca_no) {
		Connection conn=getConnection();
		AnnouncementData ann=new AnnouncementData();
		ann.setConnection(conn);
		int state=ann.NoticPortfolioSize(ca_no);
		close(conn);
		return state;
	}
	//공고 조회
	public ArrayList<Notice> noticCareerLists(String emId) {
		Connection conn=getConnection();
		AnnouncementData ann=new AnnouncementData();
		ann.setConnection(conn);
		ArrayList<Notice> notice=ann.noticCareerLists(emId);
		close(conn);
		return notice;
	}
}
