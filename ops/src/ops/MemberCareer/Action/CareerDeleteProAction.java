package ops.MemberCareer.Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;


public class CareerDeleteProAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{
		ActionForward forward = null;
		int ca_no = Integer.parseInt(request.getParameter("ca_no"));
		CareerDeleteProService cdp = new CareerDeleteProService();
			boolean isDeleteSuccess = cdp.removeArticle(ca_no);

			if(!isDeleteSuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			else{
				forward = new ActionForward("careerList.ops2",true);				
			}		
		return forward;
	}
	}

