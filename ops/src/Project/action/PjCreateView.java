package Project.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.MemberAll;
import comm.Action;
import comm.ActionForward;

public class PjCreateView implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		
		//친구 목록 (현재 전체 회원목록)
		PjCreateViewService pjcvs=new PjCreateViewService();
		ArrayList<MemberAll> mba=pjcvs.MemberInfoSelect(myId);
		
		if(mba!=null) {
			request.setAttribute("mba", mba);
			
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('실패')");
			out.println("</script>");
		}
		
		
		forward=new ActionForward("pjCreate.jsp",false);
		return forward;
	}
}
