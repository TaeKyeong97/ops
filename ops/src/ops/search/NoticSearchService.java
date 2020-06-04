package ops.search;

import java.sql.Connection;
import java.util.ArrayList;
import static common.ConUtilDAO.*;
public class NoticSearchService {
	//공고 리스트 3개(메인)
	public ArrayList<NoticBeans> noticSearch() {
		Connection conn=getConnection();
		SearchDAO sd=SearchDAO.getInstance();
		sd.setConnection(conn);		
		ArrayList<NoticBeans> list=sd.noticSearch();		
		close(conn);	
		return list;
	}
}
