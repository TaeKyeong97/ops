package ops.announcement.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.Notice.Beans.Notice;
//공고 지원자 조회 전 리스트
public class noticCareerListsAction  implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String emId=(String)session.getAttribute("emID");
		NoticCareerListService ncs=new NoticCareerListService();
		ArrayList<Notice> ntc=ncs.noticCareerLists(emId);
		NoticCareerListService ncls=new NoticCareerListService();
		if(ntc!=null) {
			ArrayList<Integer> ntb=new ArrayList<Integer>();
			for(int ntbSize=0; ntbSize<ntc.size();ntbSize++) {
				if(ncls.noticCorpCareerList(emId,ntc.get(ntbSize).getN_no())!=null) {
					ntb.add(ncls.noticCorpCareerList(emId,ntc.get(ntbSize).getN_no()).size());
				}
			}
		
		
			request.setAttribute("ntc", ntc);
			request.setAttribute("ntb",ntb);
		}
		forward=new ActionForward("management/careerLists.jsp",false);
		return forward;
	}

}
