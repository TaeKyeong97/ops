package ops.MemberCareer.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.member.GetmemberInfoAction;
import ops.member.LoginCk;
import ops.member.beans.MemberBean;

//이력서 작성 페이지
public class careerWriteFormAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward("write/careerWrite.jsp",false);
		LoginCk lc=new LoginCk(request,response);
		HttpSession session=request.getSession();
		if(request.getAttribute("userID")!=null) {
			GetmemberInfoAction gmi=new GetmemberInfoAction();
			MemberBean mb=gmi.getmemberInfo(request, response);
			request.setAttribute("mb", mb);
			session.removeAttribute("fileName");
		}
		return forward;
	}
}
