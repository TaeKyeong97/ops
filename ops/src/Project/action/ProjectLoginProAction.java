package Project.action;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.Member;
import Project.beans.MemberImg;
import comm.Action;
import comm.ActionForward;

public class ProjectLoginProAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ActionForward forward=null;
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		int state=0;
		ProjectLoginProService prls=new ProjectLoginProService();
		state=prls.loginAction(id, pw);
		
		if(state>0){
			HttpSession session=request.getSession();
			session.setAttribute("EM_id",id);
			session.setMaxInactiveInterval(7200);
			
			String EM_id=(String)session.getAttribute("EM_id");
			ProjectUserInfoService pjui=new ProjectUserInfoService();
			ProjectInfoChangeService pics=new ProjectInfoChangeService();
			
			Member list=pjui.userInfoService(EM_id);//개인 정보
			MemberImg mbimg=pics.userInfoImg(EM_id);//개인 이미지
			request.setAttribute("list",list);
			session.setAttribute("user_name",list.getEM_name());
			session.setAttribute("user_imgName",mbimg.getEMImg_name());
			session.setAttribute("user_imgFolder",mbimg.getEMImg_folder());
			
			//채팅을위한 세션 ID별 IP주소 부여
			/*
			String ipAddress=request.getRemoteAddr();
			if(ipAddress.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
			    InetAddress inetAddress;
				try {
					inetAddress = InetAddress.getLocalHost();

				    ipAddress=inetAddress.getHostAddress();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			session.setAttribute(id, ipAddress);
			*/
			
			//이름저장
			String myName=pjui.loginName(EM_id);
			session.setAttribute("EM_name", myName);
			
			forward=new ActionForward("../index.ops?menu=mypage",true);
		}else if(state==0){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out= response.getWriter();
			out.println("<script>");
			out.println("alert('패스워드 불일치')");
			out.println("history.back()");
			out.println("</script>");
		}else if(state==-3){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out= response.getWriter();
			out.println("<script>");
			out.println("alert('탈퇴처리된 아이디 입니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out= response.getWriter();
			out.println("<script>");
			out.println("alert('아이디 불일치')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		
		return forward;
	}
}
