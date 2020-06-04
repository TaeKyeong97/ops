package ops.MemberCareer.Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.MemberCareer.Beans.Career;



public class CareerModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		int ca_no = Integer.parseInt(request.getParameter("ca_no"));
		Career article = new Career();
		CareerModifyProService cmps = new CareerModifyProService();
		boolean isRightUser = cmps.isArticleWriter(ca_no);
		//System.out.println("isRightUser = "+isRightUser);
		if(!isRightUser){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			article.setCa_no(ca_no);
			article.setCa_title(request.getParameter("title"));
			article.setCa_subTitle(request.getParameter("subTitle"));
			article.setCa_selfText(request.getParameter("ca_selfText"));
			article.setCa_talk(request.getParameter("talk"));
			article.setCa_job(request.getParameter("job"));
			article.setCa_address(request.getParameter("address"));
			article.setCa_workTerm(request.getParameter("workTerm"));
			article.setCa_workDay(request.getParameter("workDay"));
			article.setCa_workTime(request.getParameter("workTime"));
			article.setCa_sal(request.getParameter("sal"));
			article.setCa_acadamiBg(request.getParameter("acadamiBg"));
			article.setCa_startPublic(request.getParameter("startPublic"));
			article.setCa_endPublic(request.getParameter("endPublic"));
			article.setCa_publicTerm(request.getParameter("publicTerm"));
			article.setCa_phone(request.getParameter("phone"));
			article.setCa_addPhone(request.getParameter("addPhone"));
			isModifySuccess = cmps.modifyArticle(article);
			
			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back()");
				out.println("</script>");
			}
			else{
				forward = new ActionForward("careerList.ops", true);
			
			}
		}

		return forward;
	}

}
