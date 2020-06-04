package Project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.Member;
import Project.beans.MemberImg;
import comm.Action;
import comm.ActionForward;

public class ProjectInfoChangeAction implements Action {
	//개인정보
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward=null;
		HttpSession session= request.getSession();
		String EM_id=(String)session.getAttribute("EM_id");
		
		ProjectInfoChangeService pics=new ProjectInfoChangeService();
		Member member=pics.selectUserInfo(EM_id);
		if(EM_id!=null) {
			String email=member.getEM_email();
			String emails[]=email.split("@");
			String emailBuffer="";
			for(int k=0;k<emails[0].length();k++) {
				if(k<2) {
					emailBuffer+=emails[0].substring(k, k+1);
				}else {
					emailBuffer+="*";
				}
			}
			email=emailBuffer+"@"+emails[1];
			member.setEM_email(email);
			
			MemberImg mbimg=pics.userInfoImg(EM_id);
			request.setAttribute("member", member);
			request.setAttribute("mbimg", mbimg);
		
			forward=new ActionForward("infoChange.jsp",false);
		}else {
			forward=new ActionForward("index.ops",true);
		}
		return forward;
	}
}
