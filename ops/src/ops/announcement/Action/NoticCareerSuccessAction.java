package ops.announcement.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;

public class NoticCareerSuccessAction implements Action{
	//공고 지원 승인하기
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		int hi_no=0;
		int n_no=0;
		if(request.getParameter("hi_no")!=null) {
			hi_no=Integer.parseInt(request.getParameter("hi_no"));
		}
		if(request.getParameter("n_no")!=null) {
			n_no=Integer.parseInt(request.getParameter("n_no"));
		}
		NoticCareerSuccessService nss=new NoticCareerSuccessService();
		nss.NoticCareerSuccess(hi_no);
		
		
		forward=new ActionForward("noticCorpCareerList.no?n_no="+n_no,true);
		return forward;
	}
}
