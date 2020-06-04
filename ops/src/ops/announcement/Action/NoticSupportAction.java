package ops.announcement.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.portfolio.Errorcommand;
//공고 지원하기 (이력서 제출 엑션)
public class NoticSupportAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("userID");
		int ca_no=0;
		int n_no=0;
		if(myId!=null) {
			if(request.getParameter("portfolioList")!=null) {
				ca_no=Integer.parseInt(request.getParameter("portfolioList"));
			}
			if(request.getParameter("n_no")!=null) {
				n_no=Integer.parseInt(request.getParameter("n_no"));
			}
			System.out.println(n_no);
			NoticSupportService nss=new NoticSupportService();
			nss.noticSupport(myId, ca_no, n_no);
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>");
				out.println("opener.document.location.reload();");
				out.println("self.close();");
				out.println("</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//forward=new ActionForward("ops/main",true);
		}else {
			try {
				Errorcommand.Error(response, "로그인후 이용가능합니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return forward;
	}
}
