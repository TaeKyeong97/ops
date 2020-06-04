package Project.pro.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.UploadFileBean;
import comm.Action;
import comm.ActionForward;

public class SharingListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
	//업로드 리스트 보기
		ActionForward forward=null;
		String pj_no=request.getParameter("pj_no");
		String pjg_no=request.getParameter("pjgp_no");
		HttpSession session=request.getSession();
		String EM_id=(String)session.getAttribute("EM_id");
		
		SharingListService sls=new SharingListService();
		ArrayList<UploadFileBean> upfileList=sls.sharingListService(Integer.parseInt(pj_no), Integer.parseInt(pjg_no));
		request.setAttribute("upfileList", upfileList);
		request.setAttribute("EM_id", EM_id);
		
		//패이징 하기
		if(request.getParameter("page")!=null) {
		int page=Integer.parseInt(request.getParameter("page"));	//현재 페이지
		int startPage=0;
		int endPage=0;
		int maxGrouPage=0;
		double maxGrouPageDouble=0;
		int maxSize=0;
		int nextPage=0;
		double nextPageDouble=0;
		if(upfileList!=null) {
			maxSize=upfileList.size()-1;	//전체 리스트 갯수
		}else {
			maxSize=0;
		}
		
		
		endPage = page*5;
		startPage = endPage-4;
		
		maxGrouPageDouble=Math.ceil((double)maxSize/(double)5);		//총 그룹 페이지
		maxGrouPage=(int)maxGrouPageDouble;
		
		
		nextPageDouble=Math.ceil((Math.ceil((double)maxSize/(double)5))-1);	//예상 페이지 (예를들어 두번째 그룹의 첫번째 리스트가 지워질 경우 그룹은 1나가되어야하고 삭제후 해당 그룹으로 이동하여야하기떄문에)
		nextPage=(int)nextPageDouble;
		
		
		System.out.print(nextPage);
		
		
		
		request.setAttribute("startPage", startPage);	//하나의 페이지의 리스트번호
		request.setAttribute("endPage", endPage);
		request.setAttribute("maxGrouPage", maxGrouPage);	//총 구룹 페이지
		request.setAttribute("nextPage", nextPage);	//리스트삭제 번지가 첫번째 이면 1을 가져가서 그만큼 빼기
		
		
		forward=new ActionForward("Sharing.jsp?",false);
		}
		
		
		
		return forward;
		
	}
	
}
