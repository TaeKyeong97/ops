package ops.MemberCareer.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.MemberCareer.Beans.Career;


public class CareerModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	CareerDetailService cds = new CareerDetailService();
			int ca_no = Integer.parseInt(request.getParameter("ca_no"));
		   	Career article = cds.getArticle(ca_no);
		   	request.setAttribute("article", article);
		   	ActionForward forward = new ActionForward("careerModify.jsp",false);
	   		
	   		return forward;
	   		
	 }

}

