package Project.pro.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.Member;
import comm.Action;
import comm.ActionForward;

public class SearchFriendAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward=new ActionForward("search-friend.jsp",false);
		//친구 찾기
		String userId=request.getParameter("userId").trim();	//상대 아이디
		String title=request.getParameter("title");
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		
		if(myId.equals(userId)) {
			request.setAttribute("message","본인 ID는 검색할 수 없습니다.");
		}else if(userId.equals("")){
			request.setAttribute("message","ID를 입력하여 주세요.");
		}else{
			SearchFriendService sfs=new SearchFriendService();
			Member mb=sfs.searchFriendSerivce(userId, myId);
			if(mb.getEM_uniqueCode()!=null) {
				//이미 바이 존재 하면
				request.setAttribute("message","이미 친구 추가 하였습니다.");
			}else {
				request.setAttribute("userId",mb);
			}
		}
		
		return forward;
	}

}
